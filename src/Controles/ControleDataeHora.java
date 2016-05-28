package Controles;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ControleDataeHora {
	
	  Date data = new Date();		 
	  SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	  SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm");
	  String dataEntrada =  dataFormatada.format(data);		  
	  String horaEntrada= horaFormatada.format(data);
	 
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
}