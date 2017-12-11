import java.awt.*;

public class Ball{
	double PosX, PosY, diametro, radio, xDir, yDir;
	
	public Ball(int r) {
		PosX = (GUI.width / 2);
		PosY = (GUI.height / 2);
		xDir = 4;
		yDir = 3;
		diametro = r*2;
		radio = r;
		}
	
	public double getX() {
		return PosX;
	}
	
	public double getY() {
		return PosY;
	}
	
	public void setX(int x) {
		this.PosX = x;
	}
	
	public void setY(int y) {
		this.PosY = y;
	}
	
	public double getDiametro() {
		return diametro;
	}
	
	public void setDiametro(int r) {
		this.diametro = r*2;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setXDir(double xDir) {
		this.xDir = xDir;
	}
	
	public double getXDir() {
		return xDir;
	}
	
	public void setYDir(double yDir) {
		this.yDir = yDir;
	}
	
	public double getYDir() {
		return yDir;
	}
	
	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public void move() {
		PosX += xDir;
		//PosY += yDir;
	}
	
	public void stopBall() {
		this.xDir = 0;
		this.yDir = 0;
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(37,107,247));
		g.fillOval((int)PosX, (int)PosY, (int)diametro, (int)diametro);
	}
}
