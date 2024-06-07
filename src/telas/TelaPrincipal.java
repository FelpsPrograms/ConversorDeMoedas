package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pesquisa.PesquisaJsonParser;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private JTable tbConversao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\conversor_icone.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Conversor de Moedas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 10, 416, 13);
		contentPane.add(lblTitulo);
		
		JComboBox<String> listaMoedaBase = new JComboBox<>();
		listaMoedaBase.setBounds(10, 50, 150, 21);
		contentPane.add(listaMoedaBase);
		
		JLabel lblConverterPara = new JLabel("converter para");
		lblConverterPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblConverterPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConverterPara.setBounds(170, 54, 96, 13);
		contentPane.add(lblConverterPara);
		
		JComboBox<String> listaMoedaAlvo = new JComboBox<>();
		listaMoedaAlvo.setBounds(276, 50, 150, 21);
		contentPane.add(listaMoedaAlvo);
		
		tbConversao = new JTable();
		tbConversao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		tbConversao.setBounds(10, 140, 416, 60);
		contentPane.add(tbConversao);
		
		txtValor = new JTextField();
		txtValor.setBounds(225, 77, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaJsonParser pesquisa = new PesquisaJsonParser();
				pesquisa.jsonParserConverter("BRL", "IDR", 100000);
				DefaultTableModel modelo = (DefaultTableModel) tbConversao.getModel();
				//modelo.addRow();
			}
		});
		btnConverter.setBounds(170, 103, 97, 21);
		contentPane.add(btnConverter);
		
		JLabel lblValor = new JLabel("Valor a converter:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValor.setBounds(10, 80, 205, 13);
		contentPane.add(lblValor);
	}
}
