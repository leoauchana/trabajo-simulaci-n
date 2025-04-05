package Main;
import java.util.ArrayList;
import java.util.List;

public class MetodoLehmer {
    private final int semilla;
    private final int t;
    private final int n;
    private final int k;

    public MetodoLehmer(int semilla, int t) {
        this.semilla = semilla;
        this.t = t;
        this.n = String.valueOf(semilla).length();
        this.k = String.valueOf(t).length();
    }

    public List<Double> generar(int cantidad) {
        List<Double> numeros = new ArrayList<>();
        int ni = semilla;

        for (int i = 0; i < cantidad; i++) {
            int producto = ni * t;
            String productoStr = String.format("%0" + (n + k) + "d", producto);

            String izq = productoStr.substring(0, k);
            String der = productoStr.substring(k);

            int izquierda = Integer.parseInt(izq);
            int derecha = Integer.parseInt(der);

            ni = derecha - izquierda;

            if (ni < 0) {
                ni += (int) Math.pow(10, n);
            }

            // 👇 Agregar ceros A LA DERECHA si ni tiene menos de n cifras
            while (String.valueOf(ni).length() < n) {
                ni *= 10;
            }

            double ui = (double) ni / Math.pow(10, n);
            numeros.add(ui);

            // Mostrar paso a paso
            System.out.printf("J = %d:\n", i + 1);
            System.out.printf("ni * t = %d * %d = %s\n", (ni + izquierda - (int)Math.pow(10, n)), t, productoStr);
            System.out.printf("Izquierda: %s, Derecha: %s\n", izq, der);
            System.out.printf("ni = %d - %d = %d\n", derecha, izquierda, ni);
            System.out.printf("u%d = %.0" + n + "f\n\n", i + 1, ui);
        }

        return numeros;
    }
}
