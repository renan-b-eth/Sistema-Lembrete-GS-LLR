package br.com.fiap.beans;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener, KeyListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginPadrao = "admin", senhaPadrao = "admin";
	private JTextField txtLogin, lblSenha;
	private JButton lblEntrar;
	//private ImageIcon imagem = new ImageIcon(getClass().getResource("..//Imagens//logohap.png"));
	private Image imagem;
	
	public void load() {
		
		//ImageIcon objImageIcon = new ImageIcon("Imagens//logohap.png");
		//imagem = objImageIcon.getImage();
		
		
	}
	
	


	

	private JLabel lblLogo = new JLabel();
	
	public TelaLogin() {
		
		setTitle("Login - Sistema de SMS");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setText("Digite seu email:");
		txtLogin.setBounds(100, 100, 300, 50);
		
		lblSenha = new JTextField();
		lblSenha.setText("Digite sua senha:");
		lblSenha.setBounds(100, 170, 300, 50);
		lblSenha.setVisible(true);
		
		lblEntrar = new JButton("Entrar");
		lblEntrar.setBounds(190, 250, 100, 50);
		lblEntrar.setVisible(true);
		
		lblEntrar.addActionListener(this); // coloca ação no botão no evento actionListener
		lblEntrar.setFont(new Font("Arial", Font.BOLD, 20));
		lblEntrar.setForeground(new Color(20,20,20));
		lblEntrar.setBackground(new Color(205, 170, 100));
		
		//lblLogo.setVisible(true);
		//lblLogo.setBounds(0,10,205,170);
		
		//A ação do evento listener fica no construtor
		
		addKeyListener(this);
		
		
		
		//Adiciona os icones na tela
		add(lblSenha);
		add(txtLogin);
		//add(lblLogo);
		//add(imagem);
		add(lblEntrar);
		validate();
		
	}
	
	public void abrirTela() {
		//abrir a tela
		new TelaOpcoes();		
	}
	
	//validarLogin
	public TelaVacinacao validarLogin(String e, String s) {
		if(loginPadrao.equals(txtLogin.getText()) && senhaPadrao.equals(lblSenha.getText())) {
			abrirTela();
			setVisible(false);
		} else if(loginPadrao.isEmpty() && senhaPadrao.isEmpty()){
			JOptionPane.showMessageDialog(null, "Campos vazios, por favor preencha-os", "SistemaSMS", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Login errado, Faça-o novamente.", "SistemaSMS", JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		validarLogin(txtLogin.getText(), lblSenha.getText());
	}
	
	

	
	private void KeyListener() {
		// TODO Auto-generated method stub

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
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			validarLogin(txtLogin.getText(), lblSenha.getText());
        }
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
        }
	}

}
