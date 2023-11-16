import javax.swing.JFrame;

public class Container extends JFrame{

    public Container(){
        add(new Fase1());
        setTitle("Joguinho");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
}