package meujogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FimJogo extends JPanel{

    private Image imagemFimJogo;
    
    public FimJogo(){
        //setTitle("Fim jogo");
        setSize(1024,728);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);// centro 
        //this.setResizable(false);// ajuste da janela 
        //setVisible(true);

        ImageIcon referencia = new ImageIcon("res//fimdejogo.jpg");
        imagemFimJogo = referencia.getImage();

    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(imagemFimJogo, 0, 0, null);

        g.dispose();
    }
}
