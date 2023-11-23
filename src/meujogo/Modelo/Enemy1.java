package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy1 {
    
   private Image imagem; // imagem do tiro 
    private int x,y; // posição do tiro 
    private int largura, altura; // a dimensão do tiro 
    private boolean isVisivel; // fazer o tiro sumir 

    //private static final int LARGURA = 938; // fazer o tiro sumir 
    private static int VELOCIDADE = 4;

    public Enemy1(int x, int y){
        // os parametros é a posição do jogador.

        this.x = x; 
        this.y=y;
        isVisivel = true; 

    }

    public void load(){
        ImageIcon referencia = new ImageIcon("res\\inimigo1.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update(){
        this.x-= VELOCIDADE;
       /*if(this.x > LARGURA){
            isVisivel = false; // quando o tiro utrapassar o limite, irá sumir 
        }*/ 

    }

    public Rectangle getBounds(){
        return new Rectangle (x,y,largura,altura);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

   

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

   
    
 
}
