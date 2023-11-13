package redVendedores.aplication;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import redVendedores.controllers.CarritoController;
import redVendedores.controllers.CompraController;
import redVendedores.controllers.FacturaController;
import redVendedores.controllers.IniciarRedController;
import redVendedores.controllers.LoginAdministradorController;
import redVendedores.controllers.LoginVendedorController;
import redVendedores.controllers.NuevoVendedorController;
import redVendedores.controllers.PagoPSEController;
import redVendedores.controllers.PagoTarjetasController;
import redVendedores.controllers.RedPrincipalAdminController;
import redVendedores.controllers.ReedController;
import redVendedores.controllers.RestablecerContrasena2AdminController;
import redVendedores.controllers.RestablecerContrasena2Controller;
import redVendedores.controllers.RestablecerContrasenaAdminController;
import redVendedores.controllers.RestablecerContrasenaController;
import redVendedores.model.Producto;
import redVendedores.model.Red;


 public class Aplicacion extends Application{

	private Stage primaryStage;

	Red red = new Red ("Shopify MarketPlace");




	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Shopify MarketPlace");

		mostrarVentanaIniciarRed();

	}

	public void mostrarVentanaIniciarRed() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/IniciarRed.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			IniciarRedController iniciarRedController= loader.getController();
			iniciarRedController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void mostrarVentanaPrincipal(String documento, String correo) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Reed.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			ReedController reedController = loader.getController();
			reedController.setAplicacion(this, documento, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaPrincipalAdmin(String documento) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RedPrincipalAdmin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RedPrincipalAdminController redPrincipalAdminController = loader.getController();
			redPrincipalAdminController.setAplicacion(this, documento);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void mostrarVentanaLoginVendedor() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/LoginVendedor.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginVendedorController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaRestablecerContrasena() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasena.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasenaController restablecerController = loader.getController();
			restablecerController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaRestablecerContrasena2(String correo, String codigoGenerado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasena2.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasena2Controller restablecer2Controller = loader.getController();
			restablecer2Controller.setAplicacion(this,correo, codigoGenerado);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaNuevoVendedor() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/NuevoVendedor.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			NuevoVendedorController nuevoVendedorController = loader.getController();
			nuevoVendedorController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaLoginAdmin(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/LoginAdministrador.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginAdministradorController loginAdministradorController = loader.getController();
			loginAdministradorController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaFactura(int totalPagar, String metodo, String nombre, Integer numP){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Factura.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			FacturaController loginAdministradorController = loader.getController();
			loginAdministradorController.setAplicacion(this, totalPagar, metodo, nombre, numP);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaRestablecerContrasena2Admin(String correo, String codigoGenerado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasena2Admin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasena2AdminController restablecerContrasena2AdminController = loader.getController();
			restablecerContrasena2AdminController.setAplicacion(this, correo, codigoGenerado);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaRestablecerContrasenaAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasenaAdmin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasenaAdminController restablecerContrasenaAdminController = loader.getController();
			restablecerContrasenaAdminController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaCarrito(String documento, String correo){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Carrito.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			CarritoController carritoController = loader.getController();
			carritoController.setAplicacion(this, documento, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaCompra(String usuario, String correo, int num, String precio){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Compra.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			CompraController compraController = loader.getController();
			compraController.setAplicacion(this, usuario, correo, num, precio);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPagoTarjetas(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/PagoTarjetas.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PagoTarjetasController pagoTarjetasController = loader.getController();
			pagoTarjetasController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPagoPSE(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/pagoPSE.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PagoPSEController pagoPSEController = loader.getController();
			pagoPSEController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public static void main(String[] args) {
		launch(args);
	}
	

 }
