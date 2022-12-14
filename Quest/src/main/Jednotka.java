package main;

import java.util.Random;
import java.util.Scanner;


public class Jednotka {

	// TODO mozno by bolo fajn este popridavat gettre/settre, popripade aspon modifiere k tymto atributom
	// modifier ako public/private, ktore sa pouzivaju tak isto ako pri metodach. Metody ktore pouzivas iba vramci triedy
	// a nevolas ich z vonku, ako napriklad kontrolaXp mozu byt private.
	// idealne by bolo ale asi pouzit gettre a settre na atributy, kedze "encapsulation", je jeden z key prvkov OOP,
	// co znamena ze chces kontrolovat kto ma aky pristup ku ktorym atributom, a ako ich mozu modifkovat.
	String jmeno,rasa,typ;
	int zivoty, poskozeni, rychlost, zkusenosti = 0, uroven = 1, max_zkusenosti = 100, max_zivoty;
	
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);

	// TODO preco maju tieto konstanty inu hodnotu ako v game? 🤔 (prave som zistil ze tu mozem pridavat emoji hell yeah)
	final int RYTIR = 0;
	final int MAG = 1;
	final int STRELEC = 2;
	
	int min_xp = 45;
	int max_xp = 125;

	int hp_clovek = 500;
	int hp_clovek_max = 800;
	int hp_ork = 300;
	int hp_ork_max = 620;
	int hp_elf = 280;
	int hp_elf_max = 525;

	
	int poskozeni_clovek = 15;
	int poskozeni_clovek_max = 90;
	int poskozeni_ork = 45;
	int poskozeni_ork_max = 160;
	int poskozeni_elf = 35;
	int poskozeni_elf_max = 150;


	
	int rychlost_clovek = 10;
	int rychlost_clovek_max = 20;
	int rychlost_ork = 5;
	int rychlost_ork_max = 15;
	int rychlost_elf = 20;
	int rychlost_elf_max = 30;

	public void zisk_xp(int delitel) {
		this.zkusenosti = this.zkusenosti + ((rand.nextInt(max_xp - min_xp) + min_xp)/delitel);
		kontrola_xp();
	}
	
	public void vylecit() {
		this.zivoty = this.max_zivoty;
	}
	
	
	public void kontrola_xp() {
		if(this.zkusenosti >= this.max_zkusenosti) {
			this.max_zkusenosti = this.max_zkusenosti + 25;
			this.zkusenosti = 0;
			this.max_zivoty = this.max_zivoty + rand.nextInt(30-15)+15;
			this.poskozeni = this.poskozeni + rand.nextInt(15-2)+2;
			System.out.println(this.rasa+" "+this.typ+" zvysil svou uroven!");
			this.uroven++;
		}
	}
	
	
	public void rnd_typ() {
		int rnd = rand.nextInt(3);
		if (rnd == RYTIR) {
			this.typ = "RYTIR";
		}else if (rnd ==MAG) {
			this.typ = "MAG";
		}else if (rnd == STRELEC) {
			this.typ = "STRELEC";
		}
	}
	
	
	
	public void rnd_clovek() {
		this.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
		this.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
		this.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		rnd_typ();
	}
	 
	public void rnd_ork() {
		this.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
		this.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
		this.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		rnd_typ();
	}
	
	public void rnd_elf() {
		this.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
		this.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
		this.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		rnd_typ();
	}
	
}
