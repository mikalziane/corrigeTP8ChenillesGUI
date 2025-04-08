package chenille;

public class Chenille {
	private Tete tete;
	private Anneau[] anneaux;

	public Chenille(int nbAnneaux, int xt, int yt) {
		tete = new Tete(xt, yt);
	    anneaux = new Anneau[nbAnneaux];
	    for (int i = 0; i < nbAnneaux; ++i)
	    	anneaux[i] = new Anneau(xt - i - 1, yt);
	}


	public void deplacer(int xMAX, int yMAX) {
		for (int i = anneaux.length -1; i >=1; --i)
			anneaux[i].placerSur(anneaux[i-1]);
		anneaux[0].placerSur(tete);
		tete.deplacer(xMAX, yMAX);
	}

}
