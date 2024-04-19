package geoanalytique.controleur;

import geoanalytique.graphique.GCoordonnee;
import geoanalytique.graphique.Graphique;
import geoanalytique.model.Droite;
import geoanalytique.view.GeoAnalytiqueView;
import geoanalytique.model.GeoObject;
import geoanalytique.model.Point;
import geoanalytique.util.Dessinateur;
import geoanalytique.model.ViewPort;
import geoanalytique.util.Usine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;


public class GeoAnalytiqueControleur implements MouseListener {

    private ArrayList<GeoObject> objects = new ArrayList<GeoObject>();
    private Object selectedObject;
    private GeoAnalytiqueView vue;
    String figureSelectionnee ; 
   
    Dessinateur dessinateur ;
    ViewPort viewport ;
    GCoordonnee g1,g2 ;

    public GeoAnalytiqueControleur(GeoAnalytiqueView vue) {
        this.vue = vue;
        viewport=new ViewPort(vue.getWidth(), vue.getHeight());
         dessinateur = new Dessinateur(viewport);
         vue.addDeleteButtonListener(e -> {
            // Supprimer tous les objets géométriques
            objects.clear();
            // Recalculer et rafraîchir les points
           
        });
        for (JButton button  :  this.vue.getListeButtons()) {
            button.addActionListener(e->{
                JButton b = (JButton) e.getSource() ; 
                figureSelectionnee = b.getText(); 
            });
        }
       

    }
    public void recalculPoints() {
        vue.clear();
        // Parcourir tous les objets géométriques
        for (GeoObject obj : objects) {
            if (obj != null) { // Vérifier si l'objet n'est pas null
                // Appeler la méthode accepter de l'objet avec le dessinateur
                Graphique graphique = obj.accepter(dessinateur);
                if (graphique != null) {
                    vue.ajouterGraphique(graphique); // Ajouter le graphique à la liste
                }
            }
        }
    
        // Demander à la vue de redessiner les graphiques
        vue.repaint();
    }
    
    
    

    Usine usine = new Usine() ;

    public void addObjet(GCoordonnee g1, GCoordonnee g2) {
      //  vue.clear();
        
        Point p1 = viewport.convert(g1);
        Point p2 = viewport.convert(g2);
         
            objects.add(
                usine.produire(p1, p2, figureSelectionnee)
            );

        System.out.println(figureSelectionnee);
    

    }


    public void selectionner(GeoObject obj) {
        if (objects.contains(obj)) {
            selectedObject = obj;
            vue.updateSelection(obj); // Mettre à jour la vue avec l'objet sélectionné
        }
    }

    public void deselectionner() {
        if (selectedObject != null) {
            selectedObject = null;
            vue.clearSelection(); // Effacer la sélection dans la vue
        }
    }





    @Override
public void mouseClicked(MouseEvent e) {
   
}




    @Override
    public void mousePressed(MouseEvent e) {
          // Enregistrer les coordonnées de la souris lorsque le bouton est enfoncé
        g1 = new GCoordonnee(e.getX(), e.getY());
    }

    /**
     * Permet de recuperer les cordoonnées de la souris relachée
     * @param e Evenement souris
     */
    @Override
    public void mouseReleased(MouseEvent e) {
         // Enregistrer les coordonnées de la souris lorsque le bouton est relâché
        g2 = new GCoordonnee(e.getX(), e.getY());
        
        addObjet(g1,g2);   // Ajouter l'objet géométrique correspondant aux coordonnées

        recalculPoints();  // Recalculer et rafraîchir les points
}


@Override
public void mouseEntered(MouseEvent e) {
    // Rien à faire ici pour le moment
}

@Override
public void mouseExited(MouseEvent e) {
    // Rien à faire ici pour le moment
}


    // Dans la classe GeoAnalytiqueControleur
    
    
//implemnter listeneur
//impl dessinateur
//impl viewport



    // Autres méthodes du contrôleur
    
   // public void recalculPoints() {
        //parcourir GeoObject 
        // obObject.accepter(Dessinateur): renvoit graphique
        // recupere Graphique et donne au vue
        //sortie boucle et demander a graphique de tout redessiner 
    //}

    // public void onDrawButtonClicked() {
    //     // Logique pour gérer l'événement du bouton "Dessiner"
    //     // Par exemple :
    //     // Ajouter un objet factice
    // }

    // public void onMoveButtonClicked() {
    //     // Logique pour gérer l'événement du bouton "Droite"
    //     // Par exemple :
    //     if (selectedObject != null) {
    //         // Déplacer l'objet sélectionné
    //     }
    // }

    // public void onDeleteButtonClicked() {
    //     // Logique pour gérer l'événement du bouton "Supprimer"
    //     // Par exemple :
    //     if (selectedObject != null) {
    //         objects.remove(selectedObject); // Supprimer l'objet sélectionné
    //         deselectionner(); // Désélectionner l'objet
    //         vue.refresh(); // Rafraîchir la vue
    //     }
    // }

    

    // public void addObjet(GCoordonnee g1, GCoordonnee g2) {
        
    //     if (figureSelectionnee.equals("Point")) {
    //         objects.add(
    //             viewport.convert(g1)
    //         );

    //     }
        
    

    // }

}
