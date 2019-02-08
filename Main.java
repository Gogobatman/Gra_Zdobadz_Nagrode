package gradnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame{
    Main2 main2= new Main2(this);
    PlanszaRozgrywki planszaRozgrywki = new PlanszaRozgrywki();
    public Main(String nazwaFrame, int szerokoscFrame, int wysokoscFrame){
        super(nazwaFrame);
        setSize(szerokoscFrame, wysokoscFrame);
        dodajMenu();
        setVisible(true);
        setFocusable(true);
        addKeyListener(planszaRozgrywki);
    }

public void dodajMenu(){
        remove(planszaRozgrywki);
        add(main2.menu);

}
    public void dodajRozgrywke(){
        remove(main2.menu);
        add(planszaRozgrywki);
    }

    public static void main(String[] args) {
        Main main = new Main("GraDND", 1050, 800);
    }
}
