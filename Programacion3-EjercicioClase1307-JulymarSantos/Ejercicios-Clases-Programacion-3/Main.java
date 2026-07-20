import java.util.Scanner;
public class Main {
    

    public static void validarEstudiante(String nombre, int edad, double indiceAcademico) throws Exception{

        if(nombre.trim().isEmpty()){
            throw new Exception("Error: El nombre no puede estar vacio.");
        }
        if(edad < 18){
            throw new Exception("Error: la edad debe estar entre 18 - 100 anios");
        }
        if(indiceAcademico < 0.00 || indiceAcademico > 4.00){
            throw new Exception("Error: El indice debe estar entre 0.00 y 4.00");
        }
    }
    public static void main(String[] args){

       Scanner scan = new Scanner(System.in);

       System.out.println("Nombre: ");
       String nombre = scan.nextLine();

       System.out.println("Edad: ");
       int edad = scan.nextInt();

       System.out.println("Indice: ");
        double indiceAcademico = scan.nextDouble();
       



        try{
            validarEstudiante(nombre, edad, indiceAcademico);

            System.out.println("Estudiante registrado correctamente");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Proceso finalizado");
        }
        scan.close();
    }
}
