function cambiarReporte() {
    const tipoReporte = document.getElementById("tipoReporte").value;
    const textArea = document.getElementById("reportes");

    let reportesTexto = "";

    if (tipoReporte === "falla") {
        reportesTexto = 
                `Alerta 1: \n- En la heladera: 1234 \n- Dia : 11/09/2024 19:00 \n- Descripcion: No abre la puerta \n\nAlerta 2: \n- En la heladera: 4567 \n- Dia : 11/09/2024 19:00 \n- Descripcion: Perdida de temperatura`;
    } else if (tipoReporte === "movimiento") {
        reportesTexto = 
                `Alerta 1: \n- En la heladera: 2345 \n- Se Ingresaron: 22 \n- Se Retiraron: 5 \n\nAlerta 2: \n- En la heladera: 6789 \n- Se Ingresaron: 16 \n- Se Retiraron: 9`;
    } else if (tipoReporte === "viandasColaborador") {
        reportesTexto = 
                `Alerta 1: \n- Persona: Michael Scott \n- Viandas Donadas: 3 \n- Viandas Entregadas: 3 \n\nAlerta 2: \n- Persona: Jim Halpert \n- Viandas Donadas: 7 \n- Viandas Entregadas: 6`;
    } else {
        reportesTexto = "";
    }

    textArea.value = reportesTexto;
}

