package redVendedores.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import redVendedores.aplication.Aplicacion;

public class Daviplata2Controller {
	
	@FXML
    private Text fecha;

    @FXML
    private Label hora;

	@FXML
	private Button btnEfectuar;

	@FXML
	private Button btnCancelar;

	@FXML
	private TextField txtCodigo;
	
	private Aplicacion aplicacion;
	
	private String precio; 
	
	private String correo;
	
	private String usuario;
	
	private String fecha2;

	public void setAplicacion(Aplicacion aplicacion, String precio, String correo, String usuario) {
		this.aplicacion = aplicacion;
		this.precio= precio;
		this.correo= correo;
		this.usuario= usuario;
		
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaComoString = fechaActual.format(formato);
        fecha.setText(fechaComoString);
        
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha2 = fechaActual.format(formato2);
	}
	
	@FXML
	void cancelarEvent(ActionEvent event) {
		aplicacion.mostrarVentanaPagoRechazado(precio,fecha2,"Daviplata", usuario, correo);
	}

	@FXML
	void efectuarEvent(ActionEvent event) {

	}
	
	@FXML
    void initialize() {
		updateClock(); // Actualizar la hora al cargar la ventana
		Timeline timeline = new Timeline(
	            new KeyFrame(Duration.minutes(1), event -> updateClock())
	        );
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.play();
		
	}
	
	public void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        String currentTime = sdf.format(new Date());
        hora.setText(currentTime);
    }

}
