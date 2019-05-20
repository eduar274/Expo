package m;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Test1 extends JFrame implements ActionListener{
	
	
	private static ArrayList<String> preguntar=new ArrayList<String>();
	static JButton obP = new JButton("Obtener Nueva Palabra");
	static JButton ver = new JButton("Verificar");
	static JButton exit = new JButton("Salir");
	private JPanel contentPane;
	private JLabel imagen=new JLabel();
	private JTextField palIng;
	private JTextField palEsp;
	private static int aux  = 0, auxy=0,nPre = 0 , nAce = 0;
	private static String nameImg;
	private static String paSp , paIg;
	public void setPalabras(ArrayList<String> preg) {
		preguntar=preg;
	}
	
	public ArrayList<String> getPalabras(){
		return preguntar;
	}
	
	public static void setNameImg(String nameImg2) {
		nameImg = nameImg2;
	}
	
	public static void setAux(int aux2) {
		aux=aux2;
	}
	
	public static int getAux(){
		return aux;
	}
	
	public static String getNameImg() {
		return nameImg;
	}
	
	Test1(ArrayList<String> palabras){
		preguntar=(ArrayList<String>) palabras.clone();
		System.out.println(preguntar);
		
	}
	
	
	   Test1(){
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(1000,500);
			
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setResizable(false);
			
			JLabel frase1 = new JLabel("Escriba el nombre de la imagen en español e ingles / Write the name of the image in Spanish and English ");
			frase1.setFont(new Font(null, Font.ITALIC, 18));
			frase1.setBounds(41, 24, 990, 22);
			contentPane.add(frase1);
			
			JLabel frase2 = new JLabel("Palabra en español/Spanish Word");
			frase2.setFont(new Font(null, Font.ITALIC, 18));
			frase2.setBounds(550, 120, 400, 22);
			contentPane.add(frase2);
			
			palEsp = new JTextField();
			palEsp.setEditable(true);
			palEsp.setFont(new Font(null, Font.ITALIC, 30));
			palEsp.setBounds(550, 160, 120, 32);
			contentPane.add(palEsp);
			palEsp.setColumns(10);
			
			JLabel frase3 = new JLabel("Palabra en ingles/English Word");
			frase3.setFont(new Font(null, Font.ITALIC, 18));
			frase3.setBounds(550, 220, 400, 22);
			contentPane.add(frase3);
			
			palIng = new JTextField();
			palIng.setEditable(true);
			palIng.setFont(new Font(null, Font.ITALIC, 30));
			palIng.setBounds(550, 260, 120, 32);
			contentPane.add(palIng);
			palIng.setColumns(10);
			
			exit.setBounds(31, 400, 125, 23);
			exit.addActionListener(this);
			contentPane.add(exit);
			
			obP.setBounds(730, 400, 200, 23);
			obP.addActionListener(this);
			contentPane.add(obP);
			
			ver.setBounds(330, 400, 200, 23);
			ver.addActionListener(this);
			contentPane.add(ver);
			
			
			imagen.setBounds(160, 30, 400, 400);
			
			contentPane.add(imagen);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getActionCommand().equalsIgnoreCase(exit.getText())) {	
		    aux=0;
		    nPre=0;
		    nAce=0;
		    ImageIcon pal=new ImageIcon("C:\\Users\\Eduar\\eclipse-workspace\\ExpoPoster (2019-1)\\files\\nada.png");
			imagen.setIcon(pal);
			this.dispose();
		}else {
			if(e.getActionCommand().contentEquals(obP.getText()) && aux == getPalabras().size()) {
				//Mostrar puntuacion
				JOptionPane.showMessageDialog(null, "Aciertos: "+" "+nAce+" Preguntas: "+nPre, "Finalizo", JOptionPane.WARNING_MESSAGE);
				System.out.println("Aciertos: "+nAce+" Preguntas: "+nPre);
			}else {
				if(e.getActionCommand().equalsIgnoreCase(obP.getText())  && !preguntar.isEmpty() && aux <= getPalabras().size()-1) {
					System.out.println(preguntar+" "+getPalabras().get(0));
					ImageIcon pal=new ImageIcon("C:\\Users\\BOG-A408-E-016\\Downloads\\Expo-master\\ExpoPoster (2019-1)\\files\\"+getPalabras().get(aux)+".png");
					imagen.setIcon(pal);
					nPre+=1;
					paSp=preguntar.get(aux);
					//System.out.println(preguntar);
					paIg=preguntar.get(aux+1);
					//System.out.println(preguntar);
					
					aux+=2;
					//System.out.println(paSp+" 2"+paIg+" "+palEsp.getText()+" "+palIng.getText());
					
					//System.out.println(paSp+" 1"+paIg+" "+palEsp.getText()+" "+palIng.getText());
					
					//System.out.println("Aciertos: "+nAce+" Preguntas: "+nPre+" "+aux+" "+getPalabras().size());
					
						
					}else {
						if(e.getActionCommand().equalsIgnoreCase(ver.getText())) {
							//System.out.println(paSp+" 3"+paIg+" "+palEsp.getText()+" "+palIng.getText());
							if(palIng.getText().equalsIgnoreCase(paIg) && palEsp.getText().equalsIgnoreCase(paSp)) {
								nAce+=1;
							}
						}
					}
				}
			}
		}
	}
	
