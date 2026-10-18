# PROTOTYPE-v2.md — Requerimientos para la segunda versión del prototipo

## 1. Contexto y motivo de la v2

La versión 1 del prototipo (actual) tiene un error crítico: **Thymeleaf no está procesando las plantillas**, por lo que el navegador muestra código Thymeleaf crudo (`th:text`, `th:src`, `th:if`) en lugar del contenido renderizado. Esto impide que Sofía y la docente utilicen la aplicación.

Además, se detectan oportunidades de mejora en navegación, accesibilidad y experiencia de uso para una niña de 5 años con TEA nivel 1.

Esta v2 corrige los errores críticos y añade funciones prioritarias para el uso real en el aula.

---

## 2. Objetivos de la v2

1. Corregir el renderizado de Thymeleaf (que las plantillas se vean correctamente).
2. Corregir la visualización de pictogramas en todas las vistas (Sofía y docente).
3. Mejorar la navegación entre vistas con un header consistente y funcional.
4. Añadir confirmación visual clara al completar una actividad.
5. Mantener privacidad (sin diagnóstico, sin datos sensibles).
6. Mantener acceso sin autenticación (sin login).
7. Seguir sin usar IA generativa (motor basado en reglas).

---

## 3. Requerimientos funcionales (v2)

| ID | Requerimiento | Prioridad | Justificación (Sofía) |
|----|---------------|-----------|----------------------|
| RF2-01 | Renderizado correcto de todas las plantillas Thymeleaf (sin código crudo en pantalla) | Must | Sin esto, la aplicación no es usable. |
| RF2-02 | Header consistente en todas las vistas con título legible y mascota guía (🐬) | Must | Previsibilidad y reducción de ansiedad al navegar. |
| RF2-03 | Pictogramas visibles en vista de Sofía (secuencia y actividad actual) | Must | Memoria visual excepcional; necesita ver el pictograma grande y claro. |
| RF2-04 | Pictogramas visibles en vista docente (tabla de horario y previa) | Must | La docente debe verificar qué asignó a cada actividad. |
| RF2-05 | Botón "Siguiente actividad" grande y único por pantalla en vista de Sofía | Must | Una acción principal por pantalla evita confusiones. |
| RF2-06 | Botón "Hecho" con confirmación visual (cambio de color o marca) al completar actividad | Should | Refuerzo positivo y sensación de control sobre la rutina. |
| RF2-07 | Aviso visual de cambio de rutina con temporizador silencioso (5 min) | Must | Reduce frustración ante transiciones sin advertencia. |
| RF2-08 | Navegación "Volver al inicio" desde cualquier pantalla | Must | Salida de emergencia si Sofía se pierde en la interfaz. |
| RF2-09 | Vista previa para Sofía desde el panel docente | Should | La docente valida antes de mostrarle la secuencia a Sofía. |
| RF2-10 | Carga de horario diario por la docente (agregar, editar, ordenar actividades) | Must | La docente gestiona la rutina diaria. |

---

## 4. Requerimientos no funcionales (v2)

| ID | Requerimiento | Prioridad |
|----|---------------|-----------|
| RNF2-01 | Thymeleaf procesa correctamente sin necesidad de Layout Dialect externo | Must |
| RNF2-02 | Diseño responsivo para tablet 768×1024 (vertical) y PC | Must |
| RNF2-03 | Sin sonidos de alerta, sin autoplay, sin parpadeos | Must |
| RNF2-04 | Contraste de texto ≥ 4.5:1 (normal), ≥ 3:1 (grande y componentes) | Must |
| RNF2-05 | Objetivos táctiles mínimo 60×60 px para Sofía (recomendado 80 px) | Must |
| RNF2-06 | `lang="es"` en todas las páginas | Must |
| RNF2-07 | Texto alternativo (`alt`) en todas las imágenes de pictogramas | Must |
| RNF2-08 | Navegación operable solo con teclado (Tab, Enter, Espacio) | Should |
| RNF2-09 | Base de datos embebida H2 (sin servidor externo) | Must |
| RNF2-10 | Sin almacenamiento de diagnóstico ni datos de salud | Must |

---

## 5. Requerimientos de accesibilidad WCAG 2.2 AA (v2)

