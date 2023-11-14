package redVendedores.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import redVendedores.aplication.Aplicacion;

public class Daviplata4Controller {
	
	@FXML
	private Label fecha;

	@FXML
	private Label nroAprobacion;

	@FXML
	private Label valorTransaccion;

	@FXML
	private Label referencia;

	@FXML
	private Button btnSalir;
	
	private Aplicacion aplicacion;

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	void salirEvent(ActionEvent event) {

	}


}
