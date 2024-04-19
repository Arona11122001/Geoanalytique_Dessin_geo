package geoanalytique.graphique;

import java.awt.*;

public class GPolygone extends Graphique {
    private GCoordonnee[] sommets;

    public GPolygone(GCoordonnee[] sommets) {
        this.sommets = sommets;
    }

    public GCoordonnee[] getSommets() {
        return sommets;
    }

    @Override
    public void dessiner(Graphics g) {
        if (sommets.length < 3) {
            // Ne peut pas dessiner un polygone avec moins de 3 sommets
            return;
        }

        int[] xPoints = new int[sommets.length];
        int[] yPoints = new int[sommets.length];

        // Convertir les coordonnées en points x et y pour le dessin
        for (int i = 0; i < sommets.length; i++) {
            xPoints[i] = (int) sommets[i].getX();
            yPoints[i] = (int) sommets[i].getY();
        }

        g.drawPolygon(xPoints, yPoints, sommets.length);

        
    }
}
