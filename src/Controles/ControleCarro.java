package Controles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;

import ViewBuilder.Relatorio;
import ViewBuilder.TelaExcluir;
import ViewBuilder.TelaSistema;
import ConexaoBancoDados.ConexaoBD;
	
	
	public class ControleCarro {
		ControleDataeHora dataHora = new ControleDataeHora();
	
		public void InserirDadosCarro(String modelo,String placa,ControleDataeHora dataHora,String propietario,String tempo ){
			
			ConexaoBD conectado = new ConexaoBD();
			conectado.conectar();
			try{
				Connection conn = (Connection) conectado.conectar();
				Statement state = (Statement) conn.createStatement();
				String mySql = "INSERT INTO estacionamento.veiculo (modelo, placa,horaEntrada,dataEntrada,propietario,tempo) VALUES ('"+modelo+"','"+placa+"','"+dataHora.getHoraEntrada()+"','"+dataHora.getDataEntrada()+"','"+propietario+"','"+tempo+"')";
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
		public int  DeletarVeiculo(String placa){
			ConexaoBD conectado = new ConexaoBD();
				conectado.conectar();
			try{
			Connection conn = (Connection) conectado.conectar();
			Statement state = (Statement) conn.createStatement();
			String mySql = "DELETE FROM estacionamento.veiculo WHERE placa = '"+placa+"';";
			int res = state.executeUpdate(mySql);	
					if(res>0){
								
						JOptionPane.showMessageDialog(null,"Veículo removido com sucesso!!!");
					}else{
						JOptionPane.showMessageDialog(null,"Veículo não cadastrado!!!");
					}
			state.close();
			conectado.fecharBancoDados();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());				
			conectado.fecharBancoDados();
		}
			return (Integer) null;
	}
		
		public String Editar(int id,String modelo,String placa,ControleDataeHora dataHora,String propietario,String tempo){

			ConexaoBD conectado = new ConexaoBD();
			conectado.conectar();
			String mySql;
			try{

				mySql = "UPDATE veiculo set modelo = '"+modelo+"', placa = '"+placa+"', horaEntrada = '"+dataHora.getHoraEntrada()+"',dataEntrada ='"+dataHora.getDataEntrada()+"',propietario = '"+propietario+"', tempo = '"+tempo+"' where id = '"+id+"'";
				Connection conn =  conectado.conectar();
				Statement state =  conn.createStatement();
				int res = state.executeUpdate(mySql);	
				if(res>0){
							
					JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso!!!");
					
				}else{
					JOptionPane.showMessageDialog(null,"Os dados não poderam ser atualizados devido a um erro interno!!!");
					System.out.println(id);
				}
				
				state.close();
				conectado.fecharBancoDados();
			}catch(Exception e){
				e.getStackTrace();
				
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				System.out.println(id);
				conectado.fecharBancoDados();
				
			}
			return modelo;
			
			
		}
	

	
}
	

	
	



