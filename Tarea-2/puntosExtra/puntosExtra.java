package puntosExtra;

import java.util.Scanner;

public class puntosExtra {

    public static void simularMovimiento(double velocidadInicial, double tiempoParada, double desaceleracion, double aceleracion, double distanciaEstacion) {
        double vi = velocidadInicial * 1000 / 3600;

        double intervalo = 1.0; 

        double tiempoTotal = 0;
        double distanciaRecorrida = 0;
        double velocidadActual = vi;
        boolean enParada = false;

        while (distanciaRecorrida < distanciaEstacion * 2) {

            if (!enParada) {
                if (velocidadActual > 0) {
                    velocidadActual += desaceleracion * intervalo;
                    if (velocidadActual < 0) {
                        velocidadActual = 0;
                        enParada = true;
                    }
                } else if (velocidadActual == 0 && tiempoTotal < tiempoParada) {
                    enParada = true;
                } else {
                    velocidadActual += aceleracion * intervalo;
                }
            } else {
                if (tiempoTotal >= tiempoParada) {
                    enParada = false;
                }
            }

            distanciaRecorrida += velocidadActual * intervalo;

            dibujarTren(distanciaRecorrida, distanciaEstacion);

            tiempoTotal += intervalo;

            try {
                Thread.sleep((long) (intervalo * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dibujarTren(double distanciaRecorrida, double distanciaEstacion) {

        System.out.println("Pista:");
        System.out.println("--------------------------------------------------");

        int posicionTren = (int) (distanciaRecorrida / 100); 
        for (int i = 0; i < posicionTren; i++) {
            System.out.print(" ");
        }
        System.out.println("🚅");


        int posicionEstacion = (int) (distanciaEstacion / 100); 
        for (int i = 0; i < posicionEstacion; i++) {
            System.out.print(" ");
        }
        System.out.println("🏁");

        System.out.println("Distancia recorrida: " + distanciaRecorrida + " m");
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese la velocidad inicial del tren (km/h): ");
            double velocidadInicial = scanner.nextDouble();

            System.out.print("Ingrese el tiempo de parada en la estación (min): ");
            double tiempoParada = scanner.nextDouble() * 60; 

            System.out.print("Ingrese la desaceleración (m/s²): ");
            double desaceleracion = scanner.nextDouble();

            System.out.print("Ingrese la aceleración (m/s²): ");
            double aceleracion = scanner.nextDouble();

            System.out.print("Ingrese la distancia a la estación (m): ");
            double distanciaEstacion = scanner.nextDouble();

            simularMovimiento(velocidadInicial, tiempoParada, desaceleracion, aceleracion, distanciaEstacion);
        } catch (Exception e) {
            System.out.println("Por favor, ingrese valores numéricos válidos.");
        } finally {
            scanner.close();
        }
    }
}
