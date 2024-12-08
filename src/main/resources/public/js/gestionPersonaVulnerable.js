document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const registroPersonaVulnerableBoton = document.getElementById('registroPersonaVulnerable');
    const administrarPersonasVulnerablesExistentes = document.getElementById('administrarPersonasVulnerablesExistentes');
    const editarPersonaVulnerableBoton = document.getElementById('editarPersonaVulnerableBoton');
    const eliminarPersonaVulnerableBoton = document.getElementById('eliminarPersonaVulnerableBoton');


    // Añade un evento 'click' al botón
    registroPersonaVulnerableBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/registrarPersona'; // Reemplaza con la URL a la que deseas redirigir
    });

    administrarPersonasVulnerablesExistentes.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/administracionPersonasVulnerablesExistentes'; // Reemplaza con la URL a la que deseas redirigir
    });

    editarPersonaVulnerableBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/gestionPersonasVulnerables/update'; // Reemplaza con la URL a la que deseas redirigir
    });

    eliminarPersonaVulnerableBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/borradoExitoso'; // Reemplaza con la URL a la que deseas redirigir
    });

});