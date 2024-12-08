document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const boton = document.getElementById('aniadirMenorBoton');

    // Añade un evento 'click' al botón
    boton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/aniadirMenor.html'; // Reemplaza con la URL a la que deseas redirigir
    });
});
