package controlador;

import modelo.dao.MascotaDao; 

import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import modelo.logica.Logica;

import vista.gui.ConsultarPersonaGui;
import vista.gui.ConsultarProductoGui;
import vista.gui.EliminarPersonaGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.TablaPersonasGui;
import vista.gui.TablaPersonasGui;
import vista.gui.VentanaPrincipal;

public class Relaciones {
	public Relaciones() {
		//Se declaran las clases que van a representar instancias unicas
		VentanaPrincipal miVentanaPrincipal;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		Coordinador miCoordinador;
		PersonaDao miPersonaDao;
		NacimientoDao miNacimientoDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		PersonaProductoDao miPersonaProductoDao;
		ConsultarPersonaGui miConsultaPersonaGui;
		Logica miLogica;
		TablaPersonasGui miTablaPersonaGui;
		EliminarPersonaGui miElimminarPersonaGui;
		ConsultarProductoGui miConsultarProducto;
		
		
		//Se instancian por unica ocasión las clases declaradas
		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miCoordinador= new Coordinador();
		miPersonaDao= new PersonaDao();
		miMascotaDao= new MascotaDao();
		miNacimientoDao= new NacimientoDao();
		miProductoDao= new ProductoDao();
		miPersonaProductoDao= new PersonaProductoDao();
		miConsultaPersonaGui=new ConsultarPersonaGui(miVentanaPrincipal,true);
		miLogica = new Logica();
		miTablaPersonaGui = new TablaPersonasGui();
		miElimminarPersonaGui=new EliminarPersonaGui(miVentanaPrincipal, true);
		miConsultarProducto=new ConsultarProductoGui();
		
		
		//Se establece la relación entre el coordinador y cada instancia unica
		//Al coordinador se le asigna el control de cada clase unica
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setNacimientoDao(miNacimientoDao);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setPersonaProductoDao(miPersonaProductoDao);
		miCoordinador.setConsultarPersonaGui(miConsultaPersonaGui);
		miCoordinador.setLogica(miLogica);
		miCoordinador.setTablaPersonasGui(miTablaPersonaGui);
		miCoordinador.setEliminarPersonaGui(miElimminarPersonaGui);
		miCoordinador.setConsultarProductoGui(miConsultarProducto);
		
		
		//A cada clase unica se le asigna la unica instancia del coordinador
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miNacimientoDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miPersonaProductoDao.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miConsultaPersonaGui.setCoordinador(miCoordinador);
		miLogica.setMiCoordinador(miCoordinador);
		miTablaPersonaGui.setCoordinador(miCoordinador);
		miElimminarPersonaGui.setMiCoordinador(miCoordinador);
		miConsultarProducto.setCoordinador(miCoordinador);
		
		
		//Se muestra la ventana principal.
		miVentanaPrincipal.setVisible(true);
	}

	
}

