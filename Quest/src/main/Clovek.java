package main;

public class Clovek extends Jednotka {

	public Clovek() {
		this.rasa = "CLOVEK";
		this.zivoty = 700;
		this.max_zivoty = 700;
		this.poskozeni = 45;
		this.rychlost = 15;
	}
	
	@Override
    public void rnd() {
		this.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
        this.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
        this.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
        rnd_typ();
    }
	
	
}
