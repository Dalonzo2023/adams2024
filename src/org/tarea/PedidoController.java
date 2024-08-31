package org.tarea.controller;

import org.tarea.model.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidoController {
    private ArrayList<Pedido> pedidos;

    public PedidoController() {
        this.pedidos = new ArrayList<>();
        // Agregando 5 pedidos iniciales
        pedidos.add(new Pedido("001", LocalDate.of(2023, 8, 20), "Juan Perez", "Laptop", 2, 1500.00));
        pedidos.add(new Pedido("002", LocalDate.of(2023, 8, 22), "Maria Garcia", "Smartphone", 1, 800.00));
        pedidos.add(new Pedido("003", LocalDate.of(2023, 8, 25), "Carlos Lopez", "Tablet", 3, 600.00));
        pedidos.add(new Pedido("004", LocalDate.of(2023, 8, 26), "Ana Torres", "Smartwatch", 5, 200.00));
        pedidos.add(new Pedido("005", LocalDate.of(2023, 8, 28), "Luis Ramirez", "Monitor", 1, 300.00));
    }

    public void crearPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del pedido: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese la fecha del pedido (YYYY-MM-DD): ");
        LocalDate fechaPedido = LocalDate.parse(scanner.nextLine());

        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.print("Ingrese el producto: ");
        String producto = scanner.nextLine();

        System.out.print("Ingrese la cantidad de unidades: ");
        int unidades = scanner.nextInt();

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        Pedido nuevoPedido = new Pedido(codigo, fechaPedido, nombreCliente, producto, unidades, precio);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido creado exitosamente.");
    }

    public void modificarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del pedido a modificar: ");
        String codigo = scanner.nextLine();

        Pedido pedido = buscarPedido(codigo);
        if (pedido != null) {
            System.out.print("Ingrese la nueva fecha del pedido (YYYY-MM-DD) o presione Enter para mantener la actual: ");
            String nuevaFecha = scanner.nextLine();
            if (!nuevaFecha.isEmpty()) {
                pedido.setFechaPedido(LocalDate.parse(nuevaFecha));
            }

            System.out.print("Ingrese la nueva cantidad de unidades o presione Enter para mantener la actual: ");
            String nuevasUnidades = scanner.nextLine();
            if (!nuevasUnidades.isEmpty()) {
                pedido.setUnidades(Integer.parseInt(nuevasUnidades));
            }

            System.out.println("Pedido modificado exitosamente.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public void mostrarDiasDesdePedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del pedido: ");
        String codigo = scanner.nextLine();

        Pedido pedido = buscarPedido(codigo);
        if (pedido != null) {
            long dias = pedido.calcularDiasDesdePedido();
            System.out.println("Han pasado " + dias + " días desde que se realizó el pedido.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public void eliminarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del pedido a eliminar: ");
        String codigo = scanner.nextLine();

        Pedido pedido = buscarPedido(codigo);
        if (pedido != null) {
            pedidos.remove(pedido);
            System.out.println("Pedido eliminado exitosamente.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    private Pedido buscarPedido(String codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo().equals(codigo)) {
                return pedido;
            }
        }
        return null;
    }

    public void mostrarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }
}

