import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame implements KeyListener {

    public Grille grille;
    private PanneauInfo pi;

    private String mot;
    private int nb_chance ;
    private int position_lettre ;
    private boolean moins_de_5 = true;
    private String lemot = "";

    public Fenetre(){
        this.setTitle("Wordle");
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        grille = new Grille();
        this.add(grille,BorderLayout.CENTER);
        EcouteurFenetre ef = new EcouteurFenetre();
        this.addWindowListener(ef);
        pi = new PanneauInfo();
        this.add(pi,BorderLayout.NORTH);
        this.addKeyListener(this);
        this.repaint();
        this.revalidate();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code >= 65 && code <= 90){
            if(moins_de_5)
                if (position_lettre < 5 )
                {
                    grille.getLesboutons()[nb_chance][position_lettre].setText(String.valueOf((char) code));
                    position_lettre++;
                }else{moins_de_5 = false;}
        } else if (code == 10) {
            if (nb_chance < 6 )
                if (position_lettre == 5){

                    for(int i = 0; i<5;i++){
                        lemot += grille.getLesboutons()[nb_chance][i].getText();
                    }
                    nb_chance++;
                    System.out.println(lemot);

                }
        } else if (code == 8){
            if(position_lettre > 0)
                position_lettre--;
                moins_de_5=true;
                grille.getLesboutons()[nb_chance][position_lettre].setText("");

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
