import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";
        Integer monedaOriginal = null;
        Integer monedaDestino = null;
        String argumento1 = null;
        String argumento2 = null;
        double tasaDeCambio = 0;
        double cantidadAConvertir = 0;
        double resultado = 0;

        MenuPrincipal.lanzarMensaje();
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println(ANSI_BLUE + "Selecciona la moneda que deseas convertir (1-COP, 2-ARS, 3-MXN, 4-USD, 5-CAD, 6-EUR, 7-DOP) o 0 para salir:" + ANSI_RESET);
            try {
                monedaOriginal = teclado.nextInt();
                if (monedaOriginal == 0) {
                    System.out.println("Gracias por utilizar el conversor de monedas.");
                    break;
                }
                if (monedaOriginal < 1 || monedaOriginal > 7) {
                    System.out.println(ANSI_RED + "Opción no válida" + ANSI_RESET);
                    System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                    continue;
                }
                switch (monedaOriginal) {
                    case 1 -> argumento1 = "COP";
                    case 2 -> argumento1 = "ARS";
                    case 3 -> argumento1 = "MXN";
                    case 4 -> argumento1 = "USD";
                    case 5 -> argumento1 = "CAD";
                    case 6 -> argumento1 = "EUR";
                    case 7 -> argumento1 = "DOP";
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Entrada no válida" + ANSI_RESET);
                teclado.next(); // clear the invalid input
                System.out.println("""
                        **************************
                        *      Reiniciando       *
                        **************************
                        """);
                continue;
            }

            System.out.println(ANSI_BLUE + "Escoge la moneda destino (1-COP, 2-ARS, 3-MXN, 4-USD, 5-CAD, 6-EUR, 7-DOP) o 0 para salir:" + ANSI_RESET);
            try {
                monedaDestino = teclado.nextInt();
                if (monedaDestino == 0) {
                    System.out.println("Gracias por utilizar el conversor de monedas.");
                    break;
                }
                if (monedaDestino < 1 || monedaDestino > 7) {
                    System.out.println(ANSI_RED + "Opción no válida" + ANSI_RESET);
                    System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                    continue;
                }
                switch (monedaDestino) {
                    case 1 -> argumento2 = "COP";
                    case 2 -> argumento2 = "ARS";
                    case 3 -> argumento2 = "MXN";
                    case 4 -> argumento2 = "USD";
                    case 5 -> argumento2 = "CAD";
                    case 6 -> argumento2 = "EUR";
                    case 7 -> argumento2 = "DOP";
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Entrada no válida" + ANSI_RESET);
                teclado.next(); // clear the invalid input
                System.out.println("""
                        **************************
                        *      Reiniciando       *
                        **************************
                        """);
                continue;
            }

            System.out.println(ANSI_BLUE + "Ingrese la cantidad de dinero a cambiar (" + argumento1 + ") o 0 para salir:" + ANSI_RESET);
            try {
                cantidadAConvertir = teclado.nextDouble();
                if (cantidadAConvertir == 0) {
                    System.out.println("Gracias por utilizar el conversor de monedas.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Entrada no válida" + ANSI_RESET);
                teclado.next(); // clear the invalid input
                System.out.println("""
                        **************************
                        *      Reiniciando       *
                        **************************
                        """);
                continue;
            }

            tasaDeCambio = BuscarTasaDeCambio.generarTasa(argumento1, argumento2);
            resultado = tasaDeCambio * cantidadAConvertir;

            System.out.println(ANSI_YELLOW + cantidadAConvertir + " " + argumento1 + " equivalen a: " + new DecimalFormat("#.##").format(resultado) + " " + argumento2 + ANSI_RESET);

            System.out.println("¿Deseas realizar otra conversión? (si/no):");
            String rta = teclado.next();
            if (rta.equalsIgnoreCase("si")) {
                MenuPrincipal.lanzarMensaje();
            } else if (rta.equalsIgnoreCase("no")) {
                System.out.println("Gracias por utilizar el conversor de monedas.");
                break;
            } else {
                System.out.println(ANSI_RED + "Opción no válida. Saliendo del programa." + ANSI_RESET);
                break;
            }
        }

        teclado.close();
    }
}

