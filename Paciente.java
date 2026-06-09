public class Paciente {
    private String nombre;
    private String apellido;
    private double estatura;
    private double pesoEnLibras;
    private int edad;
    
    public Paciente(){

    }

    public Paciente(String nombre, String apellido, double estatura, double pesoEnLibras, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.pesoEnLibras = pesoEnLibras;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public double getEstatura(){
        return estatura;
    }

    public double getPesoEnLibras (){
        return pesoEnLibras;
    }

    public int getEdad(){
        return edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setEstatura(double estatura){
        this.estatura = estatura;
    }

    public void setPesoEnLibras(double pesoEnLibras){
        this.pesoEnLibras = pesoEnLibras;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public double getPesoKg(){
        return pesoEnLibras * 0.453592;
    }

    public double calcularIMC(){
        if(estatura <= 0)
            return 0;
        return getPesoKg() / (estatura * estatura);
    }

    public String diagnostico(){
        double imc = calcularIMC();
        if(imc < 18.5)
            return "Bajo peso";
        else if(imc < 25.0 )
            return "Peso normal";
        else if(imc < 30.0)
            return "Sobrepeso";
        else
            return "Obesidad";
    }

    public void mostrarInfo(){
        System.out.println("--------------------------------");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Edad: " + edad);
        System.out.printf("Estatura: %.2f m%n",  estatura);
        System.out.printf("Peso: %.1f lbs (%.2f kg)%n", pesoEnLibras, getPesoKg());
        System.out.printf("IMC : %.2f%n", calcularIMC());
        System.out.println("Estado: " + diagnostico());
        System.out.println("--------------------------------");
    }
}
