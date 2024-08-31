package org.tarea.model;

import java.time.LocalDate;

public class Pedido {
    private final String codigo;
    private LocalDate fechaPedido;
    private final String nombreCliente;
    private final String producto;
    private int unidades;
    private double precio;

    // Constructor
    public Pedido(String codigo, LocalDate fechaPedido, String nombreCliente, String producto, int unidades, double precio) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.nombreCliente = nombreCliente;
        this.producto = producto;
        this.unidades = unidades;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    // Método para calcular los días desde la fecha de pedido
    public long calcularDiasDesdePedido() {
        LocalDate hoy = LocalDate.now();
        return java.time.temporal.ChronoUnit.DAYS.between(fechaPedido, hoy);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", producto='" + producto + '\'' +
                ", unidades=" + unidades +
                ", precio=" + precio +
                '}';
    }
}

