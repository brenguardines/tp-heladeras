document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const registroPersonaHumanaBoton = document.getElementById('registroPersonaHumanaBoton');
    const registroPersonaJuridicaBoton = document.getElementById('registroPersonaJuridicaBoton');

    // Añade un evento 'click' al botón
    registroPersonaHumanaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/registroPersonaHumana.html'; // Reemplaza con la URL a la que deseas redirigir
    });

    registroPersonaJuridicaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/registroPersonaJuridica.html'; // Reemplaza con la URL a la que deseas redirigir
    });

});