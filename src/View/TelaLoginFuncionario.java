package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexaoBancoDados.ConexaoBD;
import Controles.ControleCarro;
import Controles.ControleFuncionario;



public class TelaLoginFuncionario extends JFrame implements ActionListener{
	ControleFuncionario func = new ControleFuncionario();
	ConexaoBD conectado = new ConexaoBD();
	ControleCarro carro = new ControleCarro();
	public Connection connect=null;
	public PreparedStatement pst = null;
	public ResultSet rs=null;
	
	
	
	JButton botaoCancelar;	
	JButton botaoEntrar;
	JLabel labelSenha;
	JLabel labelLogin;
	JTextField textSenha;
	JTextField textLogin;
	
	
	public TelaLoginFuncionario(){
	
	tela();
	botoes();
	eventos();
	conectado.conectar();
	
		
		
	}
	public void botoes(){
		botaoEntrar = new JButton("Entrar");
		botaoCancelar = new JButton("Cancelar");
		labelSenha = new JLabel("Login");
		labelLogin = new JLabel("Senha");
		textSenha = new JTextField(15);
		textLogin = new JTextField(15);
		add(labelSenha);
		add(textSenha);
		add(labelLogin);		
		add(textLogin);
		add(botaoCancelar);			
		add(botaoEntrar);
			}
	public void tela(){
		setSize(400,150);
		setVisible(true);
		setLayout(new GridLayout(3,2));
		setLocationRelativeTo(null);
		setTitle("Tela Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void eventos(){
	botaoEntrar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == botaoEntrar){
				

			logar();
					
			}
			
		}
	});
	botaoCancelar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botaoCancelar){
			textSenha.setText("");
			textLogin.setText("");
			
			
			}
			
		}
	});
	}
	public void actionPerformed(ActionEvent e) {
	
	}

	public void logar(){
		
		String sql = "SELECT * FROM funcionario where login=? and senha=?";
		try {
		

			pst = conectado.connect.prepareStatement(sql);
			pst.setString(1,textLogin.getText());
			pst.setString(2, textSenha.getText());
			rs=pst.executeQuery();
			if(rs.next()){
				dispose();
				 TelaSistemaCentral telaCentral = new TelaSistemaCentral();
				 telaCentral.setVisible(true);
				 
			}else{
				JOptionPane.showMessageDialog(null, "login ou senha incorretos");
				textSenha.setText("");
				textLogin.setText("");
				
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,e);
			System.out.println();
			conectado.fecharBancoDados();
			System.out.println(textLogin.getText()+textSenha.getText());
			e.printStackTrace();
			
		}
		
	}

	
	public JTextField getTextSenha() {
		return textSenha;
	}
	public void setTextSenha(JTextField textSenha) {
		this.textSenha = textSenha;
	}
	public JTextField getTextLogin() {
		return textLogin;
	}
	public void setTextLogin(JTextField textLogin) {
		this.textLogin = textLogin;
	}
	public static void main(String[] args) {
		new TelaLoginFuncionario();
	}
}