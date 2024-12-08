document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const registroExitosoBoton = document.getElementById('registroExitosoBoton');
    const colaboracionExitosaBoton = document.getElementById('colaboracionExitosaBoton');
    const suscripcionExitosaBoton = document.getElementById('suscripcionExitosaBoton');

    // Añade un evento 'click' al botón
    registroExitosoBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/registroExitoso.html'; // Reemplaza con la URL a la que deseas redirigir
    });

    colaboracionExitosaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/colaboracionExitosa.html'; // Reemplaza con la URL a la que deseas redirigir
    });

    suscripcionExitosaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/suscripcionExitosa.html'; // Reemplaza con la URL a la que deseas redirigir
    });
});
