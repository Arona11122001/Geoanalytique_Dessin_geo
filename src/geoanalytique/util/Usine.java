package geoanalytique.util;

import geoanalytique.model.*;

public class Usine {
    

    

public GeoObject produire(Point p1, Point p2, String type) {
    GeoObject obj = null;
   // Color color = new Color(couleur);
   // System.out.println(color);

    double l1 = p2.getAbscisse() - p1.getAbscisse();
    double l2 = p2.getOrdonnee() - p1.getOrdonnee();
    Point p3 = new Point(
        Math.min(p1.getAbscisse(), p2.getAbscisse()),
        Math.min(p1.getOrdonnee(), p2.getOrdonnee())
    );

    switch (type) {
        case "Point":
            obj = new Point(p1.getAbscisse(), p1.getOrdonnee());
            break;
        case "Droite":
            obj = new Droite(p1, p2);
            break;
      
        case "Rectangle":
            obj = new Rectangle(p1,   Math.max(Math.abs(l1), Math.abs(l2)) ,   Math.max(Math.abs(l1), Math.abs(l2)));
            break;
        case "Carre":
            obj = new Carre(
                p3,
                Math.max(Math.abs(l1), Math.abs(l2))
            );
            break;
            case "Pentagone":
            obj = new Pentagone(
                p3,
                Math.max(Math.abs(l1), Math.abs(l2))
            );
            break;
        // case "ELLIPSE":
        //     obj = new Ellipse(
        //         new Point(
        //             (p1.getAbscisse() + p2.getAbscisse()) / 2,
        //             (p1.getY() + p2.getY()) / 2
        //         ),
        //         Math.abs(l1) / 2,
        //         Math.abs(l2) / 2
        //     );
        //     break;
        case "Cercle": 
        System.out.println(p1.getAbscisse() + p2.getAbscisse());
            obj = new Cercle(
                new Point(
                    (p1.getAbscisse() + p2.getAbscisse()) / 2,
                    (p1.getOrdonnee() + p2.getOrdonnee()) / 2
                ),
                Math.max(Math.abs(l1), Math.abs(l2)) / 2
            );
            break;
            case "Triangle":
            obj = new TriangleIsocele(
                p3,
                Math.max(Math.abs(l1), Math.abs(l2))
            );
            break;
        case "Losange":
            obj = new Losange( p3,
            Math.max(Math.abs(l1), Math.abs(l2)));
            break;
        default:
            break;
    }
   // obj.setCouleur(color);
    return obj;
}


}
