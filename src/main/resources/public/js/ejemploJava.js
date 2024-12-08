function cambiarNombre() {
    let cuerpo = document.querySelector("body");
    let nombre = document.getElementById("nombre").value;
    cuerpo.innerHTML = "<h1>Bienvenido "+nombre+"</h1>"
}

function mostrarUOcultarCuadrado() {
    let cuerpo = document.querySelector("body");
    let nombre = document.getElementById("cuadrado");
    if (nombre.style.display === "none") {
        nombre.style.display = "block";
    } else {
        nombre.style.display = "none";
    }
}