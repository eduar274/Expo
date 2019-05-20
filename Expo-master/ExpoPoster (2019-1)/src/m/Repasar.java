package m;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Repasar extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	static JButton menu = new JButton("Regresar Menu");
	static JButton Pru1 = new JButton("Test 1");
	static JButton Pru2 = new JButton("Test 2");
	private static ArrayList<String> palabras = new ArrayList<String>();
	private JLabel imagen=new JLabel();
	Test1 test;
	Test2 test2;
	
	public  void setPalabras(ArrayList<String> preg) {
		palabras=preg;
	}
	
	public ArrayList<String> getPalabras(){
		return palabras;
	}
	

	public Repasar(Test1 test,Test2 test2) {
		this.test=test;
		this.test2=test2;
        //System.out.print(palabras);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Repasar/To check");
		setResizable(false);
		
		JLabel frase1 = new JLabel("Prueba / Test");
		frase1.setFont(new Font(null, Font.ITALIC, 30));
		frase1.setBounds(150, 24, 290, 30);
		contentPane.add(frase1);
		
		Pru1.setBounds(31, 310, 125, 23);
		Pru1.addActionListener(this);
		contentPane.add(Pru1);
		
		Pru2.setBounds(320, 310, 125, 23);
		Pru2.addActionListener(this);
		contentPane.add(Pru2);
		
		menu.setBounds(170, 420, 125, 23);
		menu.addActionListener(this);
		contentPane.add(menu);
		ImageIcon pal=new ImageIcon("C:\\Users\\BOG-A408-E-016\\Downloads\\Expo-master\\ExpoPoster (2019-1)\\files\\repasar.png");
		
		
		imagen.setBounds(90, 50, 300, 300);
		imagen.setIcon(pal);
		contentPane.add(imagen);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase(menu.getText())) {
			
			this.setVisible(false);
		}else {
			if(e.getActionCommand().equalsIgnoreCase(Pru1.getText())){
				if(getPalabras().isEmpty()) {
					test.setVisible(false);
					JOptionPane.showMessageDialog(null, "No tiene conocimientos/ Has no knowledge", "Sin elementos/No elements", JOptionPane.WARNING_MESSAGE);
				}else {
					if(!getPalabras().isEmpty()) {
		
						test.setVisible(true);
					}
					
				}
			}else {
				if(e.getActionCommand().equalsIgnoreCase(Pru2.getText())){
					if(palabras.isEmpty()) {
						test.setVisible(false);
						JOptionPane.showMessageDialog(null, "No tiene conocimientos/ Has no knowledge", "Sin elementos/No elements", JOptionPane.WARNING_MESSAGE);
					}else {
						test2.setVisible(true);
					}
					
				}
			}
		}
		
	}
	
}
