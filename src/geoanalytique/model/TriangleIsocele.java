package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class TriangleIsocele extends Polygone {
    private Point centre;
    private double base;

    public TriangleIsocele(Point centre,double base)
    {
        this.centre=centre;
        this.base=base;
    }

    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public Point getCentre() {
        return centre;
    }
    public void setCentre(Point centre) {
        this.centre = centre;
    }

     @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }


   
    
    // Constructeur, getters, setters et autres méthodes
}