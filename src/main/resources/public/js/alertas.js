function cambiarAlerta() {
    const tipoAlerta = document.getElementById("tipoAlerta").value;
    const textArea = document.getElementById("alertas");

    let alertasTexto = "";

    if (tipoAlerta === "fraude") {
        alertasTexto = 
                `Alerta 1: \n- En la heladera: 1234 \n- Fecha y Hora : 11/09/2024 19:00 \n- Valor: 100 \n\nAlerta 2: \n- En la heladera: 4567 \n- Fecha y Hora : 11/09/2024 19:00 \n- Valor: 100`;
    } else if (tipoAlerta === "conexion") {
        alertasTexto = 
                `Alerta 1: \n- En la heladera: 2345 \n- Fecha y Hora del Alta: 10/09/2024 18:00 \n- Fecha y Hora de Ejecucion: 11/09/2024 19:00 \n- Motivo: Falta de conexión detectada \n- Tarjeta: 123456789 \n- Cantidad: 100 \n- Estado: Falso \n\nAlerta 2: \n- En la heladera: 6789 \n- Fecha y Hora del Alta: 10/09/2024 18:00 \n- Fecha y Hora de Ejecucion: 11/09/2024 19:00 \n- Motivo: Problema con la conexión a internet \n- Tarjeta: 851905362 \n- Cantidad: 70 \n- Estado: Verdadero`;
    } else if (tipoAlerta === "temperatura") {
        alertasTexto = 
                `Alerta 1: \n- Persona: Michael Scott \n- Temperatura: 3 \n- Fecha y Hora : 11/09/2024 19:00 \n\nAlerta 2: \n- Persona: Jim Halpert \n- Temperatura: 28 \n- Fecha y Hora : 11/09/2024 19:00`;
    } else {
        alertasTexto = "";
    }

    textArea.value = alertasTexto;
}
