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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaConsulta extends JFrame implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTextoTeleMedi, lblTextoVacinacao, lblTextoMaraConsulta, lblTextoExames;
	JLabel lblSubTextoTeleMedi, lblSubTextoVacinacao, lblSubTextoMaraConsulta, lblSubTextoExames;
	JButton btnAtivarLembrete, btnWhatsapp, btnSms, btnVoltar, btnMarcar;
	JLabel lblAviso, lblTelefone, lblOk, lblConsulta;
	
	JTextField txtNomePaciente;
	
	String numeroPadrao = "551151998891";
	
	
	int distanciaLabel= 30, r=0, g=0, b=0;
	String textoBotao = "Ativar Lembrete", numero;
	
	

	
	
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
	
	public JLabel criarSubLabel3(JLabel lbl, String texto, int x, int y, int w, int h, int tamanhoFonte) {
		
		lbl.setText(texto);
		lbl.setBounds(x,y,w,h);
		lbl.setFont(new Font("Urbanist", Font.BOLD, tamanhoFonte));
		lbl.setForeground(new Color(110,245,0));
		
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
	
	public JButton criarBotao2(JButton btn, int x, int y, int w, int h, int tamanhoFonte) {
		
		btn.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		btn.setForeground(new Color(20,20,20));
		btn.setBackground(new Color(117, 117, 117));
		btn.setBounds(x, y, w, h);
		btn.setVisible(true);
		
		return btn;
	}
	// esse metodo não estou usando
	public JTextField criarTextField(JTextField txt, String texto, int x, int y, int w, int h, int tamanhoFonte) {
		txt = new JTextField(texto);
		txt.setBounds(x, y, w, h);
		return txt;
	}
	
	// Abrir link na web
	
	public void abrirLink(String numero) {
		try {
			URI link1 = new URI("https://api.whatsapp.com/send?phone="+numero+"&text=Ol%C3%A1,%20sua%20consulta%20est%C3%A1%20marcada.%0A%0AEm%2024%20horas%20antes%20da%20sua%20consulta%20te%20lembraremos.");
			Desktop.getDesktop().browse(link1);
		} catch (Exception e) {
			System.out.println("Deu o seguinte erro: "+e);
		}
	}
	
	
	//metodo que deixa apenas numeros de uma string
	public String deixarNumeros(String n) {
		 StringBuffer sb = new StringBuffer();

		    char [] caracteres = n.toCharArray();

		    for (Character caracter : caracteres) {
		        if (Character.isDigit(caracter)) {
		            sb.append(caracter);
		        }
		    }
		return sb.toString();
	}
	
	public TelaConsulta() {
		
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
		
		
		criarLabel(lblTextoVacinacao,"Marcar Consulta", 50, 50, 300, 100, 18);
		criarSubLabel(lblSubTextoVacinacao, "Buscar na rede credenciada", 50, getY()-distanciaLabel, 300, 100, 13);
		criarBotao(btnAtivarLembrete,300,100,150,50, 12);
		
		lblOk = new JLabel();
		criarSubLabel3(lblOk, "Lembrete enviado com sucesso.", 50, 150, 250, 50, 15);
		lblOk.setVisible(false); // deixa falso porém é criado
		
		lblConsulta = new JLabel();
		criarSubLabel3(lblConsulta, "Consulta Marcada com Sucesso !", 50, 250, 250, 50, 15);
		lblConsulta.setVisible(false); 
		
		//txtNomePaciente = new JTextField(); quando eu adiciono some alguns componentes da tela
		//criarTextField(txtNomePaciente, "Digite o nome do paciente:", 100, 100, 300, 50, 10);
		
		btnMarcar = new JButton("Marcar Consulta");
		criarBotao(btnMarcar,50,200,150,50, 12);
		btnMarcar.setBackground(new Color(153, 255, 153));
		
		
		btnVoltar = new JButton("VOLTAR PARA OPÇÕES");
		criarBotao2(btnVoltar, 180, 350, 250, 50, 15);
		
		// coloca ação no botão no evento actionListener
		btnAtivarLembrete.addActionListener(this); 
		btnWhatsapp.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnMarcar.addActionListener(this);
		
		
		add(lblSubTextoVacinacao);
		add(lblTextoVacinacao);
		add(btnAtivarLembrete);
		add(lblAviso);
		add(lblTelefone);
		add(btnWhatsapp);
		add(btnSms);
		add(lblOk);
		add(btnVoltar);
		add(btnMarcar);
		add(lblConsulta);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		// voltar para tela inicial
		
		if(e.getSource() == btnVoltar) {
			new TelaOpcoes();
			setVisible(false);
		}
		
		//set o botão for o whatsapp
		if(e.getSource() == btnWhatsapp) {
			JOptionPane.showMessageDialog(null, "Lembrete Ativado!! Vamos te direcionar para o whatsapp.");
			lblOk.setVisible(true);
			abrirLink(deixarNumeros(numero));
		}
		
		// digitar o numero
		
		if(e.getSource() == btnAtivarLembrete) {
			numero = JOptionPane.showInputDialog("Digite seu número de whatsapp no padrão (xx) 9yyyy-yyyy:");
			// validação para não por nada na tela se o valor for vazio
			
			if(numero!=null) {
				criarSubLabel(lblAviso, "Por onde deseja receber o lembrete?", getX()-80, getY(), 300, 100, 13);
				criarSubLabel2(lblTelefone, numero, getX()-20, getY()+20, 300, 100, 13);
				criarBotao(btnWhatsapp,300,getY()+90,50,50, 12);
				criarBotao(btnSms,400,getY()+90,50,50, 12);
			}
		}
		
		if(e.getSource() == btnMarcar) {
			String nomePaciente = JOptionPane.showInputDialog("Digite o nome do Paciente: ");
			String nomeMedico = JOptionPane.showInputDialog("Digite o nome do médico: ");
			String data = JOptionPane.showInputDialog("Digite a data da consulta: ");
			String horarioConsulta = JOptionPane.showInputDialog("Digite o Horario da Consulta");
			lblConsulta.setVisible(true);
			JOptionPane.showMessageDialog(null, "Consulta Marcada para: " + nomePaciente + "\n com o Médico: " + nomeMedico + "\n na data: " + data + "\n no horario: " + horarioConsulta + "\n Clique no ativar lembrete para te direcionar para o whatsapp.");
			abrirLink(deixarNumeros(numeroPadrao)); // numeroPadrao Da String
		}
		
		
		//evento padrão do botão
		
		
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
