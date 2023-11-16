import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro {
    private Image imagemTiro;
    private int x, y;
    private int largura, altura;
    private boolean visible;
    public static final int ALTURA = 700;
    public static int VELOCIDADE = 2;

    public Tiro(int x, int y){
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    public void loadTiro(){
        ImageIcon imageTiro = new ImageIcon("recursos\\balas.png");
        imagemTiro = imageTiro.getImage();

        this.largura = imagemTiro.getWidth(null);
        this.altura = imagemTiro.getHeight(null);
    }

    public void updateTiro(){
        this.y -= VELOCIDADE;
        if(this.y > ALTURA){
            visible = false;
        }
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public Image getImagemTiro() {
        return imagemTiro;
    }

    public void setImagemTiro(Image imagemTiro) {
        this.imagemTiro = imagemTiro;
    }

}
