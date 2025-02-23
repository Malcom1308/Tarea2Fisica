package ejercicio2;

import java.util.Scanner;

public class Ejercicio2b {
    
    public static double calcularTiempoCrecimientoPelo(double longitudInicial, double longitudFinal, 
    double tasaCrecimiento, String unidadTiempo){
        double tiempoMeses = (longitudFinal - longitudInicial) / tasaCrecimiento;

        switch (unidadTiempo) {
            case "dias":
                return tiempoMeses * 30;
            case "semanas":
                return tiempoMeses * 4;
            case "años":
                return tiempoMeses / 12;
            default:
                return tiempoMeses;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); 

        try {
            System.out.print("Ingrese la longitud inicial del cabello en cm: ");
            double longitudInicial = scanner.nextDouble();

            System.out.print("Ingrese la longitud final deseada del cabello en cm: ");
            double longitudFinal = scanner.nextDouble();

            System.out.print("Ingrese la tasa de crecimiento del cabello en cm/mes: ");
            double tasaCrecimiento = scanner.nextDouble();

            System.out.println("Seleccione la unidad de tiempo para la respuesta:");
            System.out.println("1. Meses");
            System.out.println("2. Días");
            System.out.println("3. Semanas");
            System.out.println("4. Años");
            System.out.print("Ingrese el número de la opción deseada: ");
            int opcion = scanner.nextInt();

            String unidadTiempo;
            switch (opcion) {
                case 1:
                    unidadTiempo = "meses";
                    break;
                case 2:
                    unidadTiempo = "dias";
                    break;
                case 3:
                    unidadTiempo = "semanas";
                    break;
                case 4:
                    unidadTiempo = "años";
                    break;
                default:
                    System.out.println("Opción no válida. Se usará 'meses' por defecto.");
                    unidadTiempo = "meses";
                    break;
            }

            double tiempo = calcularTiempoCrecimientoPelo(longitudInicial, longitudFinal, tasaCrecimiento, unidadTiempo);
            System.out.printf("El tiempo necesario para que el cabello crezca es: %.2f %s%n", tiempo, unidadTiempo);
        } catch (Exception e) {
            System.out.println("Por favor, ingrese valores numéricos válidos.");
        } finally {
            scanner.close(); 
        }
    }
}
