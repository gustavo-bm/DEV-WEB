package com.restaurant.dao;

import com.restaurant.model.Reserva;
import com.restaurant.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    public boolean criarReserva(Reserva reserva) {
        String sqlReserva = "INSERT INTO reservas (mesa_id, nome_cliente) VALUES (?, ?);";
        String sqlUpdateMesa = "UPDATE mesas SET status = 'RESERVADA' WHERE id = ? AND status = 'LIVRE';";

        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // 1. Check if table is free and update it
            try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdateMesa)) {
                stmtUpdate.setInt(1, reserva.getMesaId());
                int rowsUpdated = stmtUpdate.executeUpdate();
                
                if (rowsUpdated == 0) {
                    // Table not found or already reserved
                    conn.rollback();
                    return false;
                }
            }

            // 2. Insert reservation
            try (PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva)) {
                stmtReserva.setInt(1, reserva.getMesaId());
                stmtReserva.setString(2, reserva.getNomeCliente());
                stmtReserva.executeUpdate();
            }

            conn.commit(); // Commit transaction
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
