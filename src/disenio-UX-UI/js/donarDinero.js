// Seleccionar los elementos de radio y el campo de texto
const radioOtro = document.getElementById('radioOtro');
const inputOtroMonto = document.getElementById('inputOtroMonto');
const radiosMonto = document.querySelectorAll('.radioMonto');

// Escuchar el cambio en los radios
radiosMonto.forEach(radio => {
    radio.addEventListener('change', () => {
        if (radio.value === 'otro') {
            inputOtroMonto.disabled = false;  // Habilitar campo de texto si elige "Otro monto"
            inputOtroMonto.focus();           // Hacer foco en el campo de texto para que pueda empezar a escribir
            inputOtroMonto.required = true;   // Requerir que complete este campo
        } else {
            inputOtroMonto.disabled = true;   // Deshabilitar el campo si elige un monto preestablecido
            inputOtroMonto.required = false;  // No es necesario llenar el campo de texto
            inputOtroMonto.value = '';        // Limpiar el campo de texto
        }
    });
});
