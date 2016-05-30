package ViewBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;

import ConexaoBancoDados.ConexaoBD;
import Controles.ControleCarro;
import Controles.ControleFuncionario;

import javax.swing.JButton;


public class LoginFuncionarioBuilder extends JFrame implements ActionListener{
	ControleFuncionario func = new ControleFuncionario();
	static ConexaoBD conectado = new ConexaoBD();
	ControleCarro carro = new ControleCarro();
	public Connection connect=null;
	public PreparedStatement pst = null;
	public ResultSet rs=null;

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	private JButton btnSair;
	private JButton btnEntrar;

	
	public static void main(String[] args) {
		conectado.conectar();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFuncionarioBuilder frame = new LoginFuncionarioBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginFuncionarioBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 175);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblLogin.setBounds(30, 25, 70, 15);
		panel.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		textFieldLogin.setBounds(100, 23, 198, 19);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSenha.setBounds(30, 70, 70, 15);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 68, 198, 19);
		panel.add(passwordField);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSair.setBounds(100, 99, 81, 25);
		panel.add(btnSair);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnEntrar.setBounds(217, 99, 81, 25);
		panel.add(btnEntrar);
		contentPane.setLayout(gl_contentPane);
		
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnEntrar){
					logar();
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
	}
public void logar(){
		
		String sql = "SELECT * FROM funcionario where login=? and senha=?";
		try {
		

			pst = conectado.connect.prepareStatement(sql);
			pst.setString(1,textFieldLogin.getText());
			pst.setString(2, passwordField.getText());
			rs=pst.executeQuery();
			if(rs.next()){
				dispose();
//				 TelaSistemaBuilder tela  =  new TelaSistemaBuilder();
//				 tela.setVisible(true);
				TelaSistema t = new TelaSistema();
				t.setVisible(true);
				 
				 
			}else{
				JOptionPane.showMessageDialog(null, "login ou senha incorretos");
				textFieldLogin.setText("");
				passwordField.setText("");
				
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,e);
			System.out.println();
			conectado.fecharBancoDados();
			e.printStackTrace();
			
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
}
