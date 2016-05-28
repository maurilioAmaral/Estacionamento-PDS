package View;

import java.awt.Component;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import ConexaoBancoDados.ConexaoBD;
import Controles.ControleCarro;
import Controles.ControleDataeHora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEntradaVeiculos extends JFrame implements ActionListener{
	
	private static final LayoutManager FlowLayout = null;
	ConexaoBD conexao = new ConexaoBD();
	ControleCarro carroControl = new ControleCarro();
	ControleDataeHora dataHora = new ControleDataeHora();
	
	JLabel labelModelo;
	JTextField textModelo;
	JLabel labelPlaca;
	JTextField textPlaca;
	JLabel labelHoraEntrada;
	JTextField textHoraEntrada;
	
		
	
	
	JLabel labelData;
	JTextField textData;
	JButton botaocadastrar;	
	JButton botaosair;
	
	
	public TelaEntradaVeiculos(){
		
		ajusteTela();
		botoes();
		eventos();
		conexao.conectar();
		
	}
	public void ajusteTela(){
		
		setSize(450,200);
		setVisible(true);
		setResizable(false);		
		setLayout(new GridLayout(5,2));		
		setTitle("Cadastro de veiculos");
		setLocationRelativeTo(null);
				
	}
	public void botoes(){
		
		labelModelo = new JLabel("Modelo");
		textModelo = new JTextField(12);
		labelPlaca = new JLabel("Placa");
		textPlaca = new JTextField(12);	
		textHoraEntrada = new JTextField(12);
		labelHoraEntrada = new JLabel("Hora de Entrada");		
		labelData = new JLabel("Data");
		textData = new JTextField(12);	
		botaocadastrar = new JButton("Cadastrar");	
		botaosair = new JButton("sair");
		
		add(labelModelo);
		add(textModelo);
		add(labelPlaca);
		add(textPlaca);
		add(labelHoraEntrada);
		add(textHoraEntrada);	
		add(labelData);
		add(textData);	
		add(botaocadastrar);
		add(botaosair);	
		
		textHoraEntrada.setEnabled(false);
		textData.setEnabled(false);
		textHoraEntrada.setText(dataHora.getHoraEntrada());
		textData.setText(dataHora.getDataEntrada());

	}
		public void eventos(){
			
				
			botaosair.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					if(e.getSource() == botaosair){
						dispose();
						
					}
				}
			});
			botaocadastrar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				
		if(e.getSource() == botaocadastrar){
			String modelo = textModelo.getText();
			String placa = textPlaca.getText();	
			carroControl.InserirDadosCarro(modelo, placa, dataHora);
//			carroControl.InserirDadosCarro(modelo, placa,dataHora);			
			textModelo.setText("");					
			textPlaca.setText("");		
			
		

				}		
			}
	
			});
			
		}
	
	public JLabel getLabelnome() {
		return labelModelo;
	}
	public void setLabelnome(JLabel labelnome) {
		this.labelModelo = labelnome;
	}

	public JTextField getTextnome() {
		return textModelo;
	}
	public void setTextnome(JTextField textnome) {
		this.textModelo = textnome;
	}
	
	public JButton getBotaocadastrar() {
		return botaocadastrar;
	}
	public void setBotaocadastrar(JButton botaocadastrar) {
		this.botaocadastrar = botaocadastrar;
	}
	
	public JButton getBotaosair() {
		return botaosair;
	}
	public void setBotaosair(JButton botaosair) {
		this.botaosair = botaosair;
	}
	public JLabel getLabelPlaca() {
		return labelPlaca;
	}
	public void setLabelPlaca(JLabel labelPlaca) {
		this.labelPlaca = labelPlaca;
	}
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	public JLabel getLabelModelo() {
		return labelModelo;
	}
	public void setLabelModelo(JLabel labelModelo) {
		this.labelModelo = labelModelo;
	}
	public JLabel getLabelHoraEntrada() {
		return labelHoraEntrada;
	}
	public void setLabelHoraEntrada(JLabel labelHoraEntrada) {
		this.labelHoraEntrada = labelHoraEntrada;
	}
	public JTextField getTextPlaca() {
		return textPlaca;
	}
	public void setTextPlaca(JTextField textPlaca) {
		this.textPlaca = textPlaca;
	}
	public JTextField getTextModelo() {
		return textModelo;
	}
	public void setTextModelo(JTextField textModelo) {
		this.textModelo = textModelo;
	}
	public JTextField getTextHodaEntrada() {
		return textHoraEntrada;
	}
	public void setTextHodaEntrada(JTextField textHodaEntrada) {
		this.textHoraEntrada = textHodaEntrada;
	}
	
	public JLabel getLabelData() {
		return labelData;
	}
	public void setLabelData(JLabel labelData) {
		this.labelData = labelData;
	}
	public JTextField getTextData() {
		return textData;
	}
	public void setTextData(JTextField textData) {
		this.textData = textData;
	}

}
