# PROTOTYPE.md — Alcance de la primera versión del prototipo

## 1. Objetivo
Prototipo funcional (no producto final) de asistente de anticipación visual con pictogramas para Sofía, niña de 5 años con TEA nivel 1, que reduzca su ansiedad ante transiciones y cambios de rutina en el aula.

## 2. Alcance de la primera versión (MVP)

### Qué se entrega
- **Aplicación web Spring Boot** (sin instalación de base de datos externa).
- **Vista de Sofía (niña):**
  - Pantalla de secuencia diaria de actividades (un pictograma a la vez).
  - Botón principal único: "Siguiente actividad" (grande, pictograma, poco texto).
  - Pantalla de actividad actual con botón simulado "Actividad terminada".
  - Pantalla de aviso visual de cambio de rutina (sin sonido).
  - Navegación lineal y predecible.
- **Vista del docente (adulto):**
  - Pantalla para cargar el horario diario (agregar, editar, reordenar actividades).
  - Asignación de pictogramas a cada actividad desde un catálogo simple.
  - Vista previa de lo que verá Sofía ese día.
  - Guía rápida de consejos de inclusión (texto estático, sin datos de Sofía).
- **Motor basado en reglas:** el horario diario se convierte automáticamente en secuencia de pictogramas (no usa IA generativa).
- **Base de datos embebida H2** (en memoria, para pruebas del prototipo).
- **Plantillas Thymeleaf** renderizadas en el servidor (sin frontend framework complejo).

### Qué NO se entrega en esta versión
- Autenticación de docente (acceso sin login).
- Inteligencia artificial generativa ni modelos de lenguaje.
- Almacenamiento de diagnóstico de TEA ni datos de salud de Sofía.
- Registro real de comportamiento o transiciones con datos personales.
- Aplicación móvil nativa (solo web responsive).
- Notificaciones, emails o informes para familias.
- Sincronización entre dispositivos.
- Pictogramas reales finales (placeholders hasta que se disponga de ellos).

## 3. Stack tecnológico
- **Java 17**
- **Spring Boot 3.3.5** (está configurada en `pom.xml`; la versión 4.0.8 no existe como estable)
- **Maven**
- **Spring Web MVC**
- **Thymeleaf** (plantillas del lado del servidor)
- **Spring Data JPA**
- **H2 Database** (embebida, runtime)
- **Bean Validation**
- **Spring DevTools** (desarrollo)
- **Lombok** (opcional, reducir código repetitivo)

## 4. Arquitectura (capas)
```
Presentación (Thymeleaf + CSS + JS mínimo)
      ↓
Web (Controladores @Controller con rutas amigables)
      ↓
Servicio (reglas: horario → secuencia de pictogramas)
      ↓
Persistencia (Spring Data JPA + H2)
      ↓
Base de datos en memoria
```
Transversales: manejo global de excepciones, internacionalización (`messages.properties`), accesibilidad WCAG 2.2 AA (contraste, teclado, foco, tamaño objetivo, `lang="es"`, `alt` en pictogramas).

## 5. Diseño y accesibilidad (resumen)
- Paleta aprobada: fondos `#EAF6FF`, `#CFF0EA`; botones `#3E8FD6`; texto `#1E5A9C`; estados `#3E9B94`.
- Contrastes: texto ≥ 4.5:1 (normal), ≥ 3:1 (grande y componentes).
- Botones grandes recomendados 60–80 px para Sofía (mínimo WCAG 24 × 24 px).
- Tema marino / transporte en pictogramas y mascota guía.
- Sin parpadeos, sin animaciones intrusivas, sin sonidos de alerta ni autoplay.
- Optimizado para tablet 768×1024 (vertical), usable también en PC.

## 6. Endpoints principales (prototipo)
| Método | Ruta | Propósito |
|---|---|---|
| GET | `/` | Pantalla de inicio |
| GET | `/horario/{fecha}` | Secuencia diaria para Sofía |
| GET | `/actividad/{id}` | Actividad actual (Siguiente / Hecho) |
| GET | `/aviso-cambio` | Aviso visual de cambio de rutina |
| GET | `/docente/horario` | Gestionar jornada diaria |
| POST | `/docente/actividad` | Crear/editar actividad |
| GET | `/docente/previa/{fecha}` | Vista previa para Sofía |
| POST | `/cambio-rutina` | Aviso simulado de cambio |
| POST | `/transicion` | Botón simulado "actividad terminada" |

## 7. Privacidad
- No se almacena diagnóstico de Sofía.
- No se guardan datos personales innecesarios.
- Solo lo mínimo para el funcionamiento del prototipo.

## 8. Estado actual del repositorio
- Estructura de carpetas creada y coherente.
- `pom.xml` configurado (Spring Boot 3.3.5, Java 17, dependencias del MVP).
- `application.properties` configurado (H2, Thymeleaf, servidor).
- Todos los archivos Java, plantillas Thymeleaf, CSS y JS están **vacíos** (pendientes de implementación tras autorización).

## 9. Siguiente paso
Esperando su autorización para comenzar a codificar la lógica de aplicación (entidades, controladores, servicios, plantillas, estilos).

---

*Documento generado como parte de la definición de requisitos y configuración del proyecto. No contiene código de aplicación todavía.*