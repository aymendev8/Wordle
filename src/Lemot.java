import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Lemot {
    public static String mot_aleatoire() throws FileNotFoundException
    {
        File f = new File("./Mots.txt");
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); )
        {
            ++n;
            String line = sc.nextLine();
            if(rand.nextInt(n) == 0)
                result = line;
        }

        return result;
}
    public static boolean mot_exist(String mot){
        String ligne = "";
        File lesmots = new File("./Mots.txt");
        try{
            FileReader fr = new FileReader(lesmots);
            BufferedReader br = new BufferedReader(fr);

            while((ligne= br.readLine()) != null)
            {
                if(ligne.equals(mot))
                    return true;
            }

        }catch(Exception e){e.printStackTrace();}
        return false;
    }
}
