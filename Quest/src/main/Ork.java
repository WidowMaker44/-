package main;

public class Ork extends Jednotka {
	
	int hp_ork = 300;
    int hp_ork_max = 620;
    int poskozeni_ork = 45;
    int poskozeni_ork_max = 160;
    int rychlost_ork = 5;
    int rychlost_ork_max = 15;

	public Ork() {
		this.rasa = "ORK";
		this.zivoty = 550;
		this.max_zivoty = 550;
		this.poskozeni = 90;
		this.rychlost = 10;
	}
	
	@Override
    public void rnd() {
		this.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
        this.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
        this.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
        rnd_typ();
    }

	
	
}
