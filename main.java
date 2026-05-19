import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {


    static ArrayList<Paciente> pacientes = new ArrayList<>();
    
    static Scanner scan = new Scanner(System.in);

    static void mostrarPaciente(){
        if(pacientes.isEmpty()){
            System.out.println("No hay pacientes registrados");
            return;
        }
        System.out.println("Ingrese el nombre del paciente");
        String busqueda = scan.nextLine().toLowerCase();

        boolean encontrado = false;
        for(Paciente pacienteA: pacientes){
            if(pacienteA.getNombre().toLowerCase().equals(busqueda)){
                pacienteA.mostrarInfo();
                encontrado = true;
            }
            if(!encontrado) {
                System.out.println("Paciente no encontrado.");
            }
        }
    }

    static void mostrarIMCPaciente(){
        if(pacientes.isEmpty()){
            System.out.println("No hay pacientes registrados");
            return;
        }
        System.out.println("Ingrese el nombre del paciente: ");
        String busqueda = scan.nextLine().toLowerCase();

        for(Paciente pacienteA : pacientes){
            if(pacienteA.getNombre().toLowerCase().equals(busqueda)){
                System.out.printf("IMC de %s: %.2f -> %s%n", pacienteA.getNombre(), pacienteA.calcularIMC(), pacienteA.diagnostico());
                return;
            }
        }

        System.out.println("Paciente no encontrado.");
    }


    static void mostrarTodosPacientes(){
        if(pacientes.isEmpty()){
            System.out.println("No hay pacientes registrados");
            return;
        }
        System.out.println("=== Lista de pacientes ===");
        for(Paciente pacienteA: pacientes){
            pacienteA.mostrarInfo();
        }
    }


    static int leerEntero(String mensaje){
        int valor = 0;
        boolean valido = false;
        while(!valido){
            try{
                System.out.print(mensaje);
                valor = scan.nextInt();
                valido = true;
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero entero.");

            }finally{
                scan.nextLine();
            }
        }
        return valor;
    }

    static double leerDecimal(String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor  = scan.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero.");
            } finally {
                scan.nextLine(); 
            }
        }
        return valor;
    }
    static void registrarPaciente(){
        System.out.println("\n--- Registrar paciente ---");

        System.out.println("Nombre: ");
        String nombre = scan.nextLine();

        System.out.println("Apellido: ");
        String apellido = scan.nextLine();

        System.out.println("Edad: ");
        int edad = scan.nextInt();

        System.out.println("Estatura (en metros): ");
        double estatura = scan.nextDouble();

        System.out.println("Peso (en libras): ");
        double peso = scan.nextDouble();

        Paciente pacienteA = new Paciente(nombre, apellido, estatura, peso, edad);
        pacientes.add(pacienteA);

        System.out.println("--- Paciente registrado ---");


    }
    static void mostrarMenu(){
        System.out.println("=== Sistema Medico ===");
        System.out.println("\t1.Registrar paciente.");   
        System.out.println("\t2.Mostrar informacion de un paciente.");
        System.out.println("\t3.Calcular IMC de un paciente");
        System.out.println("\t4.Mostrar pacientes registrados.");
        System.out.println("\t5.Salir.");
    }

    public static void main(String[] args){

        

        int opcion;
       
        
        do{
            mostrarMenu();
            opcion = leerEntero("Seleccine una opcion: ");

            switch(opcion){

                case 1:
                    registrarPaciente();
                    break;
            
                case 2:
                    mostrarPaciente();
                    break;
            
                case 3:
                    mostrarIMCPaciente();
                    break;
            
                case 4:
                    mostrarTodosPacientes();
                    break;
        
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida.");

                } 
            }while(opcion != 5);

    }
}
