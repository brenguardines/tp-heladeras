document.addEventListener("DOMContentLoaded", function () {
    // Crear el mapa, centrado en la primera coordenada
    const map = L.map('map').setView([coordenadas[0].lat, coordenadas[0].lng], 13);

    // Agregar una capa de OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '© OpenStreetMap contributors'
    }).addTo(map);

    // Añadir marcadores para cada coordenada
    coordenadas.forEach(coord => {
        L.marker([coord.lat, coord.lng])
            .addTo(map)
            .bindPopup(`Lat: ${coord.lat}, Lng: ${coord.lng}`);
    });
});
