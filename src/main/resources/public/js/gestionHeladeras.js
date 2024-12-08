document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const registroHeladerasBoton = document.getElementById('registroHeladeras');
    const administrarHeladerasExistentes = document.getElementById('administrarHeladerasExistentes');
    const editarHeladeraBoton = document.getElementById('editarHeladeraBoton');
    const eliminarHumanoBoton = document.getElementById('eliminarHeladeraBoton');


    // Añade un evento 'click' al botón
    registroHeladerasBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/colaboraciones/hacerCargoDeUnaHeladera'; // Reemplaza con la URL a la que deseas redirigir
    });

    administrarHeladerasExistentes.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/administracionHeladerasExistentes'; // Reemplaza con la URL a la que deseas redirigir
    });

    editarHeladeraBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/gestionUsuarios/update'; // Reemplaza con la URL a la que deseas redirigir
    });

    eliminarHumanoBoton.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '/borradoExitoso'; // Reemplaza con la URL a la que deseas redirigir
    });

});