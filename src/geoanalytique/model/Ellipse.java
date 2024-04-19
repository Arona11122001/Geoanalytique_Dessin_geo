package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Ellipse extends Surface {
    private Point centre;
    private double grandAxe;
    private double petitAxe;
    
    // Constructeur, getters, setters et autres méthodes*
    public Point getCentre() {
        return centre;
    }
    public void setCentre(Point centre) {
        this.centre = centre;
    }
    public double getGrandAxe() {
        return grandAxe;
    }
    public void setGrandAxe(double grandAxe) {
        this.grandAxe = grandAxe;
    }
    public double getPetitAxe() {
        return petitAxe;
    }
    public void setPetitAxe(double petitAxe) {
        this.petitAxe = petitAxe;
    }
      @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }
}