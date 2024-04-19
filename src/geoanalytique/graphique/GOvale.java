package geoanalytique.graphique;

import java.awt.*;

public class GOvale extends Graphique {
    private double x;
    private double y;
    private double largeur;
    private double hauteur;

    public GOvale(double x, double y, double largeur, double hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public double getX() {
        return x;
    }
    public double getHauteur() {
        return hauteur;
    }
    public double getLargeur() {
        return largeur;
    }
    public double getY() {
        return y;
    }

    

    @Override
    public void dessiner(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.getX() - hauteur), (int)(this.getY() - largeur), (int)(2 * largeur), (int)(2 * hauteur));
    }
}
