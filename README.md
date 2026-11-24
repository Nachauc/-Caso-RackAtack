# RackAtack - Sistema de Levantamiento de Infraestructura IT

Aplicación Android nativa desarrollada en **Kotlin** y **Jetpack Compose (Material 3)** bajo la arquitectura **MVVM**. Permite a los técnicos e inspectores registrar levantamientos de racks en terreno, capturar evidencia fotográfica, revisar equipamiento y sincronizar toda la información en tiempo real con dos servicios REST alojados en **Xano**.

---

## Funcionalidades

* **Autenticación y Registro de Usuarios:** Creación de cuentas e inicio de sesión validados contra base de datos remota, con persistencia de sesión local mediante `SharedPreferences`.
* **Gestión CRUD de Levantamientos:** Visualización en tiempo real mediante tarjetas (`LazyColumn`), creación, edición, eliminación y búsqueda específica por ID numérico de registro.
* **Flujo Guiado de Inspección:** Registro de antecedentes, toma de fotografía del rack con la cámara del dispositivo y pantalla unificada de detalle con el inventario de componentes (*Patch panel, Switch, UPS, Servidor, PDU, Firewall y Cableado estructurado*).
* **Recursos Nativos Integrados:**
  * **Cámara:** Captura de evidencia fotográfica en terreno.
  * **Notificaciones Locales:** Alertas del sistema al confirmar y guardar un levantamiento en la nube (con gestión de permisos `POST_NOTIFICATIONS` para Android 13+).
* **Pruebas Unitarias:** Cobertura automatizada de capa de datos y lógica de presentación con JUnit y MockWebServer.

---

## Tecnologías Utilizadas

* **Lenguaje y UI:** Kotlin, Jetpack Compose (Material 3), Navigation Compose.
* **Arquitectura y Asincronía:** MVVM, Coroutines y `StateFlow`.
* **Consumo de API y Persistencia:** Retrofit, Gson, `SharedPreferences` y Xano (Backend REST).
* **Testing:** JUnit y `MockWebServer` (OkHttp).

---

## Arquitectura y Estructura del Proyecto

El código sigue el patrón **MVVM** con separación de responsabilidades por dominio:

```text
app/src/main/java/com/duoc/rackatack/
├── MainActivity.kt          # Punto de entrada y configuración de permisos
├── models/                  # Modelos de datos (Levantamiento, Usuario)
├── remote/                  # Instancias de Retrofit y definición de endpoints (ApiService, ApiServiceUsuario)
├── repository/              # Repositorios independientes por dominio (LevantamientoRepository, UsuarioRepository)
├── viewmodel/               # Gestión de estado reactivo con StateFlow y puente de datos temporales
└── ui/theme/                # Pantallas Compose, componentes reutilizables, navegación y tema
```

## Conexión Backend (7 Endpoints en Xano)

La aplicación consume dos grupos de API independientes configurados en RetrofitInstance:

API de Levantamientos:
```text
GET /levantamiento — Obtener listado completo de registros.
GET /levantamiento/{id} — Buscar un levantamiento específico por su ID numérico.
POST /levantamiento — Crear y almacenar un nuevo levantamiento.
PATCH /levantamiento/{id} — Actualizar datos de un levantamiento existente.
DELETE /levantamiento/{id} — Eliminar un levantamiento de la base de datos.
```

API de Usuarios:
```text
GET /usuario — Consultar registros de usuarios para validación de inicio de sesión.
POST /usuario — Registrar una nueva cuenta de usuario en la plataforma.
```

## Requisitos y Ejecución del Proyecto

Requisitos Previos:
* **Android Studio:** Ladybug (2024.2.1) o superior con JDK 17.

* **Dispositivo / Emulador:** Android 7.0 (API 24) o superior, con acceso a internet y cámara habilitada.

Pasos de Instalación:

1.- Clonar el repositorio:
```text
git clone https://github.com/Nachauc/-Caso-RackAtack
```
2.- Abrir en Android Studio:
* Seleccionar File > Open, elegir la carpeta del proyecto y esperar a que Gradle finalice la sincronización.

3.- Ejecutar la aplicación:
* Seleccionar el emulador o dispositivo físico conectado y presionar Run.

Flujo de Prueba Sugerido:

* **Registro e Inicio de Sesión:** En la pantalla inicial, presionar "¿No tienes cuenta? Regístrate aquí" para crear un usuario nuevo en Xano o ingresar con credenciales existentes.

* **Listado y Búsqueda:** En Inicio, revisar las tarjetas cargadas desde la nube, usar el ícono de lupa superior para filtrar por ID numérico, o probar las acciones Editar y Eliminar.

* **Nuevo Levantamiento:** Presionar Nuevo Levantamiento +, completar los antecedentes, tomar la fotografía con la cámara y confirmar con Validar y Guardar para disparar la notificación local y actualizar el listado.

## Pruebas Unitarias

El proyecto cuenta con dos suites de pruebas unitarias ubicadas en app/src/test/java/com/duoc/rackatack/:

* **LevantamientoViewModelTest:** Valida el comportamiento y actualización de estados (StateFlow) del ViewModel utilizando un repositorio simulado (Fake Repository).
* **LevantamientoRepositoryTest:** Valida las peticiones HTTP y el mapeo de respuestas JSON del repositorio utilizando MockWebServer.

## Autores
Integrantes: Alan Alfaro y Maria Ignacia Urrutia

Asignatura: Desarrollo de aplicación movil

Institución: Duoc UC

