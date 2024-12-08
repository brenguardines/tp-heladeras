const map = L.map("map", {
	center: [-34.61315, -58.37723],
	zoom: 13,
});

const tiles = L.tileLayer("https://tile.openstreetmap.org/{z}/{x}/{y}.png", {
	maxZoom: 19,
	attribution:
		'&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>',
}).addTo(map);

L.marker(L.latLng(-34.61315, -58.37723), { opacity: 0.9 }).addTo(map);


document.addEventListener('DOMContentLoaded', (event) => {
    // Selecciona el botón usando su ID
    const botonHacerceCargoDeHeladera = document.getElementById('hacerceCargoDeHeladera');

    botonHacerceCargoDeHeladera.addEventListener('click', () => {
        // Redirige a la página deseada
        window.location.href = '../html/hacerceCargoDeHeladera.html'; // Reemplaza con la URL a la que deseas redirigir
    });
});