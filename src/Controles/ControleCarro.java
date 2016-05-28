package Controles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import View.TelaBuscaVeiculos;
import View.TelaSistemaCentral;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import ConexaoBancoDados.ConexaoBD;
	
	
	public class ControleCarro {
		ControleDataeHora dataHora = new ControleDataeHora();		
		public void InserirDadosCarro(String modelo,String placa,ControleDataeHora dataHora){
			
			ConexaoBD conectado = new ConexaoBD();
			conectado.conectar();
			try{
				Connection conn = (Connection) conectado.conectar();
				Statement state = (Statement) conn.createStatement();
				String mySql = "INSERT INTO estacionamento.veiculo (modelo, placa,horaEntrada,dataEntrada) VALUES ('"+modelo+"','"+placa+"','"+dataHora.getHoraEntrada()+"','"+dataHora.getDataEntrada()+"')";
				System.out.println(mySql);
				boolean res = state.execute(mySql);
				JOptionPane.showMessageDialog(null,(!res)?"Veículo inserido com sucesso!!!":"");
				state.close();
				conectado.fecharBancoDados();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e.getMessage());				
				conectado.fecharBancoDados();
				
			}
			
		}
		public String  DeletarVeiculo(String placa){
			ConexaoBD conectado = new ConexaoBD();
			conectado.conectar();
			try{
			Connection conn = (Connection) conectado.conectar();
			Statement state = (Statement) conn.createStatement();
			String mySql = "DELETE FROM estacionamento.veiculo WHERE placa = '"+placa+"';";
			boolean res = state.execute(mySql);
			JOptionPane.showMessageDialog(null,(!res)?"Veículo removido com sucesso!!!":"");
			state.close();
			conectado.fecharBancoDados();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());				
			conectado.fecharBancoDados();
		}
			return placa;
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
				 while(rs.next()){
					 
					 System.out.println("MODELO: "+rs.getString("modelo")+" PLACA: "+rs.getString("placa")+" HORA DE ENTRADA :"+rs.getString("horaEntrada")+" DATA DA ENTRADA: "+rs.getString("dataEntrada"));
					 
					 
				 }
				 
				 
			 
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
	
}
	

	
	



