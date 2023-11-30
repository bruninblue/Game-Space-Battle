package meujogo.Modelo;

//Classe criada por @Victor Bruno
// Precisa ser revisada
// Pesquisar sobre life no vídeo do YouTube

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player2 {
    private int x, y;
    private int dx, dy;
    private Image player2;
    private int altura, largura;
    private List<Tiro> tiros;
    private boolean isVisivel;
    private int life = 3;
    private int score = 0;
    private Image imagemLife;

    public Player2(){
        this.x = 100;
        this.y = 300;
        this.isVisivel = true;
        tiros = new ArrayList<Tiro>();
    }

    //definir imagem do player2
    public void loadPlayer2(){
        ImageIcon ref = new ImageIcon("resource");
        player2 = ref.getImage();

        this.altura = player2.getHeight(null);
        this.largura = player2.getWidth(null);

    }

    //atualiza a movimentação do player2
    public void updateMovimento(){
        x += dx;
        y += dy;
    }

    //define a posição dos tiros
    public void tiroSimples(){
        this.tiros.add(new Tiro(x+largura+8, y+(altura/2)));
    }

    //define os limites do objeto
    public Rectangle getBounds(){
        return new Rectangle (x,y,largura,altura);
    }

    public void keyPressed(KeyEvent tecla){
        int cod = tecla.getKeyCode();

        if(cod == KeyEvent.VK_V){
            Sound.shoot.play();
            tiroSimples();
        }

        if(cod == KeyEvent.VK_W){
            dy=-5; // quando for pressionado para cima dx =3 intencidade. 
        }
        if(cod == KeyEvent.VK_S){
            dy=5; 
        }
        if(cod == KeyEvent.VK_A){
            dx=-5; 
        }
        if(cod == KeyEvent.VK_D){
            dx=5; 
        }
    }

    public void keyReleased(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        if(codigo == KeyEvent.VK_W){
            dy=0;
        }
        if(codigo == KeyEvent.VK_S){
            dy=0; 
        }
        if(codigo == KeyEvent.VK_A){
            dx=0; 
        }
        if(codigo == KeyEvent.VK_D){
            dx=0; 
        }
    }

    public void render(Graphics a){

        a.setColor(Color.white);
        a.setFont(new Font("Arial", Font.BOLD,30));
        a.drawString("Score player 2: " + score, 10, 50);

        ImageIcon ref = new ImageIcon("res//life.png");
        imagemLife = ref.getImage();

        //perguntar ao marcos como funciona
        for(int i=0; i<life;i++){
            a.drawImage(imagemLife,1 + (i*20),35,35,19, null);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Image getPlayer2() {
        return player2;
    }

    public void setPlayer2(Image player2) {
        this.player2 = player2;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Image getImagemLife() {
        return imagemLife;
    }

    public void setImagemLife(Image imagemLife) {
        this.imagemLife = imagemLife;
    }

}
