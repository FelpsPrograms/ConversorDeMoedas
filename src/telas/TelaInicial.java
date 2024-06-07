package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\idioma_icone.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbSelecionarIdioma = new JLabel("Select the language:");
		lbSelecionarIdioma.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSelecionarIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		lbSelecionarIdioma.setBounds(10, 10, 426, 30);
		contentPane.add(lbSelecionarIdioma);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\selecionar_icone.png"));
		lblImagem.setBounds(225, 46, 100, 100);
		contentPane.add(lblImagem);
		
		JRadioButton rdbtnIngles = new JRadioButton("English");
		rdbtnIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnIngles.setBounds(60, 46, 103, 21);
		contentPane.add(rdbtnIngles);
		rdbtnIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    lblImagem.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\ingles_icone.png" ));
			}
		});
		
		JRadioButton rdbtnPortugues = new JRadioButton("Português");
		rdbtnPortugues.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPortugues.setBounds(60, 69, 103, 21);
		contentPane.add(rdbtnPortugues);
		rdbtnPortugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    lblImagem.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\portugues_icone.png" ));
			}
		});
		
		JRadioButton rdbtnIndonesio = new JRadioButton("Bahasa Indonesia");
		rdbtnIndonesio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnIndonesio.setBounds(60, 92, 132, 21);
		contentPane.add(rdbtnIndonesio);
		rdbtnIndonesio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    lblImagem.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\indonesio_icone.png" ));
			}
		});
		
		ButtonGroup grupoBotoes = new ButtonGroup();
		grupoBotoes.add(rdbtnIngles);
		grupoBotoes.add(rdbtnPortugues);
		grupoBotoes.add(rdbtnIndonesio);
		
		JButton btnSelecionar = new JButton("Confirm");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grupoBotoes.getSelection().equals(rdbtnIngles.getModel())) {
					MainScreen mainScreen = new MainScreen();
					mainScreen.setVisible(true);
					dispose();
				} else if (grupoBotoes.getSelection().equals(rdbtnPortugues.getModel())) {
					TelaPrincipal telaPrincipal = new TelaPrincipal();
					telaPrincipal.setVisible(true);
					dispose();
				} else if (grupoBotoes.getSelection().equals(rdbtnIndonesio.getModel())) {
					LayarUtama layarUtama = new LayarUtama();
					layarUtama.setVisible(true);
					dispose();
				}
			}
		});
		btnSelecionar.setBounds(60, 119, 85, 21);
		contentPane.add(btnSelecionar);
	}
}
