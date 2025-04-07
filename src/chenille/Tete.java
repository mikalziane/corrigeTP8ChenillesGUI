package chenille;
import static geometrie.Direction.EST;

import geometrie.Direction;

public class Tete extends Anneau {
	private Direction cap;
	
	public Tete(int x, int y, Direction cap) {
		super(x, y);
		this.cap = cap;
	}
	
	public Tete(int x, int y) {
		this(x,y,EST);
	}
	
	@Override
	public char getSymbole() {
		return 't';
	}
	
	//@Override
	public void deplacer(int xMax, int yMax) {
		if (getX() == 0 || getX() == xMax || 
				getY() == 0 || getY() == yMax)
			cap = cap.inverser();
		else
			cap = cap.deriver(1);
		super.deplacer(cap.getDx(), cap.getDy());
	}
}
