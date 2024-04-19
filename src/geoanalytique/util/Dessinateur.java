package geoanalytique.util;

import geoanalytique.model.Losange;
import geoanalytique.graphique.*;
import geoanalytique.model.Carre;
import geoanalytique.model.Cercle;
import geoanalytique.model.Droite;
import geoanalytique.model.Ellipse;
import geoanalytique.model.Pentagone;
import geoanalytique.model.Point;
import geoanalytique.model.Rectangle;
import geoanalytique.model.Surface;
import geoanalytique.model.Triangle;
import geoanalytique.model.TriangleIsocele;
import geoanalytique.model.ViewPort;
import geoanalytique.util.*;



public class Dessinateur implements GeoObjectVisitor<Graphique> {

    private ViewPort viewport;
    

    public Dessinateur(ViewPort viewport) { // Constructeur prenant le viewport en paramètre
        this.viewport = viewport;
    }


   // Méthode de visite pour dessiner un point
   @Override
   public GCoordonnee visit(Point point) {
       return viewport.convert(point); // Convertit le point et retourne sa représentation graphique
   }

   // Méthode de visite pour dessiner un cercle
   @Override
   public GOvale visit(Cercle cercle) {
       // Convertit le centre du cercle et calcule le grand axe
       GCoordonnee centre = viewport.convert(cercle.getCentre());
       double grandAxe = cercle.getRayon() * viewport.getEchelle();
       // Crée et retourne un ovale représentant le cercle
       return new GOvale(centre.getX(), centre.getY(), (int) grandAxe, (int) grandAxe);
   }

   // Méthode de visite pour dessiner un carré
   @Override
   public GPolygone visit(Carre carre) {
       // Convertit le centre du carré et calcule la demi-longueur du côté
       GCoordonnee centre = viewport.convert(carre.getCentre());
       double demiLongueur = carre.getLongueurCote() * 0.5 * viewport.getEchelle();
       // Calcule les coordonnées des sommets du carré
       GCoordonnee[] sommets = {
           new GCoordonnee(centre.getX() - demiLongueur, centre.getY() - demiLongueur),
           new GCoordonnee(centre.getX() + demiLongueur, centre.getY() - demiLongueur),
           new GCoordonnee(centre.getX() + demiLongueur, centre.getY() + demiLongueur),
           new GCoordonnee(centre.getX() - demiLongueur, centre.getY() + demiLongueur)
       };
       // Crée et retourne un polygone représentant le carré
       return new GPolygone(sommets);
   }

    @Override
public GPolygone visit(Losange losange) {
    GCoordonnee centre = this.viewport.convert(losange.getCentre());
    double demiLongueur = losange.getLongueurCote() * 0.5 * this.viewport.getEchelle();
    
    // Déterminer les coordonnées des sommets du losange
    GCoordonnee[] sommets = {
        new GCoordonnee(centre.getX() - demiLongueur, centre.getY()), // Sommet gauche
        new GCoordonnee(centre.getX(), centre.getY() - demiLongueur), // Sommet supérieur
        new GCoordonnee(centre.getX() + demiLongueur, centre.getY()), // Sommet droit
        new GCoordonnee(centre.getX(), centre.getY() + demiLongueur) // Sommet inférieur
    };
    
    return new GPolygone(sommets);
}


    // @Override
    // public GPolygone visit(Pentagone pentagone) {
    //     GCoordonnee[] sommets = new GCoordonnee[3];
    //     sommets[0] = this.viewport.convert(pentagone.getSommet1());
    //     sommets[1] = this.viewport.convert(pentagone.getSommet2());
    //     sommets[2] = this.viewport.convert(pentagone.getSommet3());
    
