package meujogo;

import javax.swing.JFrame;
import meujogo.Modelo.Fase;
import meujogo.Modelo.Menu;

public class Container extends JFrame {
    public Container(){
        
        setTitle("Meu Jogo");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// centro 
        this.setResizable(false);// ajuste da janela 
        add(new Fase());
        setVisible(true);
    }

    
    public static void main(String args[]){
        new Menu();
    }
    
}
