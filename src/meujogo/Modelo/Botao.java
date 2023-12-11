package meujogo.Modelo;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseEvent;

public class Botao extends JButton{

    private BufferedImage backgroundButton;

    private BufferedImage bufferedImageSelected;

    private boolean stretched = true;

    private boolean hover = false;

    public BufferedImage getBackgroundButton() {
        return backgroundButton;
    }

    public void setBackgroundButton(BufferedImage backgroundButton) {
        this.backgroundButton = backgroundButton;
    }

    public BufferedImage getBufferedImageSelected() {
        return bufferedImageSelected;
    }

    public void setBufferedImageSelected(BufferedImage bufferedImageSelected) {
        this.bufferedImageSelected = bufferedImageSelected;
    }  

    public boolean isStretched() {
        return stretched;
    }

    public void setStretched(boolean stretched) {
        this.stretched = stretched;
    }


    public Botao() {
        super();
    }

     public Botao (String urlImg) {
        File file = new File(urlImg);
        try {
            setBackgroundButton(ImageIO.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIcon(new ImageIcon(urlImg));
    }

     public Botao (String urlImgNormal, String urlImgSelected) {
        File file = new File(urlImgNormal);
        File fileSelected = new File(urlImgSelected);
        try {
            setBackgroundButton(ImageIO.read(file));
            setBufferedImageSelected(ImageIO.read(fileSelected));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mudando para o cursor de mão
                repaint(); // Solicita uma nova pintura quando o mouse entra
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint(); // Solicita uma nova pintura quando o mouse sai
                setCursor(Cursor.getDefaultCursor()); // Restaurando o cursor padrão
            }
        });
        //setIcon(new ImageIcon(urlImgNormal));
    }
    


    @Override
    public void paintComponent(Graphics g) {  
 
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
        double scaleX;
        double scaleY;
        if (hover) {
             scaleX = getWidth() / (double) bufferedImageSelected.getWidth(null);  
            scaleY = getHeight() / (double) bufferedImageSelected.getHeight(null);  
            AffineTransform xform = AffineTransform.getScaleInstance(scaleX, scaleY);  
            ((Graphics2D) g).drawImage(bufferedImageSelected, xform, this); 
        } else {
            scaleX = getWidth() / (double) backgroundButton.getWidth(null);  
            scaleY = getHeight() / (double) backgroundButton.getHeight(null);  
            AffineTransform xform = AffineTransform.getScaleInstance(scaleX, scaleY);  
            ((Graphics2D) g).drawImage(backgroundButton, xform, this); 
        }
    }
}
