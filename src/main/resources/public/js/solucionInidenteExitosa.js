document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona los botones usando sus IDs
    const solucionExitosaBoton = document.getElementById("solucionExitosaBoton");

    // Añade eventos 'click' a los botones
    solucionExitosaBoton.addEventListener('click', () => {
        window.location.href = '/solucionIncidenteExitosa'; // Reemplaza con la URL correspondiente
    });
});