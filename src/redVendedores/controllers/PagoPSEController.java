package redVendedores.controllers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import redVendedores.aplication.Aplicacion;

public class PagoPSEController {
	
	//--------NEQUI----------------
	
    @FXML
    private ComboBox<String> comboBoxBancos;

    @FXML
    private AnchorPane NEQUI;

    @FXML
    private TextField txtNequiNroCel;

    @FXML
    private PasswordField claveNequi;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnNequiNo;
    
    @FXML
    void entrarEvent(ActionEvent event) {
    	if(verificarCelular(txtNequiNroCel.getText())){
    		if(verificarClave(claveNequi.getText())){
    			aplicacion.mostrarVentanaNequi2(precio, correo, usuario);
    		}else{
    			JOptionPane.showMessageDialog(null, "La clave solo debe contener números y ser de 4 digitos");
    		}
    	}else{
    		JOptionPane.showMessageDialog(null, "El número telefonico solo debe contener números y ser de 10 digitos");
    	}
    }

    @FXML
    void nequiNoEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaPagoRechazado(precio, fecha, "Daviplata", usuario, correo);
    }
    
    private boolean verificarCelular(String celular) {
	    String regex = "^[0-9]{10}$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(celular);
	    return matcher.matches();
	}
    
    private boolean verificarClave(String clave) {
	    String regex = "^[0-9]{4}$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(clave);
	    return matcher.matches();
	}
    
    
    //------------------DAVIPLATA-------------

    @FXML
    private AnchorPane DAVIPLATA;

    @FXML
    private Label timeLabel;

    @FXML
    private Button btnContinuarDavi;

    @FXML
    private Button btnCancelarDavi;

    @FXML
    private TextField txtDocumentoDavi;

    @FXML
    private ComboBox<String> comboBoxDocumentoDavi;

    @FXML
    private AnchorPane TAPA;
    
    @FXML
    void cancelarDaviEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaPagoRechazado(precio, fecha, "Daviplata", usuario, correo);
    }

    @FXML
    void continuarDaviEvent(ActionEvent event) {
    	String selectedState = comboBoxBancos.getSelectionModel().getSelectedItem();
    	if(selectedState!=null){
    		if(verificarDocumento(txtDocumentoDavi.getText())){
    			aplicacion.mostrarVentanaDaviplata2(precio,correo, usuario);
    		}else{
    			JOptionPane.showMessageDialog(null, "El documento solo debe constar de números");
    		}
    	}else{
    		JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento");
    	}

    }
    
    private boolean verificarDocumento(String documento) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(documento);
		return matcher.matches();
	}
    
    private Aplicacion aplicacion;
    
    private String precio;
    
    private String correo;
    
    private String usuario;
    
    private String fecha; 

	public void setAplicacion(Aplicacion aplicacion, String precio, String correo, String usuario) {
		this.aplicacion = aplicacion;
		this.precio= precio;
		this.correo= correo;
		this.usuario= usuario;
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = fechaActual.format(formato);
	}
	
	@FXML
	void initialize() {
		comboBoxBancos.getItems().addAll("NEQUI", "DAVIPLATA");
		comboBoxBancos.setOnAction(this::filtrarAnchors);
		comboBoxDocumentoDavi.getItems().addAll("Cédula de Ciudadanía", "Tarjeta de Identidad", "Cédula de Extranjería");
	}
	
	private void filtrarAnchors(ActionEvent event) {
		String selectedState = comboBoxBancos.getSelectionModel().getSelectedItem();
		if (selectedState != null) {
			if (selectedState.equals("NEQUI")) {
				TAPA.toBack();
				DAVIPLATA.setVisible(false);;
				NEQUI.toFront();
			}
			if (selectedState.equals("DAVIPLATA")) {
				TAPA.setVisible(false);
				DAVIPLATA.setVisible(true);
				DAVIPLATA.toFront();
			}
		}
		
	}
		



}
