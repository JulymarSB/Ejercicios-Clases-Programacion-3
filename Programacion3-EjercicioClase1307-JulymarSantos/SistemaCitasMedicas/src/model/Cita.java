package model;

import javafx.scene.control.DatePicker;

public class Cita {
    
    private String codigo;
    private String nombrePaciente;
    private int cedula;
    private int telefono;
    private String medico;
    private String especialidad;
    private DatePicker fecha;
    private String hora;
    private String motivoConsulta;
    private String estado;

    public Cita(String codigo, String nombrePaciente, String medico, int cedula, int telefono, String especialidad, DatePicker fecha, String hora, String motivoConsulta, String estado)
    {
        this.codigo = codigo;
        this.nombrePaciente = nombrePaciente;
        this.cedula = cedula;
        this.telefono = telefono;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public int getCedula() {
        return cedula;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getMedico(){
        return medico;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public DatePicker getFecha(){
        return fecha;
    }
    public String getHora(){
        return hora;
    }
    public String getMotivoConsulta(){
        return motivoConsulta;
    }
    public String getEstado(){
        return estado;
    }
}
