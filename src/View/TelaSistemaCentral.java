package View;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controles.ControleCarro;

public class TelaSistemaCentral extends JFrame implements ActionListener{
	
	ControleCarro carro = new ControleCarro();

	JButton entradaCarro;
	JButton saidaCarro;
	JButton listagemCarro;
	JButton botaoBuscar;
	JButton botaosair;
	JLabel labelEntradaVeiculos;
	JLabel labelListagemVeiculos;
	JLabel labelRemoverVeiculos; 
	
	
	
	public TelaSistemaCentral(){
		tela();
		botoes();
		eventos();
		
	}
	public void tela(){
		setLayout(new GridLayout(4,2));
		setSize(450,250);
		setVisible(true);
		setLocationRelativeTo(null);
		
				
	}
	public void botoes(){
		entradaCarro = new JButton("Entrada");
		saidaCarro = new JButton("Remoção");
		listagemCarro = new JButton("Listagem");
		botaoBuscar = new JButton("Buscar");
		botaosair = new JButton("Sair");
		labelEntradaVeiculos = new JLabel("Entrada de Veículos");
		labelRemoverVeiculos = new JLabel("Saída de Veículos");
		labelListagemVeiculos = new JLabel("Listagem de Veículos");
		add(labelEntradaVeiculos);
		add(entradaCarro);
		add(labelRemoverVeiculos);
		add(saidaCarro);
		add(labelListagemVeiculos);
		add(listagemCarro);
		add(botaosair);
		add(botaoBuscar);
				
	}
		
	public void eventos(){
		entradaCarro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == entradaCarro){
					new TelaEntradaVeiculos();
				}
			}
		});
		
		botaosair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botaosair){
				System.exit(0);				
			}
				
			}
		});
		saidaCarro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == saidaCarro){
				String placa = JOptionPane.showInputDialog(null,"Digite a placa do  veiculo");
				carro.DeletarVeiculo(placa);
			}
				
			}
		});
		listagemCarro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == listagemCarro){
//				carro.listar();
				
				
			}
				
			}
		});
		botaoBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoBuscar);
				TelaBuscaVeiculos telabusca = new TelaBuscaVeiculos();
				
				
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
	public JButton getEntradaCarro() {
		return entradaCarro;
	}
	public void setEntradaCarro(JButton entradaCarro) {
		this.entradaCarro = entradaCarro;
	}
	public JButton getSaidaCarro() {
		return saidaCarro;
	}
	public void setSaidaCarro(JButton saidaCarro) {
		this.saidaCarro = saidaCarro;
	}
	public JButton getListagemCarro() {
		return listagemCarro;
	}
	public void setListagemCarro(JButton listagemCarro) {
		this.listagemCarro = listagemCarro;
	}

}
