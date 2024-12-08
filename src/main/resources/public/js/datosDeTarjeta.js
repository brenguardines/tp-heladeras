document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el formulario y el botón usando sus IDs
    const formulario = document.getElementById('formularioDeDonarDinero');

    // Añade un evento 'submit' al formulario
    formulario.addEventListener('submit', (event) => {
        // Luego redirige a la página deseada
        window.location.href = '../html/datosDeTarjeta.html'; // Reemplaza con la URL a la que deseas redirigir
    });
});
