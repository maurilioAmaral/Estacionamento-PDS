package ViewBuilder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;

import ConexaoBancoDados.ConexaoBD;
import Controles.ControleCarro;
import Controles.ControleDataeHora;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;



public class TelaSistema extends JFrame {
	
	ConexaoBD conexao = new ConexaoBD();
	ControleCarro carroControl = new ControleCarro();
	ControleDataeHora dataHora = new ControleDataeHora();
	
	
	
	DefaultTableModel model;
	private JPanel contentPane;
	private JTextField textFieldModelo;
	private JTextField textFieldData;
	private JTextField textFieldBusca;
	private JTextField textFieldPropietario;
	private JTable table;
	private JTextField textFieldHora;
	private JFormattedTextField JformattedPlaca ;

	public TelaSistema() {
		setTitle("Estacionamento");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 470);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(100, 149, 237));
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 87, 70, 15);
		lblModelo.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(78, 85, 117, 19);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(201, 87, 70, 15);
		lblPlaca.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblPlaca);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(12, 126, 70, 15);
		lblHora.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblHora);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(201, 126, 70, 15);
		lblData.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(251, 124, 114, 19);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(12, 167, 117, 25);
		btnCadastrar.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnCadastrar);
		
		final JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(154, 167, 117, 25);
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnExcluir);
		
		final JButton btnListar = new JButton("listar");
		btnListar.setBounds(295, 167, 117, 25);
		btnListar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnListar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(439, 210, 80, 20);
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnBuscar);
		
		final JButton btnSair = new JButton("Sair");
		btnSair.setBounds(565, 413, 58, 19);
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnSair);
		
		JLabel lblEstacioneFcil = new JLabel("Estacione Fácil");
		lblEstacioneFcil.setBounds(83, 0, 188, 27);
		contentPane.add(lblEstacioneFcil);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a placa");
		lblDigiteAPlaca.setBounds(22, 210, 107, 15);
		lblDigiteAPlaca.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblDigiteAPlaca);
		
		textFieldBusca = new JTextField();
		textFieldBusca.setBounds(129, 208, 276, 19);
		contentPane.add(textFieldBusca);
		textFieldBusca.setColumns(10);
		
		JLabel lblPropietrio = new JLabel("Propietário");
		lblPropietrio.setBounds(12, 39, 99, 15);
		lblPropietrio.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblPropietrio);
		
		textFieldPropietario = new JTextField();
		textFieldPropietario.setBounds(108, 39, 257, 19);
		contentPane.add(textFieldPropietario);
		textFieldPropietario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(439, 167, 117, 25);
		btnLimpar.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 247, 611, 164);
		contentPane.add(scrollPane);

		model = new DefaultTableModel(null,
			new String[] {"ID", "Modelo", "Placa", "Hora", "Data", "Propietario"});
		
		table = new JTable(model);
		
		
		
		scrollPane.setViewportView(table);
		 MaskFormatter mascaraPlaca = null;
		 
		try {
			mascaraPlaca = new MaskFormatter("UUU-####");
			
		} catch (Exception e) {
			
		}
		
		JformattedPlaca = new JFormattedTextField(mascaraPlaca);
		JformattedPlaca.setBounds(255, 85, 110, 19);
		contentPane.add(JformattedPlaca);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(78, 124, 114, 19);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCadastrar){				
					if(textFieldModelo.getText().length()==0 || JformattedPlaca.getText().equals("   -    ") || textFieldPropietario.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
							
						}else{

							String modelo = textFieldModelo.getText();
							String placa  = JformattedPlaca.getText();
							textFieldHora.setText(dataHora.getHoraEntrada());
							textFieldData.setText(dataHora.getDataEntrada());
							String propietario = textFieldPropietario.getText();
							carroControl.InserirDadosCarro(modelo, placa, dataHora, propietario);
							textFieldModelo.setText("");					
							JformattedPlaca.setText("");	
							textFieldHora.setText("");
							textFieldData.setText("");
							textFieldPropietario.setText("");
							listar();
							
							
							
						}
					
				}
				
			}

			

			
		});
		btnListar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnListar){
				listar();
				
				
			}
				
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textFieldModelo.setText("");					
				JformattedPlaca.setText("");	
				textFieldHora.setText("");
				textFieldData.setText("");
				textFieldPropietario.setText("");
				textFieldBusca.setText("");
				
			}
		});
		btnExcluir.addActionListener(new  ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnExcluir){
					String placa = JOptionPane.showInputDialog(null,"Digite a placa do  veiculo");
					carroControl.DeletarVeiculo(placa);
					listar();
				}
				
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			pesquisar();
				
				
			}
		});
		btnSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSair){								
				int r = JOptionPane.showConfirmDialog(null, "Deseja sair");
				if(r==0){
					System.exit(0);
				}				
			}
				
			}
		});
		
		
	}
	////////////////////////////////////////////////////////////////////////////
	
	
	public void pesquisar(){
		
		 ConexaoBD conectado = new ConexaoBD();
		 conectado.conectar();
		 PreparedStatement pst = null;
		 ResultSet rs=null;
		
		
		try {
			String sql = "select * from veiculo where placa=?";
			pst = conectado.connect.prepareStatement(sql);
			pst.setString(1,textFieldBusca.getText());
			rs=pst.executeQuery();
			
			if(rs.next()){
				JformattedPlaca.setText(rs.getString("placa"));				
				textFieldModelo.setText(rs.getString("modelo"));
				textFieldHora.setText(rs.getString("horaEntrada"));
				textFieldData.setText(rs.getString("dataEntrada"));
				textFieldPropietario.setText(rs.getString("propietario"));
				
				
			
			}
			else{
				
				JOptionPane.showMessageDialog(null, "veículo não cadastrado ou placa incorreta");
				textFieldBusca.setText("");
				
				
			}
			
		} catch (Exception e) {
		
			
			JOptionPane.showMessageDialog(null,"erro no banco de dados");
			System.out.println();
			conectado.fecharBancoDados();				
			e.printStackTrace();
			
		}
		
	}
	public void listar(){
		 ConexaoBD conectado = new ConexaoBD();
		 conectado.conectar();
		 Connection connect=null;
		 PreparedStatement pst = null;
		 ResultSet rs=null;
		 try {
			 String sql="select * from veiculo ";
			 pst=conectado.connect.prepareStatement(sql);
			 rs=pst.executeQuery(sql);
			 model.setNumRows(0);
			 while(rs.next()){
				
				 
				 model.addRow(new Object[]{rs.getInt("id"),rs.getString("modelo"),rs.getString("placa"),rs.getString("horaEntrada"),rs.getString("dataEntrada"),rs.getString("propietario")});
				 

								 
			 }
			 		 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
}