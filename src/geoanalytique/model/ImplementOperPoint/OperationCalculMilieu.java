package geoanalytique.model.ImplementOperPoint;
import java.lang.String;

import geoanalytique.model.Point;

import geoanalytique.util.Operation;


public class OperationCalculMilieu implements Operation {
    private Point point1;
    private Point point2;
    
    public OperationCalculMilieu(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    @Override
    public String getTitle() {
        return "Calculer le milieu de deux points";
    }

    @Override
    public int getArite() {
        return 0; // Pas d'argument nécessaire
    }

    @Override
    public void setArgument(int num, Object o) {
        // Pas d'argument à définir
    }

    @Override
    public Class getClassArgument(int num) {
        return null; // Pas d'argument à définir
    }

    @Override
    public Point calculer() {
        double milieuX = (point1.getAbscisse() + point2.getAbscisse()) / 2;
        double milieuY = (point1.getOrdonnee() + point2.getOrdonnee()) / 2;
        Point milieu = new Point(milieuX, milieuY);
        return milieu;
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null; // Pas d'argument à définir
    }
}

