import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

@SuppressWarnings("serial")
class GameDraw extends JComponent{
			static Jugador rocket1 = new Jugador();
			static Jugador rocket2 = new Jugador();
			static Ball pelota = new Ball(15);
			static int cont = 0, cont2 = 0;
			static Porteria goal1 = new Porteria(1,280,89,209);
			static Rectangle g1 = new Rectangle(5,280,100,209);
			static Rectangle g2 = new Rectangle(1215,280,100,209);
			static Porteria goal2 = new Porteria(1215,280,100,209);
			static int width = GUI.width;
			static int height = GUI.height;
			static boolean gameOver, bouncing;
			private BufferedImage image;
			Thread updateThread;
			
			public GameDraw() {
				try {
					image = ImageIO.read(getClass().getResourceAsStream("/field2.jpg"));
				}
				catch(IOException e) {}
				newGame();
				updateThread = new Thread(){
					public void run() {
						while(true) {
							update();
							gameOver = false;
							repaint();
							try {
								Thread.sleep(50);
							}
							catch(InterruptedException e) {}
						}
					}
				};
				updateThread.start();
			}
			
			public void paint(Graphics g) {
				Graphics2D graphicsSet = (Graphics2D) g;
				AffineTransform id = new AffineTransform();
				AffineTransform id2 = new AffineTransform();
				graphicsSet.drawImage(image,0,65,1315,637,null);
				pelota.paint(g);
				graphicsSet.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				graphicsSet.setPaint(new Color(37,149,160));
				
				
				//Player 1 Controls//
				if(GUI.keyHeld_D == true && GUI.keyHeldCode == Controls.D) {
					rocket1.increaseRotAngle();
				}
				else if(GUI.keyHeld_A == true && GUI.keyHeldCode == Controls.A) {
					rocket1.decreaseRotAngle();
				}
				else if(GUI.keyHeld_W == true && GUI.keyHeldCode == Controls.W) {
					rocket1.setMovingAngle(rocket1.getRotationAngle());
					rocket1.increaseXVel(rocket1.rocketXMoveAngle(rocket1.getMovingAngle())*0.1);
					rocket1.increaseYVel(rocket1.rocketYMoveAngle(rocket1.getMovingAngle())*0.1);	
				}
				else if(GUI.keyHeld_S == true && GUI.keyHeldCode == Controls.S) {
					rocket1.setMovingAngle(rocket1.getRotationAngle());
					rocket1.decreaseXVel(rocket1.rocketXMoveAngle(rocket1.getMovingAngle())*0.1);
					rocket1.decreaseYVel(rocket1.rocketYMoveAngle(rocket1.getMovingAngle())*0.1);
				}
				else if(GUI.keyHeld_E == true && GUI.keyHeldCode == Controls.E) {
					rocket1.stopRocket();
				}
				
				
				//Player 2 Controls//
				if(GUI.keyHeld_RIGHT == true && GUI.keyHeldCode == Controls.RIGHT) {
					rocket2.increaseRotAngle();
				}
				else if(GUI.keyHeld_LEFT == true && GUI.keyHeldCode == Controls.LEFT) {
					rocket2.decreaseRotAngle();
				}
				else if(GUI.keyHeld_UP == true && GUI.keyHeldCode == Controls.UP) {
					rocket2.setMovingAngle(rocket2.getRotationAngle());
					rocket2.increaseXVel(rocket2.rocketXMoveAngle(rocket2.getMovingAngle())*0.1);
					rocket2.increaseYVel(rocket2.rocketYMoveAngle(rocket2.getMovingAngle())*0.1);	
				}
				else if(GUI.keyHeld_DOWN == true && GUI.keyHeldCode == Controls.DOWN) {
					rocket2.setMovingAngle(rocket2.getRotationAngle());
					rocket2.decreaseXVel(rocket2.rocketXMoveAngle(rocket2.getMovingAngle())*0.1);
					rocket2.decreaseYVel(rocket2.rocketYMoveAngle(rocket2.getMovingAngle())*0.1);
				}
				else if(GUI.keyHeld_SHIFT == true && GUI.keyHeldCode == Controls.SHIFT) {
					rocket2.stopRocket();
				}
				
				rocket1.movement();
				graphicsSet.setTransform(id);
				graphicsSet.translate(rocket1.getXCenter(), rocket1.getYCenter());
				graphicsSet.rotate(Math.toRadians(rocket1.getRotationAngle()));
				graphicsSet.draw(rocket1);
				
				
				rocket2.movement();
				graphicsSet.setTransform(id2);
				graphicsSet.translate(rocket2.getXCenter(), rocket2.getYCenter());
				graphicsSet.rotate(Math.toRadians(rocket2.getRotationAngle()));
				graphicsSet.draw(rocket2);
				
			}
			
			public static void newGame() {
				pelota.setX(width/2);
				pelota.setY(height/2);
				rocket1.setXCenter(220);
				rocket1.setYCenter(380);
				rocket2.setXCenter(1100);
				rocket2.setYCenter(380);
			}
			
			public static void bounce() {
				if(g1.intersects(pelota.PosX, pelota.PosY, pelota.diametro, pelota.diametro)) {
					System.out.println("COLISION PORTERIA 1");
					cont = cont + 1;
					GUI.scorePlayer1(cont);
					newGame();
				}
				if(g2.intersects(pelota.PosX, pelota.PosY, pelota.diametro, pelota.diametro)) {
					System.out.println("COLISION PORTERIA 2");
					cont2 = cont2 + 1;
					GUI.scorePlayer2(cont2);
					newGame();
				}
				
				if(Collision.intersects(rocket1, pelota)) {
					pelota.xDir =- pelota.xDir;
					
				}
				if(Collision.intersects(rocket2, pelota)) {
					pelota.xDir =- pelota.xDir;
				}
				if(pelota.PosX - pelota.radio < 90) {
					pelota.xDir =- pelota.xDir;
					pelota.PosX = 90 + pelota.radio;
				}
				else if(pelota.PosX + pelota.radio > 1200) {
					pelota.xDir =- pelota.xDir;
					pelota.PosX = 1200 - pelota.radio;
					
				}
				if(pelota.PosY - pelota.radio < 70) {
					pelota.yDir =- pelota.yDir;
					pelota.PosY = 70 + pelota.radio;
					
				}
				else if(pelota.PosY + pelota.radio > 680) {
					pelota.yDir =- pelota.yDir;
					pelota.PosY = 680 - pelota.radio;
				}
				bouncing = false;
			}
			
			public static void update() {
				if(!gameOver) {
					if(!bouncing) {
						bouncing = true;
						bounce();
					}
					pelota.move();
				}
			}
			
		}