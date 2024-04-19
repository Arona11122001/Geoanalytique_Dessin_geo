package geoanalytique;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import geoanalytique.controleur.GeoAnalytiqueControleur;
import geoanalytique.view.GeoAnalytiqueView;

public class Main {
     public static void main(String[] args) {
    
        JFrame frame = new JFrame("GeoAnalytique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        GeoAnalytiqueView view = new GeoAnalytiqueView();
        frame.getContentPane().add(view, BorderLayout.CENTER);

        GeoAnalytiqueControleur controleur = new GeoAnalytiqueControleur(view);
        view.addMouseListener(controleur);

        frame.setVisible(true);
    };
}
