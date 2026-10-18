# REQUISITOS_PROTOTIPO.md — Asistente de Anticipación Visual - Caso Sofía

Documento consolidado con todos los requisitos, directrices de diseño, accesibilidad, alcance y configuración del proyecto para la primera versión del prototipo funcional.

---

## 1. Contexto del caso

**Sofía**, 5 años, preschool (Transition), TEA nivel 1. Urbano, kindergarten público, 20 niños, docente con formación básica en inclusión. Asiste 4 días a semana.

### Fortalezas
- Memoria visual excepcional
- Interés intenso en animales marinos y vehículos de transporte
- Frases habladas cortas y claras
- Responde bien a rutinas y anticipación visual

### Desafíos
- Dificultad para transitar entre actividades sin aviso
- Sensibilidad auditiva (campana escolar, gritos)
- Interacción limitada con pares
- Frustración ante cambios inesperados de rutina

### Barreras ambientales
- Espacios ruidosos y poco estructurados
- Sin apoyos visuales en el aula
- Actividades grupales sin anticipación
- Docente sin formación especializada en TEA

### Tecnología actual
- Ninguna en el aula. Familia usa pictogramas impresos en casa.

---

## 2. Requerimientos funcionales (RF)

| ID | Requerimiento | Prioridad MoSCoW | Justificación (necesidad de Sofía) |
|----|---------------|------------------|------------------------------------|
| RF-01 | Mostrar secuencia diaria de actividades como pictogramas, uno tras otro, en orden lineal | Must | Reduce incertidumbre y ansiedad ante transiciones sin aviso |
| RF-02 | Pantalla principal con una sola acción principal: "Siguiente actividad" | Must | Interfaz predecible para niña de 5 años pre-lectora |
| RF-03 | Aviso visual de cambio de rutina con anticipación (ej. "en 5 minutos cambiamos de actividad") | Must | Evita frustración ante cambios inesperados de rutina |
| RF-04 | Botones grandes, pictogramas con poco o ningún texto, navegación lineal | Must | Accesible sin saber leer y con habilidades motoras en desarrollo |
| RF-05 | Modo silencioso: sin sonidos de alerta, sin autoplay, sin volumen alto | Must | Hiper sensibilidad auditiva (campana, gritos) |
| RF-06 | Tema motivador: animales marinos y vehículos en pictogramas y mascota guía | Should | Aprovecha intereses intensos para motivar el uso |
| RF-07 | Pantalla docente para crear/editar horario diario y asignar pictogramas | Must | Docente sin formación en TEA necesita herramienta sencilla |
| RCV-01 | Aviso de cambio de rutina | Must | Sofía se frustra con cambios inesperados; aviso visual con minutos de antelación le permite prepararse |
| RCV-03 | Apoyo ante ruido | Must | Sensibilidad auditiva a campanas y gritos; alertas solo visuales, opción de auriculares |
| RCV-07 | Interfaz sin texto o con texto mínimo | Must | Es pre-lectora (5 años, Transition); todo se comunica con pictogramas, iconos y muy pocas palabras claras |
| RCV-08 | Privacidad por diseño (no diagnóstico) | Must | Menor de edad; no almacenar diagnóstico ni datos innecesarios |

---

## 3. Requerimientos no funcionales (RNF)

| ID | Requerimiento | Prioridad MoSCoW | Justificación |
|----|---------------|------------------|---------------|
| RNF-01 | Prototipo web responsive que funcione en tablet del aula sin instalación compleja | Must | Entorno escolar con dispositivos compartidos |
| RNF-02 | Funcionamiento sin dependencia de IA generativa (reglas) para el MVP | Must | Prototipo funcional, predecible, sin costes de API externos |
| RNF-03 | Tiempos de respuesta < 2 s y trabajo offline básico tras carga inicial | Should | Reduce frustración por esperas; aulas con conectividad variable |
| RCV-02 | Modo baja estimulación | Should | Espacios ruidosos generan sobrecarga sensorial; modo con colores más suaves, sin animaciones y sin sonidos |
| RCV-04 | Pictogramas personalizables por interés | Should | Intereses intensos (animales marinos, vehículos) motivan la atención |
| RCV-05 | Temporizador visual de transición | Should | Dificultad para terminar una actividad sin advertencia; cronómetro grande y silencioso hace el fin predecible |
| RCV-06 | Confirmación "actividad terminada" | Should | Le da control y previsibilidad; refuerza la rutina y reduce ansiedad al pasar a lo siguiente |