| Criterio | Nombre | Nivel | Cómo se cumple en v2 |
|----------|--------|-------|----------------------|
| 1.1.1 | Non-text Content | A | `alt` descriptivo en pictogramas; decorativos con `alt=""` |
| 1.3.1 | Info and Relationships | A | HTML semántico (`header`, `main`, `section`, `ol`, `h1-h6`) |
| 1.4.1 | Use of Color | A | Color nunca es el único portador de información (icono + texto + color) |
| 1.4.3 | Contrast (Minimum) | AA | Texto ≥ 4.5:1, grande ≥ 3:1, componentes ≥ 3:1 |
| 1.4.10 | Reflow | AA | Usable a 320 px CSS sin scroll horizontal |
| 1.4.11 | Non-text Contrast | AA | Botones y bordes ≥ 3:1 frente al fondo |
| 2.1.1 | Keyboard | A | Todo operable solo con teclado |
| 2.1.2 | No Keyboard Trap | A | Sin trampas de teclado |
| 2.3.1 | Three Flashes | A | Sin contenido que parpadee > 3 veces por segundo |
| 2.4.2 | Page Titled | A | `<title>` distinto y descriptivo por pantalla |
| 2.4.7 | Focus Visible | AA | Indicador de foco visible con anillo contrastante |
| 2.4.11 | Focus Not Obscured | AA | Foco nunca oculto por cabeceras fijas |
| 2.5.8 | Target Size | AA | Mínimo 24×24 px; recomendado 60–80 px para Sofía |
| 3.1.1 | Language of Page | A | `<html lang="es">` |
| 3.2.4 | Consistent Identification | A | Iconos y botones repetidos mantienen misma función y etiqueta |
| 3.2.6 | Consistent Help | A | Ayuda/mascota guía en misma posición en todas las pantallas |
| 3.3.6 | Redundant Entry | A | No se pide el mismo dato dos veces |
| 4.1.2 | Name, Role, Value | A | Semántica nativa de HTML; ARIA solo si es necesario |
| 4.1.3 | Status Messages | AA | Mensajes de estado con `aria-live="polite"` sin robar foco |

---

## 6. Estructura de navegación propuesta (v2)

| Vista | URL | Propósito | Elementos principales |
|-------|-----|-----------|----------------------|
| Inicio / Secuencia Sofía | `/horario/{fecha}` | Ver secuencia del día | Header, lista de pictogramas, botón "Siguiente", aviso de cambio |
| Actividad actual | `/actividad/{id}` | Ver actividad en curso | Header, pictograma grande, nombre, temporizador, botón "Hecho", "Siguiente" |
| Aviso de cambio | `/aviso-cambio` | Alerta visual anticipada | Header, mensaje "Cambio pronto", pictograma siguiente, botón "Entendido" |
| Panel docente horario | `/docente/horario` | Gestionar jornada diaria | Header, tabla de actividades, botón "Agregar actividad", "Ver previa", "Ver lo que ve Sofía" |
| Formulario actividad | `/docente/actividad-form` | Crear/editar actividad | Header, formulario (nombre, pictograma, orden, duración, aviso cambio), botón "Guardar" |
| Previa para Sofía | `/docente/previa/{fecha}` | Validar secuencia antes de mostrar | Header, secuencia visual simplificada, botón "Volver al horario" |
| Error | `/error` | Página de error amigable | Header, mensaje claro, botón "Volver al inicio" |

---

## 7. Modelo de datos (v2) — sin cambios estructurales, solo correcciones

```
Nino (id, nombreApodo, temaPreferido, fechaCreacion)
Jornada (id, fecha, actividades[])
Actividad (id, jornadaId, nombre, pictogramaClave, orden, duracionEstimadaMin, avisoCambioMin, activo)
Pictograma (id, clave, urlImagen, tema, descripcion)
TransicionSimulada (id, actividadId, fecha, completada)
```

Regla de privacidad: **no se almacena diagnóstico**, ni nombre completo innecesario, ni datos de salud.

---

## 8. Archivos a corregir / crear en v2

| Archivo | Acción | Motivo |
|---------|--------|--------|
| `templates/horario.html` | Reescribir sin fragmentos, con header directo | Thymeleaf no procesaba `th:insert` de fragmentos |
| `templates/actividad.html` | Reescribir sin fragmentos | Igual |
| `templates/aviso-cambio.html` | Reescribir sin fragmentos | Igual |
| `templates/docente/horario.html` | Corregir rutas de imágenes (`/img/pictogramas/{clave}.png`) | Pictogramas no se veían |
| `templates/docente/actividad-form.html` | Reescribir sin fragmentos | Igual |
| `templates/docente/previa-sofia.html` | Corregir rutas de imágenes | Pictogramas inconsistentes |
| `templates/error.html` | Reescribir sin fragmentos | Igual |
| `templates/layout.html` | Eliminar | Ya no se usa, causa confusión |
| `templates/fragments.html` | Eliminar | Mecanismo de fragmentos no funciona sin Layout Dialect |
| `static/css/styles.css` | Verificar contrastes con herramienta externa | Asegurar WCAG 2.2 AA |
| `static/js/app.js` | Añadir confirmación visual al botón "Hecho" | Refuerzo positivo para Sofía |

---

## 9. Qué NO entra en la v2

- Autenticación de docente (sigue sin login)
- Inteligencia artificial generativa
- Almacenamiento de diagnóstico o datos de salud
- Registro real de comportamiento con datos personales
- Aplicación móvil nativa
- Notificaciones o emails a familias
- Sincronización entre dispositivos

---

## 10. Criterios de aceptación para aprobar la v2

1. Al entrar a `http://localhost:8080/horario/2026-10-17` se ve el header con texto "Mis actividades de hoy" (sin código `th:text` visible).
2. Los pictogramas se muestran correctamente en vista de Sofía y en vista docente.
3. El botón "Siguiente" es grande (≥72 px) y con texto claro.
4. El botón "Hecho" da confirmación visual al pulsarlo.
5. No hay sonidos, parpadeos ni animaciones intrusivas.
6. La aplicación funciona en tablet 768×1024 y en PC.

---

*Documento pendiente de aprobación antes de iniciar la implementación de la versión 2.*