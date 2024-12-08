package ar.edu.utn.frba.dds.utils.cron;

import ar.edu.utn.frba.dds.models.entities.reportes.IReporte;
import ar.edu.utn.frba.dds.models.entities.reportes.tiposDeReportesSemanales.ReporteFallasPorHeladeras;
import ar.edu.utn.frba.dds.models.entities.reportes.tiposDeReportesSemanales.ReporteMovimientoDeViandasPorHeladera;
import ar.edu.utn.frba.dds.models.entities.reportes.tiposDeReportesSemanales.ReporteViandasPorColaborador;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GenerarReportes {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        // Numero de semana
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());

        // Año de la semana
        int weekYear = date.get(weekFields.weekBasedYear());

        // Crear un documento
        Document pdf = new Document();

        try {
            // Crear un escritor de PDF que enviará el documento a un archivo
            PdfWriter.getInstance(pdf, new FileOutputStream("Reporte semana " + weekNumber + " anio " + weekYear + ".pdf"));

            pdf.open();

            pdf.add(new Paragraph("----------------------------------------- REPORTES SEMANALES ---------------------------------------------------"));
            pdf.add(new Paragraph(new ReporteFallasPorHeladeras().hacerReporte()));
            pdf.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
            pdf.add(new Paragraph(new ReporteMovimientoDeViandasPorHeladera().hacerReporte()));
            pdf.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
            pdf.add(new Paragraph(new ReporteViandasPorColaborador().hacerReporte()));
            pdf.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            pdf.close();
        }
    }
}


/*
 PARA ABRIR EL ARCHIVO .JAR, ABRO LA TERMINAL Y PONGO: java -jar ruta/al/archivo/archivo.jar
*/