---

## 4. Requerimientos de accesibilidad (ACC) — WCAG 2.2 AA

| ID | Criterio WCAG | Nombre | Nivel | Aplica a | ¿Cómo se cumple? |
|----|--------------|--------|-------|----------|------------------|
| ACC-01 | 1.4.3 | Contrast (Minimum) | AA | Ambas | Texto ≥ 4.5:1 normal / ≥ 3:1 grande, según tabla de contrastes |
| ACC-02 | 2.5.8 | Target Size | AA | Ambas | Mínimo 24 × 24 px; recomendado ≥ 44 × 44 px (vista Sofía: 60–80 px) |
| ACC-03 | 2.1.1, 2.1.2, 2.4.7 | Keyboard, No Keyboard Trap, Focus Visible | A/AA | Ambas | Todo operable con teclado; sin trampas; indicador de foco visible |
| ACC-04 | 3.1.1, 1.1.1 | Language of Page, Non-text Content | A | Ambas | `<html lang="es">`; `alt` en pictogramas; HTML semántico; ARIA solo cuando necesario |
| ACC-05 | 2.3.1 | Three Flashes | A | Ambas | Sin parpadeos, sin animaciones intrusivas, sin sonidos fuertes ni autoplay |
| ACC-06 | 1.4.11 | Non-text Contrast | AA | Ambas | Componentes (botones, bordes) ≥ 3:1 frente al fondo adyacente |
| ACC-07 | 2.4.11 | Focus Not Obscured | AA (2.2) | Ambas | El foco nunca queda oculto por cabeceras fijas ni overlays |
| ACC-08 | 2.5.7 | Dragging Movements | AA (2.2) | Ambas | No se requiere arrastrar; alternativa de clic simple para reordenado |
| ACC-09 | 3.2.6 | Consistent Help | A (2.2) | Docente / Niña | Guía rápida en misma posición en pantallas docentes; mascota guía constante en vista niña |
| ACC-10 | 3.3.7 | Redundant Entry | A (2.2) | Docente | No se solicita el mismo dato dos veces |
| ACC-11 | 3.3.8 | Accessible Authentication | AA (2.2) | Docente | Si hubiera login, no depende solo de función cognitiva (gestor de contraseñas, sin CAPTCHA) |
| ACC-12 | 1.4.1 | Use of Color | A | Ambas | El color nunca es el único portador de información (acompañado de icono y/o texto) |
| ACC-13 | 4.1.2 | Name, Role, Value | A | Ambas | Semántica nativa de HTML; ARIA solo si es necesario |
| ACC-14 | 4.1.3 | Status Messages | AA | Ambas | Mensajes de estado con `aria-live="polite"` sin robar el foco |

**Distinción:** la vista de Sofía cumple la mayoría de criterios de forma nativa por su simplicidad. La vista docente añade criterios de formularios, errores y ayuda consistente. Ninguna almacena diagnóstico.

---

## 5. Requerimientos de contenido y pedagógicos (PC)

| ID | Requerimiento | Prioridad | Justificación |
|----|---------------|-----------|---------------|
| PC-01 | Pictogramas claros, culturales y reales o estilo ARASAAC; sin textos largos | Must | Pre-lectora; memoria visual excepcional |
| PC-02 | Confirmación visual al completar una actividad (marca de "hecho") | Should | Refuerzo positivo y sensación de control |
| PC-03 | Temporizador visual de transición (cuenta atrás grande y silenciosa) | Should | Ayuda a anticipar el fin de una actividad |
| PC-04 | Pictogramas temáticos marino y transporte | Should | Intereses intensos de Sofía |

---

## 6. Requerimientos de uso docente (UX)

| ID | Requerimiento | Prioridad | Justificación |
|----|---------------|-----------|---------------|
| UX-01 | Guía rápida de consejos de inclusión (sin almacenar diagnóstico) | Must | Docente con formación básica en inclusión, no especializada |
| UX-02 | Acceso sencillo al horario semanal y vista previa de lo que verá Sofía | Should | Coordinación entre lo que planifica la docente y lo que ve Sofía |

---

## 7. Paleta de colores y asignación de elementos

