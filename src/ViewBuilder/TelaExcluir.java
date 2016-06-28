package ViewBuilder;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import com.mysql.jdbc.ResultSet;

import ConexaoBancoDados.ConexaoBD;
import Controles.ControleCarro;
import Controles.ControleDataeHora;

public class TelaExcluir extends JFrame {
	TelaSistema t = new TelaSistema();

	private JPanel contentPane;
	private JTextField textFieldPropietario;
	private JTextField textFieldModelo;
	private JTextField textFieldplaca;
	private JTextField textFieldTempo;
	private JTextField textFieldHora;
	private JTextField textFieldData;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnEditar;
	
	
	ConexaoBD conexao = new ConexaoBD();
	ControleCarro carro = new ControleCarro();
	ControleDataeHora dataHora = new ControleDataeHora();
	private JTextField textFieldId;
	

	
	
	public TelaExcluir() {
		
	
		setResizable(false);
		conexao.conectar();
		
		
		setBounds(100, 100, 558, 315);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblRemoverVeculo = new JLabel("Remover veículo");
		lblRemoverVeculo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRemoverVeculo.setBounds(117, 12, 136, 15);
		contentPane.add(lblRemoverVeculo);
		
		JLabel lblDigiteOid = new JLabel("Digite o id");
		lblDigiteOid.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDigiteOid.setBounds(26, 52, 94, 15);
		contentPane.add(lblDigiteOid);
		
		JLabel lblPropietrio = new JLabel("propietário");
		lblPropietrio.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPropietrio.setBounds(26, 99, 94, 15);
		contentPane.add(lblPropietrio);
		
		textFieldPropietario = new JTextField();
		textFieldPropietario.setBounds(155, 97, 114, 19);
		contentPane.add(textFieldPropietario);
		textFieldPropietario.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblModelo.setBounds(302, 99, 70, 15);
		contentPane.add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(390, 97, 114, 19);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPlaca.setBounds(26, 153, 70, 15);
		contentPane.add(lblPlaca);
		
		textFieldplaca = new JTextField();
		textFieldplaca.setBounds(155, 151, 114, 19);
		contentPane.add(textFieldplaca);
		textFieldplaca.setColumns(10);
		
		textFieldTempo = new JTextField();
		textFieldTempo.setBounds(390, 151, 114, 19);
		contentPane.add(textFieldTempo);
		textFieldTempo.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora de entrada");
		lblHora.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHora.setBounds(26, 216, 126, 15);
		contentPane.add(lblHora);
		
		JLabel lblTempo = new JLabel("tempo");
		lblTempo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTempo.setBounds(302, 153, 70, 15);
		contentPane.add(lblTempo);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(155, 214, 114, 19);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);
		
		JLabel lblDataDaEntrada = new JLabel("Dia");
		lblDataDaEntrada.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDataDaEntrada.setBounds(302, 216, 59, 15);
		contentPane.add(lblDataDaEntrada);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(390, 214, 114, 19);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCancelar.setBounds(450, 252, 94, 25);
		contentPane.add(btnCancelar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluir.setBounds(355, 252, 83, 25);
		contentPane.add(btnExcluir);
		
		
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnEditar.setBounds(237, 252, 106, 25);
		contentPane.add(btnEditar);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(155, 50, 59, 19);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
//		 MaskFormatter mascaraPlaca = null;
//		
//		 
//		try {
//			
//			mascaraPlaca = new MaskFormatter("UUU-####");
//			
//			
//		} catch (Exception e) {
//			
//		}
		
		textFieldId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnCancelar){
				dispose();
				
			}
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()== btnExcluir){
					
				
				}
					if(textFieldId.getText().equals("")||textFieldplaca.getText().equals("")||textFieldplaca.getText().equals("")||
							textFieldHora.getText().equals("")||textFieldData.getText().equals("")|| textFieldPropietario.getText().equals("")||
							 textFieldTempo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Realize a pesquisa por ID antes");
						
						
					}
					

					else{
						int r = JOptionPane.showConfirmDialog(null, "Deseja excluir?");
						if(r==0){
					String placa = textFieldplaca.getText();
					textFieldModelo.setText("");					
					textFieldData.setText("");
					textFieldPropietario.setText("");
					textFieldHora.setText("");
					textFieldplaca.setText("");
					textFieldTempo.setText("");
					textFieldId.setText("");
					carro.DeletarVeiculo(placa);
						}
						
					
					}
					
					
					
				
				
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnEditar){
				if(textFieldId.getText().equals("")||textFieldplaca.getText().equals("")||textFieldplaca.getText().equals("")||
						textFieldHora.getText().equals("")||textFieldData.getText().equals("")|| textFieldPropietario.getText().equals("")||
						 textFieldTempo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Realize a pesquisa por ID antes");
					
				}else{
				int id = Integer.parseInt(textFieldId.getText());
				String modelo = textFieldModelo.getText();
				String placa = textFieldplaca.getText();
				textFieldHora.setText(dataHora.getHoraEntrada());
				textFieldData.setText(dataHora.getDataEntrada());
				String propietario = textFieldPropietario.getText();
				String tempo = textFieldTempo.getText();
				carro.Editar(id,modelo, placa, dataHora, propietario, tempo);
				}
				
			}
				
			}
		});
		
		
	}
	public void pesquisar(){
		
		 ConexaoBD conectado = new ConexaoBD();
		 conectado.conectar();
		 PreparedStatement pst = null;
		 ResultSet rs=null;
		
		
		try {
			String sql = "select * from veiculo where id=?";
			pst = conectado.connect.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(textFieldId.getText()));
			rs=(ResultSet) pst.executeQuery();
			
			if(rs.next()){
				textFieldplaca.setText(rs.getString("placa"));				
				textFieldModelo.setText(rs.getString("modelo"));
				textFieldHora.setText(rs.getString("horaEntrada"));
				textFieldData.setText(rs.getString("dataEntrada"));
				textFieldPropietario.setText(rs.getString("propietario"));
				textFieldTempo.setText(rs.getString("tempo"));
				
			
			}
			else{
				
				JOptionPane.showMessageDialog(null, "veículo não encontrado verifique a placa e tente novamente");
				textFieldId.setText("");
				
				
			}
			
		} catch (Exception e) {
		
			
			JOptionPane.showMessageDialog(null,"erro no banco de dados");
			System.out.println();
			conectado.fecharBancoDados();				
			e.printStackTrace();
			
		}
	}

	
	public JTextField getTextFieldId() {
		return textFieldId;
	}
	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}
}
