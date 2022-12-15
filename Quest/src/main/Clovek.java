package main;

public class Clovek extends Jednotka {
	
	int hp_clovek = 500;
    int hp_clovek_max = 800;
    int poskozeni_clovek = 15;
    int poskozeni_clovek_max = 90;
    int rychlost_clovek = 10;
    int rychlost_clovek_max = 20;

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
