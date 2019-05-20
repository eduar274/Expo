package m;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.io.IOException;

public class Aprender extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private static String [] filas;
	private static ArrayList<Integer> numeros = new ArrayList<Integer>();
	private static ArrayList<String> palabrasAprendidas = new ArrayList<String>();
	
	private JTextField fraseIng;
	private JTextField fraseEsp;
	private static int aux  = 0;
	private static String nameImg;
	static JButton menu = new JButton("Regresar Menu");
	static JButton sig = new JButton("Siguiente");
	static JButton bot3 = new JButton("Borrar");
	private JLabel imagen=new JLabel();

	public static void setNameImg(String nameImg2) {
		nameImg = nameImg2;
	}
	
	public static void setAux(int aux2) {
		aux=aux2;
	}
	
	public static int getAux(){
		return aux;
	}
	public ArrayList<String> getPalabrasAprendidas(){
		return palabrasAprendidas;
	}
	
	public void Borrar() {
		setAux(0);
		palabrasAprendidas.clear();
	}
	
	public static String getNameImg() {
		return nameImg;
	}

	
	public void setFilas(String [] filas) {
		this.filas = filas;
	}
	
	
	public Aprender(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBounds(10, 10, 500, 500);
		setSize(1000,500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Learn");
		setResizable(false);
		

		JLabel frase1 = new JLabel("Palabra Español / Spanish word");
		frase1.setFont(new Font(null, Font.ITALIC, 18));
		frase1.setBounds(31, 24, 290, 22);
		contentPane.add(frase1);
		
		fraseEsp = new JTextField();
		fraseEsp.setEditable(false);
		fraseEsp.setFont(new Font(null, Font.ITALIC, 30));
		fraseEsp.setBounds(10, 177, 282, 50);
		contentPane.add(fraseEsp);
		fraseEsp.setColumns(10);
		
		JLabel frase2 = new JLabel("Imagen / Picture");
		frase2.setFont(new Font(null, Font.ITALIC, 18));
		frase2.setBounds(410, 24, 291, 22);
		contentPane.add(frase2);
		
		
		contentPane.add(imagen);
		
		
		
		JLabel frase3 = new JLabel("Palabra Ingles/ English word");
		frase3.setFont(new Font(null, Font.ITALIC, 18));
		frase3.setBounds(700, 24, 291, 22);
		contentPane.add(frase3);
		
		fraseIng = new JTextField();
		fraseIng.setEditable(false);
		fraseIng.setFont(new Font(null, Font.ITALIC, 30));
		fraseIng.setBounds(700, 177, 282, 50);
		contentPane.add(fraseIng);
		fraseIng.setColumns(10);

		
		menu.setBounds(31, 400, 125, 23);
		menu.addActionListener(this);
		contentPane.add(menu);
		
		bot3.setBounds(300, 400, 125, 23);
		bot3.addActionListener(this);
		contentPane.add(bot3);
		
		sig.setBounds(800, 400, 125, 23);
		sig.addActionListener(this);
		contentPane.add(sig);

		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equalsIgnoreCase(menu.getText())) {	
			ImageIcon pal=new ImageIcon("C:\\Users\\Eduar\\eclipse-workspace\\ExpoPoster (2019-1)\\files\\nada.png");
			imagen.setIcon(pal);
			fraseIng.setText(null);
			fraseEsp.setText(null);
			this.dispose();
		}else {
			if(e.getActionCommand().equalsIgnoreCase(sig.getText())) {
				if(getAux() == filas.length) {
					JOptionPane.showMessageDialog(null, "No hay mas vocabulario", "Aviso", JOptionPane.WARNING_MESSAGE);
				}else {
					String [] temp;
					//boolean seguir = true;
					if(getAux() == filas.length) {
						JOptionPane.showMessageDialog(null, "No hay mas vocabulario", "Sin elementos", JOptionPane.WARNING_MESSAGE);
						
					}else {
						temp = filas [getAux()].split("/");
						if(temp [2].equalsIgnoreCase("F")) {
							
							setAux(getAux()+1);
						}else {
							fraseIng.setText(temp[1]);
							fraseEsp.setText(temp[0]);
							palabrasAprendidas.add(temp[0]);
							palabrasAprendidas.add(temp[1]);
							setNameImg(temp[0]);
							ImageIcon pal=new ImageIcon("C:\\Users\\Eduar\\eclipse-workspace\\ExpoPoster (2019-1)\\files\\"+getNameImg()+".png");
							//System.out.print(nameImg+" "+getNameImg());
							imagen.setBounds(370, 40, 300, 300);
							imagen.setIcon(pal);
							
							setAux(getAux()+1);
						}
						
					}
				
			}
		}else {
			if(e.getActionCommand().equalsIgnoreCase(bot3.getText())) {
				Borrar();
			}
		}
		
		}
	}
	}