| Color | Uso en la interfaz | Elemento |
|-------|-------------------|----------|
| `#EAF6FF` | Fondo principal | Fondo de pantalla (vista Sofía y docente) |
| `#CFF0EA` | Fondo secundario / tarjetas | Tarjetas de actividad, paneles informativos |
| `#BFE3FA` | Fondo de componentes ligeros | Tarjetas de pictograma, estados inactivos |
| `#88C9C4` | Bordes y divisores | Bordes de tarjetas, separadores |
| `#7FC4F2` | Texto secundario / subtítulos | Etiquetas pequeñas, subtítulos (no para texto corporal) |
| `#3E8FD6` | Botones primarios y enlaces | Botón "Siguiente actividad", acciones principales |
| `#3E9B94` | Estados de éxito / completado | Marca de "hecho", botón de confirmación |
| `#20666B` | Texto de soporte / captions | Leyendas, textos de ayuda secundarios |
| `#1E5A9C` | Texto principal / títulos | Títulos, texto corporal, etiquetas de pictograma |
| `#0C3B45` | Texto sobre fondos oscuros / estados críticos | Texto sobre botones oscuros, avisos importantes |

### Reglas de uso
- Nunca usar solo el color para indicar un estado (acompañar siempre con icono y/o texto).
- Evitar rojo/verde como único código de estado (daltonismo).

---

## 8. Verificación de contrastos (aproximados; verificar con WebAIM en implementación)

| Combinación | Ratio aprox. | Texto normal ≥ 4.5:1 | Texto grande ≥ 3:1 | Componente ≥ 3:1 | Veredicto |
|-------------|--------------|----------------------|--------------------|------------------|-----------|
| `#1E5A9C` sobre `#EAF6FF` | 6.4 : 1 | ✅ | ✅ | ✅ | Válido para texto normal |
| `#3E8FD6` sobre `#EAF6FF` | 3.1 : 1 | ❌ | ✅ | ⚠️ | No válido para texto corporal; solo texto grande |
| `#1E5A9C` sobre `#BFE3FA` | 5.2 : 1 | ✅ | ✅ | ✅ | Válido |
| `#3E8FD6` sobre `#BFE3FA` | 2.6 : 1 | ❌ | ❌ | ❌ | No válido para texto ni componente |
| `#0C3B45` sobre `#CFF0EA` | 10.0 : 1 | ✅ | ✅ | ✅ | Válido |
| `#3E9B94` sobre `#CFF0EA` | 2.7 : 1 | ❌ | ❌ | ❌ | No válido para texto; usar solo decorativo |
| Blanco sobre `#1E5A9C` | 7.0 : 1 | ✅ | ✅ | ✅ | Válido (botón oscuro con texto blanco) |
| Blanco sobre `#3E8FD6` | 3.4 : 1 | ❌ | ✅ | ⚠️ | Solo texto grande; no para botones con texto pequeño |
| Blanco sobre `#0C3B45` | 12.2 : 1 | ✅ | ✅ | ✅ | Válido |
| `#3E8FD6` sobre `#EAF6FF` (botón) | 3.1 : 1 | — | — | ✅ (justo) | Válido como componente, añadir borde |
| `#BFE3FA` sobre `#EAF6FF` (tarjeta) | 1.2 : 1 | — | — | ❌ | No válido como componente distinguible; requiere borde |

---

## 9. Priorización MoSCoW y alcance del prototipo (v1)

| Grupo | Requerimientos | ¿Entra en el prototipo v1? |
|-------|----------------|----------------------------|
| **Must** | RF-01, RF-02, RF-03, RF-04, RF-05, RF-07, RNF-01, RNF-02, ACC-01 a ACC-14, PC-01, UX-01, RCV-01, RCV-03, RCV-07, RCV-08 | ✅ Sí — núcleo del MVP |
| **Should** | RF-06, RNF-03, PC-02, PC-03, UX-02, RCV-02, RCV-04, RCV-05, RCV-06 | ✅ Sí, en lo posible (simplificados) |
| **Could** | IA generativa para sugerir pictogramas, sincronización multi-dispositivo, avatar personalizable, notificaciones push | ❌ No (versión 2) |
| **Won't** | Almacenar diagnóstico, chat con IA, videollamadas, informes médicos, pagos/suscripción, redes sociales | ❌ Fuera de alcance |

### Qué está FUERA del alcance del prototipo v1
- Diagnóstico, historia clínica o datos de salud de Sofía.
- Inteligencia artificial generativa (modelos de lenguaje, generación de imágenes por IA).
- Autenticación compleja (OAuth2, SSO, recuperación de contraseña sofisticada).
- Aplicación móvil nativa (solo web responsive).
- Registro real de comportamiento/transiciones con datos personales.
- Informes, analíticas, exportación o comunicación con familias por email/notificaciones.
- Integración con sistemas de gestión escolar existentes.

