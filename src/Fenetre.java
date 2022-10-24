import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.Locale;

public class Fenetre extends JFrame implements KeyListener {

    public Grille grille;
    private PanneauInfo pi;

    private String mot = Lemot.mot_aleatoire().toUpperCase();
    private int nb_chance ;
    private int position_lettre ;
    private boolean moins_de_5 = true;
    private String lemot = "";

    private boolean jeu_fini = false;


    public Fenetre() throws FileNotFoundException {
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
        System.out.println(mot);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code >= 65 && code <= 90){
            if(moins_de_5 && !jeu_fini)
                if (position_lettre < 5)
                {
                    grille.getLesboutons()[nb_chance][position_lettre].setText(String.valueOf((char) code));
                    position_lettre++;
                }else{moins_de_5 = false;}
        } else if (code == 10) {
            if (nb_chance < 5 ) {
                if (position_lettre == 5) {
                    System.out.println(nb_chance);
                    for (int i = 0; i < 5; i++) {
                        lemot += grille.getLesboutons()[nb_chance][i].getText();
                    }
                    System.out.println(lemot);
                    if (lemot.equals(mot)) {
                        for (int i = 0; i < 5; i++) {
                            if (lemot.charAt(i) == mot.charAt(i)) {
                                grille.getLesboutons()[nb_chance][i].setBackground(Color.green);
                            }
                        }
                        pi.info.setForeground(Color.green);
                        pi.info.setText("Bien joué, tu as trouver le mot !  1 pour rejouer.");
                        jeu_fini = true;
                    } else if (Lemot.mot_exist(lemot.toLowerCase()) && !lemot.equals(mot)) {
                        for (int j = 0; j < 5; j++) {
                            if (mot.indexOf(lemot.charAt(j)) != -1) {
                                grille.getLesboutons()[nb_chance][j].setBackground(Color.orange);
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            if (lemot.charAt(i) == mot.charAt(i)) {
                                grille.getLesboutons()[nb_chance][i].setBackground(Color.green);
                            }
                        }
                        pi.info.setForeground(Color.red);
                        pi.info.setText("Ce n'est pas le bon mot ! ");
                        lemot = "";
                        nb_chance++;
                        position_lettre = 0;
                    } else {
                        if (!jeu_fini)
                            pi.info.setForeground(Color.red);
                            pi.info.setText("Le mot n'existe pas ! ");
                    }
                }
            }else {
                if(nb_chance == 5) {
                    System.out.println(nb_chance);
                    pi.info.setForeground(Color.red);
                    pi.info.setText("Tu as perdu ! le mot était : " + mot.toLowerCase() +" | 1 pour rejouer ");
                    jeu_fini = true;
                }
            }
        } else if (code == 8){
            if(position_lettre > 0)
                position_lettre--;
                moins_de_5=true;
                grille.getLesboutons()[nb_chance][position_lettre].setText("");
                lemot = "";
        } else if (code == 49 && jeu_fini ) {
            System.out.println("nouvelle parti ! ");
            Main.f.dispose();
            Fenetre f;
            try {
                f = new Fenetre();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            f.setVisible(true);
            Main.f = f;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

}

