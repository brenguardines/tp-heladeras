document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const botonDonarVianda = document.getElementById('donarVianda');
    const botonDonarDinero = document.getElementById('donarDinero');
    const botonDistribuirViandas = document.getElementById('distribuirViandas');
    const botonHacerceCargoDeHeladera = document.getElementById('hacerceCargoDeHeladera');
    const botonDonarOferta = document.getElementById('donarOferta');

    // Añade un evento 'click' al botón
    botonDonarVianda.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/donarViandas.html'; // Reemplaza con la URL a la que deseas redirigir
    });
    
    botonDonarDinero.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/donarDinero.html'; // Reemplaza con la URL a la que deseas redirigir
    });

    botonDistribuirViandas.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/distribuirViandas.html'; // Reemplaza con la URL a la que deseas redirigir
    });

    botonHacerceCargoDeHeladera.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/hacerceCargoDeHeladera.html'; // Reemplaza con la URL a la que deseas redirigir
    });

q
});