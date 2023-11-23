package br.com.fiap.beans;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaOpcoes extends JFrame implements KeyListener, ActionListener{
	
	
	private JButton btnVacinacao, btn2, btn3, btnSair;
	
	public JButton criarBotao(JButton btn, int x, int y, int w, int h, int tamanhoFonte) {
		
		btn.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		btn.setForeground(new Color(20,20,20));
		btn.setBackground(new Color(205, 170, 100));
		btn.setBounds(x, y, w, h);
		btn.setVisible(true);
		
		return btn;
	}
	
	public JButton criarBotao2(JButton btn, int x, int y, int w, int h, int tamanhoFonte) {
		
		btn.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		btn.setForeground(new Color(255,255,255));
		btn.setBackground(new Color(245, 66, 66));
		btn.setBounds(x, y, w, h);
		btn.setVisible(true);
		
		return btn;
	}
	
	
	public TelaOpcoes() {
		setTitle("Login - Sistema de SMS");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		btnVacinacao = new JButton("Vacinacao");	
		criarBotao(btnVacinacao, 30, 150, 130, 130, 15);
		
		btn2 = new JButton("BTN2");
		criarBotao(btn2, 180, 150, 130, 130, 15);
		
		btn3 = new JButton("BTN3");
		criarBotao(btn3, 330, 150, 130, 130, 15);
		
		
		btnSair = new JButton("SAIR");
		criarBotao2(btnSair, 160, 370, 150, 50, 15);
		
		btnVacinacao.addActionListener(this); 
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btnSair.addActionListener(this);
		
		add(btnVacinacao);
		add(btn2);
		add(btn3);
		add(btnSair);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnVacinacao) {
			new TelaVacinacao();
			setVisible(false);
		}
		
		if(e.getSource() == btnSair) {
			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}