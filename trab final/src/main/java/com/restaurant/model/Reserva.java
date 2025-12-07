package com.restaurant.model;

import java.sql.Timestamp;

public class Reserva {
    private int id;
    private int mesaId;
    private String nomeCliente;
    private Timestamp dataReserva;

    public Reserva() {}

    public Reserva(int mesaId, String nomeCliente) {
        this.mesaId = mesaId;
        this.nomeCliente = nomeCliente;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMesaId() { return mesaId; }
    public void setMesaId(int mesaId) { this.mesaId = mesaId; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public Timestamp getDataReserva() { return dataReserva; }
    public void setDataReserva(Timestamp dataReserva) { this.dataReserva = dataReserva; }
}
