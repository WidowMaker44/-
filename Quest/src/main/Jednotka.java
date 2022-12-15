package main;

import java.util.Random;
import java.util.Scanner;
import java.util.jar.JarEntry;


public class Jednotka {

    String jmeno, rasa, typ;
    int zivoty, poskozeni, rychlost, zkusenosti = 0, uroven = 1, max_zkusenosti = 100, max_zivoty;

    Random rand = new Random();
    Scanner keyboard = new Scanner(System.in);

 

    private int min_xp = 45;
    private int max_xp = 125;

    
    
   

    public void zisk_xp(int delitel) {
        this.zkusenosti = this.zkusenosti + ((rand.nextInt(max_xp - min_xp) + min_xp) / delitel);
        kontrola_xp();
    }

    public void vylecit() {
        this.zivoty = this.max_zivoty;
    }


    private void kontrola_xp() {
        if (this.zkusenosti < this.max_zkusenosti) {
            return;
        }

        this.max_zkusenosti = this.max_zkusenosti + 25;
        this.zkusenosti = 0;
        this.max_zivoty = this.max_zivoty + rand.nextInt(30 - 15) + 15;
        this.poskozeni = this.poskozeni + rand.nextInt(15 - 2) + 2;
        System.out.println(this.rasa + " " + this.typ + " zvysil svou uroven!");
        this.uroven++;
    }

    public void rnd_typ() {
        int rnd = rand.nextInt(3)+1;
        if (rnd == Game.RYTIR) {
            this.typ = "RYTIR";
        } else if (rnd == Game.MAG) {
            this.typ = "MAG";
        } else if (rnd == Game.STRELEC) {
            this.typ = "STRELEC";
        }
    }

    public void rnd() {
    	
    }

  
    
    
    
    public int getMinXp() {
        return min_xp;
    }
    
   
    public int getMaxXp() {
        return max_xp;
    }
    
  
}
