package meujogo.Modelo;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fundo extends JPanel {

    private BufferedImage fundo;

    private boolean stretched = true;

    public BufferedImage getFundo() {
        return fundo;
    }

    public void setFundo(BufferedImage fundo) {
        this.fundo = fundo;
    }

    public boolean isStretched() {
        return stretched;
    }

    public void setStretched(boolean stretched) {
        this.stretched = stretched;
    }

    public Fundo() {
        super();
    }

    public Fundo (String urlImg) {
        File file = new File(urlImg);
        try {
            setFundo(ImageIO.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        if (fundo != null) {
            g.drawImage(fundo, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
    
    protected void graphics(Graphics g) {
        if (fundo == null) {
            super.paintComponent(g);
            return;
        }
        int w = getWidth();
        int h = getHeight();
        if (stretched) {
            g.drawImage(fundo, 0, 0, w, h, this);
            return;
        }
        int iw = fundo.getWidth();
        int ih = fundo.getHeight();
        int colunas = w / iw;
        int linhas = h / ih;
        if (colunas * iw < w) {
            colunas++;
        }
        if (linhas * ih < h) {
            linhas++;
        }
        int offsetX = 0;
        for (int i = 0; i < linhas; i++) {
            int y = i * ih;
            if (y > h) {
                break;
            }
            for (int j = 0; j < colunas; j++) {
                int x = j * iw + offsetX;
                if (j == 0 && x > 0) {
                    g.drawImage(fundo, -(iw - x), y, iw, ih, this);
                }
                if (j == colunas - 1 && x < w) {
                    g.drawImage(fundo, x + iw, y, iw, ih, this);
                }
                if (x > w) {
                    break;
                }
                if (x < -iw) {
                    break;
                }
                g.drawImage(fundo, x, y, iw, ih, this);
            }
        }
    }


}
