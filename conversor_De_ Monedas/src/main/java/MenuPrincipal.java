public class MenuPrincipal {
    public static void lanzarMensaje() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        System.out.println(ANSI_GREEN + "**************************");
        System.out.println("*  Conversor de Monedas  *");
        System.out.println(ANSI_GREEN + "**************************" + ANSI_RESET);
        System.out.println("""
                1. Peso Colombiano
                2. Peso Argentino
                3. Peso Mexicano
                4. Dólar Estadounidense
                5. Dólar Canadiense
                6. Euro
                7. Peso Dominicano
                0. Salir""");
    }
}

