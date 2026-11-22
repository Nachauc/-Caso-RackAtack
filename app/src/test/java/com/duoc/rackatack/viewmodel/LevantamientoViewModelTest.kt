package com.duoc.rackatack.viewmodel
import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.models.Rack
import com.duoc.rackatack.remote.ApiService
import com.duoc.rackatack.repository.LevantamientoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LevantamientoViewModelTest {
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun preparar() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun limpiar() {
        Dispatchers.resetMain()
    }

    @Test
    fun `carga los levantamientos y los publica`() = runTest {
        println("INICIO: comprobar la carga de levantamientos.")
        println("PREPARACION: la API falsa devolvera un levantamiento; no se usa internet.")
        val lista = listOf(
            Levantamiento(id = 1, rackId = "12345", fecha = "12/12/2026",
                inspector = "alan alfaro", estado = "revisado")
        )
        val apiFalsa = object : ApiService {
            override suspend fun getLevantamientos() = lista
            override suspend fun getRacks() = emptyList<Rack>()
            override suspend fun getLevantamientoPorId(id: Int) = lista[0]
            override suspend fun crearLevantamiento(levantamiento: Levantamiento) = levantamiento
            override suspend fun actualizarLevantamiento(id: Int, levantamiento: Levantamiento) = levantamiento
            override suspend fun eliminarLevantamiento(id: Int) {}
            override suspend fun crearRack(rack: Rack) = rack
        }
        val viewModel = LevantamientoViewModel(LevantamientoRepository(apiFalsa))

        println("ACCION: iniciar la carga y ejecutar las corrutinas pendientes.")
        assertEquals(emptyList<Levantamiento>(), viewModel.levantamientos.value)
        advanceUntilIdle()

        println("COMPROBACION: la lista publicada debe ser la que devolvio la API falsa.")
        assertEquals(lista, viewModel.levantamientos.value)
        println("CORRECTO: se publicaron los levantamientos esperados.")
    }
}