package meujogo.Modelo;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Stars {
    
    private Image imagem; // imagem do tiro 
    private int x,y; // posição do tiro 
    private int largura, altura; // a dimensão do tiro 
    private boolean isVisivel; // fazer o tiro sumir 

    //private static final int LARGURA = 938; // fazer o tiro sumir 
    private static int VELOCIDADE = 4;

    public Stars(int x, int y){
        // os parametros é a posição do jogador.

        this.x = x; 
        this.y=y;
        isVisivel = true; 

    }

    public void load(){
        ImageIcon referencia = new ImageIcon("res\\stars.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update(){

        if(this.x<0){
            this.x = largura; // quando a estrela char ao fim da janela elá será levada a posição 1024, ou seja, LARGURA. 
            Random a = new Random();
            int m = a.nextInt(500);// 0 - 500
            this.x = m+1024;
            Random r = new Random();
            int n =r.nextInt(768);
            this.y = n; 
        }else{
            this.x-= VELOCIDADE;
        }
       
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

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
   
    
 
}
