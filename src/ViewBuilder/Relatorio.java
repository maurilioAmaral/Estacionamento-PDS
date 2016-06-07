package ViewBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;

import com.mysql.jdbc.ResultSet;

import ConexaoBancoDados.ConexaoBD;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Relatorio extends JFrame {
	ConexaoBD conexao = new ConexaoBD();
	JTextArea textArea;
	

	private JPanel contentPane;
	private JButton btnSair;

	public Relatorio() {
		
		setBounds(100, 100, 808, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradaDeVeculos = new JLabel("Entrada de veículos");
		lblEntradaDeVeculos.setBounds(5, 5, 430, 15);
		lblEntradaDeVeculos.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblEntradaDeVeculos);
		
		 textArea = new JTextArea(10,6);
		 textArea.setColumns(10);  
		 textArea.setRows(6);  
		 textArea.setWrapStyleWord(true);  
		 textArea.setLineWrap(true);  
		textArea.setBounds(15, 32, 771, 225);
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		
		 btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSair.setBounds(711, 276, 83, 25);
		contentPane.add(btnSair);
		
		 
		GerarRelatorio();
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSair){
					dispose();
				}
				
			}
		});
		
	}
	public void GerarRelatorio(){
		 ConexaoBD conectado = new ConexaoBD();
		 conectado.conectar();
		 Connection connect=null;
		 PreparedStatement pst = null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from veiculo ";
			 pst=conectado.connect.prepareStatement(sql);			 
			 rs= (ResultSet) pst.executeQuery(sql);
//			 rs.next();
			 
			 while(rs.next()){
				 

				 textArea.append("ID: ");
				 textArea.append(rs.getString("id"));
				 textArea.append(" PROPIETARIO: ");
				 textArea.append(rs.getString("propietario"));
				 textArea.append(" MODELO: ");
				 textArea.append(rs.getString("modelo"));
				 textArea.append(" PLACA: ");
				 textArea.append(rs.getString("placa"));
				 textArea.append(" HORA DE ENTRADA: ");
				 textArea.append(rs.getString("horaEntrada"));
				 textArea.append(" DATA DA ENTRADA: ");
				 textArea.append(rs.getString("dataEntrada"));				 
				 textArea.append("\n\n");
				 
			 }
			 		 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
	
	}
}
