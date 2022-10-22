import javax.swing.*;
import java.awt.*;

public class Grille extends JPanel {

    private Bouton lesboutons[][];


    public Grille(){
        this.setLayout(new GridLayout(6,5));
        lesboutons = new Bouton[6][5];
        int i,j ;
        Bouton b ;
        for(i = 0; i < 6; i++)
            for(j = 0; j < 5; j++){
                b = new Bouton(i,j,this.lesboutons);
                lesboutons[i][j]= b;
                this.add(b);
            }
    }

    public Bouton[][] getLesboutons() {
        return lesboutons;
    }

}
