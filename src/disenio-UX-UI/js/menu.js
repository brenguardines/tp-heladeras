// Agregar Eventos Click al Inicializar
window.onload = function() {

	let burger = document.getElementById("burger-menu");

    burger.addEventListener("click", function() {
        document.body.classList.toggle("open");
    });

};
