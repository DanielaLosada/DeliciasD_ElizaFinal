package redVendedores.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import redVendedores.aplication.Aplicacion;

public class Nequi5Controller {
	
	@FXML
	private Label referencia;

	@FXML
	private Label monto;

	@FXML
	private Text referenciaNequi;

	@FXML
	private Label nroReferencia;

	@FXML
	private Button btnSalir;
	
	private Aplicacion aplicacion;
	
	private String precio;

	public void setAplicacion(Aplicacion aplicacion, String precio) {
		this.aplicacion = aplicacion;
		this.precio= precio;
		
		monto.setText(precio);
	}

	@FXML
	void salirEvent(ActionEvent event) {

	}

}
