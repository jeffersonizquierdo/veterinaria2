package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.Nacimiento;
import modelo.vo.PersonaVo;
import modelo.vo.ProductoVo;

public class ProductoDao {
		
	private Coordinador micoordinador;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.micoordinador=miCoordinador;
		
	}
	
	

	public Coordinador getMicoordinador() {
		return micoordinador;
	}



	public void setMicoordinador(Coordinador micoordinador) {
		this.micoordinador = micoordinador;
	}



	public String registrarproducto(ProductoVo miproducto) {
		
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO bd_clinica.productos (nombre_producto,precio_producto)"
				+ "  VALUES (?,?)";

		try {
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miproducto.getNombreProducto());
			preStatement.setDouble(2, miproducto.getPrecioProducto());
		
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



	public ProductoVo consultarpersona(String nombreproduc) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ProductoVo miProducto=null;
		
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM productos where nombre_producto= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, nombreproduc);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miProducto= new ProductoVo();
					
					miProducto.setNombreProducto(result.getString("nombre_producto"));
					miProducto.setPrecioProducto(result.getDouble("precio_producto"));
				
					

				}		
				   miConexion.desconectar();
			}else{
				miProducto=null;
			}			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del producto: "+e.getMessage());
		}
			return miProducto;
	}



	public String actualizarproducto(ProductoVo miproducto) {
		String resultado="";
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		
		try {
			
			String consulta = "update  productos  set nombre_producto = ?, precio_producto = ?;";
			
			PreparedStatement preStatement = connection.prepareStatement(consulta);
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miproducto.getNombreProducto());
			preStatement.setDouble(2, miproducto.getPrecioProducto());
			
			
			preStatement.execute();

			resultado = "ok";
			miConexion.desconectar();
			
		}catch(SQLException	 e){
            System.out.println(e);
            resultado="error";
        }
		return resultado;
	}



	



	
}


