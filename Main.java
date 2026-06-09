import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
  
    public static void mostrarMenu(){

        System.out.println("=== Registro de estudiantes ===");
        System.out.println("1.Agregar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Salir");
            
    }
    public static void main(String[] args){

        int opcion;
        Scanner scan = new Scanner(System.in);
        do{
            mostrarMenu();

            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion){

                case 1:
                    agregarEstudiante(scan);
                    break;
                
                case 2:
                    mostrarEstudiante();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 3);
    }

    public static void agregarEstudiante(Scanner scan){
       
        try{
        FileWriter archivo = new FileWriter("estudiante.txt", true);

        System.out.println("Ingrese Nombre: ");
        String nombre = scan.nextLine();

        System.out.println("Ingrese su matricula: ");
        int matricula = scan.nextInt();

        scan.nextLine();

        System.out.println("Ingrese su carrera: ");
        String carrera = scan.nextLine();

        
        archivo.write("Nombre: " + nombre + "\n");
        archivo.write("Matricula: " + matricula + "\n");
        archivo.write("Carrera: " + carrera + "\n");

        archivo.close();
        
        }
        catch(Exception e){
            System.out.println("Error al guardar: " + e.getMessage());
        }
      
    }

    public static void mostrarEstudiante(){
        try{
            File archivo = new File("estudiante.txt");

            if(!archivo.exists()){
                System.out.println("No hay datos guardados");
            }

            BufferedReader lector = new BufferedReader(new FileReader(archivo));

            String linea;

            System.out.println("=== Datos del Estudiante ===");
            while((linea = lector.readLine()) != null){
                System.out.println(linea);
            }

            lector.close();
        }catch (IOException e){
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
