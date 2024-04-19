package geoanalytique.graphique;

import java.awt.*;

public abstract class Graphique {

    /**
     * Méthode abstraite pour dessiner le graphique sur le contexte graphique spécifié.
     * @param g2d Le contexte graphique sur lequel dessiner.
     */
    public abstract void dessiner(Graphics g2d);

    // Vous pouvez ajouter d'autres méthodes et attributs communs à tous les graphiques ici
}
