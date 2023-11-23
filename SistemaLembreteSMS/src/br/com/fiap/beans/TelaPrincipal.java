package br.com.fiap.beans;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTextoTeleMedi, lblTextoVacinacao, lblTextoMaraConsulta, lblTextoExames;
	JLabel lblSubTextoTeleMedi, lblSubTextoVacinacao, lblSubTextoMaraConsulta, lblSubTextoExames;
	JButton btnAtivarLembrete, btnWhatsapp, btnSms;
	JLabel lblAviso, lblTelefone;
	
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
	
	public JLabel criarSubLabel2(JLabel lbl, String texto, int x, int y, int w, int h, int tamanhoFonte) {
		
		lbl.setText(texto);
		lbl.setBounds(x,y,w,h);
		lbl.setFont(new Font("Urbanist", Font.BOLD, tamanhoFonte));
		
		return lbl;
	}
	
	public JButton criarBotao(JButton btn, int x, int y, int w, int h, int tamanhoFonte) {
		
		btn.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		btn.setForeground(new Color(20,20,20));
		btn.setBackground(new Color(205, 170, 100));
		btn.setBounds(x, y, w, h);
		btn.setVisible(true);
		
		return btn;
	}
	
	// Abrir link na web
	
	public void abrirLink() {
		try {
			URI link1 = new URI("www.wa.me/55");
			Desktop.getDesktop().browse(link1);
		} catch (Exception e) {
			System.out.println("Deu o seguinte erro: "+e);
		}
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
		lblAviso = new JLabel();
		lblTelefone = new JLabel();

		// instanciando os botoes
		btnAtivarLembrete = new JButton(textoBotao);
		btnWhatsapp = new JButton();
		btnSms = new JButton();
		
		
		criarLabel(lblTextoVacinacao,"CARTEIRA DE VACINAÇÃO", 50, 50, 300, 100, 18);
		criarSubLabel(lblSubTextoVacinacao, "Vacinas Aplicada", 50, getY()-distanciaLabel, 300, 100, 13);
		criarBotao(btnAtivarLembrete,300,100,150,50, 12);
		
		
		// coloca ação no botão no evento actionListener
		btnAtivarLembrete.addActionListener(this); 
		
		
		
		add(lblSubTextoVacinacao);
		add(lblTextoVacinacao);
		add(btnAtivarLembrete);
		add(lblAviso);
		add(lblTelefone);
		add(btnWhatsapp);
		add(btnSms);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		criarSubLabel(lblAviso, "Por onde deseja receber o lembrete?", getX()-80, getY(), 300, 100, 13);
		criarSubLabel2(lblTelefone, "(11) 9999-9999", getX()-20, getY()+20, 300, 100, 13);
		criarBotao(btnWhatsapp,300,getY()+90,50,50, 12);
		criarBotao(btnSms,400,getY()+90,50,50, 12);
		abrirLink();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
