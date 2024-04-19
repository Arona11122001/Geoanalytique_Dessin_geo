package geoanalytique.model;

import java.awt.Graphics;

import geoanalytique.graphique.Graphique;
import geoanalytique.util.GeoObjectVisitor;

public abstract class GeoObject  {
    // Attributs et méthodes communs à tous les objets géométriques

    public abstract Graphique  accepter(GeoObjectVisitor <Graphique> visitor);
    

   
}
