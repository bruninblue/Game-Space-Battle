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
        largura = imagem.getWidth(null);
    }

    public void update(){ // movimentação

        if(x<861 && x>0 ){ // logica para limitar a movimentação no cenário 
           this.x+=dx;
        }else if(x>860){
            this.x=860;
        }else if(x<1){
            this.x=1;
        }

        if(y<631 && y>0){
            y+=dy;
        }else if(y<1){
            this.y=1;
        }else if(y>630){
            this.y=630;
        }

        // apesar da resolução ser 1024X728, nesse ponto a imagem da nave está para fora no cenário. 
        // limite da nave em x 0 - 860
        // limite da nave em y 0 - 630
        
    }

    public void tiroSimples(){
        this.tiros.add(new Tiro(x+largura+8, y+(altura/2))); // posicionar o surgimento do tiro
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

    public int getScore(){
        return score;
    }

    public void setX(int x) {
        this.x = x;
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

    public void setImagem(Image imagem) {
        this.imagem = imagem;
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

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }
    
}
