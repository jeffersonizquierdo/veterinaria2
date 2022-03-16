package modelo.vo;

public class MascotasVo {
	private Long idMascota;
	private String nombre;
	private String raza;
	private String colorMascota;
	private String sexo;
	private PersonaVo persona;
	
	public MascotasVo() {
		
	}
	
	
	public PersonaVo getPersona() {
		return persona;
	}


	public void setPersona(PersonaVo persona) {
		this.persona = persona;
	}


	public MascotasVo(String nombre, String raza, String colorMascota, String sexo) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.colorMascota = colorMascota;
		this.sexo = sexo;
	}

	//generamos los setters y getters correspondientes
	public Long getIdMascota() {
		return idMascota;
	}

	
	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColorMascota() {
		return colorMascota;
	}

	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", nombre=" + nombre + ","
				+ " raza=" + raza + ", colorMascota="
				+ colorMascota + ", sexo=" + sexo + "]";
	}


	
}
