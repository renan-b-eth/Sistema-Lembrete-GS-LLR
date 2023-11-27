package br.com.fiap.beans;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaSolicitarExame extends JFrame implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTextoTeleMedi, lblTextoVacinacao, lblTextoMaraConsulta, lblTextoExames;
	JLabel lblSubTextoTeleMedi, lblSubTextoVacinacao, lblSubTextoMaraConsulta, lblSubTextoExames;
	JButton btnAtivarLembrete, btnWhatsapp, btnSms, btnVoltar, btnMarcar,btnOk2, btnOk3;
	JLabel lblAviso, lblTelefone, lblOk, lblConsulta;
	JOptionPane job;
	JDialog diag, diag2;
	
	JTextField txtNomePaciente;
	
	
	String numeroPadrao = "551151998891", protocoloPadrao= "001545677";
	String[] medico = {"Joao", "Joaquim", "Juarez"};
	String[] paciente = {"Maria", "Joaquina", "Renata"};
	
	
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
	
	public void criarComboBox() {

        
        @SuppressWarnings("unchecked")
		JComboBox jcd = new JComboBox(medico);
        btnOk2 = new JButton("Escolher paciente do médico: ");
        
        
        jcd.setEditable(true);

        //Criar o JOptionPane
        Object[] options = new Object[] {};
        Container jop = new JOptionPane("Selecione O Médico",
                                        JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.DEFAULT_OPTION,
                                        null,options, null);

        //add combos no JOptionPane
        jop.add(jcd);
        jop.add(btnOk2);


        //Criar o jdialog e add no joptionpane
        diag = new JDialog();
        diag.getContentPane().add(jop);

        diag.pack();
        diag.setVisible(true);
        
        //evento no botao solicitar protocolo
        btnOk2.addActionListener(this);
    }
	
	public void criarComboBoxPaciente() {

        
        @SuppressWarnings("unchecked")
		JComboBox jcd = new JComboBox(paciente);
        btnOk3 = new JButton("Solicitar Protocolo");
        
        
        jcd.setEditable(true);

        //Criar o JOptionPane
        Object[] options = new Object[] {};
        Container jop = new JOptionPane("Paciente",
                                        JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.DEFAULT_OPTION,
                                        null,options, null);

        //add combos no JOptionPane
        jop.add(jcd);
        jop.add(btnOk3);


        //Criar o jdialog e add no joptionpane
        diag2 = new JDialog();
        diag2.getContentPane().add(jop);

        diag2.pack();
        diag2.setVisible(true);
        
        //evento no botao solicitar protocolo
        btnOk3.addActionListener(this);
    }
	
	public TelaSolicitarExame() {
		
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
		
		
		criarLabel(lblTextoVacinacao,"Solicitar Exames", 50, 50, 300, 100, 18);
		criarSubLabel(lblSubTextoVacinacao, "Protocolo de agendamento", 50, getY()-distanciaLabel, 300, 100, 13);
		criarBotao(btnAtivarLembrete,300,100,150,50, 12);
		
		lblOk = new JLabel();
		criarSubLabel3(lblOk, "Lembrete enviado com sucesso.", 50, 150, 250, 50, 15);
		lblOk.setVisible(false); // deixa falso porém é criado
		
		lblConsulta = new JLabel();
		criarSubLabel3(lblConsulta, "Consulta Marcada com Sucesso !", 50, 250, 250, 50, 15);
		lblConsulta.setVisible(false); 
		
		//txtNomePaciente = new JTextField(); quando eu adiciono some alguns componentes da tela
		//criarTextField(txtNomePaciente, "Digite o nome do paciente:", 100, 100, 300, 50, 10);
		
		btnMarcar = new JButton("Solicitar Exame");
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
			criarComboBox();
			
		}
		if(e.getSource() == btnOk2) {
			criarComboBoxPaciente();
			diag.setVisible(false);
		}
		//solicitar protocolo
		if(e.getSource() == btnOk3) {
			diag.setVisible(false); // deixa o joption panel falso
			diag2.setVisible(false);
			String nomeMedico = medico[0]; // aqui deixa o medico padrão porque não consegui pegar o index pra mudar no 0
			JOptionPane.showMessageDialog(null, "Exame Solicitado: " + "\n com o Médico: " + nomeMedico + "\n Protocolo: " + protocoloPadrao + "\n Clique no ativar lembrete para te direcionar para o whatsapp.");
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
