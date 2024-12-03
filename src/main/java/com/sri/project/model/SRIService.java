package com.sri.project.model;

import com.sri.soap.RecepcionComprobantesOffline;
import com.sri.soap.RecepcionComprobantesOfflineService;
import com.sri.soap.RespuestaSolicitud;

import java.util.Base64;

public class SRIService {

    public RespuestaSolicitud validarComprobante(String xmlBase64) {
        try {
            // Crear una instancia del servicio
            RecepcionComprobantesOfflineService service = new RecepcionComprobantesOfflineService();
            RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();

            // Limpiar el string Base64 para eliminar espacios y caracteres no válidos
            String sanitizedBase64 = xmlBase64.replaceAll("\\s+", "");

            // Decodificar el XML en Base64 a byte[]
            byte[] decodedXml = Base64.getDecoder().decode(sanitizedBase64);

            // Llamar al servicio con los bytes decodificados
            RespuestaSolicitud response = port.validarComprobante(decodedXml);

            return response;
        } catch (IllegalArgumentException e) {
            System.err.println("Error al decodificar Base64: " + e.getMessage());
            System.err.println("Entrada Base64 proporcionada: " + xmlBase64);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}







