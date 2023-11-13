package redVendedores.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import redVendedores.aplication.Aplicacion;

public class PagoTarjetasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNroTarjeta;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtFechaVencimiento;

    @FXML
    private TextField txtCodigo;

    @FXML
    private Button btnContinuar;
    
    private Aplicacion aplicacion;

    @FXML
    void ContinuarEvent(ActionEvent event) {
    	if(verificarTarjeta(txtNroTarjeta.getText())){
    		if(verificarNombre(txtNombre.getText())){
    			if(verificarVencimiento(txtFechaVencimiento.getText())){
    				if(verificarCodigo(txtCodigo.getText())){
    					JOptionPane.showMessageDialog(null, "Todo correcto");
    				}else{
    					JOptionPane.showMessageDialog(null, "Codigo incorrecto");
    				}
    			}else{
    				JOptionPane.showMessageDialog(null, "Fecha incorrecta");
    			}
    		}else{
    			JOptionPane.showMessageDialog(null, "nombre incorrecto");
    		}
    	}else{
    		JOptionPane.showMessageDialog(null, "tarjeta incorrecta");
    	}
    }
    
    public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	private boolean verificarNombre(String nombre) {
		String regex = "^[a-zA-Z ]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nombre);
		return matcher.matches();
	}

	private boolean verificarTarjeta(String tarjeta) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(tarjeta);
		return matcher.matches();
	}

	private boolean verificarVencimiento(String fecha) {
		String regex = "^(0[1-9]|1[0-2])/(\\d{2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fecha);
		return matcher.matches();
	}
	
	private boolean verificarCodigo(String codigo) {
	    String regex = "^[0-9]{3}$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(codigo);
	    return matcher.matches();
	}
    
    

}