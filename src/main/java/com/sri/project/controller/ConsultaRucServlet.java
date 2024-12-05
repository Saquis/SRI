package com.sri.project.controller;

import com.sri.project.model.SRIService;
import com.sri.soap.RespuestaSolicitud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ConsultaRucServlet", urlPatterns = {"/ConsultaRucServlet"})
public class ConsultaRucServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ruc = request.getParameter("ruc");

        // Validación básica del RUC
        if (ruc == null || ruc.length() != 13 || !ruc.matches("\\d+")) {
            request.setAttribute("error", "El RUC ingresado no es válido.");
            request.getRequestDispatcher("resultados.jsp").forward(request, response);
            return;
        }

        // Llamar al servicio SRI
        SRIService sriService = new SRIService();
        RespuestaSolicitud respuesta = sriService.validarComprobante(ruc);

        // Log de depuración
        System.out.println("Estado de la respuesta: " + (respuesta != null ? respuesta.getEstado() : "null"));
        if (respuesta != null && respuesta.getComprobantes() != null) {
            System.out.println("Comprobantes:");
            respuesta.getComprobantes().getComprobante().forEach(comprobante -> {
                System.out.println(comprobante);
            });
        } else {
            System.out.println("No se encontraron comprobantes.");
        }

        // Verificar respuesta del servicio
        if (respuesta != null && respuesta.getEstado() != null) {
            request.setAttribute("estado", respuesta.getEstado());
            if (respuesta.getComprobantes() != null && respuesta.getComprobantes().getComprobante() != null) {
                request.setAttribute("comprobantes", respuesta.getComprobantes().getComprobante());
            } else {
                request.setAttribute("comprobantes", new ArrayList<>()); // Lista vacía si no hay comprobantes
            }
        } else {
            request.setAttribute("error", "No se pudo obtener información del servicio.");
        }

        // Redirigir a resultados.jsp
        request.getRequestDispatcher("resultados.jsp").forward(request, response);
    }
}




