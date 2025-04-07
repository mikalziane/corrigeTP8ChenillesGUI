package chenille;

public class Anneau {
	private int x, y;

	public Anneau(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public char getSymbole() {
		return 'a';
	}
	
	public void deplacer(int dx, int dy) {
		x += dx;
		y += dy;
	}
	public void placerA(Anneau a) {
		x = a.x;
		y = a.y;
	}
	

}
