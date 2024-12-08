document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const buscarRecomendacion = document.getElementById('buscarRecomendacion');

    // Añade un evento 'click' al botón
    buscarRecomendacion.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/src/main/java/ar/edu/utn/frba/dds/utils/mapasHeladeras/index.html'; // Reemplaza con la URL a la que deseas redirigir
    });
});