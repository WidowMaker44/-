package main;

public class Elf extends Jednotka {
	
	 	int hp_elf = 280;
	    int hp_elf_max = 525;   
	    int poskozeni_elf = 35;
	    int poskozeni_elf_max = 150;	    
	    int rychlost_elf = 20;
	    int rychlost_elf_max = 30;

	public Elf() {
		this.rasa = "ELF";
		this.zivoty = 400;
		this.max_zivoty = 400;
		this.poskozeni = 75;
		this.rychlost = 25;
	}
	
	@Override
    public void rnd() {
		this.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
        this.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
        this.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
        rnd_typ();
    }
}
