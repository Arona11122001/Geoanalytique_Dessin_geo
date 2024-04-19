package geoanalytique.graphique;

import java.awt.*;

public class GLigne extends Graphique {
    private Point pointDepart;
    private Point pointArrivee;

    public GLigne(Point pointDepart, Point pointArrivee) {
        this.pointDepart = pointDepart;
        this.pointArrivee = pointArrivee;
    }

    public Point getPointDepart() {
        return pointDepart;
    }
    public Point getPointArrivee() {
        return pointArrivee;
    }

    public GLigne(double abscisse, double ordonnee, double abscisse2, double ordonnee2) {
        this.pointDepart = new Point((int) abscisse, (int) ordonnee);
        this.pointArrivee = new Point((int) abscisse2, (int) ordonnee2);
    }

    public GLigne(GCoordonnee convert, GCoordonnee convert2) {
        this.pointDepart = new Point((int) convert.getX(), (int) convert.getY());
        this.pointArrivee = new Point((int) convert2.getX(), (int) convert2.getY());
    }

    @Override
    public void dessiner(Graphics g2d) {
        g2d.drawLine(pointDepart.x, pointDepart.y, pointArrivee.x, pointArrivee.y);
    }

    public void setCouleur(Object couleur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCouleur'");
    }


}
