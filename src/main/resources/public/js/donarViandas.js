document.addEventListener('DOMContentLoaded', (event) => {
    const botonHeladeraNuestra = document.getElementById('botonHeladeraNuestra');
    const botonHeladeraRecomendada = document.getElementById('botonHeladeraRecomendada');
    const seleccionHeladeraNuestra = document.getElementById('seleccionHeladeraNuestra');
    const seleccionHeladeraRecomendada = document.getElementById('seleccionHeladeraRecomendada');

    // Ocultar ambos selects al inicio
    seleccionHeladeraNuestra.style.display = 'none';
    seleccionHeladeraRecomendada.style.display = 'none';

    // Listener para Heladera Nuestra
    botonHeladeraNuestra.addEventListener('change', () => {
        if (botonHeladeraNuestra.checked) {
            seleccionHeladeraNuestra.style.display = 'block';
            seleccionHeladeraRecomendada.style.display = 'none'; // Oculta el otro select
            seleccionHeladeraRecomendada.selectedIndex = 0; // Resetea la selección del otro select
        }
    });

    // Listener para Heladera Recomendada
    botonHeladeraRecomendada.addEventListener('change', () => {
        if (botonHeladeraRecomendada.checked) {
            seleccionHeladeraRecomendada.style.display = 'block';
            seleccionHeladeraNuestra.style.display = 'none'; // Oculta el otro select
            seleccionHeladeraNuestra.selectedIndex = 0; // Resetea la selección del otro select
        }
    });
});
