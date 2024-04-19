package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Cercle extends Ellipse {
   
    private double rayon;
    
    // Constructeur, getters, setters et autres méthodes

    public Cercle (Point centre, double rayon)
    {
        super.setCentre(centre);
        this.rayon=rayon;
    }

    @Override
    public Point getCentre() {
        // TODO Auto-generated method stub
        return super.getCentre();
    }
    @Override
    public void setCentre(Point centre) {
        // TODO Auto-generated method stub
        super.setCentre(centre);
    }

    public double getRayon() {
        return rayon;
    }
    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
       @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }

}
