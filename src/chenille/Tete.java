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

	public void deplacer(int xMax, int yMax) {
		if (x() == 0 || x() == xMax ||
				y() == 0 || y() == yMax)
			cap = cap.inverser();
		else
			cap = cap.deriver(1);
		super.placerA(x()+cap.getDx(), y()+cap.getDy());
	}
}
