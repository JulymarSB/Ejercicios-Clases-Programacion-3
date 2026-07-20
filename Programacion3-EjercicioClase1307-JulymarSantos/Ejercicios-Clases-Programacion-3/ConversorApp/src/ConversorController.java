import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public class ConversorController {
    @FXML
    private TextField txtMonto;

    @FXML
    private ComboBox<String> cmbMoneda;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize(){

        cmbMoneda.getItems().add("USD");
        cmbMoneda.getItems().add("EUR");
    }

    @FXML
    private void convertir(ActionEvent evento){
        if(txtMonto.getText().isEmpty()){
            lblMensaje.setText("Error: Por favor ingrese un monto.");
            return;
        }
        try {
            double monto = Double.parseDouble(txtMonto.getText());

            if(cmbMoneda.getValue() == null){
                lblMensaje.setText("Error: Seleccione una moneda");
                return;
            }

            String moneda = cmbMoneda.getValue();
            double resultado = 0;

            if(moneda.equals("USD")){
                resultado = monto / 59.00;
            } else{
                resultado = monto / 64.00;
            }

            lblResultado.setText(String.format("Equivale a: %.2f %s",resultado, moneda));
            lblMensaje.setText("Conversion exitosa");
        }catch (NumberFormatException e){
            lblMensaje.setText("Error: Ingrese un numero valido");
        }
    }

    @FXML
    private void mouseEntrar(javafx.scene.input.MouseEvent evento){

        lblMensaje.setText("Precione para realizar conversion");
    }

    @FXML
    private void mouseSalir(javafx.scene.input.MouseEvent evento){
        lblMensaje.setText("Esperando informacion");
    }

    @FXML
    private void detectarEnter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            convertir(null);
        }
    }

    @FXML
    private void limpiar(ActionEvent event){
        txtMonto.clear();
        cmbMoneda.setValue(null);
        lblResultado.setText("Esperando informacion...");
        lblMensaje.setText("");
    }
    
}
