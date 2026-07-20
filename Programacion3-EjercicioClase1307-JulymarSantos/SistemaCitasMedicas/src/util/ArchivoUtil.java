package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Cita;

public class ArchivoUtil {
    
    public static void registrarCita(Cita cita){
        try{
            FileWriter archivo = new FileWriter("Citas.txt", true);
            archivo.write(cita.getCodigo()+ ";" + cita.getNombrePaciente() + "; " 
                + cita.getCedula() + "; "
                + cita.getTelefono() + "; "                     + cita.getMedico() + "; " 
                + cita.getEspecialidad()
                + "; " + cita.getFecha() 
                + "; " + cita.getHora() 
                + "; " + cita.getMotivoConsulta() 
                + "; " + cita.getEstado() + "\n");
            archivo.close();
            System.out.println("Cita Registrada");
        }catch(Exception e){
            System.out.println("Error al registrar cita");
        }

        public static ArrayList<Cita> cargarCitas(){
        ArrayList<Cita> citas = new ArrayList<>();

            try
            {
                FileReader archivo = new FileReader("Citas.txt");
                BufferedReader read = new BufferedReader(archivo);
                String linea;

                while((linea = read.readLine()) != null){
                    String[] partes = linea.split("; ");
                    citas.add(cita);
                }
                read.close();
                archivo.close();
            } catch(IOException e){
                System.out,println("No se pudo leer el archivo");
            }
            return;
                
        }
    }

}


