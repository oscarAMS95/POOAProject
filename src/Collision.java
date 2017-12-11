public class Collision {
	
	public static boolean intersects(Jugador player1, Ball pelota) {
		double XPlayer = player1.getXCenter() - 14;
		double YPlayer = player1.getYCenter() - 15;
		double mitadWidth = player1.getPlayerWidth()/2;
		double mitadHeight = player1.getPlayerHeight()/2;
		
		double distX_Player1 = Math.abs(pelota.getX() - XPlayer - mitadWidth);
		double distY_Player1 = Math.abs(pelota.getY() - YPlayer - mitadHeight);
				
		if(distX_Player1 > (mitadWidth + pelota.getDiametro())) {
			return false;
		}
		if(distY_Player1 > (mitadHeight + pelota.getDiametro())) {
			return false;
		}
		if(distX_Player1 <= mitadWidth) {
			return true;
		}
		if(distY_Player1 <= mitadHeight) {
			return true;
		}
		double dx = distX_Player1 - mitadWidth;
		double dy = distX_Player1 - mitadHeight;		
		return((dx*dx+dy*dy) <= (pelota.getDiametro()*pelota.getDiametro()));
	}
	
	public static boolean intersectsPorteria(Porteria porteria, Ball pelota) {
		double XPlayer = porteria.getW() / 2;
		double YPlayer = porteria.getH() / 2;
		double mitadWidth = porteria.getW() /2 ;
		double mitadHeight = porteria.getH() / 2;
		
		double distX_Porteria = Math.abs(pelota.getX() - XPlayer - mitadWidth);
		double distY_Porteria = Math.abs(pelota.getY() - YPlayer - mitadHeight);
				
		if(distX_Porteria > (mitadWidth + pelota.getDiametro())) {
			return false;
		}
		if(distY_Porteria > (mitadHeight + pelota.getDiametro())) {
			return false;
		}
		if(distX_Porteria <= mitadWidth) {
			return true;
		}
		if(distY_Porteria <= mitadHeight) {
			return true;
		}
		double dx = distX_Porteria - mitadWidth;
		double dy = distX_Porteria - mitadHeight;		
		return((dx*dx+dy*dy) <= (pelota.getDiametro()*pelota.getDiametro()));
	}
}
