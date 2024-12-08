document.addEventListener('DOMContentLoaded', (event) => {
    const radios = document.querySelectorAll('input[name="monto"]');
    const inputEspecifico = document.getElementById('inputOtroMonto');

    radios.forEach(radio => {
        radio.addEventListener('change', () => {
            if (radio.value === 'otro') {
                inputEspecifico.style.display = 'block'; // Muestra el input
            } else {
                inputEspecifico.style.display = 'none'; // Oculta el input
            }
        });
    });
});