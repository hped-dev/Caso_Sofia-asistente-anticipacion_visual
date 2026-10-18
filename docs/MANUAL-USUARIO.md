# Manual de uso — Asistente de Anticipación Visual

**Versión del manual:** 1.0  
**Fecha:** 17 de octubre de 2026  
**Última revisión:** 17 de octubre de 2026

## Índice

1. [Para qué sirve](#1-para-qué-sirve)
2. [Antes de empezar](#2-antes-de-empezar)
3. [Inicio rápido](#3-inicio-rápido)
4. [Vista infantil](#4-vista-infantil)
5. [Vista docente](#5-vista-docente)
6. [Consejos prácticos](#6-consejos-prácticos)
7. [Opciones de accesibilidad](#7-opciones-de-accesibilidad)
8. [Uso en distintas pantallas](#8-uso-en-distintas-pantallas)
9. [Preguntas frecuentes](#9-preguntas-frecuentes)
10. [Privacidad](#10-privacidad)
11. [Límites del prototipo y comentarios](#11-límites-del-prototipo-y-comentarios)

## 1. Para qué sirve

Esta aplicación es un prototipo para mostrar una rutina con imágenes y pasos cortos. Puede ayudar a hacer más predecibles los cambios entre actividades.

No sustituye la conversación, el acompañamiento adulto ni las decisiones de la familia o del centro. No da diagnósticos ni recomendaciones médicas.

## 2. Antes de empezar

Necesita un navegador y que alguien haya iniciado la aplicación. Pregunte a la persona que la instaló cómo abrirla en su equipo. Normalmente se usa una dirección parecida a `http://localhost:8080`.

Para preparar o mantener la aplicación, consulte el [manual técnico](MANUAL-TECNICO.md).

## 3. Inicio rápido

1. Abra la aplicación en el navegador.
2. Revise la secuencia del día en la vista infantil.
3. Pulse **Docente** para abrir el horario del día.
4. Compruebe las actividades, sus imágenes y su orden.
5. Pulse **Ver lo que ve Sofía** antes de mostrar la secuencia a la niña o al niño.

## 4. Vista infantil

### La secuencia del día

La pantalla principal muestra las actividades del día en orden. Cada tarjeta tiene un número, una imagen, el nombre de la actividad, un tiempo estimado y el botón **Siguiente**.

Pulse **Siguiente** en la actividad que se va a realizar. Se abre una pantalla con la imagen más grande.

[Captura: secuencia-del-dia]

### Actividad actual

En esta pantalla se ve una imagen grande, el nombre de la actividad y el tiempo estimado. Tiene dos acciones:

- **Hecho**: registra una finalización de prueba y vuelve al horario de hoy.
- **Siguiente**: vuelve a la secuencia del día.

[Captura: actividad-actual]

### Aviso de cambio

En la secuencia aparece el botón **Aviso de cambio de rutina**. Al pulsarlo, se muestra durante unos segundos un aviso visual en la misma página: “Cambio pronto”. No emite sonido.

La pantalla de aviso también existe y dice que faltan 5 minutos. En la versión actual no muestra automáticamente cuál será la siguiente actividad.

[Captura: aviso-de-cambio]

### Volver arriba

Cuando la página es larga, aparece un botón **Ir arriba**. Devuelve al inicio de la página. Si se desactivan las animaciones, el salto es inmediato.

## 5. Vista docente

Pulse **Docente** desde la cabecera para abrir el horario del día.

### Revisar el horario

La tabla muestra el orden, la actividad, su imagen, el tiempo estimado, el aviso y la acción de edición. También encontrará:

- **Agregar actividad**.
- **Vista previa para Sofía**.
- **Ver lo que ve Sofía**.

[Captura: panel-docente-horario]

### Agregar o editar una actividad

1. Pulse **Agregar actividad** o **Editar**.
2. Escriba un nombre corto y claro.
3. Elija una imagen de la lista disponible.
4. Indique el orden, la duración y los minutos de aviso.
5. Pulse **Guardar actividad**.

La actividad debe estar ligada a una jornada existente. La aplicación no ofrece una pantalla para crear una jornada nueva. Si ese dato falta, verá un mensaje de error.

[Captura: formulario-de-actividad]

### Verificar antes de mostrar

Pulse **Vista previa para Sofía** para comprobar la lista visual. Pulse **Volver al horario** para regresar.

Pulse **Ver lo que ve Sofía** para abrir la secuencia infantil en esa fecha.

[Captura: vista-previa]

### Comunicar un cambio

Antes de un cambio, muestre la secuencia y diga con una frase corta lo que ocurrirá después. Puede pulsar el aviso visual de cambio para acompañar ese mensaje.

En este prototipo, ese botón solo muestra un aviso temporal. No programa un cambio ni envía una notificación a otra persona.

## 6. Consejos prácticos

- Muestre la secuencia antes de empezar la jornada y antes de cada transición importante.
- Use frases cortas. Señale la imagen mientras nombra la actividad.
- Avise con calma cuando algo vaya a cambiar. Después muestre qué actividad sigue.
- Mantenga la pantalla despejada. Presente un paso cada vez si hay distracción.
- Si ayuda, elija imágenes relacionadas con intereses agradables, como animales marinos o vehículos. Las imágenes disponibles en esta versión son fijas.
- Evite añadir sonidos, prisas o muchas instrucciones a la vez.

## 7. Opciones de accesibilidad

En la vista docente, pulse **Opciones**. Puede elegir a quién se aplicarán los cambios:

- **Selección normal (solo para el docente)**.
- **Aplicar también para Sofía**.
- **Aplicar solo para Sofía**.

Después puede seleccionar:

| Opción | Qué hace |
|---|---|
| Tamaño normal, grande o muy grande | Cambia el tamaño del texto |
| Contraste normal o alto contraste | Cambia los colores para aumentar la diferencia visual |
| Fuente estándar o fuente dislexia | Cambia la fuente de letras |
| Cursor normal o grande | Cambia el puntero del ratón |
| Enlaces normales o resaltados | Hace más visibles los enlaces |
| Sin guía o guía visual | Añade o quita líneas de guía de lectura |
| Animaciones activas o detener animaciones | Reduce movimientos y hace que “Ir arriba” salte al inicio |

Pulse **Aceptar** al final del panel para cerrarlo. También puede pulsar la tecla **Escape**. Las elecciones se guardan en ese navegador.

Puede usar teclado: pulse **Tab** para avanzar por botones y campos, **Enter** para abrir enlaces o botones y **Espacio** para activar botones y opciones.

## 8. Uso en distintas pantallas

| Pantalla | Qué puede esperar |
|---|---|
| Teléfono | Una columna, botones grandes y la tabla docente en tarjetas |
| Tableta | Imágenes y botones cómodos para tocar; es una opción práctica para el aula |
| Laptop o escritorio | Contenido centrado, con espacio para revisar el horario |
| TV o proyector | Texto e imágenes más grandes para mirar desde lejos |

Puede ampliar el navegador si lo necesita. La aplicación permite el zoom del navegador.

## 9. Preguntas frecuentes

| Situación | Qué hacer |
|---|---|
| La página no abre | Revise la dirección. Si sigue sin abrir, pida ayuda a quien configuró la aplicación. |
| Ve una pantalla de error al abrir un día | Puede que no exista un horario para esa fecha. Vuelva al horario del día actual o consulte a quien mantiene la aplicación. |
| El horario parece vacío | Revise que exista una jornada y que las actividades estén activas. La aplicación trae ejemplos al iniciarse. |
| No aparece una imagen | Elija una imagen disponible al editar la actividad. Si el problema continúa, comuníquelo a la persona técnica. |
| El menú de accesibilidad es largo en el teléfono | Desplácese dentro del menú y pulse **Aceptar** al final. |
| El texto no cambia en la vista infantil | En Opciones, elija “Aplicar también para Sofía” o “Aplicar solo para Sofía”; después seleccione el tamaño de texto. |
| Perdí una actividad al reiniciar la aplicación | Es esperable en este prototipo: la información se guarda solo mientras la aplicación está encendida. |

## 10. Privacidad

La aplicación guarda la rutina, las actividades, las imágenes seleccionadas y registros de prueba de finalización mientras está encendida. Al cerrarse, esos datos se eliminan.

Las opciones de accesibilidad se guardan en el navegador del equipo. La aplicación no incluye inicio de sesión, envío de correos, informes ni comunicación automática con familias.

No escriba información sensible en los nombres de actividad. Use palabras sencillas y necesarias para la rutina.

## 11. Límites del prototipo y comentarios

Esta versión es una demostración. No tiene cuentas de usuario, sincronización entre equipos, avisos enviados a familias, guardado permanente ni creación de jornadas desde la pantalla.

El equipo técnico no ha definido un canal de comentarios dentro de la aplicación. Comparta dudas, errores o ideas mediante el medio acordado con la persona o equipo que la instaló.
