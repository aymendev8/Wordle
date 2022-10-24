import java.io.FileNotFoundException;

public class Main {
    public static Fenetre f;
    public static void main(String[] args) throws FileNotFoundException {
        f = new Fenetre();
        f.setVisible(true);
        System.out.println("La fenetre est lancée ");
    }

}
