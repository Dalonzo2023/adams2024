import org.tarea.controller.PedidoController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PedidoController controller = new PedidoController();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Pedidos ---");
            System.out.println("1. Crear Pedido");
            System.out.println("2. Modificar Pedido");
            System.out.println("3. Mostrar días desde pedido");
            System.out.println("4. Eliminar Pedido");
            System.out.println("5. Mostrar todos los pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    controller.crearPedido();
                    break;
                case 2:
                    controller.modificarPedido();
                    break;
                case 3:
                    controller.mostrarDiasDesdePedido();
                    break;
                case 4:
                    controller.eliminarPedido();
                    break;
                case 5:
                    controller.mostrarPedidos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
