package gradnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PlanszaRozgrywki extends JPanel implements KeyListener{
    Random rand = new Random();

    int x1 = rand.nextInt(16) + 1;
    int x2 = rand.nextInt(16) + 1;
    int y1 = rand.nextInt(12) + 1;
    int y2 = rand.nextInt(12) + 1;
    int x3 = rand.nextInt(16) + 1;
    int y3 = rand.nextInt(12) + 1;
    int xN = rand.nextInt(16) + 1;
    int yN = rand.nextInt(12) + 1;
    int Polozeniex = x1 * 50;
    // int Polozeniex=50;
    // int Polozeniey=600;
    int Polozeniey = y1 * 50;
    //int Polozeniex2=50;
    int Polozeniex2 = x2 * 50;
    //int Polozeniey2=100;
    int Polozeniey2 = y2 * 50;
    int Polozeniex3 = x3 * 50;
    //int Polozeniey2=100;
    int Polozeniey3 = y3 * 50;
    int PolozenieNagrodyX=xN*50;
    int PolozenieNagrodyY=yN*50;
    int punkty=0;
    int a = 0;
    int b = 0;
    Licznik licznik;
    Przycisk start = new Przycisk("Start", 'S');
    Przycisk R= new Przycisk("Reset",'R');
    Przycisk L = new Przycisk("←", 'L');
    Przycisk P = new Przycisk("→", 'P');
    Przycisk U = new Przycisk("↑", 'U');
    Przycisk D = new Przycisk("↓", 'D');
    String string=Integer.toString(punkty);
    JTextField text = new JTextField(string);
    boolean przegrana = false;
    String poziomTrudnosci="Latwy";
    int keyCode;

    public void keyPressed(KeyEvent e){
        keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_Q) {
            licznik.start();
            rysujKwadrat('S', Polozeniex, Polozeniey, 1);
            rysujKwadrat('N',PolozenieNagrodyX,PolozenieNagrodyY,1);
            }

        if(keyCode==KeyEvent.VK_D) {
            if (Polozeniex >= 800) {
                System.out.println("Jestes na skraju planszy!");
            } else {
                Polozeniex += 50;
                rysujKwadrat('P', Polozeniex, Polozeniey, 1);
            }
        }else if (keyCode==KeyEvent.VK_S) {
            if (Polozeniey >= 600) {
                System.out.println("Jestes na skraju planszy!");
            } else {
                Polozeniey += 50;
                rysujKwadrat('D', Polozeniex, Polozeniey, 1);
            }
        }else if (keyCode==KeyEvent.VK_W) {
            if (Polozeniey <= 50) {
                System.out.println("Jestes na skraju planszy!");
            } else {
                Polozeniey -= 50;
                rysujKwadrat('U', Polozeniex, Polozeniey, 1);
            }
        }else if (keyCode==KeyEvent.VK_A) {
            if (Polozeniex <= 50) {
                System.out.println("Jestes na skraju planszy!");
            } else {
                Polozeniex -= 50;
                rysujKwadrat('L', Polozeniex, Polozeniey, 1);
            }
        }

    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
    public class Licznik {

        int czas = 0;

        java.util.Timer timer = new Timer();
        TimerTask zadanie = new TimerTask() {
            public void run() {
                if (przegrana == false) {
                    czas++;
                    if(punkty>=3 || poziomTrudnosci=="Sredni"){
                        if ((Polozeniex == Polozeniex2 && Polozeniey == Polozeniey2) || (Polozeniex==Polozeniex3 && Polozeniey==Polozeniey3)) {
                            System.out.println("error!");
                            przegrana = true;
                        }
                    }
                    else{
                        if (Polozeniex == Polozeniex2 && Polozeniey == Polozeniey2) {
                            System.out.println("error!");
                            przegrana = true;
                        }
                    }

                    if (Polozeniex == PolozenieNagrodyX && Polozeniey == PolozenieNagrodyY) {
                        System.out.println("wygrales");
                        punkty++;

                        while(true){
                            x1 = rand.nextInt(16) + 1;
                            x2 = rand.nextInt(16) + 1;
                            y1 = rand.nextInt(12) + 1;
                            y2 = rand.nextInt(12) + 1;
                            x3 = rand.nextInt(16) + 1;
                            y3 = rand.nextInt(12) + 1;
                            xN = rand.nextInt(16) + 1;
                            yN = rand.nextInt(12) + 1;
                            Polozeniex = x1 * 50;
                            Polozeniey = y1 * 50;
                            Polozeniex2 = x2 * 50;
                            Polozeniey2 = y2 * 50;
                            Polozeniex3 = x3 * 50;
                            Polozeniey3 = y3 * 50;
                            PolozenieNagrodyX=xN*50;
                            PolozenieNagrodyY=yN*50;
                            if((x1!=x2&&y1!=y2)&&(x1!=xN&&y1!=yN)&&(x2!=xN&&y2!=yN)&&(x1!=x3&&y1!=y3)&&(x2!=x3 &&y2!=y3)&&(x3!=xN&&y3!=yN)){
                                break;
                            }
                        }

                        wyczyscPole();
                        odswiezPunktacje();


                    }
                    rysujKwadrat('S',Polozeniex,Polozeniey,1);
                    rysujKwadrat('N',PolozenieNagrodyX,PolozenieNagrodyY,1);
                    a = rand.nextInt(4);
                    b = rand.nextInt(4);
                    if (a == 0) {
                        if (Polozeniex2 <= 50) {
                            System.out.println("Jestes na skraju planszy!");
                        } else {
                            Polozeniex2 -= 50;
                            rysujKwadrat('L', Polozeniex2, Polozeniey2, 2);
                        }

                    }
                    if (a == 1) {
                        if (Polozeniex2 >= 800) {
                            System.out.println("Jestes na skraju planszy!");
                        } else {
                            Polozeniex2 += 50;
                            rysujKwadrat('P', Polozeniex2, Polozeniey2, 2);
                        }

                    }
                    if (a == 2) {
                        if (Polozeniey2 >= 600) {
                            System.out.println("Jestes na skraju planszy!");
                        } else {
                            Polozeniey2 += 50;
                            rysujKwadrat('D', Polozeniex2, Polozeniey2, 2);
                        }

                    }
                    if (a == 3) {
                        if (Polozeniey2 <= 50) {
                            System.out.println("Jestes na skraju planszy!");
                        } else {
                            Polozeniey2 -= 50;
                            rysujKwadrat('U', Polozeniex2, Polozeniey2, 2);
                        }

                    }
                    if(punkty>=3 || poziomTrudnosci=="Sredni"){
                        if (b == 0) {
                            if (Polozeniex3 <= 50) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniex3 -= 50;
                                rysujKwadrat('L', Polozeniex3, Polozeniey3, 3);
                            }

                        }
                        if (b == 1) {
                            if (Polozeniex3 >= 800) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniex3 += 50;
                                rysujKwadrat('P', Polozeniex3, Polozeniey3, 3);
                            }

                        }
                        if (b == 2) {
                            if (Polozeniey3 >= 600) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniey3 += 50;
                                rysujKwadrat('D', Polozeniex3, Polozeniey3, 3);
                            }

                        }
                        if (b == 3) {
                            if (Polozeniey3 <= 50) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniey3 -= 50;
                                rysujKwadrat('U', Polozeniex3, Polozeniey3, 3);
                            }

                        }
                    }

                } else {
                    System.out.println("Przegrales!");
                }
            }

        };

        public void start() {
            timer.scheduleAtFixedRate(zadanie, 1000, 1000);
        }
    }
    public void odswiezPunktacje(){
        remove(text);
        string=Integer.toString(punkty);
        text = new JTextField(string);
        add(text);
        repaint();
        revalidate();
    }
    public PlanszaRozgrywki() {
        // L.setBounds(30,30,30,30);
        add(start);
        add(R);
        add(L);
        add(P);
        add(U);
        add(D);
        odswiezPunktacje();
        licznik = new Licznik();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.GRAY);
        g.setColor(Color.lightGray);
        g.fillRect(50, 50, 802, 602);
    }
    public void wyczyscPole(){
        Graphics g = getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(50, 50, 802, 602);
    }
    public void rysujKwadrat(char znak, int Polozenie, int Polozenie2, int gracz) {
        Graphics g = getGraphics();

        if (znak == 'N') {
            g.setColor(Color.BLACK);
            g.drawOval(Polozenie, Polozenie2, 50, 50);

            g.setColor(Color.YELLOW);


            g.fillOval(Polozenie + 2, Polozenie2 + 2, 47, 47);
        }
        if (znak == 'S') {
            g.setColor(Color.BLACK);
            g.drawRect(Polozenie, Polozenie2, 50, 50);
            if (gracz == 1) {
                g.setColor(Color.BLUE);
            } else if (gracz == 2) {
                g.setColor(Color.RED);
            } else if (gracz == 3) {
                g.setColor(Color.GREEN);
            }

            g.fillRect(Polozenie + 2, Polozenie2 + 2, 47, 47);
        }
        if (znak == 'D') {
            g.setColor(Color.lightGray);
            g.fillRect(Polozenie, Polozenie2 - 50, 52, 50);
            g.setColor(Color.BLACK);
            g.drawRect(Polozenie, Polozenie2, 50, 50);
            if (gracz == 1) {
                g.setColor(Color.BLUE);
            } else if (gracz == 2) {
                g.setColor(Color.RED);
            } else if (gracz == 3) {
                g.setColor(Color.GREEN);
            }
            g.fillRect(Polozenie + 2, Polozenie2 + 2, 47, 47);
        }
        if (znak == 'U') {
            g.setColor(Color.lightGray);
            g.fillRect(Polozenie, Polozenie2 + 2, 52, 100);
            g.setColor(Color.BLACK);
            g.drawRect(Polozenie, Polozenie2, 50, 50);
            if (gracz == 1) {
                g.setColor(Color.BLUE);
            } else if (gracz == 2) {
                g.setColor(Color.RED);
            } else if (gracz == 3) {
                g.setColor(Color.GREEN);
            }
            g.fillRect(Polozenie + 2, Polozenie2 + 2, 47, 47);
        }
        if (znak == 'P') {
            g.setColor(Color.lightGray);
            g.fillRect(Polozenie - 50, Polozenie2, 100, 51);
            g.setColor(Color.BLACK);
            g.drawRect(Polozenie, Polozenie2, 50, 50);
            if (gracz == 1) {
                g.setColor(Color.BLUE);
            } else if (gracz == 2) {
                g.setColor(Color.RED);
            } else if (gracz == 3) {
                g.setColor(Color.GREEN);
            }
            g.fillRect(Polozenie + 2, Polozenie2 + 2, 47, 47);
        }
        if (znak == 'L') {
            g.setColor(Color.lightGray);
            g.fillRect(Polozenie + 2, Polozenie2, 99, 51);
            g.setColor(Color.BLACK);
            g.drawRect(Polozenie, Polozenie2, 50, 50);
            if (gracz == 1) {
                g.setColor(Color.BLUE);
            } else if (gracz == 2) {
                g.setColor(Color.RED);
            } else if (gracz == 3) {
                g.setColor(Color.GREEN);
            }
            g.fillRect(Polozenie + 2, Polozenie2 + 2, 47, 47);
        }


    }

    public class Przycisk extends JButton {

        public Przycisk(String nazwa, char operacja) {
            super(nazwa);
            //     ImageIcon obrazek = new ImageIcon(getClass().getResource(srcObrazka[numerPorzadkowy]));
            //    setIcon(obrazek);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(operacja=='R'){
                        punkty=0;
                        przegrana=false;
                        poziomTrudnosci="Poziom Latwy";
                        while(true){
                            x1 = rand.nextInt(16) + 1;
                            x2 = rand.nextInt(16) + 1;
                            y1 = rand.nextInt(12) + 1;
                            y2 = rand.nextInt(12) + 1;
                            x3 = rand.nextInt(16) + 1;
                            y3 = rand.nextInt(12) + 1;
                            xN = rand.nextInt(16) + 1;
                            yN = rand.nextInt(12) + 1;
                            Polozeniex = x1 * 50;
                            Polozeniey = y1 * 50;
                            Polozeniex2 = x2 * 50;
                            Polozeniey2 = y2 * 50;
                            Polozeniex3 = x3 * 50;
                            Polozeniey3 = y3 * 50;
                            PolozenieNagrodyX=xN*50;
                            PolozenieNagrodyY=yN*50;
                            if((x1!=x2&&y1!=y2)&&(x1!=xN&&y1!=yN)&&(x2!=xN&&y2!=yN)&&(x1!=x3&&y1!=y3)&&(x2!=x3 &&y2!=y3)&&(x3!=xN&&y3!=yN)){
                                rysujKwadrat('S', Polozeniex, Polozeniey, 1);
                                rysujKwadrat('N',PolozenieNagrodyX,PolozenieNagrodyY,1);
                                break;
                            }
                        }

                        wyczyscPole();
                        odswiezPunktacje();
                    }
                    if (przegrana == false) {
                        if (operacja == 'S') {
                            licznik.start();
                            rysujKwadrat('S', Polozeniex, Polozeniey, 1);
                            rysujKwadrat('N',PolozenieNagrodyX,PolozenieNagrodyY,1);
                        }
                        if (operacja == 'L') {
                            if (Polozeniex <= 50) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniex -= 50;
                                rysujKwadrat('L', Polozeniex, Polozeniey, 1);
                            }

                        }
                        if (operacja == 'P') {
                            if (Polozeniex >= 800) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniex += 50;
                                rysujKwadrat('P', Polozeniex, Polozeniey, 1);
                            }

                        }
                        if (operacja == 'D') {
                            if (Polozeniey >= 600) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniey += 50;
                                rysujKwadrat('D', Polozeniex, Polozeniey, 1);
                            }

                        }
                        if (operacja == 'U') {
                            if (Polozeniey <= 50) {
                                System.out.println("Jestes na skraju planszy!");
                            } else {
                                Polozeniey -= 50;
                                rysujKwadrat('U', Polozeniex, Polozeniey, 1);
                            }

                        }

                    } else {
                        System.out.println("Przegrales!");
                    }
                }
            });

        }
    }
}
