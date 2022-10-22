import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private Grille grille;
    public Fenetre(){
        this.setTitle("Wordle");
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        EcouteurFenetre ef = new EcouteurFenetre();
        this.addWindowListener(ef);
        grille = new Grille();
        this.add(grille,BorderLayout.CENTER);
    }
}
