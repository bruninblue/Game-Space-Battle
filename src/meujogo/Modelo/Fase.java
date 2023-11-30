package meujogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{

    // ActionListener metodo que atualiza a tela 

    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemy1> enemy1;
    private List<Stars> stars;
    private boolean emJogo;
    private Menu menuJogo;
    

    public Fase(){
        
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\background.jpg");
        fundo = referencia.getImage();

        player = new Player();
        player.load(); // carregar a imagem da nave. 
        addKeyListener(new TecladoAdapter()); // utilizar o teclado. 

        timer = new Timer(5,this); // velocidade do jogo
        timer.start();
        inicializaInimigos();
        inicializaStars();
        emJogo = true;
    }

    public void inicializaInimigos(){

        int coordernadas [] = new int[80];
        enemy1 = new ArrayList<Enemy1>();

        for(int i = 0; i<coordernadas.length; i++){
            int x = (int) (Math.random() * 20000+1024); // a laargura da tela é 1024, ou seja, a soma é para garantir que o inimigo apareça antes da tela 
            int y = (int) (Math.random() * 630+15);// garantir que o inimigo não seja criado nem muito baixo nem muito alto, mais baixo será 30. 
            enemy1.add(new Enemy1(x,y));
        }
    }

    public void inicializaStars(){
        int coordernadas[] = new int[100];
        stars = new ArrayList<Stars>();

        for(int i = 0; i<coordernadas.length; i++){
            int x = (int) (Math.random() *1024); // a laargura da tela é 1024, ou seja, a soma é para garantir que o inimigo apareça antes da tela 
            int y = (int) (Math.random() * 768);// garantir que o inimigo não seja criado nem muito baixo nem muito alto, mais baixo será 30. 
            stars.add(new Stars(x,y));
        }
    }


    public void paint(Graphics g){

        Graphics2D graficos = (Graphics2D) g;
        if(emJogo == true){
            graficos.drawImage(fundo,0,0,null); // importar para a tela da imagem 

            
            for(int p=0;p<stars.size();p++){
                Stars s = stars.get(p);
                s.load();
                graficos.drawImage(s.getImagem(), s.getX(), s.getY(),this);
            }

            player.render(g);
            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this); // colocando o nave na fase. 
            List<Tiro> tiros = player.getTiros();

            for(int i=0;i<tiros.size();i++){
                Tiro m = tiros.get(i);
                m.load();
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }

            for(int o =0; o<enemy1.size();o++){
                Enemy1 in = enemy1.get(o);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }

        }else{
            //new Menu();
            menuJogo.setVisible(true);
            this.setVisible(false);
            
            // ImageIcon fimJogo = new ImageIcon("res\\fimdejogo.png");
            // Image gameOver = fimJogo.getImage();
            // graficos.drawImage(gameOver,-100,0, null);
        }
        
        checarColisoes();
        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       player.update();

        for(int p =0; p<stars.size();p++){
            Stars on = stars.get(p);
            if(on.isVisivel()){
                on.update();
            }else{
                stars.remove(p);
            }
        }

       List<Tiro> tiros = player.getTiros();
       for(int i=0;i<tiros.size();i++){
            Tiro m = tiros.get(i);
            if(m.isVisivel()){
                m.update();
            }else{
                tiros.remove(i);
            }
       }

       for(int o =0; o<enemy1.size();o++){
            Enemy1 in = enemy1.get(o);

            if(in.isVisivel()){
                in.update();
            }else{
                enemy1.remove(o);
                
            } // enquanto o inimigo estiver no cenario ela estará visivel
       }
       repaint(); // toda vez que houver um movitmento, haverá uma repintagem. 
    }

    // colissão dos objetos -------------

    public void checarColisoes(){
        Rectangle formaNave =  player.getBounds();
        Rectangle formaEnemy1;
        Rectangle formaTiro;

        for(int i=0; i<enemy1.size();i++){
            Enemy1 tempEnemy1 = enemy1.get(i);
            formaEnemy1 = tempEnemy1.getBounds();
            if(formaNave.intersects(formaEnemy1)){
                Sound.hit.play();
                player.dano();
                tempEnemy1.setVisivel(false);
                if(player.getLife()==0){
                    emJogo = false;
                    player.setVisivel(false);
                }
                
            }
        }

        List<Tiro> tiros = player.getTiros();

        for (int j=0; j< tiros.size();j++){
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBounds();
            for(int o = 0; o<enemy1.size();o++){
                Enemy1 tempEnemy1 = enemy1.get(o);
                formaEnemy1 = tempEnemy1.getBounds();
                if(formaTiro.intersects(formaEnemy1) ){
                    Sound.explosion.play();
                    tempEnemy1.setVisivel(false);
                    tempTiro.setVisivel(false);
                    player.ponto();
                }
            }
        }
        
    }

    private class TecladoAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
        
    }
    
}
