package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
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
	}


