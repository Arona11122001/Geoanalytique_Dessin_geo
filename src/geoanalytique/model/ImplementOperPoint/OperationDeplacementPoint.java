package geoanalytique.model.ImplementOperPoint;
import java.lang.String;

import geoanalytique.model.Point;

import geoanalytique.util.Operation;



public class OperationDeplacementPoint implements Operation {
    private Point point;
    private double nouveauX;
    private double nouveauY;
    
    public OperationDeplacementPoint(Point point, double nouveauX, double nouveauY) {
        this.point = point;
        this.nouveauX = nouveauX;
        this.nouveauY = nouveauY;
    }
    
    @Override
    public String getTitle() {
        return "Déplacer le point";
    }

    @Override
    public int getArite() {
        return 2; // Un argument pour la nouvelle abscisse et un autre pour la nouvelle ordonnée
    }

    @Override
    public void setArgument(int num, Object o) {
        if (num == 0) {
            this.nouveauX = (double) o;
        } else if (num == 1) {
            this.nouveauY = (double) o;
        }
    }

    @Override
    public Class getClassArgument(int num) {
        return Double.class;
    }

    @Override
    public Point calculer() {
        point.setAbscisse(nouveauX);
        point.setOrdonnee(nouveauY);
        return point;
    }

    @Override
    public String getDescriptionArgument(int num) {
        if (num == 0) {
            return "Nouvelle abscisse";
        } else if (num == 1) {
            return "Nouvelle ordonnée";
        }
        return null;
    }
}