---

## 10. Pantallas mínimas

### Vista Sofía (niña)
1. **Horario / Secuencia del día** — pictogramas uno tras otro, botón "Siguiente".
2. **Actividad actual** — pictograma grande, nombre corto, temporizador visual opcional, botón "Hecho".
3. **Aviso de cambio** — pantalla de alerta visual: "En 5 minutos: [siguiente actividad]".
4. **Modo baja estimulación** — activador para reducir colores y estímulos (simplificado en v1).

### Vista Docente (adulto)
1. **Panel horario** — tabla/semana de actividades; agregar, editar o reordenar.
2. **Editar actividad** — nombre, pictograma, hora, aviso de cambio (minutos), categoría.
3. **Vista previa de Sofía** — lo que verá la niña con el horario configurado.
4. **Guía rápida** — consejos de inclusión y TEA (texto estático, sin datos de Sofía).

---

## 11. Modelo de datos (entidades y relaciones)

```
Niño (id, nombreApodo, temaPreferido, fechaCreacion)
   └── NO guarda diagnóstico ni datos sensibles familiares

Jornada (id, fecha)
Actividad (id, nombre, pictogramaClave, categoria, orden, duracionEstimadaMin, avisoCambioMin, activo)
Pictograma (id, clave, urlImagen, categoria, tema: marino | transporte)
TransicionSimulada (id, actividadId, fecha, completada)  -- solo para pruebas del prototipo
```

Regla de privacidad: **no se almacena diagnóstico de TEA**, ni nombre completo innecesario, ni datos de salud. Solo el mínimo para funcionar (apodo/nombre usado en la app, horario y preferencia de tema). Consentimiento familiar requerido antes de usar con Sofía.

---

## 12. Endpoints / rutas principales (v1)

| Método | Ruta | Propósito |
|--------|------|-----------|
| GET | `/` | Redirige al horario de hoy |
| GET | `/horario/{fecha}` | Secuencia diaria para Sofía |
| GET | `/actividad/{id}` | Actividad actual (botón Siguiente / Hecho) |
| GET | `/aviso-cambio` | Aviso visual de cambio de rutina |
| GET | `/docente/horario` | Gestionar jornada diaria |
| POST | `/docente/actividad` | Crear/editar actividad |
| GET | `/docente/previa/{fecha}` | Vista previa de lo que verá Sofía |
| POST | `/cambio-rutina` | Anunciar aviso de cambio (simulado) |
| POST | `/transicion` | Botón simulado "actividad terminada" |

---

## 13. Configuración Spring Initializr (versión corregida)

| Campo | Valor exacto |
|-------|-------------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.3.5 (última estable de la rama 3.x; **4.0.8 no existe**) |
| Group | `com.casosofia` |
| Artifact | `asistente-anticipacion-visual` |
| Name | Asistente de Anticipación Visual - Caso Sofía |
| Description | Prototipo funcional de asistente de anticipación visual con pictogramas para niña de 5 años con TEA nivel 1 |
| Package name | `com.casosofia.asistente` |
| Packaging | Jar |
| Java | 17 |

### Dependencias a seleccionar en Initializr (nombres exactos)

| Dependencia | Justificación |
|-------------|---------------|
| Spring Web | Controladores web y rutas del asistente y la vista docente |
| Thymeleaf | Renderizado de páginas del lado del servidor (sin frontend JS complejo) |
| Spring Data JPA | Persistencia simple del horario, actividades y pictogramas |
| Validation | Validación de formularios del docente (nombre de actividad, horarios, etc.) |
| H2 Database | Base de datos embebida para pruebas y prototipo sin servidor externo |
| Spring Boot DevTools | Reinicio automático en desarrollo del prototipo |
| Lombok | Reduce código repetitivo en entidades y DTOs |

### Dependencias que NO añadir todavía
Spring AI, Spring Cloud, OAuth2, WebSocket, Spring Mail, PostgreSQL/MySQL (usa H2), React/Vue/Angular (usa Thymeleaf), Spring Boot Actuator, Docker, Testcontainers.

### Estructura de carpetas sugerida

