package geoanalytique.view;

import javax.swing.*;

import geoanalytique.controleur.GeoAnalytiqueControleur;
import geoanalytique.graphique.Graphique;
import geoanalytique.model.GeoObject;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GeoAnalytiqueView extends JPanel {

    private JButton drawButton;
    private JButton moveButton;
    private JButton deleteButton;
    private ArrayList<JButton> listeButtons;

    private JLabel statusLabel; // Label to display selection status
    List<Graphique> graphiques = new ArrayList<>();

    public ArrayList<JButton> getListeButtons() {
        return listeButtons;
    }

    public GeoAnalytiqueView() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 400)); // Augmentation de la largeur pour inclure le repère

        drawButton = new JButton("Dessiner");
        moveButton = new JButton("Déplacer");
        deleteButton = new JButton("Supprimer");

        JPanel controlPanel = new JPanel();
        controlPanel.add(drawButton);
        controlPanel.add(moveButton);
        controlPanel.add(deleteButton);

        // statusLabel = new JLabel("Aucun objet sélectionné.");
        // controlPanel.add(statusLabel);




        setLayout(new BorderLayout());
        // liste des boutons pour les GeoObjects
        listeButtons = new ArrayList<JButton>() ; 
        listeButtons.add(new JButton("Point"));
        listeButtons.add(new JButton("Droite"));
        listeButtons.add(new JButton("Cercle")); 
        listeButtons.add(new JButton("Triangle"));
        listeButtons.add(new JButton("Rectangle"));
        listeButtons.add(new JButton("Carre")); 
        listeButtons.add(new JButton("Pentagone")); 
        listeButtons.add(new JButton("Losange")); 

        for (JButton button : listeButtons) {
            controlPanel.add(button);
        }

        add(controlPanel, BorderLayout.SOUTH);
    }

    public void deleteLastGraphique() {
        if (!graphiques.isEmpty()) {
            graphiques.remove(graphiques.size() - 1);
            repaint(); // Rafraîchir la vue pour refléter les changements
        }
    }
    
    public void deleteAllGraphiques() {
        graphiques.clear();
        repaint(); // Rafraîchir la vue pour refléter les changements
    }
    
    
   


    public void addDrawButtonListener(ActionListener listener) {
        drawButton.addActionListener(listener);
    }

    public void addMoveButtonListener(ActionListener listener) {
        moveButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(e -> {
            // Appeler la méthode pour supprimer tous les graphiques
            clear();
            // Rafraîchir la vue
            refresh();
        });
    }

    public void updateSelection(Object obj) {
        statusLabel.setText("Objet sélectionné: " + obj.toString());
    }

    public void clearSelection() {
        statusLabel.setText("Aucun objet sélectionné.");
    }

    public void refresh() {
        revalidate();
        repaint();
    }

    

   public void paint(Graphics g) {
    super.paint(g);

    // Dessiner le repère
    int centerX = getWidth() / 2; // Calcul du centre horizontal de la vue
    int centerY = getHeight() / 2; // Calcul du centre vertical de la vue
    
    // Définir les couleurs pour les axes et les graduations
    g.setColor(Color.RED);
    g.drawLine(centerX, 0, centerX, getHeight()); // Axe des ordonnées
    g.drawLine(0, centerY, getWidth(), centerY); // Axe des abscisses

    // Dessiner les graduations sur l'axe des ordonnées
    for (int y = centerY - 50; y >= 0; y -= 50) {
        g.drawLine(centerX - 5, y, centerX + 5, y); // Graduation
        g.drawString(String.valueOf((centerY - y) / 50), centerX + 10, y + 5); // Valeur de la graduation
    }
    for (int y = centerY + 50; y <= getHeight(); y += 50) {
        g.drawLine(centerX - 5, y, centerX + 5, y); // Graduation
        g.drawString(String.valueOf((centerY - y) / 50), centerX + 10, y + 5); // Valeur de la graduation
    }

    // Dessiner les graduations sur l'axe des abscisses
   // Graduations pour les abscisses (X)
   for (int x = centerX - 50; x >= 0; x -= 50) {
    // Graduation
    g.drawLine(x, centerY - 5, x, centerY + 5); // Graduation
    g.drawString(String.valueOf((x - centerX) / 50), x - 10, centerY + 20);  // Valeur de la graduation
}
for (int x = centerX + 50; x <= getWidth(); x += 50) {
    g.drawLine(x, centerY - 5, x, centerY + 5); // Graduation
    g.drawString(String.valueOf((x - centerX) / 50), x - 10, centerY + 20); // Valeur de la graduation
}


    // Dessiner les objets graphiques
    for (Graphique obj : graphiques) {
        obj.dessiner(g);
    }

   }
    public void ajouterGraphique(Graphique graphique){
        graphiques.add(graphique);
    }

    public void clear() {
        graphiques.clear(); // Vide la liste des graphiques
    }

   

    // public static void main(String[] args) {
    
    //     JFrame frame = new JFrame("GeoAnalytique");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(800, 600);
    //     frame.setLocationRelativeTo(null);

    //     GeoAnalytiqueView view = new GeoAnalytiqueView();
    //     frame.getContentPane().add(view, BorderLayout.CENTER);

    //     GeoAnalytiqueControleur controleur = new GeoAnalytiqueControleur(view);
    //     view.addMouseListener(controleur);

    //     frame.setVisible(true);
    // };
}




