import javax.swing.*;
import java.awt.*;

public class Bouton extends JButton {

    private Color sacouleur;
    private int saligne;
    private int sacolonne;

    private Bouton[][] tableau;

    public Bouton(int a, int b, Bouton[][] t ){
        sacouleur = Color.gray;
        saligne = a;
        sacolonne = b;
        tableau = t ;
    }

    public Color getSacouleur() {
        return sacouleur;
    }

    public void setSacouleur(Color sacouleur) {
        this.sacouleur = sacouleur;
    }

    public int getSaligne() {
        return saligne;
    }

    public int getSacolonne() {
        return sacolonne;
    }
}
