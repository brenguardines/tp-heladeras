document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const botonSolucionarIncidente = document.getElementById('solucionarIncidente');

    botonSolucionarIncidente.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/tecnico/solucionarIncidente'; // Reemplaza con la URL a la que deseas redirigir
    });
});