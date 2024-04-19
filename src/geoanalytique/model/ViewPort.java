package geoanalytique.model;

import geoanalytique.graphique.GCoordonnee;
import geoanalytique.graphique.GLigne;
import geoanalytique.graphique.GOvale;
import geoanalytique.model.Cercle;
import geoanalytique.model.Point;
import geoanalytique.model.Segment;

public class ViewPort {
    private double echelle;  //echelle 
    private double Xmax;
    private double Ymax;
    private double Xmin;
    private double Ymin;

    public ViewPort(double largeur, double hauteur) {  // constructeur avec 2 parametres 
        this.echelle = 20;
        this.Xmax = largeur/2;
        this.Ymax = hauteur/2;
        this.Xmin = -Xmax;
        this.Ymin = -Ymax;
    }

    public double getXmax() {
        return Xmax;
    }
    public void setXmax(double xmax) {
        Xmax = xmax;
    }
    public double getXmin() {
        return Xmin;
    }
    public void setXmin(double xmin) {
        Xmin = xmin;
    }
    public double getYmax() {
        return Ymax;
    }
    public void setYmax(double ymax) {
        Ymax = ymax;
    }
    public double getYmin() {
        return Ymin;
    }
    public void setYmin(double ymin) {
        Ymin = ymin;
    }
    public double getEchelle() {
        return echelle;
    }
    public void setEchelle(double echelle) {
        this.echelle = echelle;
    }

    // public GLigne convert(GCoordonnee point1, GCoordonnee point2 ) {
        
    //         // double x = s.getpoint1().getAbscisse();
    //         // double x2 = s.getpoint1().getOrdonnee(); 
    //         // double y = s.getpoint2().getAbscisse();
    //         // double y2 = s.getpoint2().getOrdonnee();                          
              
    //           return null ;
    //  }

    //  public GLigne convert(Segment s) {
    //     GCoordonnee coordonneeDepart = convert(s.getPointDepart());
    //     GCoordonnee coordonneeArrivee = convert(s.getPointArrivee());
    //     return new GLigne(coordonneeDepart.getX(), coordonneeDepart.getY(), coordonneeArrivee.getX(), coordonneeArrivee.getY());
    // }

    
    // public Segment convert(GLigne ligne) {
    //     // Convertir les coordonnées de la ligne
    //     Point point1 = convert(ligne.getPointDepart());
    //     Point point2 = convert(ligne.getPointArrivee());

    //     // Créer un nouvel objet Droite avec les points convertis
    //     return new Segment(point1, point2);
    // }

    // public GOvale convert(Cercle c) {
    //     GCoordonnee coordonneeCentre = convert(c.getCentre());
    //     double rayon = c.getRayon() * echelle;
    //     return new GOvale(coordonneeCentre.getX() - rayon, coordonneeCentre.getY() - rayon, 2 * rayon, 2 * rayon);
    // }
    

     // Méthode pour convertir une coordonnée graphique en coordonnée du viewport
     public GCoordonnee convert(Point point) {
        double x = (point.getAbscisse() * this.echelle + this.Xmax); // Conversion de l'abscisse
        double y = (this.Ymax - point.getOrdonnee() * this.echelle); // Conversion de l'ordonnée
        return new GCoordonnee(x, y); // Retourne la nouvelle coordonnée convertie
    } 

    // Méthode pour convertir une coordonnée du viewport en coordonnée graphique
    public Point convert(GCoordonnee coordonnee) {
        double x = (coordonnee.getX() - this.Xmax) / this.echelle; // Conversion de l'abscisse
        double y = (this.Ymax - coordonnee.getY()) / this.echelle; // Conversion de l'ordonnée
        return new Point(x, y); // Retourne le nouveau point converti
    } 

    // public GOvale convert(Cercle cercle) {
    //     // Convertir le centre du cercle
    //     Point centre = cercle.getCentre();
    //     double rayon = cercle.getRayon() * echelle;

    //     // Calculer les coordonnées du coin supérieur gauche du rectangle englobant
    //     double x = centre.getAbscisse() - rayon;
    //     double y = centre.getOrdonnee() - rayon;

    //     // Créer un nouvel objet GOvale représentant le cercle
    //     return new GOvale(x, y, 2 * rayon, 2 * rayon);
    // }

    // public Cercle convert(GOvale ovale) {
    //     // Convertir le centre du cercle
    //     Point centre = new Point(
    //         ovale.getX() + ovale.getLargeur() / 2,
    //         ovale.getY() + ovale.getHauteur() / 2
    //     );

    //     // Calculer le rayon du cercle
    //     double rayon = ovale.getLargeur() / 2;

    //     // Créer un nouvel objet Cercle avec les coordonnées du centre et le rayon
    //     return new Cercle(centre, rayon);
    // }



    // public Segment convert(GLigne l) {
    //     GCoordonnee coordonneeDepart = new GCoordonnee(l.getpoint1().getAbscisse(), l.getY1());
    //     GCoordonnee coordonneeArrivee = new GCoordonnee(l.getX2(), l.getY2());
    //     Point pointDepart = convert(coordonneeDepart);
    //     Point pointArrivee = convert(coordonneeArrivee);
    //     return new Segment(pointDepart, pointArrivee);
    // }
    
    

    
}