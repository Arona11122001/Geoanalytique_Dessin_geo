package geoanalytique.model.ImplementOperPoint;
import java.lang.String;

import geoanalytique.model.Point;

import geoanalytique.util.Operation;

public class OperationCalculDistance implements Operation {
    private Point point1;
    private Point point2;
    
    public OperationCalculDistance(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    @Override
    public String getTitle() {
        return "Calculer la distance entre deux points";
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
    public Double calculer() {
        double distance = Math.sqrt(Math.pow(point2.getAbscisse() - point1.getAbscisse(), 2) +
                                     Math.pow(point2.getOrdonnee() - point1.getOrdonnee(), 2));
        return distance;
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null; // Pas d'argument à définir
    }
}

