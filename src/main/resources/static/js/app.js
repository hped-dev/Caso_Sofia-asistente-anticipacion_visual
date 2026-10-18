// app.js - JavaScript mínimo para el prototipo
// Sin animaciones intrusivas, sin sonidos, sin autoplay.

document.addEventListener('DOMContentLoaded', function () {
  // Aviso de cambio de rutina: solo visual, sin sonido
  const btnAviso = document.getElementById('btn-aviso-cambio');
  if (btnAviso) {
    btnAviso.addEventListener('click', function () {
      const aviso = document.createElement('div');
      aviso.className = 'aviso-flotante';
      aviso.innerHTML =
        '<strong>⚠️ Cambio pronto</strong><br>' +
        'En pocos minutos cambiamos de actividad.';
      document.body.appendChild(aviso);
      setTimeout(function () {
        aviso.remove();
      }, 5000);
    });
  }

  // Temporizador visual: valor estático mostrado, sin cuenta atrás real
  // para evitar ansiedad por el paso del tiempo sin control.
  const valorTiempo = document.getElementById('valor-tiempo');
  if (valorTiempo && valorTiempo.textContent.trim() === '--') {
    valorTiempo.textContent = '--';
  }

  // =========================================
  // Botón Ir Arriba
  // =========================================
  const btnIrArriba = document.getElementById('btn-ir-arriba');
  if (btnIrArriba) {
    // Mostrar/ocultar botón según scroll
    window.addEventListener('scroll', function () {
      if (window.pageYOffset > 300) {
        btnIrArriba.classList.add('visible');
      } else {
        btnIrArriba.classList.remove('visible');
      }
    });

    // Scroll suave al hacer clic
    btnIrArriba.addEventListener('click', function (e) {
      e.preventDefault();
      const reducirMovimiento = document.body.classList.contains('animaciones-off') ||
        window.matchMedia('(prefers-reduced-motion: reduce)').matches;

      window.scrollTo({
        top: 0,
        behavior: reducirMovimiento ? 'auto' : 'smooth'
      });
    });

    // Comprobar al cargar la página
    if (window.pageYOffset > 300) {
      btnIrArriba.classList.add('visible');
    }
  }

  // =========================================
  // Opciones de Accesibilidad
  // =========================================
  const btnAccesibilidad = document.getElementById('btn-accesibilidad');
  const panelAccesibilidad = document.getElementById('panel-accesibilidad');
  const btnAceptarAccesibilidad = document.getElementById('btn-aceptar-accesibilidad');
  const opcionesDestinoAccesibilidad = document.querySelectorAll('input[name="destino-accesibilidad"]');
  const esVistaDocente = Boolean(btnAccesibilidad && panelAccesibilidad);

  function obtenerDestinoAccesibilidad() {
    const destinoGuardado = localStorage.getItem('destinoAccesibilidad');
    if (destinoGuardado) {
      return destinoGuardado;
    }

    // Conserva la elección realizada con la versión anterior del control.
    return localStorage.getItem('aplicarAccesibilidadSofia') === 'true' ? 'ambos' : 'docente';
  }

  function seAplicaEnVistaActual() {
    const destino = obtenerDestinoAccesibilidad();
    return esVistaDocente ? destino !== 'sofia' : destino !== 'docente';
  }

  function limpiarPreferenciasAccesibilidad() {
    document.documentElement.classList.remove('tamano-texto-grande', 'tamano-texto-muy-grande');
    document.body.classList.remove(
      'contraste-alto',
      'fuente-dislexia',
      'cursor-grande',
      'enlaces-destacados',
      'guia-lectura-on',
      'animaciones-off'
    );
  }

  if (btnAccesibilidad && panelAccesibilidad) {
    function cerrarPanelAccesibilidad() {
      panelAccesibilidad.classList.remove('visible');
      btnAccesibilidad.setAttribute('aria-expanded', 'false');
    }

    // Toggle panel de accesibilidad
    btnAccesibilidad.addEventListener('click', function (e) {
      e.stopPropagation();
      const estaVisible = panelAccesibilidad.classList.toggle('visible');
      btnAccesibilidad.setAttribute('aria-expanded', String(estaVisible));
    });

    // Cerrar panel al hacer clic fuera
    document.addEventListener('click', function (e) {
      if (!panelAccesibilidad.contains(e.target) && !btnAccesibilidad.contains(e.target)) {
        cerrarPanelAccesibilidad();
      }
    });

    document.addEventListener('keydown', function (e) {
      if (e.key === 'Escape' && panelAccesibilidad.classList.contains('visible')) {
        cerrarPanelAccesibilidad();
        btnAccesibilidad.focus();
      }
    });

    if (btnAceptarAccesibilidad) {
      btnAceptarAccesibilidad.addEventListener('click', function () {
        cerrarPanelAccesibilidad();
        btnAccesibilidad.focus();
      });
    }

    // Manejar opciones de accesibilidad
    const opciones = panelAccesibilidad.querySelectorAll('.boton-opcion-accesibilidad');
    opciones.forEach(function (opcion) {
      opcion.addEventListener('click', function () {
        const accion = this.getAttribute('data-accion');
        aplicarOpcionAccesibilidad(accion, this);
      });
    });

    opcionesDestinoAccesibilidad.forEach(function (opcion) {
      opcion.checked = opcion.value === obtenerDestinoAccesibilidad();
      opcion.addEventListener('change', function () {
        localStorage.setItem('destinoAccesibilidad', this.value);
        if (seAplicaEnVistaActual()) {
          cargarPreferenciasAccesibilidad();
        } else {
          limpiarPreferenciasAccesibilidad();
        }
      });
    });
  }

  // La vista docente siempre muestra qué preferencias se han seleccionado.
  // Las clases visuales solo se conservan si el destino actual la incluye.
  if (esVistaDocente) {
    cargarPreferenciasAccesibilidad();
    if (!seAplicaEnVistaActual()) {
      limpiarPreferenciasAccesibilidad();
    }
  } else if (seAplicaEnVistaActual()) {
    cargarPreferenciasAccesibilidad();
  }

  // Función para aplicar opción de accesibilidad
  function aplicarOpcionAccesibilidad(accion, elemento) {
    const body = document.body;
    const html = document.documentElement;
    // Desactivar todos los botones de la misma categoría
    const categoria = accion.split('-')[0];
    const botonesMismaCategoria = document.querySelectorAll('[data-accion^="' + categoria + '-"]');
    botonesMismaCategoria.forEach(function (btn) {
      btn.classList.remove('active');
    });
    elemento.classList.add('active');

    // Aplicar cambios según la acción
    switch (accion) {
      case 'tamano-texto-normal':
        html.classList.remove('tamano-texto-grande', 'tamano-texto-muy-grande');
        localStorage.setItem('tamanoTexto', 'normal');
        break;
      case 'tamano-texto-grande':
        html.classList.remove('tamano-texto-normal', 'tamano-texto-muy-grande');
        html.classList.add('tamano-texto-grande');
        localStorage.setItem('tamanoTexto', 'grande');
        break;
      case 'tamano-texto-muy-grande':
        html.classList.remove('tamano-texto-normal', 'tamano-texto-grande');
        html.classList.add('tamano-texto-muy-grande');
        localStorage.setItem('tamanoTexto', 'muy-grande');
        break;

      case 'contraste-normal':
        body.classList.remove('contraste-alto');
        localStorage.setItem('contraste', 'normal');
        break;
      case 'contraste-alto':
        body.classList.add('contraste-alto');
        localStorage.setItem('contraste', 'alto');
        break;

      case 'fuente-normal':
        body.classList.remove('fuente-dislexia');
        localStorage.setItem('fuente', 'normal');
        break;
      case 'fuente-dislexia':
        body.classList.add('fuente-dislexia');
        localStorage.setItem('fuente', 'dislexia');
        break;

      case 'cursor-normal':
        body.classList.remove('cursor-grande');
        localStorage.setItem('cursor', 'normal');
        break;
      case 'cursor-grande':
        body.classList.add('cursor-grande');
        localStorage.setItem('cursor', 'grande');
        break;

      case 'enlaces-normal':
        body.classList.remove('enlaces-destacados');
        localStorage.setItem('enlaces', 'normal');
        break;
      case 'enlaces-destacados':
        body.classList.add('enlaces-destacados');
        localStorage.setItem('enlaces', 'destacados');
        break;

      case 'guia-lectura-off':
        body.classList.remove('guia-lectura-on');
        localStorage.setItem('guiaLectura', 'off');
        break;
      case 'guia-lectura-on':
        body.classList.add('guia-lectura-on');
        localStorage.setItem('guiaLectura', 'on');
        break;

      case 'animaciones-on':
        body.classList.remove('animaciones-off');
        localStorage.setItem('animaciones', 'on');
        break;
      case 'animaciones-off':
        body.classList.add('animaciones-off');
        localStorage.setItem('animaciones', 'off');
        break;
    }

    if (!seAplicaEnVistaActual()) {
      limpiarPreferenciasAccesibilidad();
    }
  }

  // Cargar preferencias guardadas
  function cargarPreferenciasAccesibilidad() {
    const body = document.body;
    const html = document.documentElement;

    // Tamaño de texto
    const tamanoTexto = localStorage.getItem('tamanoTexto');
    if (tamanoTexto) {
      html.classList.remove('tamano-texto-normal', 'tamano-texto-grande', 'tamano-texto-muy-grande');
      if (tamanoTexto !== 'normal') {
        html.classList.add('tamano-texto-' + tamanoTexto);
        const btn = document.querySelector('[data-accion="tamano-texto-' + tamanoTexto + '"]');
        if (btn) btn.classList.add('active');
      }
    }

    // Contraste
    const contraste = localStorage.getItem('contraste');
    if (contraste === 'alto') {
      body.classList.add('contraste-alto');
      const btn = document.querySelector('[data-accion="contraste-alto"]');
      if (btn) btn.classList.add('active');
    }

    // Fuente
    const fuente = localStorage.getItem('fuente');
    if (fuente === 'dislexia') {
      body.classList.add('fuente-dislexia');
      const btn = document.querySelector('[data-accion="fuente-dislexia"]');
      if (btn) btn.classList.add('active');
    }

    // Cursor
    const cursor = localStorage.getItem('cursor');
    if (cursor === 'grande') {
      body.classList.add('cursor-grande');
      const btn = document.querySelector('[data-accion="cursor-grande"]');
      if (btn) btn.classList.add('active');
    }

    // Enlaces
    const enlaces = localStorage.getItem('enlaces');
    if (enlaces === 'destacados') {
      body.classList.add('enlaces-destacados');
      const btn = document.querySelector('[data-accion="enlaces-destacados"]');
      if (btn) btn.classList.add('active');
    }

    // Guía de lectura
    const guiaLectura = localStorage.getItem('guiaLectura');
    if (guiaLectura === 'on') {
      body.classList.add('guia-lectura-on');
      const btn = document.querySelector('[data-accion="guia-lectura-on"]');
      if (btn) btn.classList.add('active');
    }

    // Animaciones
    const animaciones = localStorage.getItem('animaciones');
    if (animaciones === 'off') {
      body.classList.add('animaciones-off');
      const btn = document.querySelector('[data-accion="animaciones-off"]');
      if (btn) btn.classList.add('active');
    }
  }
});
