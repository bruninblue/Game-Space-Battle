package meujogo.Modelo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
//import javax.swing.JPanel;

import meujogo.Container;

public class Menu extends JFrame {

    private final String URL_BACKGROUND = "res\\arcade.png";
    private final String URL_BACKGROUND_BUTTON = "res\\start.png";
    private final String URL_BACKGROUND_BUTTON_SELECTED = "res\\startSelected.png";

    private Botao buttonInicial;
    private boolean isVisivel;

    public Menu() {
        setTitle("Meu jogo");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Fundo fundo = new Fundo(URL_BACKGROUND);

        buttonInicial = new Botao(URL_BACKGROUND_BUTTON, URL_BACKGROUND_BUTTON_SELECTED);
        buttonInicial.setPreferredSize(new Dimension(100, 100));
        buttonInicial.setLayout(new BorderLayout(200, 100));
        buttonInicial.setBounds(400, 500, 200, 100);
        buttonInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonInicialCliecked_handler();
            }
        });

        // fundo.add(buttonInicial);
        setContentPane(fundo);
        add(buttonInicial);

        // pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void buttonInicialCliecked_handler() {
        new Container();
        revalidate();
    }

    // public boolean isVisivel() {
    // return isVisivel;
    // }

    // public void setVisivel(boolean isVisivel) {
    // this.isVisivel = isVisivel;
    // }
    // @Override
    // public void mouseClicked(MouseEvent e){
    // new Container();
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
