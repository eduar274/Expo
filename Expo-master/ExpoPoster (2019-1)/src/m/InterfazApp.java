package m;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import excel.LeerExcel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class InterfazApp extends JFrame implements ActionListener{

	JLabel tit = new JLabel("Aprender Ingles/Learn English");
	JButton bot1 = new JButton("Aprender/Learn");
	JButton bot2 = new JButton("Repasar/To Check");
	JButton bot3 = new JButton("Rest");
	
	private static Aprender Ap;
	private static Repasar Rp;
	private static Test1 test;
	private static Test2 test2;
	private static String [] filas;
	private static File excel = new File("C:\\Users\\BOG-A408-E-016\\Downloads\\Expo-master\\ExpoPoster (2019-1)\\files\\tabla.xlsx");
	private JLabel imagen=new JLabel();
	private JPanel contentPane;
	private static ArrayList<String> preguntar=new ArrayList<String>();

	
	public InterfazApp() {
		
		Ap = new Aprender();
		preguntar= Ap.getPalabrasAprendidas();
		test= new Test1();
		test2= new Test2();
		Rp = new Repasar(test,test2);
		
		LeerExcel leer = new LeerExcel();
		try {
			filas = leer.ReadStringFromExcelFile(excel).split("&");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ap.setFilas(filas);
		
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		//setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("1")));
		tit.setBounds(40, 10, 450, 50);
		tit.setFont(new Font(null, Font.ITALIC, 30));
		add(tit);
		setResizable(false);
		bot1.setBounds(30,300, 200, 30);
		bot1.addActionListener(this);
		add(bot1);
		bot2.addActionListener(this);
		bot2.setBounds(270, 300, 200, 30);
		add(bot2);
		bot3.setBounds(190, 400, 100, 30);
		bot3.addActionListener(this);
		add(bot3);
		ImageIcon pal=new ImageIcon("C:\\Users\\BOG-A408-E-016\\Downloads\\Expo-master\\ExpoPoster (2019-1)\\files\\portada.png");
		
		
		imagen.setBounds(90, 40, 300, 300);
		imagen.setIcon(pal);
		add(imagen);
		
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		InterfazApp menu = new InterfazApp();
		
		
		menu.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		test.setPalabras(preguntar);
		test2.setPalabras(preguntar);
		Rp.setPalabras(Ap.getPalabrasAprendidas());
		
		if(e.getActionCommand().equalsIgnoreCase(bot1.getText())){
			Ap.setVisible(true);
			
			
		}else {
			if(e.getActionCommand().equalsIgnoreCase(bot2.getText())) {
				Rp.setVisible(true);
				
			}else {
				if(e.getActionCommand().equalsIgnoreCase(bot3.getText())) {
					
				}
			}
		}
	}
	
}
