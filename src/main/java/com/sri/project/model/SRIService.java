package com.sri.project.model;

import com.sri.soap.RecepcionComprobantesOffline;
import com.sri.soap.RecepcionComprobantesOfflineService;
import com.sri.soap.RespuestaSolicitud;

import java.nio.charset.StandardCharsets;

public class SRIService {

    public RespuestaSolicitud validarComprobante(String ruc) {
        try {
            // Validar el RUC
            if (ruc == null || !ruc.matches("\\d{13}")) {
                System.err.println("El RUC proporcionado no es válido.");
                return null;
            }

            // Generar el XML con el RUC
            String xml = generarXML(ruc);
            System.out.println("XML generado:\n" + xml);

            // Convertir el XML a bytes
            byte[] xmlBytes = xml.getBytes(StandardCharsets.UTF_8);

            // Crear una instancia del servicio
            RecepcionComprobantesOfflineService service = new RecepcionComprobantesOfflineService();
            RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();

            // Habilitar logs SOAP
            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");

            // Llamar al servicio con los bytes del XML
            RespuestaSolicitud respuesta = port.validarComprobante(xmlBytes);

            // Verificar la respuesta
            if (respuesta != null) {
                System.out.println("Estado de la respuesta: " + respuesta.getEstado());
            } else {
                System.err.println("La respuesta del servicio es nula.");
            }

            return respuesta;

        } catch (Exception e) {
            System.err.println("Error al procesar el RUC: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private String generarXML(String ruc) {
        // Generar el XML con el RUC
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<comprobante>\n" +
                "    <ruc>" + ruc + "</ruc>\n" +
                "</comprobante>";
    }
}










