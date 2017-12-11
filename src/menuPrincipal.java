import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

@SuppressWarnings("serial")
public class menuPrincipal extends JFrame implements ActionListener {
	JButton play, salir;
	JLabel titulo;
	public menuPrincipal() {
		this.setTitle("GAME");
		this.setLayout(null);
		this.setSize(450,400);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		play = new JButton("Play");
		salir = new JButton("Salir");
		titulo = new JLabel("ROCKET FOOTBALL");
		titulo.setFont(new Font("Consolas",Font.BOLD,28));
		titulo.setBounds(120,50,280,50);
		salir.setBounds(130,200,180,60);
		play.setBounds(130,130, 180,60);
		play.addActionListener(this);
		salir.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(titulo);
		this.add(play);
		this.add(salir);
	}
	
	public static void main(String[] args) {
		new menuPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play) {
			new GUI();
			this.dispose();
		}
		else{
			this.dispose();
		}
	}
}
