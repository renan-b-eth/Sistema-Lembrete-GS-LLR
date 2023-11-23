package br.com.fiap.beans;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTextoTeleMedi, lblTextoVacinacao, lblTextoMaraConsulta, lblTextoExames;
	JLabel lblSubTextoTeleMedi, lblSubTextoVacinacao, lblSubTextoMaraConsulta, lblSubTextoExames;
	JButton btnAtivarLembrete;
	
	int distanciaLabel= 30, r=0, g=0, b=0;
	String textoBotao = "Ativar Lembrete";
	
	// metodo criar as label
	
	public JLabel criarLabel(JLabel lbl, String texto, int x, int y, int w, int h, int tamanhoFonte) {
		
		lbl.setText(texto);
		lbl.setBounds(x,y,w,h);
		lbl.setFont(new Font("Urbanist", Font.BOLD, tamanhoFonte));
		
		return lbl;
	}
	
	public JLabel criarSubLabel(JLabel lbl, String texto, int x, int y, int w, int h, int tamanhoFonte) {
		
		lbl.setText(texto);
		lbl.setBounds(x,y,w,h);
		lbl.setFont(new Font("Urbanist", Font.PLAIN, tamanhoFonte));
		
		return lbl;
	}
	
	public JButton criarBotao(JButton btn, int x, int y, int w, int h, int tamanhoFonte) {
		
		btn.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		btn.setForeground(new Color(20,20,20));
		btn.setBackground(new Color(32, 198, 122));
		btn.setBounds(x, y, w, h);
		btn.setVisible(true);
		
		return btn;
	}
	
	
	
	
	public TelaPrincipal() {
		
		setTitle("Sistema de SMS");
		setSize(650,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//instanciando as label
		lblTextoVacinacao = new JLabel();
		lblSubTextoVacinacao = new JLabel();
		btnAtivarLembrete = new JButton(textoBotao);
		
		criarLabel(lblTextoVacinacao,"CARTEIRA DE VACINAÇÃO", 50, 50, 300, 100, 18);
		criarSubLabel(lblSubTextoVacinacao, "Vacinas Aplicada", 50, getY()-distanciaLabel, 300, 100, 13);
		criarBotao(btnAtivarLembrete,300,100,150,50, 12);
		
		
		// coloca ação no botão no evento actionListener
		btnAtivarLembrete.addActionListener(this); 
		
		
		
		add(lblSubTextoVacinacao);
		add(lblTextoVacinacao);
		add(btnAtivarLembrete);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
