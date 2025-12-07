package com.restaurant.model;

public class Mesa {
    private int id;
    private int numero;
    private String status;

    public Mesa() {}

    public Mesa(int id, int numero, String status) {
        this.id = id;
        this.numero = numero;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
