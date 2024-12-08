document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const botonDonarVianda = document.getElementById('empezarIndex');

    // Añade un evento 'click' al botón
    botonDonarVianda.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/login'; // Reemplaza con la URL a la que deseas redirigir
    });
});