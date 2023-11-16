import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Fase1 extends JPanel implements ActionListener{

    private Image fundo1;
    private Nave1 nave1;
    private Timer timer;

    public Fase1(){
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon imageFase1 = new ImageIcon("recursos\\fundo_1.png");
        fundo1 = imageFase1.getImage();

        nave1 = new Nave1();
        nave1.loadNave1();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo1, 0, 0, null);
        graficos.drawImage(nave1.getNave1(), nave1.getX(), nave1.getY(), this);

        List<Tiro> tiros = nave1.getTiros();
        for(int i = 0; i< tiros.size(); i++){
            Tiro tiro = tiros.get(i);
            tiro.loadTiro();
            graficos.drawImage(tiro.getImagemTiro(), tiro.getX(), tiro.getY(), this);
        }

        g.dispose();
    }

    public void actionPerformed(ActionEvent e){
        nave1.updateNave1();
        List<Tiro> tiros = nave1.getTiros();
        for(int i = 0; i< tiros.size(); i++){
            Tiro tiro = tiros.get(i);
            if(tiro.isVisible()){
                tiro.updateTiro();
            }else{
                tiros.remove(i);
            }
        }
        repaint();
    }

    private class TecladoAdapter extends KeyAdapter{
    
        @Override
        public void keyPressed(KeyEvent e){
            nave1.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            nave1.keyReleased(e);
        }
    }
    
}
