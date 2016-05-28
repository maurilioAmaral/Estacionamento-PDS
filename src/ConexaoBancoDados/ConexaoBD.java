package ConexaoBancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;






public class ConexaoBD {
	
	 public Connection connect;
	 public ResultSet res;
	 public Statement state;

	
	public Connection conectar(){
	
		
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/estacionamento";
		connect = DriverManager.getConnection(url,"root","maurobatista");
		System.out.println("Conexão com o banco de dados efetuada");
		state = connect.createStatement();
		return connect;
		
		
	}
	catch(Exception e){
		System.out.println("Não foi possível se conectar ao banco de dados ");
		e.printStackTrace();
		return null;	
	}
	
	}
	public void fecharBancoDados(){
		try{
			connect.close();
			System.out.println("banco fechado com sucesso!!!");
		}
		catch(Exception e){
			System.out.println("erro ao fechar o banco "+ e.getMessage());
			
		}
	}
	
	
	
	
	

}