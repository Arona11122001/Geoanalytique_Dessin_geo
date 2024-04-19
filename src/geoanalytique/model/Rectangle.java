package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Rectangle extends Polygone {
    private Point centre;
    private double longueur;
    private double largeur;
    
    public Rectangle(Point p1, double l1, double l2) {
        //TODO Auto-generated constructor stub
        this.centre=p1;
        this.longueur=l1;
        this.largeur=l2;
    }
    // Constructeur, getters, setters et autres méthodes
    public Point getCentre() {
        return centre;
    }
    public double getLongueur() {
        return longueur;
    }
    public double getLargeur() {
        return largeur;
    }
    @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }
}
