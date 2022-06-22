import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int cursos[] = new int[10];
            int opcionDeseada;
            int numDeAlumnos;
            Boolean flag = false;

            mostrarMensaje("Cuantos alumnos va a ingresar?: ");
            numDeAlumnos = scanner.nextInt();
            int alumnos[] = new int[numDeAlumnos];
            for (int i = 0; i < alumnos.length; i++) {
                mostrarMensaje("Ingrese el numero de curso al que corresponde el alumno " + (i+1) + " (1-10): ");
                opcionDeseada = scanner.nextInt();
                alumnos[i] = opcionDeseada;      
            }
            System.out.println(" ");

            while (flag == false) {
                mostrarMensaje("Ingrese la opcion deseada: ");
                mostrarMensaje("1) Alumnos del curso de tecnología Microsoft");
                mostrarMensaje("2) Ver lo recaudado por numero de curso");
                mostrarMensaje("3) Salir del programa");
   
                opcionDeseada = scanner.nextInt();

                if (opcionDeseada > 4 || opcionDeseada <= 0) {
                    mostrarMensaje("Ingrese una opcion comprendida entre 1-4");
                    opcionDeseada = scanner.nextInt();
                }
   
                switch (opcionDeseada) {
                    case 1:
                        mostrarMensaje("La cantidad total de alumnos en Microsoft es de: " + mostrarMicrosoft(alumnos));
                        break;
                
                    case 2:
                        mostrarMensaje("Ingrese el curso que desea buscar, se mostrara lo recaudado: ");
                        opcionDeseada = scanner.nextInt();
                        mostrarMensaje("Lo recaudado por el curso " + opcionDeseada + " es de: " + mostrarRecaudado(cursos , alumnos , opcionDeseada));      
                        break;
                
                    case 3:
                        mostrarMensaje("Cerrando...");
                        flag = !flag;
                        break;
                            
                    default:
                        mostrarMensaje("No existe la opcion ingresada.");
                        break;
                }
            }
        }
    }
 
    public static int mostrarMicrosoft(int[] arr) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] < 6) {
                contador++;
            }
        }
        return contador;
     }

     public static int mostrarRecaudado(int[] arrCursos , int[] arrAlumnos , int num) {
        int total = 0;
        for (int i = 0; i < arrCursos.length; i++) {
            if (arrCursos[i] >= 0 && arrCursos[i] <= 5) {
                arrCursos[i] = 1500;
            } else {
                arrCursos[i] = 1250;
            }
        }
        for (int i = 0; i < arrAlumnos.length; i++) {
            if (arrAlumnos[i] == num) {
                total = total + arrCursos[num];
            }
        }
        return total;
        }
        
    
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
