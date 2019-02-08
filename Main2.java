package gradnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2  {
    Menu menu;
    public Main2(Main main){
         menu = new Menu(main);
    }

    public class Przycisk extends JButton {

        public Przycisk(String nazwaObrazka, String operacja,Main main) {
            super(operacja);
       //     ImageIcon obrazek = new ImageIcon(getClass().getResource(srcObrazka[numerPorzadkowy]));
       //    setIcon(obrazek);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(operacja=="Poziom Latwy"){
                        System.out.println(operacja);
                        main.dodajRozgrywke();
                    }
                    else if(operacja=="Poziom Sredni"){
                        main.planszaRozgrywki.poziomTrudnosci="Sredni";
                        System.out.println(operacja);
                        main.dodajRozgrywke();
                    }


                }
            });

        }
    }
    public class Menu extends JPanel{
        public Menu(Main main){
            Przycisk przyciskStart = new Przycisk("src.jpg","Poziom Latwy", main);
            Przycisk przyciskStart2 = new Przycisk("src.jpg","Poziom Sredni", main);
            add(przyciskStart);
            add(przyciskStart2);
        }
    }
}
