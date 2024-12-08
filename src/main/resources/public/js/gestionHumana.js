document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const registroPersonaHumanaBoton = document.getElementById('registroPersonaHumanaBoton');
    const administrarPersonasHumanasExistentes = document.getElementById('administrarPersonasHumanasExistentes');
    const editarHumanoBoton = document.getElementById('editarHumanoBoton');
    const eliminarHumanoBoton = document.getElementById('eliminarHumanoBoton');


    // Añade un evento 'click' al botón
    registroPersonaHumanaBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/personaHumana/register'; // Reemplaza con la URL a la que deseas redirigir
    });

    administrarPersonasHumanasExistentes.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/administracionHumanosExistentes'; // Reemplaza con la URL a la que deseas redirigir
    });

    editarHumanoBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/gestionUsuarios/update'; // Reemplaza con la URL a la que deseas redirigir
    });

    eliminarHumanoBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/borradoExitoso'; // Reemplaza con la URL a la que deseas redirigir
    });

});