package modelo.dao;

import controlador.Coordinador; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.Nacimiento;
import modelo.vo.PersonaVo;
public class NacimientoDao {
	
	private Coordinador micoordinador;
	ArrayList<Nacimiento> lista = new ArrayList<Nacimiento>();

	public void setCoordinador(Coordinador miCoordinador) {
		this.micoordinador=miCoordinador;
		
	}
	
	public Long registrarNacimiento(Nacimiento miNacimiento) {

		Long idNacimiento=null;
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		ResultSet result=null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO nacimiento (ciudad_nacimiento,departamento_nacimiento,fecha_nacimiento,pais_nacimiento)"
				+ "  VALUES (?,?,?,?)";

		try {
			System.out.println(connection);
			preStatement = connection.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, miNacimiento.getCiudadNacimiento());
			preStatement.setString(2, miNacimiento.getDepartamentoNacimiento());
			preStatement.setString(3, miNacimiento.getFechaNacimiento().toString());
			preStatement.setString(4, miNacimiento.getPaisNacimiento());
			preStatement.execute();
			
			result=preStatement.getGeneratedKeys();
			if (result.next()) {
				idNacimiento=result.getLong(1);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			idNacimiento = null;
		} catch (Exception e) {
			System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
			e.printStackTrace();
			idNacimiento = null;
		}
		finally {
			conexion.desconectar();
		}
		System.out.println("El ID del Nacimiento es: "+idNacimiento);
		return idNacimiento;
		
	}
	
	public Nacimiento consultarNacimiento(Long idNacimiento) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
				
		connection=miConexion.getConnection();
		
		Nacimiento miNacimiento = null;
		
		String consulta="SELECT * FROM nacimiento where id_nacimiento= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idNacimiento);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miNacimiento=new Nacimiento();
					miNacimiento.setIdNacimiento(result.getLong("id_nacimiento"));
					miNacimiento.setCiudadNacimiento(result.getString("ciudad_nacimiento"));
					miNacimiento.setDepartamentoNacimiento(result.getString("departamento_nacimiento"));
					miNacimiento.setPaisNacimiento(result.getString("pais_nacimiento"));
					miNacimiento.setFechaNacimiento(LocalDate.parse(result.getDate("fecha_nacimiento")+""));
				}		
				   miConexion.desconectar();
			}						   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		return miNacimiento;		
	}

	public String actualizarNacimiento(Nacimiento miNacimiento) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		String comprobar = "";

		
		try {
			
			String consulta = "update nacimiento set ciudad_nacimiento = ?, departamento_nacimiento = ?, fecha_nacimiento =  ?, pais_nacimiento = ? where id_nacimiento = ?;";

			
			PreparedStatement preStatement = connection.prepareStatement(consulta);
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miNacimiento.getCiudadNacimiento());
			preStatement.setString(2, miNacimiento.getDepartamentoNacimiento());
			preStatement.setString(3, miNacimiento.getFechaNacimiento().toString());
			preStatement.setString(4, miNacimiento.getPaisNacimiento());
			
			
			String a = "";
			a = String.valueOf(miNacimiento.getIdNacimiento());
			int b = -1;
			b = Integer.parseInt(a);
			preStatement.setInt(5, b);
			
			comprobar = "si";
			
			
		} catch (Exception e) {
			comprobar = "no";
			System.out.println(e);
		}
		
		return comprobar;
	}


	public ArrayList<Nacimiento> ListarNacimientosRegistrados() {
		
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		Nacimiento miNac;
		connection = miConexion.getConnection();
		
		String consulta = "SELECT * FROM bd_clinica.nacimiento;";
		
		try {
			
			if (connection != null ) {
				statement = miConexion.getConnection().prepareStatement(consulta);
				result = statement.executeQuery();
	            
	            while (result.next()==true) {
	            	
	            	miNac = new Nacimiento();
	            	
	            	miNac.setIdNacimiento(result.getLong("id_nacimiento"));
	            	miNac.setCiudadNacimiento(result.getString("ciudad_nacimiento"));
	            	miNac.setDepartamentoNacimiento(result.getString("departamento_nacimiento"));
	            	miNac.setPaisNacimiento(result.getString("pais_nacimiento"));
	            	miNac.setFechaNacimiento(LocalDate.parse(result.getDate("fecha_nacimiento")+""));
	            	System.out.println(miNac.getFechaNacimiento());
	            	lista.add(miNac);
	            	
	            }
			}

            
        } catch (SQLException e) {


        }

		return lista;
	}

	public String EliminarNacimiento(PersonaVo persona) {


		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		String res="";
		String consulta="DELETE FROM nacimiento where id_nacimiento= ? ";
		
		connection=miConexion.getConnection();
		
		if (connection!=null) {
			
			try {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, persona.getNacimiento().getIdNacimiento());
				
				statement.executeUpdate();
				
				statement.close();
				miConexion.desconectar();
				
				return res="ok";
				
			}catch(SQLException e) {
				
				System.out.println("Ocurrio una excecion de SQL"+" al momento de eliiminar");
				res="error";
			}
			
		}
		
		return res;	
		
	}
	

}
