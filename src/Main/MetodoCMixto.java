package Main;

import java.util.ArrayList;
import java.util.List;

public class MetodoCMixto {
    private final int semilla;
    private final int a;
    private final int c;
    private final int m;

    public MetodoCMixto(int semilla, int a, int c, int m) {
        this.semilla = semilla;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public List<Double> generar(int cantidad) {
        List<Double> numeros = new ArrayList<>();
        int ni = semilla;

        for (int i = 0; i < cantidad; i++) {
            int producto = a * ni + c;
            int nuevoNi = producto % m;
            double ui = (double) nuevoNi / m;
            numeros.add(ui);

            // Paso a paso
            System.out.println("J = " + (i + 1) + ":");
            System.out.printf("ni = %d\n", ni);
            System.out.printf("a * ni + c = %d * %d + %d = %d\n", a, ni, c, producto);
            System.out.printf("ni+1 = %d mod %d = %d\n", producto, m, nuevoNi);
            System.out.printf("u%d = %d / %d = %.4f\n\n", i + 1, nuevoNi, m, ui);

            ni = nuevoNi; // actualizar semilla para el próximo
        }

        return numeros;
    }
}
