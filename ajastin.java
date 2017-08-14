import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Jakso4_5 extends Applet {
    public void init() {
        setLayout(new GridLayout(2,1));
        add (new threadPanel());
    }
}
    class threadPanel extends Panel implements ActionListener, Runnable{
        int sekunti= -1;
        int minuutti = 0;
        int kuinkaKauan;
        Button nappi;
        TextField aika;
        Thread pros;
        public threadPanel(){ 
        add(aika = new TextField(10));
        add(nappi = new Button("Aloita"));
        nappi.addActionListener(this);
        }
        public void run(){
            while(true)
                try{
                Thread.sleep(1000);
                repaint();
                }
            catch (InterruptedException e){
            }
        }
        public void actionPerformed(ActionEvent e){ //Kuinka kauan laskuri on käynnissä, eli syötetään haluttu sekunti määärä
        String sek =aika.getText();
        int k = Integer.parseInt(sek);
        kuinkaKauan = k;
        pros = new Thread(this);
        pros.start();
        }
        public void paint(Graphics g){ //Laskuri lopettaa toimintansa. 
        sekunti++;
        if (sekunti > kuinkaKauan){
        sekunti = 0;
        pros.stop();
        }
        g.drawString("" +  sekunti,40,80); //Piirretään ajastin
        }
    }
