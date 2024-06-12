package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonSyntaxException;

import classes.Cotacao;
import classes.Moeda;
import classes.ValorConvertido;
import pesquisa.PesquisaJsonParser;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private JTable tbConversao;
	private JTable tbCotacao;
	private PesquisaJsonParser pesquisa = new PesquisaJsonParser();

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\conversor_icone.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Conversor de Moedas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 10, 416, 13);
		contentPane.add(lblTitulo);
		
		ArrayList<Moeda> moedas = pesquisa.buscarMoedas();
		
		JComboBox<Moeda> listaMoedaBase = new JComboBox<>();
		listaMoedaBase.setBounds(10, 50, 150, 21);
		contentPane.add(listaMoedaBase);
		
		for (Moeda moeda : moedas) {
			listaMoedaBase.addItem(moeda);
		}
		
		JLabel lblConverterPara = new JLabel("converter para");
		lblConverterPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblConverterPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConverterPara.setBounds(170, 54, 96, 13);
		contentPane.add(lblConverterPara);
		
		JComboBox<Moeda> listaMoedaAlvo = new JComboBox<>();
		listaMoedaAlvo.setBounds(276, 50, 150, 21);
		contentPane.add(listaMoedaAlvo);
		
		for (Moeda moeda : moedas) {
			listaMoedaAlvo.addItem(moeda);
		}
		
		tbConversao = new JTable();
		tbConversao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		tbConversao.setBounds(10, 140, 416, 50);
		contentPane.add(tbConversao);
		
		txtValor = new JTextField();
		txtValor.setBounds(225, 77, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Moeda moedaBaseSelecionada = (Moeda) listaMoedaBase.getSelectedItem();
					Moeda moedaAlvoSelecionada = (Moeda) listaMoedaAlvo.getSelectedItem();
					
					Double valor = Double.parseDouble(txtValor.getText());
					ValorConvertido valorConvertido = pesquisa.converter(moedaBaseSelecionada.abreviacao(), moedaAlvoSelecionada.abreviacao(), valor);
					DefaultTableModel modelo = (DefaultTableModel) tbConversao.getModel();
					modelo.addRow(new Object[] {valorConvertido.baseCode(), valorConvertido.targetCode()});
					modelo.addRow(new Object[] {1, valorConvertido.conversionRate()});
					modelo.addRow(new Object[] {valor, valorConvertido.conversionResult()});
					tbConversao.setModel(modelo);
				} catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Campo \"Valor a converter\" deve ser um número decimal.", "Erro!", 2);
				} catch (JsonSyntaxException error) {
					JOptionPane.showMessageDialog(null, "Valor a ser convertido é muito extenso.", "Erro!", 2);
				}
			}
		});
		btnConverter.setBounds(170, 103, 100, 21);
		contentPane.add(btnConverter);
		
		JLabel lblValor = new JLabel("Valor a converter::");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValor.setBounds(10, 80, 205, 13);
		contentPane.add(lblValor);
		
		JLabel lblTbCotacao = new JLabel("Cotação das moedas baseada no dólar americano");
		lblTbCotacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblTbCotacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTbCotacao.setBounds(10, 230, 416, 21);
		contentPane.add(lblTbCotacao);
		
		tbCotacao = new JTable();
		tbCotacao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Moeda", "Cotação"
			}
		));
		tbCotacao.setBounds(10, 261, 416, 100);
		contentPane.add(tbCotacao);
		
		JScrollPane scrollPane = new JScrollPane(tbCotacao);
		scrollPane.setBounds(10, 261, 416, 100);
		contentPane.add(scrollPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 382, 100, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblIconeVoltar = new JLabel("");
		lblIconeVoltar.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\voltar_icone.png"));
		lblIconeVoltar.setBounds(120, 382, 21, 21);
		contentPane.add(lblIconeVoltar);
		
		/** Deixando os comboBox em branco quando inicializado */
		listaMoedaBase.setSelectedIndex(-1);
		listaMoedaAlvo.setSelectedIndex(-1);
		
		JLabel lblImagem1 = new JLabel("");
		lblImagem1.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\icone1.png"));
		lblImagem1.setBounds(10, 180, 71, 71);
		contentPane.add(lblImagem1);
		
		JLabel lblImagem2 = new JLabel("");
		lblImagem2.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\icone2.png"));
		lblImagem2.setBounds(30, 25, 100, 100);
		contentPane.add(lblImagem2);
		
		JLabel lblImagem3 = new JLabel("");
		lblImagem3.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\icone3.png"));
		lblImagem3.setBounds(345, 315, 90, 90);
		contentPane.add(lblImagem3);
		
		JLabel lblImagem4 = new JLabel("");
		lblImagem4.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\icone4.png"));
		lblImagem4.setBounds(310, 180, 70, 70);
		contentPane.add(lblImagem4);
		
		JLabel lblImagem5 = new JLabel("");
		lblImagem5.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\icone5.png"));
		lblImagem5.setBounds(365, 90, 60, 60);
		contentPane.add(lblImagem5);
		
		JLabel lblImagem6 = new JLabel("");
		lblImagem6.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\icone6.png"));
		lblImagem6.setBounds(275, 1, 55, 55);
		contentPane.add(lblImagem6);
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\ESTG009\\Desktop\\one_projetos\\ConversorDeMoedas\\assets\\imagem_fundo.jpg"));
		lblImagemFundo.setBounds(0, 0, 436, 412);
		contentPane.add(lblImagemFundo);
		atualizarTabelaCotacao();
	}
	
	/** Método responsável por buscar o buscarCotacoes() na inialização da tela */
	public void atualizarTabelaCotacao() {
		ArrayList<Cotacao> cotacoes = pesquisa.buscarCotacoes();
		DefaultTableModel modelo = (DefaultTableModel) tbCotacao.getModel();
		for (Cotacao cotacao : cotacoes) {
			modelo.addRow(new Object[] {cotacao.abreviacao(), cotacao.valor()});
		}
		tbCotacao.setModel(modelo);
	}
}
