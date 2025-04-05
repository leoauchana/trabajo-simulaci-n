package Main;

import java.util.ArrayList;
import java.util.List;


public class MetodoPCdelCuadrado {
    private final int semilla;
    private final int n; 

    public MetodoPCdelCuadrado(int semilla, int cifras) {
        this.semilla = semilla;
        this.n = cifras;
    }

    public List<Double> generar(int total) {
        List<Double> numeros = new ArrayList<>();

        int mActual = semilla;

        for (int j = 0; j < total; j++) {
            int x = mActual * mActual;
            String xStr = String.valueOf(x);
            int diferencia = xStr.length() - n;

            System.out.println("J = " + (j + 1) + ":");
            System.out.println("Semilla (M): " + mActual);
            System.out.println("X = M^2 = " + x);

            if (diferencia % 2 != 0) {
                x *= 10;
                xStr = String.valueOf(x);
                System.out.println("El número de dígitos de X - N es impar. Se multiplica X por 10:");
                System.out.println("X = " + x);
            } else {
                System.out.println("El número de dígitos de X - N es par. No se multiplica.");
            }

            // Extraer n dígitos centrales
            int inicio = (xStr.length() - n) / 2;
            String mStr = xStr.substring(inicio, inicio + n);

            mActual = Integer.parseInt(mStr);
            double u = mActual / Math.pow(10, n);
            numeros.add(u);

            System.out.println("N dígitos centrales = " + mStr);
           System.out.println(String.format("u%d = %." + n + "f\n", j + 1, u));
            System.out.println("----------------------------------------");
        }

        return numeros;
    }
}