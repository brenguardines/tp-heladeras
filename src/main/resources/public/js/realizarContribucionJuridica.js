document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const botonDonarDinero = document.getElementById('donarDinero');
    const botonHacerceCargoDeHeladera = document.getElementById('hacerceCargoDeHeladera');
    const botonDonarOferta = document.getElementById('donarOferta');

    botonDonarDinero.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/donarDinero'; // Reemplaza con la URL a la que deseas redirigir
    });

    botonHacerceCargoDeHeladera.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/hacerCargoDeUnaHeladera'; // Reemplaza con la URL a la que deseas redirigir
    });

    botonDonarOferta.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/donarOferta'; // Reemplaza con la URL a la que deseas redirigir
    });
});