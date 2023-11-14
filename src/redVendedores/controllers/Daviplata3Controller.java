package redVendedores.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import redVendedores.aplication.Aplicacion;

public class Daviplata3Controller {
	
	@FXML
    private Text fecha;

    @FXML
    private Label hora;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnDetalle;
	
	private Aplicacion aplicacion;

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaComoString = fechaActual.format(formato);
        fecha.setText(fechaComoString);
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

	@FXML
	void mostrarDetalleEvent(ActionEvent event) {

	}

	@FXML
	void salirEvent(ActionEvent event) {

	}

}
