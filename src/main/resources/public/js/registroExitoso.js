document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona los botones usando sus IDs
    const boton = document.getElementById("registroExitosoBoton");

    // Añade eventos 'click' a los botones
    boton.addEventListener('click', () => {
        window.location.href = '/login'; // Reemplaza con la URL correspondiente
    });
});
