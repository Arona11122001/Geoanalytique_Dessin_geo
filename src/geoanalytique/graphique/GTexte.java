package geoanalytique.graphique;

import java.awt.*;

public class GTexte extends Graphique {
    private String texte;
    private int x;
    private int y;

    public GTexte(String texte, int x, int y) {
        this.texte = texte;
        this.x = x;
        this.y = y;
    }

    @Override
    public void dessiner(Graphics g2d) {
        g2d.drawString(texte, x, y);
    }
}
