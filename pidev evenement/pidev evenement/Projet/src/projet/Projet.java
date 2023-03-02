package projet;

import entites.evenement;
import services.Event;
import utiles.MyBD;
import entites.categorie;
import services.categori;


public class Projet {

    public static void main(String[] args) {
        // TODO code application logic here
        MyBD db1 = MyBD.getInstance();
        Event ps = new Event();
       System.out.println(ps.readAll());

        
        categori pc = new categori();
        System.out.println(pc.readAll());
        
        Event e1 = new Event();
        
        evenement u1=new evenement("brightness","evenement sur la peinture avec des couleurs shiny");
        
        categori c1 = new categori();
        
       // categorie ulc = new categorie(35,"digital", "digital art and canvas", 25);
        
        //c1.insert(ulc);
        
        //c1.update(ulc);
        
        //c1.delete(ulc);

        e1.insert(u1);

        //e1.update(u1);

        //e1.delete(u1);

    }
    
}
