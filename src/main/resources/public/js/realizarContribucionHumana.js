document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const botonDonarVianda = document.getElementById('donarVianda');
    const botonDonarDinero = document.getElementById('donarDinero');
    const botonDistribuirViandas = document.getElementById('distribuirViandas');
    const botonregistrarPersonaVulnerable = document.getElementById('registrarPersonaVulnerable');


    botonDonarDinero.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/donarDinero'; // Reemplaza con la URL a la que deseas redirigir
        console.log("asdasdasdasdasdas");
    });

    // Añade un evento 'click' al botón
    botonDonarVianda.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/donarViandas'; // Reemplaza con la URL a la que deseas redirigir
    });

    botonDistribuirViandas.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/distribuirViandas'; // Reemplaza con la URL a la que deseas redirigir
    });

    botonregistrarPersonaVulnerable.addEventListener('click', () => {
        // Redirige a la página deseada
        console.log('Click en Registrar Persona Vulnerable detectado');
        window.location.href = '/colaboraciones/registrarPersona'; // Reemplaza con la URL a la que deseas redirigir
    });
});