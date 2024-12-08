document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const registroExitosoBoton = document.getElementById('registroExitosoBoton');
    const colaboracionExitosaBoton = document.getElementById('colaboracionExitosaBoton');
    const suscripcionExitosaBoton = document.getElementById('suscripcionExitosaBoton');
    const puntosInsuficientes = document.getElementById('puntosInsuficientes');

    // Añade un evento 'click' al botón
    registroExitosoBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../mensajes/exitos/registroExitoso.hbs'; // Reemplaza con la URL a la que deseas redirigir
    });

    colaboracionExitosaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../mensajes/exitos/colaboracionExitosaHumana.hbs'; // Reemplaza con la URL a la que deseas redirigir
    });

    suscripcionExitosaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../mensajes/exitos/suscripcionExitosa.hbs'; // Reemplaza con la URL a la que deseas redirigir
    });

    suscripcionExitosaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../mensajes/errores/puntosInsuficientes.hbs'; // Reemplaza con la URL a la que deseas redirigir
    });
});
