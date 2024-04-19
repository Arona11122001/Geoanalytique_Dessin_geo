package geoanalytique.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GeoAnalytiqueGui extends JFrame {
    private DessinPanel dessinPanel;

    public GeoAnalytiqueGui() {
        super("GeoAnalytiqueGui");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dessinPanel = new DessinPanel();
        getContentPane().add(dessinPanel, BorderLayout.CENTER);

        JPanel boutonPanel = new JPanel();
        JButton boutonLigne = new JButton("Droite");
        JButton boutonSegment = new JButton("Segment");
        JButton boutonCercle = new JButton("Cercle");
        JButton boutonCarre = new JButton("Carre");
        JButton boutonRectangle = new JButton("Rectangle");
        JButton boutonTriangle = new JButton("Triangle");

        boutonLigne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DessinPanel) dessinPanel).ajouterForme("ligne");
            }
        });

        boutonSegment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DessinPanel) dessinPanel).ajouterForme("segment");
            }
        });

        boutonCercle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DessinPanel) dessinPanel).ajouterForme("cercle");
            }
        });

        boutonCarre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DessinPanel) dessinPanel).ajouterForme("Carre");
            }
        });

        boutonRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DessinPanel) dessinPanel).ajouterForme("Rectangle");
            }
        });

        boutonTriangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DessinPanel) dessinPanel).ajouterForme("Triangle");
            }
        });

        boutonPanel.add(boutonLigne);
        boutonPanel.add(boutonSegment);
        boutonPanel.add(boutonCercle);
        boutonPanel.add(boutonCarre);
        boutonPanel.add(boutonRectangle);
        boutonPanel.add(boutonTriangle);
        getContentPane().add(boutonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        GeoAnalytiqueGui gui = new GeoAnalytiqueGui();
        gui.setVisible(true);
    }
}

class DessinPanel extends JPanel {
    private ArrayList<Forme> formes = new ArrayList<>();
    private Random random = new Random();

    public void ajouterForme(String type) {
        int x = random.nextInt(getWidth());
        int y = random.nextInt(getHeight());
        formes.add(new Forme(type, x, y));
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner le repère orthonormé
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

        for (Forme forme : formes) {
            if (forme.type.equals("ligne")) {
                g.drawLine(forme.x, forme.y, forme.x + 400, forme.y + 400);
            } else if (forme.type.equals("segment")) {
                g.drawLine(forme.x, forme.y, forme.x + 200, forme.y + 200);
            } else if (forme.type.equals("cercle")) {
                g.drawOval(forme.x, forme.y, 400, 400);
            }
        }
    }
}

class Forme {
    String type;
    int x, y;

    public Forme(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
}
}