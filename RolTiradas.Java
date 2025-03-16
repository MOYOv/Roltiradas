import java.util.Random;
import java.util.Scanner;

public class RolTiradas {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static int tirarD20() {
        return random.nextInt(20) + 1;
    }

    public static int calcularIniciativa(int velocidadExtrema, int reflejos) {
        return tirarD20() + velocidadExtrema + reflejos;
    }

    public static int calcularDaño(int dañoPersonaje, int fuerzaExplosiva) {
        return dañoPersonaje + fuerzaExplosiva;
    }

    public static int calcularBloqueo(int reflejos, int bloqueo) {
        return reflejos + bloqueo;
    }

    public static int calcularGolpe(int velocidadExplosiva) {
        return tirarD20() + velocidadExplosiva;
    }

    public static int aplicarAumento(int resultado, int porcentaje) {
        return resultado + (resultado * porcentaje / 100);
    }

    public static void mostrarResultados(String nombre, int valor) {
        System.out.println(nombre + ": " + valor);
    }

    public static void main(String[] args) {
        System.out.println("Ingrese valores para el personaje:");
        System.out.print("Velocidad Extrema: ");
        int velocidadExtrema = scanner.nextInt();

        System.out.print("Reflejos: ");
        int reflejos = scanner.nextInt();

        System.out.print("Daño del personaje: ");
        int dañoPersonaje = scanner.nextInt();

        System.out.print("Fuerza Explosiva: ");
        int fuerzaExplosiva = scanner.nextInt();

        System.out.print("Bloqueo: ");
        int bloqueo = scanner.nextInt();

        System.out.print("Velocidad Explosiva: ");
        int velocidadExplosiva = scanner.nextInt();

        int iniciativa = calcularIniciativa(velocidadExtrema, reflejos);
        int daño = calcularDaño(dañoPersonaje, fuerzaExplosiva);
        int bloqueoTotal = calcularBloqueo(reflejos, bloqueo);
        int golpe = calcularGolpe(velocidadExplosiva);

        System.out.println("\nResultados:");
        mostrarResultados("Iniciativa", iniciativa);
        mostrarResultados("Daño", daño);
        mostrarResultados("Bloqueo", bloqueoTotal);
        mostrarResultados("Golpe", golpe);

        System.out.print("Desea aplicar un aumento porcentual? (100-500, 0 para ninguno): ");
        int porcentaje = scanner.nextInt();

        if (porcentaje >= 100 && porcentaje <= 500) {
            iniciativa = aplicarAumento(iniciativa, porcentaje);
            daño = aplicarAumento(daño, porcentaje);
            bloqueoTotal = aplicarAumento(bloqueoTotal, porcentaje);
            golpe = aplicarAumento(golpe, porcentaje);

            System.out.println("\nResultados con aumento del " + porcentaje + "%:");
            mostrarResultados("Iniciativa", iniciativa);
            mostrarResultados("Daño", daño);
            mostrarResultados("Bloqueo", bloqueoTotal);
            mostrarResultados("Golpe", golpe);
        }
    }
}
