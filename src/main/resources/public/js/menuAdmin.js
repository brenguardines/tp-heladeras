document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona los botones usando sus IDs
    const botonGestionHeladeras = document.getElementById('gestionHeladeras');
    const botonGestionUsuarios = document.getElementById('gestionUsuarios');
    const botonCargaCSV = document.getElementById('cargaCSV');
    //const botonVerFallas = document.getElementById('verFallas');
    const botonVerAlertas = document.getElementById('verAlertas');
    const botonVerReportes = document.getElementById('verReportes');
    const botonGestionPersonasVulnerables = document.getElementById('gestionPersonasVulnerables');

    // Añade eventos 'click' a los botones
    botonGestionHeladeras.addEventListener('click', () => {
        window.location.href = '/gestionHeladeras'; // Reemplaza con la URL correspondiente
    });

    botonGestionUsuarios.addEventListener('click', () => {
        window.location.href = '/gestionUsuario'; // Reemplaza con la URL correspondiente
    });

    botonCargaCSV.addEventListener('click', () => {
        window.location.href = '../menuAdmin/cargaCSV'; //
    });

    /* botonVerFallas.addEventListener('click', () => {
        window.location.href = '/fallas'; // Reemplaza con la URL correspondiente
    }); */

    botonVerAlertas.addEventListener('click', () => {
        window.location.href = '/alertas'; // Reemplaza con la URL correspondiente
    });

    botonVerReportes.addEventListener('click', () => {
        window.location.href = '/reportes'; // Reemplaza con la URL correspondiente
    });

    botonGestionPersonasVulnerables.addEventListener('click', () => {
        window.location.href = 'gestionPersonasVulnerables'; // Reemplaza con la URL correspondiente
    });
});
