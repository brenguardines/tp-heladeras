function togglePassword() {
    const contraseniadInput = document.getElementById('contrasenia');
    const contraseniaRepetidaInput = document.getElementById('contraseniaRepetida');

    if (contraseniadInput.type === 'password') {
        contraseniadInput.type = 'text';
    } else {
        contraseniadInput.type = 'password';
    }

    if (contraseniaRepetidaInput.type === 'password') {
        contraseniaRepetidaInput.type = 'text';
    } else {
        contraseniaRepetidaInput.type = 'password';
    }
}