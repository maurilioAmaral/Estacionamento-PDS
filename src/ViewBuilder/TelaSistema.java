package ViewBuilder;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
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
import javax.swing.UIManager;



public class TelaSistema extends JFrame {
	
	ConexaoBD conexao = new ConexaoBD();
	ControleCarro carroControl = new ControleCarro();
	ControleDataeHora dataHora = new ControleDataeHora();
	Relatorio relatorio = new Relatorio();
	DefaultTableModel model;
	private JPanel contentPane;
	private JTextField textFieldModelo;
	private JTextField textFieldData;
	private JTextField textFieldPropietario;
	private JTable table;
	private JTextField textFieldHora;
	private JFormattedTextField JformattedPlaca ;
	private JFormattedTextField formattedBuscaPlaca;
	private JButton btnRelatrio;
	private MaskFormatter mascaraPlaca;
	private JFormattedTextField formattedTextFieldTempo;
	private String placa;
	private JButton btnListar;

	public TelaSistema() {
		
		setTitle("Estacionamento");
		setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 470);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(100, 149, 237));
		contentPane.setBackground(new Color(30, 144, 255));
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
		
		textFieldData = new JTextField("Não obrigatório");
		textFieldData.setBounds(251, 124, 114, 19);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(12, 167, 117, 25);
		btnCadastrar.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnCadastrar);
		
		final JButton btnExcluir = new JButton("Excluir/Editar");
		btnExcluir.setBounds(301, 167, 152, 25);
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(234, 210, 80, 20);
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
		
		JLabel lblPropietrio = new JLabel("Propietário");
		lblPropietrio.setBounds(12, 39, 99, 15);
		lblPropietrio.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblPropietrio);
		
		textFieldPropietario = new JTextField();
		textFieldPropietario.setBounds(108, 39, 257, 19);
		contentPane.add(textFieldPropietario);
		textFieldPropietario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(155, 167, 117, 25);
		btnLimpar.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 247, 611, 164);
		contentPane.add(scrollPane);

		model = new DefaultTableModel(null,
			new String[] {"ID", "Modelo", "Placa", "Hora", "Data", "Propietario","tempo"});
		
		table = new JTable(model);
		
		
		
		scrollPane.setViewportView(table);
		 MaskFormatter mascaraPlaca = null;
		 MaskFormatter mascaraHora = null;
		 
		try {
			
			mascaraPlaca = new MaskFormatter("UUU-####");
			mascaraHora = new MaskFormatter("#:##");
			
		} catch (Exception e) {
			
		}
		
		JformattedPlaca = new JFormattedTextField(mascaraPlaca);
		JformattedPlaca.setBounds(251, 85, 70, 19);
		contentPane.add(JformattedPlaca);
		
		textFieldHora = new JTextField("Não obrigatório");
		textFieldHora.setBounds(78, 124, 114, 19);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);
		
		formattedBuscaPlaca = new JFormattedTextField(mascaraPlaca);
		formattedBuscaPlaca.setBounds(126, 211, 84, 19);
		contentPane.add(formattedBuscaPlaca);
		
		btnRelatrio = new JButton("Relatório");
		btnRelatrio.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRelatrio.setBounds(463, 413, 90, 19);
		contentPane.add(btnRelatrio);
		
		JLabel lblTempo = new JLabel("tempo");
		lblTempo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTempo.setBounds(339, 89, 70, 15);
		contentPane.add(lblTempo);
		
		formattedTextFieldTempo = new JFormattedTextField(mascaraHora);
		formattedTextFieldTempo.setBounds(397, 85, 80, 19);
		contentPane.add(formattedTextFieldTempo);
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnListar.setBounds(465, 167, 117, 25);
		contentPane.add(btnListar);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCadastrar){				
					if(textFieldModelo.getText().length()==0 || JformattedPlaca.getText().equals("   -    ") || textFieldPropietario.getText().length()==0||formattedTextFieldTempo.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
							
						}else{

							String modelo = textFieldModelo.getText();
							String placa  = JformattedPlaca.getText();
							textFieldHora.setText(dataHora.getHoraEntrada());
							textFieldData.setText(dataHora.getDataEntrada());
							String propietario = textFieldPropietario.getText();
							String tempo =  formattedTextFieldTempo.getText();
							carroControl.InserirDadosCarro(modelo, placa,dataHora, propietario, tempo);
							textFieldModelo.setText("");					
							JformattedPlaca.setText("");
							formattedTextFieldTempo.setText(null);
							textFieldHora.setText("");
							textFieldData.setText("");
							textFieldPropietario.setText("");
							JformattedPlaca.setText(null);
							
							listar();
							
							
							
						}
					
				}
				
			}

			

			
		});
		btnLimpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textFieldModelo.setText("");					
				textFieldHora.setText("");
				textFieldData.setText("");
				textFieldPropietario.setText("");
				formattedTextFieldTempo.setText(null);
				JformattedPlaca.setText(null);
				formattedBuscaPlaca.setText(null);

				
			}
		});
		btnExcluir.addActionListener(new  ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnExcluir){
					 TelaExcluir telaExcluir = new TelaExcluir();
					 telaExcluir.setVisible(true);
					
					listar();
				}
				
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(formattedBuscaPlaca.getText().equals("   -    ")){
					JOptionPane.showMessageDialog(null, "Preencha o campo de busca para pesquisar");
					
				}else{
					pesquisar();
				}
			
				
				
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
		btnListar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() ==  btnListar){
					listar();
				}
				
			}
		});
		btnRelatrio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRelatrio);
				relatorio.gerarRelatorioPDF();
				relatorio.setVisible(true);
				relatorio.GerarRelatorio();
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
			pst.setString(1,formattedBuscaPlaca.getText());
			rs=pst.executeQuery();
			
			if(rs.next()){
				JformattedPlaca.setText(rs.getString("placa"));				
				textFieldModelo.setText(rs.getString("modelo"));
				textFieldHora.setText(rs.getString("horaEntrada"));
				textFieldData.setText(rs.getString("dataEntrada"));
				textFieldPropietario.setText(rs.getString("propietario"));
				formattedTextFieldTempo.setText(rs.getString("tempo"));
				
			
			}
			else{
				
				JOptionPane.showMessageDialog(null, "veículo não encontrado verifique a placa e tente novamente");
				formattedBuscaPlaca.setText("");
				
				
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
			 rs = pst.executeQuery(sql);
			 model.setNumRows(0);
			
				
			 while(rs.next()){
					
						 model.addRow(new Object[]{rs.getInt("id"),rs.getString("modelo"),rs.getString("placa"),
						rs.getString("horaEntrada"),rs.getString("dataEntrada"),rs.getString("propietario"),rs.getString("tempo")});
						 
			 
			 }
		 }
			 		 
	catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}
	


	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}


	public void setTextFieldModelo(JTextField textFieldModelo) {
		this.textFieldModelo = textFieldModelo;
	}


	public JTextField getTextFieldData() {
		return textFieldData;
	}


	public void setTextFieldData(JTextField textFieldData) {
		this.textFieldData = textFieldData;
	}


	public JTextField getTextFieldPropietario() {
		return textFieldPropietario;
	}


	public void setTextFieldPropietario(JTextField textFieldPropietario) {
		this.textFieldPropietario = textFieldPropietario;
	}


	public JTextField getTextFieldHora() {
		return textFieldHora;
	}


	public void setTextFieldHora(JTextField textFieldHora) {
		this.textFieldHora = textFieldHora;
	}


	public JFormattedTextField getJformattedPlaca() {
		return JformattedPlaca;
	}


	public void setJformattedPlaca(JFormattedTextField jformattedPlaca) {
		JformattedPlaca = jformattedPlaca;
	}


	public JFormattedTextField getFormattedTextFieldTempo() {
		return formattedTextFieldTempo;
	}


	public void setFormattedTextFieldTempo(
			JFormattedTextField formattedTextFieldTempo) {
		this.formattedTextFieldTempo = formattedTextFieldTempo;
	}
}