package geoanalytique.model;

import java.awt.Graphics;
import java.util.List;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;;

public abstract class Polygone extends Surface {
    private List<Point> points;
    
    // Constructeur, getters, setters et autres méthodes
      @Override
    public Graphique accepter (GeoObjectVisitor <Graphique> visitor )
    {
        return visitor.visit(this);
    }


}
