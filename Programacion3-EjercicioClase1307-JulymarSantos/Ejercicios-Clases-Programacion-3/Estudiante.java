public class Estudiante {
   
    private String nombre;
    private int edad;
    private double indiceAcademico;


    public Estudiante(String nombre, int edad, double indiceAcademico){
        this.nombre = nombre;
        this.edad = edad;
        this.indiceAcademico = indiceAcademico;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public double getIndiceAcademico(){
        return indiceAcademico;
    }

   
}
