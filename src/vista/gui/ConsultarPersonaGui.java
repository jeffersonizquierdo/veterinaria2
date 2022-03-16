package vista.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.Nacimiento;
import modelo.vo.PersonaVo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;

public class ConsultarPersonaGui extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textDocumetno;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textProfecion;
	private JTextField textTipo;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textA�o;
	private JTextField textCiudad;
	private JTextField textDepartamento;
	private JTextField textPais;
	private JButton btnCancelar;
	private JButton btnConsultar;
	private Coordinador miCoordinador;
	private JButton btnActualizar;


	public ConsultarPersonaGui(VentanaPrincipal miVentanaPrincipal, boolean b) {

		setBounds(100, 100, 661, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 0, 169, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setBounds(27, 74, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textDocumetno = new JTextField();
		textDocumetno.setBounds(106, 71, 136, 20);
		contentPane.add(textDocumetno);
		textDocumetno.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(386, 68, 89, 23);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(27, 107, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(106, 107, 334, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(27, 150, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(106, 147, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Profecion");
		lblNewLabel_4.setBounds(232, 150, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textProfecion = new JTextField();
		textProfecion.setBounds(288, 147, 86, 20);
		contentPane.add(textProfecion);
		textProfecion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo");
		lblNewLabel_5.setBounds(418, 150, 34, 14);
		contentPane.add(lblNewLabel_5);
		
		textTipo = new JTextField();
		textTipo.setBounds(445, 147, 86, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setBounds(27, 199, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textDia = new JTextField();
		textDia.setBounds(106, 196, 34, 20);
		contentPane.add(textDia);
		textDia.setColumns(10);
		
		textMes = new JTextField();
		textMes.setBounds(150, 196, 32, 20);
		contentPane.add(textMes);
		textMes.setColumns(10);
		
		textA�o = new JTextField();
		textA�o.setBounds(202, 196, 57, 20);
		contentPane.add(textA�o);
		textA�o.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ciudad");
		lblNewLabel_7.setBounds(27, 251, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textCiudad = new JTextField();
		textCiudad.setBounds(106, 248, 86, 20);
		contentPane.add(textCiudad);
		textCiudad.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Departamento");
		lblNewLabel_8.setBounds(237, 251, 77, 14);
		contentPane.add(lblNewLabel_8);
		
		textDepartamento = new JTextField();
		textDepartamento.setBounds(310, 248, 86, 20);
		contentPane.add(textDepartamento);
		textDepartamento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Pais");
		lblNewLabel_9.setBounds(460, 251, 26, 14);
		contentPane.add(lblNewLabel_9);
		
		textPais = new JTextField();
		textPais.setBounds(488, 248, 86, 20);
		contentPane.add(textPais);
		textPais.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(521, 299, 89, 23);
		contentPane.add(btnCancelar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(106, 299, 89, 23);
		btnActualizar.addActionListener(this);
		contentPane.add(btnActualizar);
		
		
		JLabel lblNewLabel_10 = new JLabel("/");
		lblNewLabel_10.setBounds(144, 199, 13, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("/");
		lblNewLabel_10_1.setBounds(192, 199, 13, 14);
		contentPane.add(lblNewLabel_10_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(27, 21, 89, 23);
		contentPane.add(btnVolver);
		btnCancelar.addActionListener(this);
		
		textA�o.enable(false);
		textCiudad.enable(false);
		textDepartamento.enable(false);
		textDia.enable(false);
		textMes.enable(false);
		textNombre.enable(false);
		textPais.enable(false);
		textProfecion.enable(false);
		textTelefono.enable(false);
		textTipo.enable(false);
		
		btnActualizar.setVisible(false);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnConsultar) {
			Long idDocumento=Long.parseLong(textDocumetno.getText());
			PersonaVo personaVo=miCoordinador.setConsultarPersona(idDocumento);
			if (personaVo!=null) {
				
				personaVo.setNacimiento(miCoordinador.consultarNacimiento(personaVo.getNacimiento().getIdNacimiento()));
				System.out.println(personaVo);				
				textNombre.setText(personaVo.getNombre());
				textProfecion.setText(personaVo.getProfesion());
				textTelefono.setText(personaVo.getTelefono());
				textTipo.setText(personaVo.getTipo()+"");
				
				textCiudad.setText(personaVo.getNacimiento().getCiudadNacimiento());
				textDepartamento.setText(personaVo.getNacimiento().getDepartamentoNacimiento());
				textPais.setText(personaVo.getNacimiento().getPaisNacimiento());
				textDia.setText(personaVo.getNacimiento().getFechaNacimiento().getDayOfMonth()+"");
				textMes.setText(personaVo.getNacimiento().getFechaNacimiento().getMonthValue()+"");
				textA�o.setText(personaVo.getNacimiento().getFechaNacimiento().getYear()+"");
				
				textA�o.enable(true);
				textCiudad.enable(true);
				textDepartamento.enable(true);
				textDia.enable(true);
				textMes.enable(true);
				textNombre.enable(true);
				textPais.enable(true);
				textProfecion.enable(true);
				textTelefono.enable(true);
				textTipo.enable(true);
				
				textDocumetno.enable(false);
				btnActualizar.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"No se encuentra la persona, verifique el documento","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			
			}
			
		} else if (e.getSource() == btnActualizar) {
			
			PersonaVo miPersonaVo = new PersonaVo();
			miPersonaVo.setIdPersona(Long.parseLong(textDocumetno.getText()));
			miPersonaVo.setNombre(textNombre.getText());
			miPersonaVo.setProfesion(textProfecion.getText());
			miPersonaVo.setTelefono(textTelefono.getText());
			miPersonaVo.setTipo(Integer.parseInt(textTipo.getText()));

			Nacimiento miNacimiento=new Nacimiento();
			miNacimiento.setCiudadNacimiento(textCiudad.getText());
			miNacimiento.setDepartamentoNacimiento(textDepartamento.getText());
			miNacimiento.setPaisNacimiento(textPais.getText());
			miNacimiento.setFechaNacimiento(LocalDate.of(Integer.parseInt(textA�o.getText()), 
			Integer.parseInt(textMes.getText()), Integer.parseInt(textDia.getText())));
			
			miPersonaVo.setNacimiento(miNacimiento);
			
			
			String confirmacion="";
			String confir = "";
			
			if (miCoordinador.validarCampos(miPersonaVo) == true) {
				
				confirmacion=miCoordinador.actualizarPersona(miPersonaVo);
				long idNaci = miCoordinador.buscarNacimiento(miPersonaVo);
				miNacimiento.setIdNacimiento(idNaci);
				confir = miCoordinador.actualizaNacimiento(miNacimiento);

				
			} else {
				
				confirmacion = "Faltan datos";
			}
			
			if (confirmacion.equals("ok")) {
				
				JOptionPane.showMessageDialog(null, " Persona modificada con exito ","Confirmaci�n",JOptionPane.INFORMATION_MESSAGE);	
			} else{
				if (confirmacion.equals("Faltan datos")) {
					JOptionPane.showMessageDialog(null, "Debe Ingresar los campos obligatorios","Faltan Datos",JOptionPane.WARNING_MESSAGE);			
				}else{
		            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}

	} 


	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;
		
	}
}