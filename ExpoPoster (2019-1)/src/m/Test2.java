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

public class Test2 extends JFrame implements ActionListener {

	private static ArrayList<String> preguntar=new ArrayList<String>();
	static JButton obP = new JButton("Obtener Nueva Palabra");
	static JButton exit = new JButton("Salir");
	private JPanel contentPane;
	private JLabel imagen=new JLabel();
	private JTextField palIng;
	private JTextField palEsp;
	private static int aux  = 0, auxy=0,nPre = 0 , nAce = 0;
	private static String nameImg;
	static JButton ver = new JButton("Verificar");

	
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
	public  void setPalabras(ArrayList<String> preg) {
		preguntar=preg;
	}
	
	public ArrayList<String> getPalabras(){
		return preguntar;
	}
	
	//ArrayList<String> palabras
	Test2(){
		//preguntar=(ArrayList<String>) palabras.clone();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		//System.out.println(preguntar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel frase1 = new JLabel("Escriba el significado de la palabra / Write  ");
		frase1.setFont(new Font(null, Font.ITALIC, 18));
		frase1.setBounds(41, 24, 990, 22);
		contentPane.add(frase1);
		
		JLabel frase2 = new JLabel("Palabra en español");
		frase2.setFont(new Font(null, Font.ITALIC, 18));
		frase2.setBounds(120, 120, 400, 22);
		contentPane.add(frase2);
		
		palEsp = new JTextField();
		palEsp.setEditable(false);
		palEsp.setFont(new Font(null, Font.ITALIC, 30));
		palEsp.setBounds(120, 160, 120, 32);
		contentPane.add(palEsp);
		palEsp.setColumns(10);
		
		JLabel frase3 = new JLabel("Palabra en ingles");
		frase3.setFont(new Font(null, Font.ITALIC, 18));
		frase3.setBounds(120, 220, 400, 22);
		contentPane.add(frase3);
		
		palIng = new JTextField();
		palIng.setEditable(true);
		palIng.setFont(new Font(null, Font.ITALIC, 30));
		palIng.setBounds(120, 260, 120, 32);
		contentPane.add(palIng);
		palIng.setColumns(10);
		
		exit.setBounds(31, 400, 125, 23);
		exit.addActionListener(this);
		contentPane.add(exit);
		
		obP.setBounds(270, 400, 200, 23);
		obP.addActionListener(this);
		contentPane.add(obP);
		
		ver.setBounds(160, 430, 120, 23);
		ver.addActionListener(this);
		contentPane.add(ver);
		
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
			if(e.getActionCommand().equalsIgnoreCase(obP.getText()) && aux == getPalabras().size()) {
				System.out.println("Aciertos: "+nAce+" Preguntas: "+nPre);
				JOptionPane.showMessageDialog(null, "Aciertos: "+" "+nAce+" Preguntas: "+nPre, "Finalizo", JOptionPane.WARNING_MESSAGE);
			}else {
				if(e.getActionCommand().equalsIgnoreCase(obP.getText()) && !getPalabras().isEmpty()) {
					System.out.println(getPalabras());
					palEsp.setText(getPalabras().get(aux));
					aux+=2;
					nPre+=1;
				}else {
					if(e.getActionCommand().equalsIgnoreCase(ver.getText())) {
						System.out.println(getPalabras().get(aux-1)+" "+palIng.getText());
						if(getPalabras().get(aux-1).equalsIgnoreCase(palIng.getText())) {
							nAce+=1;
						}
					}
				}
			}
		}
		
	}

	
}
