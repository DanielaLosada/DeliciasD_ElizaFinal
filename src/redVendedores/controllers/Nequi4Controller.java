package redVendedores.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import redVendedores.aplication.Aplicacion;

public class Nequi4Controller {
	
	@FXML
	private TextField txtCodigo;

	@FXML
	private Button btnCancelar;

	@FXML
	private Text pedirOtroCodigo;

	@FXML
	private Button btnSeguir;
	
	private Aplicacion aplicacion;
	private String precio;
	private String codigo;
	private String correo; 
	private String usuario;
	private String fecha;

	public void setAplicacion(Aplicacion aplicacion, String precio, String codigo, String correo, String usuario) {
		this.aplicacion = aplicacion;
		this.precio= precio;
		this.codigo= codigo;
		this.correo= correo; 
		this.usuario= usuario;
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = fechaActual.format(formato);
	}

	@FXML
	void cancelarEvent(ActionEvent event) {
		aplicacion.mostrarVentanaPagoRechazado(precio, fecha, "NEQUI", usuario, correo);
	}

	@FXML
	void pedirCodigoEvent(MouseEvent event) {
	}

	@FXML
	void seguirEvent(ActionEvent event) {
		aplicacion.mostrarVentanaNequi5(precio);
	}

}