```
asistente-anticipacion-visual/
├── src/main/java/com/casosofia/asistente/
│   ├── AsistenteAnticipacionVisualApplication.java
│   ├── controller/
│   │   ├── HorarioController.java
│   │   ├── ActividadController.java
│   │   ├── CambioRutinaController.java
│   │   └── GlobalExceptionHandler.java
│   ├── model/
│   │   ├── Nino.java
│   │   ├── Jornada.java
│   │   ├── Actividad.java
│   │   ├── Pictograma.java
│   │   └── TransicionSimulada.java
│   ├── repository/
│   │   ├── JornadaRepository.java
│   │   ├── ActividadRepository.java
│   │   ├── PictogramaRepository.java
│   │   ├── NinoRepository.java
│   │   └── TransicionSimuladaRepository.java
│   ├── service/
│   │   ├── SecuenciaService.java
│   │   └── CambioRutinaService.java
│   ├── dto/
│   │   ├── ActividadDTO.java
│   │   └── SecuenciaDTO.java
│   └── config/
│       └── DataLoader.java
├── src/main/resources/
│   ├── templates/
│   │   ├── horario.html
│   │   ├── actividad.html
│   │   ├── aviso-cambio.html
│   │   ├── error.html
│   │   ├── docente/
│   │   │   ├── horario.html
│   │   │   ├── actividad-form.html
│   │   │   └── previa-sofia.html
│   ├── static/
│   │   ├── css/styles.css
│   │   ├── js/app.js
│   │   └── img/pictogramas/
│   ├── application.properties
│   └── messages.properties
├── pom.xml
├── PROTOTYPE.md
├── PROTOTYPE-v2.md
└── README.md
```

---

## 14. Diseño de interfaz (niña de 5 años)

### Principios
- Una acción principal por pantalla.
- Botones grandes y objetivos táctiles amplios (mínimo 24 × 24 px WCAG; recomendado 60–80 px para Sofía).
- Pictogramas con poco o ningún texto.
- Navegación lineal y predecible.
- Sin animaciones intrusivas, sin parpadeos, sin sonidos fuertes ni autoplay.
- Colores con significado redundante (nunca solo color para un estado).

### Tema motivador
- Pictogramas de la rutina ilustrados con animales marinos (pez, tortuga, delfín) y vehículos (tren, autobús, barco).
- Mascota/guía constante en pantalla (ej. delfín o submarino) en esquina, sin animaciones que distraigan.
- Fondo despejado; máximo 3–4 elementos por pantalla.

---

## 15. Privacidad y protección de menores

- No se almacena diagnóstico de TEA ni datos de salud.
- No se guardan datos personales innecesarios.
- Solo lo mínimo para el funcionamiento (apodo, horario, preferencia de tema).
- Consentimiento familiar requerido antes de usar con Sofía.
- Acceso sin autenticación en el MVP (sin login de docente).

---

## 16. Dispositivo objetivo

- Tablet de aproximadamente 768 × 1024 píxeles (vertical), con posibilidad de uso en PC.
- Diseño responsivo optimizado para tablet, usable también en PC.

---

## 17. Pictogramas necesarios (v1)

| Clave | Descripción | Uso |
|-------|-------------|-----|
| `comida` | Hora de comer | Actividad de almuerzo/merienda |
| `banio` | Hora del baño | Actividad de higiene |
| `recreo` | Hora de jugar | Actividad de juego libre/recreo |
| `clase` | Hora de clase | Actividad educativa |
| `traslado` | Llegada / Salida | Traslado al colegio o vuelta a casa |
| `siesta` | Hora de descansar | Tiempo de siesta o descanso |

**Formato recomendado:** PNG con fondo transparente (o SVG para escalabilidad).
**Dimensiones sugeridas:** 200×200 px (grande), 96×96 px (medio), 40–80 px (pequeño).
**Ubicación:** `src/main/resources/static/img/pictogramas/`

---

## 18. Notas sobre la versión actual

- La versión 1 tiene un error crítico: Thymeleaf no está procesando las plantillas (se muestra código `th:text`/`th:src` crudo en el navegador).
- Se requiere `./mvnw clean compile` y reinicio del servidor para que los archivos HTML se copien a `target/classes/templates/`.
- Se debe corregir el renderizado de Thymeleaf antes de considerar el prototipo funcional.
- `layout.html` y `fragments.html` quedaron huérfanos; no se usan en la implementación actual de plantillas independientes.

---

*Documento consolidado a partir de los requisitos, directrices de diseño, accesibilidad WCAG 2.2 AA, alcance del prototipo y configuración Spring Initializr definidos en las fases anteriores. Pendiente de aprobación para implementación de la versión 2 (ver PROTOTYPE-v2.md).*