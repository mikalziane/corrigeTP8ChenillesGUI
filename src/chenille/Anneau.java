package chenille;

public class Anneau {
	private int x, y;

	public Anneau(int x, int y) {
		placerA(x,y);
	}

	public int x() { return x; }
	public int y() {
		return y;
	}
	
	public void placerA(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void placerSur(Anneau a) {
		placerA(a.x, a.y);
	}

}
