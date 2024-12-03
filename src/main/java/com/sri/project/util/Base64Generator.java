package com.sri.project.util;
import java.util.Base64;

public class Base64Generator {
    public static void main(String[] args) {
        // XML de prueba
        String xml = "<comprobante><claveAcceso>1234567890</claveAcceso></comprobante>";

        // Convertir el XML a Base64
        String base64Encoded = Base64.getEncoder().encodeToString(xml.getBytes());

        // Mostrar el resultado
        System.out.println("Base64 Encoded XML: " + base64Encoded);
    }

}
