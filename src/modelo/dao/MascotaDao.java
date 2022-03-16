package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.MascotasVo;

public class MascotaDao {
	
	private Coordinador micoordinador;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.micoordinador=miCoordinador;
		
	}
	
	public String registrarmascota(MascotasVo mimascota) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		ResultSet result=null;
		

		connection = conexion.getConnection();
		String consulta = "INSERT INTO mascotas (colo,nombre,raza,sexo,persona_id)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, mimascota.getColorMascota());
			preStatement.setString(2, mimascota.getNombre());
			preStatement.setString(3, mimascota.getRaza());
			preStatement.setString(4, mimascota.getSexo());
			preStatement.setLong(5, mimascota.getPersona().getIdPersona());
		
		
			preStatement.execute();
			

			resultado = "ok";
			
			

		}catch (SQLException e) {
			System.out.println("No se pudo registrar la mascota, verifique el documento no exista: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la mascota";
			
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar la mascota: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la mascota";
			
		}
		finally {
			conexion.desconectar();
		}
		
	

		return resultado;
}

	public MascotasVo consultarmascota(long idmascota) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		MascotasVo miMacota=null;
		
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona where id_persona= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idmascota);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miMacota=new MascotasVo();
					miMacota.setIdMascota(result.getLong("persona_id"));
					miMacota.setNombre(result.getString("nombre"));
					miMacota.setColorMascota(result.getString("colo"));
					miMacota.setRaza(result.getString("raza"));
						
				}		
				   miConexion.desconectar();
			}else{
				miMacota=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
			return miMacota;
	}


}
