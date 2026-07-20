package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class RegistroCItaController {
    
    @FXML
    private Label lblTitulo;

    @FXML
    private Button btnIniciar;
    

    @FXML
    private void salir(ActionEvent eventoSalir){
        Platform.exit();
    }
    @FXML
    private void abrirRegistroCita(ActionEvent eventoAbrir) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Registro.fxml"));

        Parent root = loader.load();

        Stage pantallaRegistro = new Stage();

        pantallaRegistro.setScene(new Scene(root));
        pantallaRegistro.setTitle("Registro Pacientes");
        pantallaRegistro.show();

    }
}
