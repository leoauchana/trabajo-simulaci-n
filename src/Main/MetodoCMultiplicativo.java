package Main;


import java.util.ArrayList;
import java.util.List;

public class MetodoCMultiplicativo {
    private final int semilla;
    private final int a;
    private final int m;

    public MetodoCMultiplicativo(int semilla, int a, int m) {
        this.semilla = semilla;
        this.a = a;
        this.m = m;
    }

    public List<Double> generar(int cantidad) {
        List<Double> numeros = new ArrayList<>();
        int ni = semilla;

        for (int i = 0; i < cantidad; i++) {
            int producto = a * ni;
            int nuevoNi = producto % m;
            double ui = (double) nuevoNi / m;
            numeros.add(ui);

            // Mostrar paso a paso
            System.out.println("J = " + (i + 1) + ":");
            System.out.printf("ni = %d\n", ni);
            System.out.printf("a * ni = %d * %d = %d\n", a, ni, producto);
            System.out.printf("ni+1 = %d mod %d = %d\n", producto, m, nuevoNi);
            System.out.printf("u%d = %d / %d = %.3f\n\n", i + 1, nuevoNi, m, ui);

            ni = nuevoNi;
        }

        return numeros;
    }
}

