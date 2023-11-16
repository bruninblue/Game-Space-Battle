import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
public class Nave1 {
    
    private int x,y;
    private int dx, dy;
    private Image nave1;
    private int altura, largura;
    private List<Tiro> tiros;

    public Nave1(){
        this.x = 600;
        this.y = 550;

        tiros = new ArrayList<Tiro>();
    }
    
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDx() {
        return this.dx;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public int getDy() {
        return this.dy;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
    public int getAltura() {
        return this.altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getLargura() {
        return this.largura;
    }
    public void setLargura(int largura) {
        this.largura = largura;
    }
    public Image getNave1() {
        return this.nave1;
    }
    public void setNave1(Image nave1) {
        this.nave1 = nave1;
    }
    public List<Tiro> getTiros() {
        return tiros;
    }
    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }
    

    public void loadNave1(){
        ImageIcon imageNave1 = new ImageIcon("recursos\\nave_1.png");
        nave1 = imageNave1.getImage();

        this.altura = nave1.getHeight(null);
        this.largura = nave1.getWidth(null);
    }

    public void updateNave1(){
        x += dx;
        y += dy;
    }

    public void tiro(){
        this.tiros.add(new Tiro(this.getX()+(this.getAltura()/2), this.getY()));
    }

    public void keyPressed(KeyEvent teclado){
        int tecla = teclado.getKeyCode();

        if(tecla == KeyEvent.VK_T){
            tiro();
        }

        if(tecla == KeyEvent.VK_W){
            dy = -3;
        }
        if(tecla == KeyEvent.VK_S){
            dy = 3;
        }
        if(tecla == KeyEvent.VK_A){
            dx = -3;

        }
        if(tecla == KeyEvent.VK_D){
            dx = 3;
        }
    }

    public void keyReleased(KeyEvent teclado){
        int tecla = teclado.getKeyCode();

        if(tecla == KeyEvent.VK_W){
            dy = 0;
        }
        if(tecla == KeyEvent.VK_S){
            dy = 0;
        }
        if(tecla == KeyEvent.VK_A){
            dx = 0;

        }
        if(tecla == KeyEvent.VK_D){
            dx = 0;
        }
    }
}
