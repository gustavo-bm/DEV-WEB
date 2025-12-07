package com.restaurant.controller;

import com.google.gson.Gson;
import com.restaurant.dao.MesaDAO;
import com.restaurant.model.Mesa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/mesas")
public class MesaServlet extends HttpServlet {
    private MesaDAO mesaDAO;
    private Gson gson;

    @Override
    public void init() {
        mesaDAO = new MesaDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        List<Mesa> mesas = mesaDAO.listarMesas();
        String json = gson.toJson(mesas);
        
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }

    // Allow updating status (e.g., freeing a table)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        BufferedReader reader = req.getReader();
        Mesa mesaRequest = gson.fromJson(reader, Mesa.class);

        boolean success = false;
        if (mesaRequest != null && mesaRequest.getId() > 0 && mesaRequest.getStatus() != null) {
             success = mesaDAO.atualizarStatus(mesaRequest.getId(), mesaRequest.getStatus());
        }

        PrintWriter out = resp.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }
}
