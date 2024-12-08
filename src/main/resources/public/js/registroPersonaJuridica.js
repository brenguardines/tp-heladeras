document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('registroExitosoBoton').addEventListener('click', function(event) {

        const calle = document.getElementById('calle');
        const altura = document.getElementById('altura');
        const codigoPostal = document.getElementById('codigoPostal');

        const contra = document.getElementById('contrasenia');
        const contraRepe = document.getElementById('contraseniaRepetida');
        const labelErrorContra = document.getElementById('msjContraError');

        if (calle.value || altura.value || codigoPostal.value) {
            calle.setAttribute('required', 'required');
            altura.setAttribute('required', 'required');
            codigoPostal.setAttribute('required', 'required');
        } else {
            calle.removeAttribute('required');
            altura.removeAttribute('required');
            codigoPostal.removeAttribute('required');
        }

        if (contra.value !== contraRepe.value) {
            event.preventDefault(); // Evita el envío del formulario
            labelErrorContra.textContent="Las contraseñas no son iguales";
            labelErrorContra.style.color='orange';
        }
    });

    document.getElementById('tipoContacto').addEventListener('change', function() {
        const select = document.getElementById('tipoContacto');
        const input = document.getElementById('contacto');
        if (select.value === 'CORREO') {
            input.type = 'text';
        } else {
            input.type = 'number';
        }
    });


});