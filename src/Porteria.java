import java.awt.Rectangle;

public class Porteria {
	int width, height, PosicionX, PosicionY;
	Rectangle porteria1;
	public Porteria(int posX, int posY, int width, int height) {
		this.width = width;
		this.height = height;
		this.PosicionX = posX;
		this.PosicionY = posY;
		porteria1 = new Rectangle(posX, posY, width, height);
	}
	
	public int getX() {
		return PosicionX;
	}
	
	public void setX(int PosX) {
		this.PosicionX = PosX;
	}
	
	public int getY() {
		return PosicionY;
	}
	
	public void setY(int PosY) {
		this.PosicionY = PosY;
	}
	
	public int getW() {
		return width;
	}
	
	public void setW(int Width) {
		this.width = Width;
	}
	
	public int getH() {
		return height;
	}
	
	public void setH(int Height) {
		this.height = Height;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(PosicionX, PosicionY, width, height);
	}
}
