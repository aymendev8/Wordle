import javax.swing.*;
import java.awt.*;

public class PanneauInfo extends JPanel {
    public JLabel info ;

    public PanneauInfo(){
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(500,30));
        info = new JLabel("Wordle");
        info.setForeground(Color.green);
        info.setFont(new Font("Verdana",1,15));
        this.add(info);

    }
}
