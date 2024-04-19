package geoanalytique.model;

import java.util.List;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Pentagone extends Polygone {
    
    private Point centre;
    private double longueurCote;

    public Pentagone (Point centre, double longueurCote)
    {
        this.centre= centre;
        this.longueurCote=longueurCote;
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
    public void setLongueurCote(double longueurCote) {
        this.longueurCote = longueurCote;
    }

    @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }


      
}
