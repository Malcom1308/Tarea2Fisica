package ejercicio1;

import java.util.Scanner;

public class Ejercicio1b {

    public static double calcularTiempoImpulsoNervioso(double distancia) {
        double velocidadImpulso = 100; 
        return distancia / velocidadImpulso;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Ingrese la distancia en metros desde el dedo del pie hasta el cerebro: ");
        
        if (scanner.hasNextDouble()) {
            double distancia = scanner.nextDouble(); 

            double tiempo = calcularTiempoImpulsoNervioso(distancia);

            System.out.printf("El tiempo que tarda el impulso nervioso en viajar es: %.6f segundos%n", tiempo);
        } else {
            System.out.println("Por favor, ingrese un valor numérico válido.");
        }

        scanner.close(); 
    }
}