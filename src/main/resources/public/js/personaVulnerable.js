document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('registroExitosoBoton').addEventListener('click', function() {
        const calle = document.getElementById('calle');
        const altura = document.getElementById('altura');
        const codigoPostal = document.getElementById('codigoPostal');

        const tipoDni = document.getElementById('tipoDocumento');
        const dni = document.getElementById('dni');
        const hijos = document.getElementById('hijos');

        if (tipoDni.value || dni.value) {
            tipoDni.setAttribute('required', 'required');
            dni.setAttribute('required', 'required');
        } else {
            tipoDni.removeAttribute('required');
            dni.removeAttribute('required');
        }

        if (calle.value || altura.value || codigoPostal.value) {
            calle.setAttribute('required', 'required');
            altura.setAttribute('required', 'required');
            codigoPostal.setAttribute('required', 'required');
        } else {
            calle.removeAttribute('required');
            altura.removeAttribute('required');
            codigoPostal.removeAttribute('required');
        }
    });
    document.getElementById('hijos').addEventListener('change', function() {
        const checkbox = document.getElementById('hijos');
        const resultado = document.getElementById('cantidadDeHijos');
        const cantidad = document.getElementById('cantidad');

        if (checkbox.checked) {
            resultado.style.display='block';
            cantidad.setAttribute('required', 'required');
        } else {
            resultado.style.display='none'
            cantidad.removeAttribute('required');
        }
    })
});