    //     return new GPolygone(sommets);
    // }
    
    
    @Override
    public GPolygone visit(Rectangle rectangle) {
        GCoordonnee centre = this.viewport.convert(rectangle.getCentre());
        double demiLargeur = rectangle.getLargeur() * 0.5 * this.viewport.getEchelle();
        double demiHauteur = rectangle.getLongueur() * 0.75 * this.viewport.getEchelle();
    
        // Déterminer les coordonnées des sommets du rectangle
        GCoordonnee[] sommets = {
            new GCoordonnee(centre.getX() - demiLargeur, centre.getY() - demiHauteur),
            new GCoordonnee(centre.getX() + demiLargeur, centre.getY() - demiHauteur),
            new GCoordonnee(centre.getX() + demiLargeur, centre.getY() + demiHauteur),
            new GCoordonnee(centre.getX() - demiLargeur, centre.getY() + demiHauteur)
        };
    
        return new GPolygone(sommets);
    }
    
    @Override
    public GPolygone visit(TriangleIsocele triangle) {
    GCoordonnee centre = this.viewport.convert(triangle.getCentre());
    double demiBase = triangle.getBase() * 0.75 * this.viewport.getEchelle(); // Demi-base
    double hauteur = triangle.getBase() * 0.75 * this.viewport.getEchelle(); // Hauteur du triangle

    // Calcul des coordonnées des sommets
    GCoordonnee[] sommets = {
        new GCoordonnee(centre.getX() - demiBase, centre.getY() + hauteur), // Sommet gauche
        new GCoordonnee(centre.getX() + demiBase, centre.getY() + hauteur), // Sommet droit
        new GCoordonnee(centre.getX(), centre.getY() - hauteur) // Sommet supérieur (le sommet est au centre)
    };

    return new GPolygone(sommets);
}

@Override
public GPolygone visit(Pentagone pentagone) {
    GCoordonnee centre = this.viewport.convert(pentagone.getCentre());
    double demiCote = pentagone.getLongueurCote() * 0.75 * this.viewport.getEchelle(); // Demi-côté du pentagone

    // Calcul des coordonnées des sommets du pentagone régulier
    GCoordonnee[] sommets = new GCoordonnee[5];
    for (int i = 0; i < 5; i++) {
        double angle = Math.toRadians(90 + i * 72); // Angle entre chaque sommet du pentagone régulier
        double x = centre.getX() + demiCote * Math.cos(angle);
        double y = centre.getY() + demiCote * Math.sin(angle);
        sommets[i] = new GCoordonnee(x, y);
    }

    return new GPolygone(sommets);
}


    @Override
    public GLigne visit(Droite droite) {
        GCoordonnee startPoint = this.viewport.convert(droite.getPoint1());
        GCoordonnee endPoint = this.viewport.convert(droite.getPoint2());
        return new GLigne(startPoint, endPoint);
    }

    // @Override
    // public GLigne visit(Carre carre) {
    //     GCoordonnee startPoint = this.viewport.convert(carre.getCentre());
        
    //     G
       
    //     return new GLigne(startPoint, endPoint);
    // }

    // @Override
    // public GLigne visit(Rectangle re) {
    //     GCoordonnee startPoint = this.viewport.convert(droite.getPoint1());
    //     GCoordonnee endPoint = this.viewport.convert(droite.getPoint2());
    //     return new GLigne(startPoint, endPoint);
    // }

   

    @Override
    public Graphique visit(Ellipse ellipse) {
        // Point center = ellipse.getCentre();
        // double semiMajorAxis = ellipse.getGrandAxe();
        // double semiMinorAxis = ellipse.getPetitAxe();
        // Point screenCenter = viewport.convertToScreen(center);
        // double scaledSemiMajorAxis = viewport.getEchelle() * semiMajorAxis;
        // double scaledSemiMinorAxis = viewport.getEchelle() * semiMinorAxis;
       // return new GOvale(screenCenter.getAbscisse() - scaledSemiMajorAxis, screenCenter.getOrdonnee() - scaledSemiMinorAxis, 2 * scaledSemiMajorAxis, 2 * scaledSemiMinorAxis);
       return null;
    }

    @Override
    public Graphique visit(Surface surface) {
        // Pour l'instant, nous ne disposons pas d'informations suffisantes pour dessiner une surface spécifique
        // Vous pouvez implémenter cette méthode en fonction de la logique spécifique de votre application
        return null;
    }
}
