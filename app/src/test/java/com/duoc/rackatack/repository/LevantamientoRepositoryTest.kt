package com.duoc.rackatack.repository
import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.remote.ApiService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LevantamientoRepositoryTest {
    private lateinit var servidor: MockWebServer
    private lateinit var repository: LevantamientoRepository

    @Before
    fun preparar() {
        servidor = MockWebServer()
        servidor.start()
        val api = Retrofit.Builder()
            .baseUrl(servidor.url("/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        repository = LevantamientoRepository(api)
    }

    @After
    fun limpiar() {
        servidor.shutdown()
    }

    @Test
    fun `consulta el endpoint y convierte la respuesta`() = runTest {
        println("INICIO: comprobar la solicitud y la conversion del JSON.")
        println("PREPARACION: el servidor local simulado respondera con un levantamiento.")
        servidor.enqueue(MockResponse().setBody(
            """[{"id":1,"rackId":"12345","fecha":"12/12/2026","inspector":"alan alfaro","estado":"revisado"}]"""
        ))

        println("ACCION: el repositorio llama al servidor local, no a Xano.")
        val resultado = repository.obtenerLevantamientos()

        println("COMPROBACION: el JSON debe convertirse en un levantamiento y usar GET /levantamiento.")
        assertEquals(
            listOf(Levantamiento(id = 1, rackId = "12345", fecha = "12/12/2026",
                inspector = "alan alfaro", estado = "revisado")),
            resultado
        )
        val solicitud = servidor.takeRequest()
        assertEquals("GET", solicitud.method)
        assertEquals("/levantamiento", solicitud.path)
        println("CORRECTO: la solicitud y el levantamiento son los esperados.")
    }
}