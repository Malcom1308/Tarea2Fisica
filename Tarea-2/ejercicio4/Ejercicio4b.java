package ejercicio4;

import java.util.Scanner;

public class Ejercicio4b{

     public static double calcularSeparacion(double a1, double a2, double t, double d0) {
        double d1 = 0.5 * a1 * t * t;
        double d2 = 0.5 * a2 * t * t;
        return d0 + d1 + d2;
    }

    public static double calcularTiempoEncuentro(double a1, double a2, double d0) {
        return Math.sqrt((2 * d0) / (a1 + a2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese la aceleración del carrito 1 (m/s²): ");
            double a1 = scanner.nextDouble();

            System.out.print("Ingrese la aceleración del carrito 2 (m/s²): ");
            double a2 = scanner.nextDouble();

            System.out.print("Ingrese la separación inicial (m): ");
            double d0 = scanner.nextDouble();

            System.out.print("Ingrese el tiempo para calcular la separación (s): ");
            double t = scanner.nextDouble();

            double separacion = calcularSeparacion(a1, a2, t, d0);
            System.out.printf("La separación después de %.2f s es: %.2f m%n", t, separacion);

            double tiempoEncuentro = calcularTiempoEncuentro(a1, a2, d0);
            System.out.printf("El tiempo para que los pilotos se encuentren es: %.2f s%n", tiempoEncuentro);
        } catch (Exception e) {
            System.out.println("Por favor, ingrese valores numéricos válidos.");
        } finally {
            scanner.close();
        }
    }

}