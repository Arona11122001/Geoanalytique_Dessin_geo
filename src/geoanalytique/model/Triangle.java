package geoanalytique.model;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public class Triangle extends Polygone {
    private Point sommet1;
    private Point sommet2;
    private Point sommet3;
    
    // Constructeur, getters, setters et autres méthodes

    public Triangle(Point p1, Point point, Point p2) {
        //TODO Auto-generated constructor stub
        this.sommet1=p1;
        this.sommet2=point; // Changement ici
        this.sommet3=p2; // Changement ici
        
    }
    public Point getSommet1() {
        return sommet1;
    }
    public Point getSommet2() {
        return sommet2;
    }
    public Point getSommet3() {
        return sommet3;
    }
    @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }
}
