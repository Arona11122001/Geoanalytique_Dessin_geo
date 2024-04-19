package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Point extends GeoObject {
    private double abscisse;
    private double ordonnee;

    
    
    // Constructeur, getters, setters et autres méthodes
    public Point (double abscisse,double ordonnee){
        this.abscisse=abscisse;
        this.ordonnee=ordonnee;
    }


    public double getAbscisse() {
        return abscisse;
    }
    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse;
    }
    public double getOrdonnee() {
        return ordonnee;
    }
    public void setOrdonnee(double ordonnee) {
        this.ordonnee = ordonnee;
    }
    @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }
  
    public boolean contains(int x, int y) {
        // Un point contient les coordonnées (x, y) s'il correspond aux coordonnées du point
        return this.abscisse == x && this.ordonnee == y;
    }

}
