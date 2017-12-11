import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Anuncio extends JFrame implements ActionListener{
	JButton boton;
	JLabel mensaje;
	
	public Anuncio(String mensajeEndGame) {
		boton = new JButton("OK");
		mensaje = new JLabel(mensajeEndGame);
		this.setSize(300,300);
		//this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		mensaje.setBounds(25,10,280,50);
		mensaje.setFont(new Font("Consolas",Font.BOLD,18));
		boton.setBounds(45,100,200,50);
		this.setLocationRelativeTo(null);
		boton.addActionListener(this);
		this.setVisible(true);
		this.add(boton);
		this.add(mensaje);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new menuPrincipal();
		this.dispose();
		GUI v = new GUI();
		v.dispose();
	}
}
