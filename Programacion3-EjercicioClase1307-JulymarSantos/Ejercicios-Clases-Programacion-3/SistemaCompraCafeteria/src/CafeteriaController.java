import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CafeteriaController {
    @FXML private TextField txtCliente, txtCantidad;
    @FXML private ComboBox<String> cmbBebida;
    @FXML private CheckBox chkPostre;
    @FXML private Label lblResumen, lblMensaje;

    @FXML
    public void initialize() {
        cmbBebida.getItems().addAll("Café americano", "Cappuccino", "Chocolate caliente", "Jugo natural");
    }

    @FXML
    private void calcular(ActionEvent event) {
        if (txtCliente.getText().isEmpty() || cmbBebida.getValue() == null || txtCantidad.getText().isEmpty()) {
            lblMensaje.setText("Error: Complete todos los campos.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad <= 0) throw new NumberFormatException();

            double precioBebida = 0;
            switch (cmbBebida.getValue()) {
                case "Café americano": precioBebida = 100; break;
                case "Cappuccino": precioBebida = 150; break;
                case "Chocolate caliente": precioBebida = 130; break;
                case "Jugo natural": precioBebida = 120; break;
            }

            double subtotal = precioBebida * cantidad;
            double total = subtotal + (chkPostre.isSelected() ? 75 : 0);

            lblResumen.setText(String.format("Cliente: %s\nProducto: %s\nCantidad: %d\nSubtotal: RD$%.2f\nPostre: %s\nTotal: RD$%.2f",
                    txtCliente.getText(), cmbBebida.getValue(), cantidad, subtotal, chkPostre.isSelected() ? "Sí" : "No", total));
            lblMensaje.setText("¡Compra calculada exitosamente!");

        } catch (NumberFormatException e) {
            lblMensaje.setText("Error: Cantidad inválida.");
        }
    }

    @FXML
    private void mouseEntrar(javafx.scene.input.MouseEvent event) {
        lblMensaje.setText("Presione para calcular el total de la compra.");
    }

    @FXML
    private void mouseSalir(javafx.scene.input.MouseEvent event) {
        lblMensaje.setText("Esperando datos de la compra...");
    }

    @FXML
    private void detectarEnter(javafx.scene.input.KeyEvent event) {
        if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
            calcular(null); // Reutilizamos el botón de calcular
        }
    }

    @FXML
    private void limpiar(ActionEvent event) {
        txtCliente.clear();
        txtCantidad.clear();
        cmbBebida.setValue(null);
        chkPostre.setSelected(false);
        lblResumen.setText("Esperando datos de la compra...");
        lblMensaje.setText("");
    }
}
