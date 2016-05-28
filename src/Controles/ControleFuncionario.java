package Controles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import View.TelaLoginFuncionario;
import View.TelaSistemaCentral;
import ConexaoBancoDados.ConexaoBD;


public class ControleFuncionario {
	ConexaoBD conectado = new ConexaoBD();
	public Connection connect=null;	
	public ResultSet rs=null;
	public PreparedStatement pst = null;


	public void InserirDadosFuncionario(String login,String senha ){
		
		conectado.conectar();		
		try{
			Connection conn = (Connection) conectado.conectar();
			Statement state = (Statement) conn.createStatement();
			String mySql = "INSERT INTO estacionamento.funcionario VALUES(null,'"+senha+"','"+login+"')";
			System.out.println(mySql);
			boolean res = state.execute(mySql);
			JOptionPane.showMessageDialog(null,(!res)?"dados inseridos com sucesso!!!":"");
			state.close();
			conectado.fecharBancoDados();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
			conectado.fecharBancoDados();
			
		}
		
	}

public void logar(){
	TelaLoginFuncionario telaFunc = new TelaLoginFuncionario();
		conectado.conectar();
		String sql = "SELECT * FROM funcionario where login=? and senha=?";
		try {
		

			pst = conectado.connect.prepareStatement(sql);
			pst.setString(1,telaFunc.getTextLogin().getText());
			pst.setString(2, telaFunc.getTextSenha().getText());
			rs=pst.executeQuery();
			if(rs.next()){
				 TelaSistemaCentral telaCentral = new TelaSistemaCentral();
				 telaCentral.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "login ou senha incorretos");
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,e);
			System.out.println();
			conectado.fecharBancoDados();
			
			
			
		}
		
	}
}
