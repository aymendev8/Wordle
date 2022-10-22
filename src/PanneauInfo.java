import javax.swing.*;
import java.awt.*;

public class PanneauInfo extends JPanel {
    private String info ;

    public PanneauInfo(){
        this.info = "Wordle";
        this.setBackground(Color.cyan);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
