import java.awt.*;

@SuppressWarnings("serial")
public class Jugador extends Polygon {
	private double xVel = 0, yVel = 0;
	int width = 1320, height = 730;
	private double centerX = 300, centerY = 300;
	public static int[] polyXArray = {-13,14,-13,-5,-13};
	public static int[] polyYArray = {-15,0,15,0,-15};
	private int playerWidth = 27, playerHeight = 30;
	private double uLeftPos = getXCenter() + Jugador.polyXArray[0];
	private double uLeftYPos = getYCenter() + Jugador.polyYArray[0];
	private double rotationAngle = 0, movingAngle = 0;
	public static boolean interactionPlayer1 = false, interactionPlayer2 = false;
	public Jugador() {
		super(polyXArray, polyYArray, 5);
	}
	public double getXCenter() {
		return centerX;
	}
	public double getYCenter() {
		return centerY;
	}
	public void setXCenter(double xCenter) {
		this.centerX = xCenter;
	}
	public void setYCenter(double yCenter) {
		this.centerY = yCenter;
	}
	public double getULeftXPos() {
		return this.uLeftPos;
	}
	public double getULeftYPos() {
		return this.uLeftYPos;
	}
	public void setULeftXPos(double uLXPos) {
		this.uLeftPos = uLXPos;
	}
	public void setULeftYPos(double uLYPos) {
		this.uLeftYPos = uLYPos;
	}
	public int getPlayerWidth() {
		return this.playerWidth;
	}
	public int getPlayerHeight() {
		return this.playerHeight;
	}
	public double getXVelocity() {
		return this.xVel;
	}
	public double getYVelocity() {
		return this.yVel;
	}
	public void setXVelocity(double xVel) {
		this.xVel = xVel;
	}
	public void setYVelocity(double yVel) {
		this.yVel = yVel;
	}
	public void setMovingAngle(double moveAngle) {
		this.movingAngle = moveAngle;
	}
	public double getMovingAngle() {
		return this.movingAngle;
	}
	public double getRotationAngle() {
		return this.rotationAngle;
	}
	public void increaseXPos(double increaseAmount) {
		this.centerX += increaseAmount;
	}
	public void increaseYPos(double increaseAmount) {
		this.centerY += increaseAmount;
	}
	public void increaseXVel(double increaseAmount) {
		this.xVel += increaseAmount;
	}
	public void increaseYVel(double increaseAmount) {
		this.yVel += increaseAmount;
	}
	public void decreaseXVel(double decreaseAmount) {
		this.xVel -= decreaseAmount;
	}
	
	public void decreaseYVel(double decreaseAmount) {
		this.yVel -= decreaseAmount;
	}
	public void increaseMovingAngle(double moveAngle) {
		this.movingAngle += moveAngle;
	}
	public void stopRocket() {
		this.xVel = 0;
		this.yVel = 0;
		this.movingAngle = rotationAngle;
	}
	public double rocketXMoveAngle(double xMoveAngle) {
		return (double)(Math.cos(xMoveAngle * Math.PI / 180));
	}
	public double rocketYMoveAngle(double yMoveAngle) {
		return (double)(Math.sin(yMoveAngle * Math.PI / 180));
	}
	public void increaseRotAngle() {
		if(getRotationAngle() >= 355) {
			this.rotationAngle = 0;
		}
		else {
			this.rotationAngle +=5;
		}
	}
	
	public void decreaseRotAngle() {
		if(getRotationAngle() <= 0) {
			this.rotationAngle = 355;
		}
		else {
			this.rotationAngle -= 5;
		}
	}
	public Rectangle getBounds() {
		return new Rectangle((int)getXCenter() - 14,(int)getYCenter() -15,getPlayerWidth(),getPlayerHeight());
	}
	public double getRocketNoseX() {
		return this.getXCenter() + Math.cos(rotationAngle);
	}
	
	public double getRocketNoseY() {
		return this.getYCenter() + Math.sin(rotationAngle);
	}
	public void movement() {
		this.increaseXPos(this.getXVelocity());
		if(this.getXCenter() < 0) {
			this.setXCenter(width);
		}
		else if(this.getXCenter() > width) {
			this.setXCenter(0);
		}
		
		this.increaseYPos(this.getYVelocity());
		if(this.getYCenter() < 60) {
			this.setYCenter(height);
		}
		else if(this.getYCenter() > height) {
			this.setYCenter(70);
		}
	}
}
