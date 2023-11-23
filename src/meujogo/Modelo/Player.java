package meujogo.Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
    private int x, y; // utilizado para mover 
    private int dx,dy; // mover
    private Image imagem; // imagem 
    private int altura, largura; // colisão 
    private List <Tiro> tiros;
    private boolean isVisivel;
    private int life = 3;
    private int score=0;
    private Image im;

    public Player(){
        this.x=100;
        this.y=100;
        // definição da cordenada onde o icone irá espalnar
        isVisivel=true;
        tiros = new ArrayList<Tiro>();
    }

    public void load(){
        // definição da imagem do Player

        ImageIcon referencia = new ImageIcon("res//spaceship.png");
        imagem = referencia.getImage();

        altura = imagem.getHeight(null);
        largura = imagem.getHeight(null);
    }

    public void update(){ // movimentação 
        x+=dx;
        y+=dy;
    }

    public void tiroSimples(){
        this.tiros.add(new Tiro(x+largura, y+(altura/2))); // posicionar o surgimento do tiro
    }
    
    public Rectangle getBounds(){
        return new Rectangle (x,y,largura,altura);
    }
    

    public void keyPressed(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        if(codigo == KeyEvent.VK_SPACE){
            Sound.shoot.play();
            tiroSimples();
        }

        if(codigo == KeyEvent.VK_UP){
            dy=-5; // quando for pressionado para cima dx =3 intencidade. 
        }
        if(codigo == KeyEvent.VK_DOWN){
            dy=5; 
        }
        if(codigo == KeyEvent.VK_LEFT){
            dx=-5; 
        }
        if(codigo == KeyEvent.VK_RIGHT){
            dx=5; 
        }

    }

    public void keyReleased(KeyEvent tecla){  
        int codigo = tecla.getKeyCode();

        if(codigo == KeyEvent.VK_UP){
            dy=0; // quando for pressionado para cima dx =3 intencidade. 
        }
        if(codigo == KeyEvent.VK_DOWN){
            dy=0; 
        }
        if(codigo == KeyEvent.VK_LEFT){
            dx=0; 
        }
        if(codigo == KeyEvent.VK_RIGHT){
            dx=0; 
        }

    }

    public void render(Graphics a){

        a.setColor(Color.white);
        a.setFont(new Font("Arial", Font.BOLD,30));
        a.drawString("Score: "+score, 10, 25);

        ImageIcon ref = new ImageIcon("res//life.png");
        im = ref.getImage();

        for(int i=0; i<life;i++){
        a.drawImage(im,1 + (i*20),35,35,19, null);
        }
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public void dano(){
        this.life = life-1;
    }
    
    public int getLife(){
        return life;
    }

    public void ponto(){
        this.score = score + 100;
    }
}
