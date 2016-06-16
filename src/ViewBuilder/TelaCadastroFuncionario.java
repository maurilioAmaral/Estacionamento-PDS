package ViewBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;

import com.mysql.jdbc.ResultSet;

import ConexaoBancoDados.ConexaoBD;
import Controles.ControleFuncionario;
import javax.swing.JPasswordField;

public class TelaCadastroFuncionario extends JFrame {
	LoginFuncionarioBuilder l = new LoginFuncionarioBuilder();
	
	
	public Connection connect=null;
	public PreparedStatement pst = null;
	public ResultSet rs=null;
	
	static ConexaoBD conectado = new ConexaoBD();
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JButton btnConfirmar;
	private String senha;
	private String login;
	private JTextField textFieldLoginConfirm;
	private JButton btnOk;
	private JTextField textFieldLoginAdmin;
	private JTextField textFieldSenhaAdmin;
	private JButton btnCadastrar; 
	private JButton btnSair;
	private JPasswordField passwordFieldsenha;
	private JPasswordField passwordFieldSenhaConfirm;
	
	
	public TelaCadastroFuncionario() {
		
		conectado.conectar();
		
		setTitle("Cadastro de funcionário");
		setResizable(false);
		setBounds(100, 100, 408, 439);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setForeground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblLogin.setBounds(31, 29, 70, 15);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSenha.setBounds(31, 86, 70, 15);
		contentPane.add(lblSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(119, 27, 212, 19);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		 btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnConfirmar.setBounds(229, 257, 109, 25);
		contentPane.add(btnConfirmar);
		
		 btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSair.setBounds(336, 376, 58, 25);
		contentPane.add(btnSair);
		
		JLabel lblLoginConfirm = new JLabel("Login");
		lblLoginConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblLoginConfirm.setBounds(31, 179, 70, 15);
		contentPane.add(lblLoginConfirm);
		
		JLabel lblSenhaConfirm = new JLabel("Senha");
		lblSenhaConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSenhaConfirm.setBounds(31, 228, 70, 15);
		contentPane.add(lblSenhaConfirm);
		
		textFieldLoginConfirm = new JTextField();
		textFieldLoginConfirm.setBounds(119, 177, 212, 19);
		contentPane.add(textFieldLoginConfirm);
		textFieldLoginConfirm.setColumns(10);
		
		JLabel lblConfirmao = new JLabel("Confirmação de Login e Senha");
		lblConfirmao.setBounds(31, 135, 300, 15);
		contentPane.add(lblConfirmao);
		
		 btnOk = new JButton("OK");
		btnOk.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnOk.setBounds(280, 109, 58, 25);
		contentPane.add(btnOk);
		
		JLabel lblLoginAdministrativo = new JLabel("Login Administrativo");
		lblLoginAdministrativo.setBounds(31, 302, 152, 15);
		contentPane.add(lblLoginAdministrativo);
		
		textFieldLoginAdmin = new JTextField();
		textFieldLoginAdmin.setBounds(181, 300, 150, 19);
		contentPane.add(textFieldLoginAdmin);
		textFieldLoginAdmin.setColumns(10);
		
		JLabel lblSenhaAdministrativa = new JLabel("Senha Administrativa");
		lblSenhaAdministrativa.setBounds(31, 347, 152, 15);
		contentPane.add(lblSenhaAdministrativa);
		
		textFieldSenhaAdmin = new JTextField();
		textFieldSenhaAdmin.setBounds(191, 345, 140, 19);
		contentPane.add(textFieldSenhaAdmin);
		textFieldSenhaAdmin.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCadastrar.setBounds(214, 376, 117, 25);
		contentPane.add(btnCadastrar);
		
		passwordFieldsenha = new JPasswordField();
		passwordFieldsenha.setBounds(119, 84, 212, 19);
		contentPane.add(passwordFieldsenha);
		
		passwordFieldSenhaConfirm = new JPasswordField();
		passwordFieldSenhaConfirm.setBounds(124, 226, 207, 19);
		contentPane.add(passwordFieldSenhaConfirm);
		
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnConfirmar){
					
					if(textFieldLoginConfirm.getText().length()==0||passwordFieldSenhaConfirm.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
						
					}
					else if(textFieldLoginConfirm.getText().equals(login) && passwordFieldSenhaConfirm.getText().equals(senha)){
						JOptionPane.showMessageDialog(null, "Confimação realizada \n"+"Confirme agora o login e senha administrativo");
						textFieldLoginAdmin.setEnabled(true);
						textFieldSenhaAdmin.setEnabled(true);
						login = textFieldLoginConfirm.getText();
						senha = passwordFieldSenhaConfirm.getText();
						String login = textFieldLoginConfirm.getText();
						String senha = passwordFieldSenhaConfirm.getText();
						
						
						
						
					}else{
						JOptionPane.showMessageDialog(null, "login ou senha incorretos");
					}
				}
				
			}
		});
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnOk){
					cadastrar();
					
				}
					
				
			}
		});
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnSair){
				dispose();
				
			}
				
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCadastrar){
					confirmarCadastro();
					
				}
				
			}
		});
	}
	public void cadastrar(){
		
		if(textFieldLogin.getText().length()==0||passwordFieldsenha.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			
		}else{
			textFieldLoginConfirm.setEnabled(true);
			passwordFieldSenhaConfirm.setEnabled(true);
						
			login = textFieldLogin.getText();
			senha = passwordFieldsenha.getText();
			
			textFieldLoginAdmin.setEnabled(false);
			textFieldSenhaAdmin.setEnabled(false);
			
			textFieldLogin.setText("");
			passwordFieldsenha.setText("");
		}
		
		
		
		

		}
	public void confirmarCadastro(){
		ControleFuncionario controleFunc = new ControleFuncionario();
		
		if(textFieldLoginAdmin.getText().length()==0||textFieldSenhaAdmin.getText().length()==0){
			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
		}
		else{
			String sql = "SELECT * FROM funcionario where login=? and senha=?";
			
			try {
			

				pst = conectado.connect.prepareStatement(sql);
				pst.setString(1,textFieldLoginAdmin.getText());
				pst.setString(2, textFieldSenhaAdmin.getText());
				rs= (ResultSet) pst.executeQuery();
				if(rs.next()){

					
					
					login = textFieldLoginConfirm.getText();
					senha = passwordFieldSenhaConfirm.getText();
					
					controleFunc.InserirDadosFuncionario(login,senha);
					
					 
					 
				}else{
					JOptionPane.showMessageDialog(null, "login ou senha incorretos");
					textFieldLoginAdmin.setText("");
					textFieldSenhaAdmin.setText("");
					
				}
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null,e);
				System.out.println();
				conectado.fecharBancoDados();
				e.printStackTrace();
				
			}
			
		}

	}
		
	

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public void setTextFieldLogin(JTextField textFieldLogin) {
		this.textFieldLogin = textFieldLogin;
	}

	
	public JTextField getTextFieldLoginConfirm() {
		return textFieldLoginConfirm;
	}
	public void setTextFieldLoginConfirm(JTextField textFieldLoginConfirm) {
		this.textFieldLoginConfirm = textFieldLoginConfirm;
	}
	
	public JTextField getTextFieldLoginAdmin() {
		return textFieldLoginAdmin;
	}
	public void setTextFieldLoginAdmin(JTextField textFieldLoginAdmin) {
		this.textFieldLoginAdmin = textFieldLoginAdmin;
	}
	public JTextField getTextFieldSenhaAdmin() {
		return textFieldSenhaAdmin;
	}
	public void setTextFieldSenhaAdmin(JTextField textFieldSenhaAdmin) {
		this.textFieldSenhaAdmin = textFieldSenhaAdmin;
	}
	public JPasswordField getPasswordFieldsenha() {
		return passwordFieldsenha;
	}
	public void setPasswordFieldsenha(JPasswordField passwordFieldsenha) {
		this.passwordFieldsenha = passwordFieldsenha;
	}
	public JPasswordField getPasswordFieldSenhaConfirm() {
		return passwordFieldSenhaConfirm;
	}
	public void setPasswordFieldSenhaConfirm(
			JPasswordField passwordFieldSenhaConfirm) {
		this.passwordFieldSenhaConfirm = passwordFieldSenhaConfirm;
	}
}
