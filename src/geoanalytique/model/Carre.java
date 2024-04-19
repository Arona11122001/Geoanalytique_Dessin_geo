package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Carre extends Polygone {
    private Point centre;
    private double longueurCote;
    
    // Constructeur, getters, setters et autres méthodes

     public Carre(Point p3, double max) {
        //TODO Auto-generated constructor stub
        this.centre=p3;
        this.longueurCote=max;
    }

    @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }

    public Point getCentre() {
        return centre;
    }
    public void setCentre(Point centre) {
        this.centre = centre;
    }
    public double getLongueurCote() {
        return longueurCote;
    }
    
}
