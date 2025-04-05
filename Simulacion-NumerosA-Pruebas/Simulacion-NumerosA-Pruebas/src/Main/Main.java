package Main;  
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------ MENÚ DE GENERACIÓN DE NÚMEROS PSEUDOALEATORIOS ------");
            System.out.println("1. Método de la Parte Central del Cuadrado");
            System.out.println("2. Método de Lahmer");
            System.out.println("3. Método Congruencial Mixto");
            System.out.println("4. Método Congruencial Multiplicativo");
            System.out.println("5. Método Congruencial Aditivo");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la semilla (M): ");
                    int semilla = scanner.nextInt();

                    System.out.print("Ingrese la cantidad de cifras de la semilla (N): ");
                    int cifras = scanner.nextInt();

                    System.out.print("¿Cuántos números desea generar?: ");
                    int cantidad = scanner.nextInt();

                    MetodoPCdelCuadrado metodo = new MetodoPCdelCuadrado(semilla, cifras);
                    List<Double> numeros = metodo.generar(cantidad);

                    System.out.println("\n---- RESULTADO FINAL ----");
                    for (int i = 0; i < numeros.size(); i++) {
                       System.out.println("R" + (i + 1) + " = " + numeros.get(i).toString());
                    }
                    System.out.println();
                    break;
                    
                case 2:
                    System.out.print("Ingrese la semilla (M): ");
                    int semillaL = scanner.nextInt();

                    System.out.print("Ingrese el valor de t: ");
                    int t = scanner.nextInt();

                    System.out.print("¿Cuántos números desea generar?: ");
                    int cantL = scanner.nextInt();

                    MetodoLehmer lehmer = new MetodoLehmer(semillaL, t);
                    List<Double> resultados = lehmer.generar(cantL);

                    System.out.println("Números generados:");
                    for (int i = 0; i < resultados.size(); i++) {
                          System.out.println("R" + (i + 1) + " = " + resultados.get(i).toString());
                    }
                    break;
                    
                case 3:
                    System.out.print("Ingrese la semilla (n0): ");
                    int se = scanner.nextInt();

                    System.out.print("Ingrese la constante multiplicativa (a): ");
                    int a = scanner.nextInt();

                    System.out.print("Ingrese la constante aditiva (c): ");
                    int c = scanner.nextInt();

                    System.out.print("Ingrese el módulo (m): ");
                    int m = scanner.nextInt();

                    System.out.print("¿Cuántos números desea generar?: ");
                    int cant = scanner.nextInt();

                    MetodoCMixto mixto = new MetodoCMixto(se, a, c, m);
                    List<Double> numerosMixtos = mixto.generar(cant);

                    System.out.println("\nNúmeros generados:");
                    for (int i = 0; i < numerosMixtos.size(); i++) {
                        System.out.printf("R%d = %.4f\n", i + 1, numerosMixtos.get(i));
                    }
                    break;
                    
                case 4:
                    System.out.print("Ingrese semilla: ");
                    int semillaM = scanner.nextInt();
                    System.out.print("Ingrese constante multiplicativa (a): ");
                    int aM = scanner.nextInt();
                    System.out.print("Ingrese módulo (m): ");
                    int mM = scanner.nextInt();
                    System.out.print("Ingrese cantidad de números a generar: ");
                    int cantidadM = scanner.nextInt();

                    MetodoCMultiplicativo metodoMult = new MetodoCMultiplicativo(semillaM, aM, mM);
                    List<Double> numerosMult = metodoMult.generar(cantidadM);
                    break;

                case 5:
                    
                    
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.\n");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}