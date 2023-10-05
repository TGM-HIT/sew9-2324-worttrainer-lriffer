package sew9.worttrainer.lriffer;
import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

public class App { 
    
    public static void main(String[] args) {
        WortEintrag we1 = new WortEintrag("Hund", "https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/7ae66d97-8aaa-43c2-a9a9-8a0ede30a1be/labrador_retriever_liegt_bei_sonnenschein_im_park.jpg");
        WortEintrag we2 = new WortEintrag("Apfel", "https://image.jimcdn.com/app/cms/image/transf/dimension=1920x10000:format=jpg/path/s773f0b7acb31ce72/image/i1a929c29e53043aa/version/1536147543/roter-apfel-mit-einzelnem-gr%C3%BCnen-blatt-vor-wei%C3%9Fem-hintergrund.jpg");
        WortEintrag we3 = new WortEintrag("Fußball", "https://assets-de.imgfoot.com/ballon-derbystar-bundesliga-img2.jpg");
        WortEintrag we4 = new WortEintrag("Brot", "https://www.ndr.de/ratgeber/kochen/brot524_v-fullhd.jpg");

        WortListe wl = new WortListe(4);
        wl.addWort(we1);
        wl.addWort(we2);
        wl.addWort(we3);
        wl.addWort(we4);

        WortTrainer wt = new WortTrainer(wl);
        wt.setQuestions(4);
        ImageIcon icon;
        try {
            icon = new ImageIcon(new URL(we1.getUrl()));
            JOptionPane.showMessageDialog(null, "Was ist auf diesem Bild zu sehen?", "Image", JOptionPane.INFORMATION_MESSAGE, icon);
            String antwort = JOptionPane.showInputDialog(null, "Was hast du auf dem Bild vorhin gesehen?", "Frage", JOptionPane.QUESTION_MESSAGE).toString();

            if(antwort.equals(we1.getWort())){
                JOptionPane.showMessageDialog(null, "Super, richtig!");
                wt.addRight(1);
                wt.addQuestions(1);
                return;
            }else{
                JOptionPane.showMessageDialog(null, "Leider falsch!");
                wt.addWrong(1);
                wt.addQuestions(1);
                return;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
