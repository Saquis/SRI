package com.sri.project.util;

import com.sri.project.model.SRIService;
import com.sri.soap.RespuestaSolicitud;

public class TestSRIService {
    public static void main(String[] args) {
        // Instancia del servicio
        SRIService sriService = new SRIService();

        // Base64 generado del XML
        String xmlBase64 = "PGNvbXByb2JhbnRlPjxjbGF2ZUFjY2Vzbz4xMjM0NTY3ODkwPC9jbGF2ZUFjY2Vzbz48L2NvbXByb2JhbnRlPg=="; // Reemplaza este valor

        // Llamar al método para validar el comprobante
        try {
            RespuestaSolicitud response = sriService.validarComprobante(xmlBase64);
            if (response != null) {
                System.out.println("Estado de la respuesta: " + response.getEstado());
            } else {
                System.out.println("Error al validar el comprobante.");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la validación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


