package modelo.dao;

import controlador.Coordinador; 
import modelo.vo.Nacimiento;
import modelo.vo.PersonaVo;
import vista.gui.ConsultarPersonaGui;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.PersonaVo;
public class PersonaDao {
	
	
	
	private Coordinador micoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.micoordinador=miCoordinador;
		
	}

	public String registrarPersona(PersonaVo miPersona) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO persona (id_persona,nombre_persona,profesion_persona,telefono_persona,tipo_persona,nacimiento_id)"
				+ "  VALUES (?,?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, miPersona.getIdPersona());
			preStatement.setString(2, miPersona.getNombre());
			preStatement.setString(3, miPersona.getProfesion());
			preStatement.setString(4, miPersona.getTelefono());
			preStatement.setInt(5, miPersona.getTipo());
			preStatement.setLong(6, miPersona.getNacimiento().getIdNacimiento());
			preStatement.execute();

			resultado = "ok";

		}catch (SQLException e) {
			System.out.println("No se pudo registrar la persona, verifique el documento no exista: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la persona";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar la persona: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar la persona";
		}
		finally {
			conexion.desconectar();
		}

	return resultado;
		
	}
	
	public PersonaVo consultarPersona(Long idDocumento) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miPersona=null;
		Nacimiento miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM persona where id_persona= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idDocumento);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miPersona=new PersonaVo();
					miPersona.setIdPersona(result.getLong("id_persona"));
					miPersona.setNombre(result.getString("nombre_persona"));
					miPersona.setProfesion(result.getString("profesion_persona"));
					miPersona.setTelefono(result.getString("telefono_persona"));
					miPersona.setTipo(result.getInt("tipo_persona"));
					
					miNacimiento =new Nacimiento();
					miNacimiento.setIdNacimiento(Long.parseLong(result.getString("nacimiento_id")));
					miPersona.setNacimiento(miNacimiento);		
				}		
				   miConexion.desconectar();
			}else{
				miPersona=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
			return miPersona;
	}

	
	
	public String actulizaPersona(PersonaVo miPersonaVo) {
		
		String resultado="";
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		
		try {
			
			String consulta = "update  persona  set nombre_persona = ?, profesion_persona = ?, telefono_persona = ?, tipo_persona = ? where id_persona = ?;";
			
			PreparedStatement preStatement = connection.prepareStatement(consulta);
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersonaVo.getNombre());
			preStatement.setString(2, miPersonaVo.getProfesion());
			preStatement.setString(3, miPersonaVo.getTelefono());
			preStatement.setInt(4, miPersonaVo.getTipo());
			preStatement.setLong(5, miPersonaVo.getIdPersona());
			
			preStatement.execute();

			resultado = "ok";
			miConexion.desconectar();
			
		}catch(SQLException	 e){
            System.out.println(e);
            resultado="error";
        }
		return resultado;
	}

	public long buscarNac(PersonaVo miPersonaVo) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;

		int i = -1;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT nacimiento_id FROM persona where id_persona= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, miPersonaVo.getIdPersona());
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					i = result.getInt("nacimiento_id");
				}		
				   miConexion.desconectar();
			}else{
				i = -1;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		String idNac;
		idNac = String.valueOf(i);
		long idNacimientoDef;
		idNacimientoDef = Long.parseLong(idNac);
		System.out.println(idNacimientoDef);
		
		return idNacimientoDef;
	}
	
	



	public ArrayList<PersonaVo> ListarPersonaRegistradas() {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		PersonaVo miPersonaVo;
		
		connection = miConexion.getConnection();
		
		String consulta = "SELECT * FROM bd_clinica.persona;";
		ArrayList<PersonaVo> listaPersonas = new ArrayList<PersonaVo>();
		if (connection != null) {
			
			try {
	            statement = miConexion.getConnection().prepareStatement(consulta);
	            result = statement.executeQuery();
	           
	            
	            while (result.next()==true) {
	            	miPersonaVo = new PersonaVo();
	            	miPersonaVo.setIdPersona(result.getLong("id_persona"));
	            	miPersonaVo.setNombre(result.getString("nombre_persona"));
	            	miPersonaVo.setProfesion(result.getString("profesion_persona"));
	            	miPersonaVo.setTelefono(result.getString("telefono_persona"));
	            	miPersonaVo.setTipo(result.getInt("tipo_persona"));
	            	listaPersonas.add(miPersonaVo);

	            }
	            miConexion.desconectar();

	            
	        } catch (SQLException e) {
	            System.out.println(e);
	            return null;
	        }
			
		}
		return listaPersonas;

			
	}

public String EliminarPersona(PersonaVo persona) {
		
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		String res="";
		String consulta="DELETE FROM persona where id_persona= ? ";
		
		connection=miConexion.getConnection();
		
		if (connection!=null) {
			
			try {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, persona.getIdPersona());
				
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
