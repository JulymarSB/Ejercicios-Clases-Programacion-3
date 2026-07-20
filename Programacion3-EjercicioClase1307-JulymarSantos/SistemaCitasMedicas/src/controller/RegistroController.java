package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Cita;
import util.ArchivoUtil;

public class RegistroController {

    @FXML
    TextField txtCodigoCita;

    @FXML
    TextField txtNombrePaciente;

    @FXML
    TextField txtCedula;

    @FXML
    TextField txtTelefono;

    @FXML
    ComboBox<String> cmbMedico;

    @FXML
    ComboBox <String>cmbEspecialidad;

    @FXML
    DatePicker dpFecha;

    @FXML
    TextField txtHora;

    @FXML
    TextArea txtAMotivoConsulta;

    @FXML
    ComboBox <String>cmbEstado;

    @FXML
    public void initialize(){

        //cmbDestino.getItems().add("Santo Domingo");
        cmbMedico.getItems().add("Dr. Jimenez");
        cmbMedico.getItems().add("Dr. Ortega");
        cmbMedico.getItems().add("Dr. Santos");
        cmbMedico.getItems().add("Dr. Cruz");
        cmbMedico.getItems().add("Dr. Mendez");

        cmbEspecialidad.getItems().add("Cardiologo");
        cmbEspecialidad.getItems().add("Dermatologo");
        cmbEspecialidad.getItems().add("Obstetra");
        cmbEspecialidad.getItems().add("Ortopeda");
        cmbEspecialidad.getItems().add("Oftalmologo");

        cmbEstado.getItems().add("Programada");
        cmbEstado.getItems().add("Atendida");
        cmbEstado.getItems().add("Cancelada");    
    }
    
    @FXML
    private void limpiarRegistro(ActionEvent eventoBorrar){
        txtCodigoCita.clear();
        txtNombrePaciente.clear();
        txtCedula.clear();
        txtTelefono.clear();
        cmbMedico.getSelectionModel().clearSelection();
        cmbEspecialidad.getSelectionModel().clearSelection();
        dpFecha.setValue(null);
        txtHora.clear();
        txtAMotivoConsulta.clear();
        cmbEstado.getSelectionModel().clearSelection();
    }

    @FXML
    private void registrarConsulta(ActionEvent eventoRefistrar){
        Cita cita = registrarConsulta(eventoRefistrar);
        ArchivoUtil.registrarCita(cita);

    }

    @FXML
    private void cargarCitas(){
        
    }

    
}
