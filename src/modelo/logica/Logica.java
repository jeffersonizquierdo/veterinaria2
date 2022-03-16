package modelo.logica;

import controlador.Coordinador;
import modelo.vo.PersonaVo;

public class Logica {
	
	private Coordinador miCoordinador;

	public boolean VelidarCampos(PersonaVo miPersonaVo) {
		
		boolean validarNombre = false;
		boolean validarDocumento = false;
		String nombre = miPersonaVo.getNombre();
		String documento = Long.toString(miPersonaVo.getIdPersona());
		
		
		if (documento!=null && !documento.equals("")) {
			validarDocumento=true;
		}
		
		if (nombre!=null && !nombre.equals("")) {
			validarNombre=true;
		}
		
		if (validarDocumento==true && validarNombre==true) {
			return true;
			
		} else {
			
			return false;	
		}
	}

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
	

}
