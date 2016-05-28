package View;


import java.awt.Button;


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


public class TelaBuscaVeiculos extends JFrame implements ActionListener{
	
	ControleCarro carro = new ControleCarro();
	

	JLabel labelPlaca;
	JLabel labelPlaca2;
	JLabel labelModelo;
	JLabel labelHoraEntrada;
	JTextField textPlaca;
	JTextField texPlaca2;
	JTextField textModelo;
	JTextField textHora;
	JButton botaocancelar;
	JButton botaoBuscar;
	
	public TelaBuscaVeiculos(){
		ajusteTelaCadastro();
		adicionarBotoes();
		eventos();
	}
	public void ajusteTelaCadastro(){
		setSize(500,200);
	    setVisible(true);		
		setTitle("busca de veículo");
		setLayout(new GridLayout(5,2));
		setLocationRelativeTo(null);
		
	}
	public void adicionarBotoes(){
		labelPlaca = new JLabel("Digite a placa que deseja buscar");
		labelModelo =  new JLabel("Modelo");
		labelPlaca2 = new JLabel("Placa");
		labelHoraEntrada = new JLabel("Hora de entrada");
		textPlaca = new JTextField(15);			
		texPlaca2 = new JTextField(15);	
		textHora = new JTextField(15);
		textModelo = new JTextField(15);
//		textPropietario = new JTextField(15);
		botaocancelar = new JButton("cancelar");
		botaoBuscar = new JButton("buscar");
		add(labelPlaca);
		add(textPlaca);
		add(labelPlaca2);		
		add(texPlaca2);
		add(labelModelo);
		add(textModelo);
		add(labelHoraEntrada);
		add(textHora);
		add(botaocancelar);
		add(botaoBuscar);
				
	}
	public void eventos(){
		
		
		
		
						
		botaocancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botaocancelar);
		    dispose();
				
			}
		});
		botaoBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == botaoBuscar);
				pesquisar();
				
			}
		});
		
	}


	public JLabel getLabelnome() {
		return labelPlaca;
	}
	public void setLabelnome(JLabel labelnome) {
		this.labelPlaca = labelnome;
	}
	public JLabel getLabelrg() {
		return labelPlaca2;
	}
	public void setLabelrg(JLabel labelrg) {
		this.labelPlaca2 = labelrg;
	}
	public JTextField getTextnome() {
		return textPlaca;
	}
	public void setTextnome(JTextField textnome) {
		this.textPlaca = textnome;
	}
	public JTextField getTextrg() {
		return texPlaca2;
	}
	public void setTextrg(JTextField textrg) {
		this.texPlaca2 = textrg;
	}
	public JButton getBotaosalvar() {
		return botaoBuscar;
	}
	public void setBotaosalvar(JButton botaosalvar) {
		this.botaoBuscar = botaosalvar;
	}
	public JButton getBotaocancelar() {
		return botaocancelar;
	}
	public void setBotaocancelar(JButton botaocancelar) {
		this.botaocancelar = botaocancelar;
	}
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public JTextField getTextPlaca() {
		return textPlaca;
	}
	public void setTextPlaca(JTextField textPlaca) {
		this.textPlaca = textPlaca;
	}
	public void pesquisar(){		
		 ConexaoBD conectado = new ConexaoBD();
		 conectado.conectar();
		 PreparedStatement pst = null;
		 ResultSet rs=null;
		
		
		try {
			String sql = "select * from veiculo where placa=?";
			pst = conectado.connect.prepareStatement(sql);
			pst.setString(1,textPlaca.getText());
			rs=pst.executeQuery();
			
			if(rs.next()){
				textPlaca.setText("");
				texPlaca2.setText(rs.getString("placa"));
				textModelo.setText(rs.getString("modelo"));
				textHora.setText(rs.getString("horaEntrada"));
				
				
			
			}
			else{
				
				JOptionPane.showMessageDialog(null, "veículo não cadastrado ou placa incorreta");
				textPlaca.setText("");
				
				
			}
			
		} catch (Exception e) {
		
			
			JOptionPane.showMessageDialog(null,"erro no banco de dados");
			System.out.println();
			conectado.fecharBancoDados();				
			e.printStackTrace();
			
		}
		
	}
	

}
