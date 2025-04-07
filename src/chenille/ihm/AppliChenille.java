// AppliChenille.java
package chenille.ihm;

import chenille.Chenille;

public class AppliChenille {
  
  private static void effacer(char[][] t) {
    for (int y = t[0].length - 1; y >= 0; --y)
      for (int x = 0; x < t.length; ++x)
        t[x][y] = ' ';
  }
  
  private static void afficher(char[][] t) {
    for (int y = t[0].length - 1; y >= 0; --y) {
      for (int x = 0; x < t.length; ++x)
        System.out.print(t[x][y]);
      System.out.println();
    }
  }

  private static void pause() {
    try {
      Thread.sleep(200);
    } catch (Exception e) {
    }
  }
  
  public static void main(String[] args) {
    final int NBPAS = 50, NB_ANNEAUX = 7;
    final int XMAX = 40, YMAX = 10;
    Chenille c = new Chenille(NB_ANNEAUX, XMAX / 2 , YMAX / 2);
    char t[][] = new char[XMAX + 1][YMAX + 1];

    for (int i = 0; i < NBPAS; ++i) {
      effacer(t);
      c.dessiner(t);
      afficher(t);
      pause();
      c.deplacer(XMAX , YMAX);
    }
  }
}
