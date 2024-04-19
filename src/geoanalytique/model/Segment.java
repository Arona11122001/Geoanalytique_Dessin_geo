package geoanalytique.model;

import geoanalytique.model.Point;
import geoanalytique.model.Droite;

public class Segment extends Droite {
   
    public Segment(Point point1, Point point2) {
        super(point1, point2);
        //TODO Auto-generated constructor stub
    }
    private Point pointDepart;
    private Point pointArrivee;
    
    // Constructeur, getters, setters et autres méthodes
   public Point getPointArrivee() {
       return pointArrivee;
   }
   public void setPointDepart(Point pointDepart) {
       this.pointDepart = pointDepart;
   }
   public Point getPointDepart() {
       return pointDepart;
   }
   public void setPointArrivee(Point pointArrivee) {
       this.pointArrivee = pointArrivee;
   }
public Object getCouleur() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCouleur'");
}
}
