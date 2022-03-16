package vista.gui;

import java.awt.BorderLayout;  


import java.awt.EventQueue;
import java.awt.Panel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Coordinador;
import modelo.vo.*;


import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TablaPersonasGui extends JFrame implements ActionListener{

	private JPanel miPanel;
	private final JPanel contentPane = new JPanel();
	private DefaultTableModel model;
	private DefaultTableModel modelo;
	private Coordinador miCoordinador;
	private JScrollPane scroll;
	private JTable tblPersonas;
	private JButton btnListarPersonas;
	private ArrayList<PersonaVo> ListaPersonas;
	private ArrayList<Nacimiento> Listanacimiento;

	
	public TablaPersonasGui () {
		
		setBounds(0,0,900,500);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		
		tblPersonas = new JTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 80, 900, 421);
		miPanel.add(scrollPane);
		
		model = new DefaultTableModel();
		tblPersonas.setModel(model);
		model.addColumn("Documento");
		model.addColumn("Nombre");
		model.addColumn("Profesion");
		model.addColumn("Telefono");
		model.addColumn("Tipo");
		model.addColumn("ID NAcimiento");
		model.addColumn("Ciudad Nac");
		model.addColumn("Dpto Nac");
		model.addColumn("Fecha Nac");
		model.addColumn("Pais Nac");
		tblPersonas.setModel(model);
		
		scrollPane.setViewportView(tblPersonas);
		
		
		
		String[] titulos = {"Documento","Nombre","Profesion", "Telefono", "Tipo", "ID NAcimiento", "Ciudad Nac",
				"Dpto Nac", "Fecha Nac", "Pais Nac"};

		modelo = new DefaultTableModel(null, titulos);
		tblPersonas.setModel(modelo);
		
		btnListarPersonas = new JButton("Ver Personas Registradas");
		btnListarPersonas.setBounds(594, 11, 181, 44);
		btnListarPersonas.addActionListener(this);
		miPanel.add(btnListarPersonas);
		
		JLabel lblNewLabel = new JLabel("Personas Registradas ");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 385, 42);
		miPanel.add(lblNewLabel);


		
	}

	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnListarPersonas) {
		
			mostrarDatos();
		}
		
	}
	
	public void mostrarDatos () {
		
		while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
		
		try {
			
			ListaPersonas = miCoordinador.ListarPersonaRegistradas();
			Listanacimiento = miCoordinador.ListarNacimientosRegistrados();
			
			System.out.println("holaaaaa");
			System.out.println(Listanacimiento);
			System.out.println(ListaPersonas);
			
			for (PersonaVo miPersona : ListaPersonas) {
		
				
				for (Nacimiento miNac : Listanacimiento) {
					
					
					Object[] registro ={miPersona.getIdPersona(),miPersona.getNombre(),miPersona.getProfesion()
							, miPersona.getTelefono(), miPersona.getTipo(),miNac.getIdNacimiento(), miNac.getCiudadNacimiento()
							,miNac.getDepartamentoNacimiento(),miNac.getFechaNacimiento(), miNac.getPaisNacimiento()};
					
					
					modelo.addRow(registro);

				}						
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}