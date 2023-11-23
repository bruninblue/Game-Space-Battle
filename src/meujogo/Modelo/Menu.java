package meujogo.Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;

import meujogo.Container;

public class Menu extends JFrame implements ActionListener{
   private boolean isVisivel;

    

    public Menu(){

        setTitle("Meu jogo");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// centro 
        this.setResizable(false);// ajuste da janela 
        setVisible(true);
    

        setLayout(null);
        JButton jButton = new JButton("jogar");
        jButton.setBounds(100,400,280,50);
        jButton.setFont(new Font("arial", Font.BOLD,15));
        jButton.setForeground(new Color(237,241,238));
        jButton.setBackground(new Color(9,10,9));
        jButton.setVisible(true);
        add(jButton);
        jButton.addActionListener(this);
        //jButton.addMouseListener(this);
    }

    public void paint(Graphics p){

        p.setColor(new Color(200,200,200));
        p.fillRect(0,0,1024,728);

        p.setFont(new Font("Arial",Font.BOLD, 50));
        p.setColor(new Color(0,0,0));
        p.drawString("Modos de jogo",100,100);

        p.setFont(new Font("Arial",Font.BOLD, 28));
        p.setColor(new Color(0,0,0));
        p.drawString("novo jogo", 100, 200);
        p.drawString("sair", 100, 250);
        
        
    }


    public boolean isVisivel() {
        return isVisivel;
    }


    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       new Container();
       this.setVisible(false);
        
    }

    // @Override
    // public void mouseClicked(MouseEvent e){
    //     new Container();
    // }
    // @Override
    // public void mousePressed(MouseEvent e){
        
    // }
    // @Override
    // public void mouseReleased(MouseEvent e){
        
    // }
    // @Override
    // public void mouseEntered(MouseEvent e){
        
    // }
    // @Override
    // public void mouseExited(MouseEvent e){
        
    // }
}
