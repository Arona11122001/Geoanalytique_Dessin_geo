package geoanalytique.graphique;

import java.awt.*;

public class GCoordonnee extends Graphique {
    private double x;
    private double y;
    

    public GCoordonnee(double x, double y) {
        this.x = x;
        this.y = y;
    }
    

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
     public void dessiner(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int)x - 4,(int)y - 4,8,8);
     }
}
