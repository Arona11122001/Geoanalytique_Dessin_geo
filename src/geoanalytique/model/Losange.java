package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Losange extends Polygone {
    private Point centre;
   private double longueurCote;

    
    // Constructeur, getters, setters et autres méthodes

    public Losange (Point centre, double longueurCote)
    {
        this.centre=centre;
        this.longueurCote=longueurCote;
    }

    public double getLongueurCote() {
        return longueurCote;
    }
    public void setCentre(Point centre) {
        this.centre = centre;
    }
    public void setLongueurCote(double longueurCote) {
        this.longueurCote = longueurCote;
    }
    public Point getCentre() {
        return centre;
    }

    @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }
    
}
