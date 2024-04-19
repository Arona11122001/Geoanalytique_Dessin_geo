package geoanalytique.util;

import geoanalytique.graphique.GCoordonnee;
import geoanalytique.model.Carre;
import geoanalytique.model.Cercle;
import geoanalytique.model.Droite;
import geoanalytique.model.Ellipse;
import geoanalytique.model.Losange;
import geoanalytique.model.Pentagone;
import geoanalytique.model.Point;
import geoanalytique.model.Rectangle;
import geoanalytique.model.Surface;
import geoanalytique.model.Triangle;
import geoanalytique.model.TriangleIsocele;

public interface GeoObjectVisitor<T> {
    
    T visit(Point point);

    T visit(Droite droite);

    T visit(Surface surface);

    T visit(Ellipse ellipse);

    T visit(Cercle cercle);

    T visit(Rectangle rectangle);

    T visit(Carre rectangle);

    T visit(TriangleIsocele triangle);

    T visit(Pentagone pentagone);

    T visit(Losange losange);

    
}