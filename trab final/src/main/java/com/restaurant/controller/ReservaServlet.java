package com.restaurant.controller;

import com.google.gson.Gson;
import com.restaurant.dao.ReservaDAO;
import com.restaurant.model.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/reservas")
public class ReservaServlet extends HttpServlet {
    private ReservaDAO reservaDAO;
    private Gson gson;

    @Override
    public void init() {
        reservaDAO = new ReservaDAO();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        BufferedReader reader = req.getReader();
        Reserva reserva = gson.fromJson(reader, Reserva.class);

        boolean success = false;
        if (reserva != null && reserva.getMesaId() > 0 && reserva.getNomeCliente() != null) {
            success = reservaDAO.criarReserva(reserva);
        }

        PrintWriter out = resp.getWriter();
        if (success) {
            out.print("{\"success\": true, \"message\": \"Reserva realizada com sucesso!\"}");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"success\": false, \"message\": \"Erro ao realizar reserva. Mesa pode estar ocupada.\"}");
        }
        out.flush();
    }
}
