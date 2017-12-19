import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	public static int width = 1320;
	public static int height = 730;
	public static boolean keyHeld_W = false, keyHeld_A = false, keyHeld_S = false, keyHeld_D = false, keyHeld_E = false, keyHeld_UP = false, keyHeld_LEFT = false, keyHeld_DOWN = false, keyHeld_RIGHT = false, keyHeld_SHIFT = false;
	public static int keyHeldCode;
	public static Timer timeGame;
	public static JLabel player1, player2, pointsP1, pointsP2, timer;
	public static int contPointsP1 = 0, contPointsP2 = 0;
	public static int scoreP1, scoreP2;
	
	public GUI() {
		this.setTitle("ROCKET FOOTBALL");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		player1 = new JLabel();
		player2 = new JLabel();
		pointsP1 = new JLabel();
		pointsP2 = new JLabel();
		timer = new JLabel();
		this.setVisible(true);
		this.add(player1);
		this.add(player2);
		this.add(timer);
		player1.setText("PLAYER 1: "+ contPointsP1);
		player1.setFont(new Font("Consolas",Font.BOLD,26));
		player2.setText("PLAYER 2: "+ contPointsP2);
		player2.setFont(new Font("Consolas",Font.BOLD,26));
		timer.setText("2:00");
		timer.setFont(new Font("Consolas",Font.BOLD,28));
		player1.setBounds(60,10,190,60);
		player2.setBounds(920,10,190,60);
		timer.setBounds(565,10,120,60);
		
		timeGame = new Timer(1000, new ActionListener() {
			int time = 120;
			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				timer.setText(format(time/60)+":"+format(time%60));
				if(time == 0) {
					final Timer timer = (Timer)e.getSource();
					timer.stop();
					GameDraw.gameOver = true;
					endGame();
				}
			}
		});
		timeGame.start();
		this.getContentPane().setBackground(Color.cyan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				keyHeldCode = keyCode;
				//Player 1 Controls//
				if(keyHeldCode == Controls.W) {
					Jugador.interactionPlayer1 = true;
					keyHeld_W = true;
				}
				if(keyHeldCode == Controls.A) {
					Jugador.interactionPlayer1= true;
					keyHeld_A = true;
				}
				if(keyHeldCode == Controls.S) {
					Jugador.interactionPlayer1 = true;
					keyHeld_S = true;
				}
				if(keyHeldCode == Controls.D) {
					Jugador.interactionPlayer1 = true;
					keyHeld_D = true;
				}
				if(keyHeldCode == Controls.E) {
					Jugador.interactionPlayer1 = true;
					keyHeld_E = true;
				}
					
					//Player 2 Controls//
				if(keyHeldCode == Controls.UP) {
					Jugador.interactionPlayer2 = true;
					keyHeld_UP = true;
				}
				if(keyHeldCode == Controls.LEFT) {
					Jugador.interactionPlayer2 = true;
					keyHeld_LEFT = true;
				}
				if(keyHeldCode == Controls.DOWN) {
					Jugador.interactionPlayer2 = true;
					keyHeld_DOWN = true;
				}
				if(keyHeldCode == Controls.RIGHT) {
					Jugador.interactionPlayer2 = true;
					keyHeld_RIGHT = true;
				}
				if(keyHeldCode == Controls.SHIFT) {
					Jugador.interactionPlayer2 = true;
					keyHeld_SHIFT = true;
				}
			}
				
			public void keyReleased(KeyEvent e) {
				//Player 1//
					if(keyHeldCode == Controls.W) {
						keyHeld_W = false;
					}
					if(keyHeldCode == Controls.A) {
						keyHeld_A = false;
					}
					if(keyHeldCode == Controls.S) {
						keyHeld_S = false;
					}
					if(keyHeldCode == Controls.D) {
						keyHeld_D = false;
					}
					if(keyHeldCode == Controls.E) {
						keyHeld_E = false;
					}
					
					//Player 2//
					if(keyHeldCode == Controls.UP) {
						keyHeld_UP = false;
					}
					if(keyHeldCode == Controls.LEFT) {
						keyHeld_LEFT = false;
					}
					if(keyHeldCode == Controls.DOWN) {
						keyHeld_DOWN = false;
					}
					if(keyHeldCode == Controls.RIGHT) {
						keyHeld_RIGHT = false;
					}
					if(keyHeldCode == Controls.SHIFT) {
						keyHeld_SHIFT = false;
					}
				}
			});
		GameDraw gamePanel = new GameDraw();
		this.add(gamePanel, BorderLayout.CENTER);
		ScheduledThreadPoolExecutor ex = new ScheduledThreadPoolExecutor(2);
		ex.scheduleAtFixedRate(new RepaintTheBoard(this), 0L,20L, TimeUnit.MILLISECONDS);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void endGame() {	
		if(GameDraw.gameOver) {
			GameDraw.rocket1.stopRocket();
			GameDraw.rocket2.stopRocket();
			GameDraw.pelota.stopBall();
			if(scoreP1 > scoreP2) {
				new Anuncio("PLAYER 1 WINS THE MATCH!");
			}
			if(scoreP2 > scoreP1) {
				new Anuncio("PLAYER 2 WINS THE MATCH!");
			}
			if(scoreP1 == scoreP2) {
				new Anuncio("IT'S A DRAW!");
			}
		}
	}
	
	public static void scorePlayer1(int score) {
		scoreP1 = score;
		player1.setText("PLAYER 1: "+ scoreP1);
	}
	
	public static void scorePlayer2(int score2) {
		scoreP2 = score2;
		player2.setText("PLAYER 2: "+ scoreP2);
	}
	
	private static String format(int i) {
		String result = String.valueOf(i);
		if(result.length() == 1) {
			result = "0" + result;
		}
		return result;
	}
}
