package main;

import java.util.Random;
import java.util.Scanner;


public class Game implements lGame{

	int pocet_diamantu =0;
	Jednotka[] Jednotky = new Jednotka[3];
	Jednotka[] Nepratele = new Jednotka[3];
	
	final int CLOVEK = 0;
	final int ORK = 1;
	final int ELF = 2;
	
	final static int RYTIR = 1;
	final static int MAG = 2;
	final static int STRELEC = 3;
	
	final int INSPECT = 1;
	final int FIGHT = 2;
	final int INFO = 3;
	final int REORDER = 4;
	final int KONEC = 5;


	int indexJednotky = 0;
	int indexNepritele = 0;
	
	
	
	
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);


	public static void main(String[] args) {
		Game g = new Game();
		g.start();
		
	}//KONEC MAINU


	
	@Override
	public void start() {

		System.out.println("			****** HRA JE OVLADANA POUZE CISLICEMI ******");
		System.out.println("Zdravim te, dobrodruhu! Pro zvoleni rasy a typu jednotky pouzij cislice! Zvol si sve 3 cleny druziny:");
		System.out.println("");
			
		//ZVOLENI ARMADY
		volbaJednotky();

		//VÝPIS ARMÁDY
		System.out.println("TVA DRUZINA:");
		info();
		
		System.out.println("");
		System.out.println("Nyni te ceka zacatek tveho dobrodruzstvi. Tvym ukolem je vycistit 7 jeskyni. V kazde z nich se ukryva cast diamantu, ktery byl tve rodine odcizen!");
		
		//VSTUP DO 1. JESKYNĚ
		System.out.println("VSTUPUJETE DO PRVNI JESKYNE: ");
		zmackniEnter();
		while(pocet_diamantu <7) {
			System.out.println("VSTUPUJETE DO JESKYNE!");
			vytvoreni_nepratel();
			menu();
			volba();
		}
	
		System.out.println("GRATULUJI, POVEDLO SE TI NASBIRAT VSECH 7 CASTI DIAMANTU!");
		System.out.println("******************************* VYHRAAAAAAAAAAAL JSIIIIIIIIIIIIIII!!!!! *******************************");
	}

	//*****************************FUNKCE**************************
	
	private void volbaJednotky() {
		
		for(int i=0;i<3;i++) {
			System.out.println((i+1)+". Jednotka:");
			System.out.println("1) CLOVEK -> velky pocet zivotu, male poskozeni, stredne rychly!");
			System.out.println("2) ORK    -> velke poskozeni, stredne zivotuy, pomaly! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK A ELF");
			System.out.println("3) ELF    -> rychla jednotka, stredni poskozeni, malo zivotu! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK");
			System.out.print("> ");
			int cislo = keyboard.nextInt();
			if (cislo == (CLOVEK+1)) {
				System.out.println("Zvolen CLOVEK!");
				Jednotky[i] = new Clovek();
			} else if (cislo == (ORK+1)) {
				System.out.println("Zvolen ORK!");
				Jednotky[i] = new Ork();
			} else if (cislo == (ELF+1)) {
				System.out.println("Zvolen ELF!");
				Jednotky[i] = new Elf();
			} else {
				while(true) {
					System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
					cislo = keyboard.nextInt();
					if (cislo ==(CLOVEK+1)) {
						System.out.println("Zvolen CLOVEK!");
						Jednotky[i] = new Clovek();
						break;
					} else if (cislo == (ORK+1)) {
						System.out.println("Zvolen ORK!");
						Jednotky[i] = new Ork();
						break;
					} else if (cislo == (ELF+1)) {
						System.out.println("Zvolen ELF!");
						Jednotky[i] = new Elf();
						break;
					}
				}
			}
	
	
			//TYP
			System.out.println("1) RYTIR   -> Jeho utoky jsou efektivni proti MAG!");
			System.out.println("2) MAG     -> Jeho utoky jsou efektivni proti RYTIR!");
			System.out.println("3) STRELEC -> Jeho utoky jsou efektivni proti RYTIR!");
			System.out.print("> ");
			cislo = keyboard.nextInt();
			if (cislo == RYTIR) {
				Jednotky[i].typ = "RYTIR";
				System.out.println("Zvolen RYTIR! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
			} else if (cislo == MAG) {
				Jednotky[i].typ = "MAG";
				System.out.println("Zvolen MAG! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
			} else if (cislo == STRELEC) {
				Jednotky[i].typ = "STRELEC";
				System.out.println("Zvolen STRELEC! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
			} else {
				while(true) {
					System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
					cislo = keyboard.nextInt();
					if (cislo == RYTIR) {
						Jednotky[i].typ = "RYTIR";
						System.out.println("Zvolen RYTIR! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
						break;
					} else if (cislo == MAG) {
						Jednotky[i].typ = "MAG";
						System.out.println("Zvolen MAG! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
						break;
					} else if (cislo == STRELEC) {
						Jednotky[i].typ = "STRELEC";
						System.out.println("Zvolen STRELEC! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
						break;
					}
				}
			}
		}
	}
	
	private void volba() {
		int cislo = keyboard.nextInt();
		if (cislo == INSPECT) {
			inspect();
			System.out.println("");
			menu();
			volba();
		} else if (cislo==FIGHT) {
			fight();
		} else if (cislo == INFO) {
			info();
		} else if(cislo == REORDER) {
			reorder();
		} else if(cislo == KONEC) {
			konec();
		}else  {
			System.out.println("SPATNE CISLO/ZNAK, ZADEJ ZNOVU: ");
			menu();
			volba();
		}
	}
	
	private void fight() {
		indexJednotky = 0;
		indexNepritele = 0;
		int pocetKol = 0;
		while(true) {
			System.out.println("    "+(indexJednotky+1)+". Jednotka| HP: "+Jednotky[indexJednotky].zivoty);
			System.out.println("    "+(indexNepritele +1)+". Nepritel| HP: "+Nepratele[indexNepritele].zivoty);
			if(Jednotky[0].zivoty<=0 && Jednotky[1].zivoty<=0 && Jednotky[2].zivoty<=0) {
				System.out.println("Vase jednotka je mrtva!");
				System.out.println("PROHRAL JSI! TVE JEDNOTKY SI MUSI ODPOCINOUT!");
				for(int i=0;i<3;i++) {
					Jednotky[i].zisk_xp(2);
					Jednotky[i].vylecit();
				}
				break;
			} else if (Nepratele[0].zivoty<=0 && Nepratele[1].zivoty<=0 && Nepratele[2].zivoty<=0) {
				System.out.println("Nepritel je zabit!");
				System.out.println("PORAZIL SI VSECHNY NEPRATELE! ZDE JE TVA CAST DIAMANTU!");
				for(int i=0;i<3;i++) {
					Jednotky[i].zisk_xp(1);
					Jednotky[i].vylecit();
				}
				pocet_diamantu++;
				break;
			}
			System.out.println(pocetKol+". KOLO");
			if(Jednotky[indexJednotky].rychlost>= Nepratele[indexNepritele].rychlost) {
				Jednotka utocnik = Jednotky[indexJednotky];
				Jednotka obrance = Nepratele[indexNepritele];
				utok(utocnik, obrance);
				kontrolaHpNepritele(indexNepritele);
				utok(obrance, utocnik);
				kontrolaHpJednotky(indexJednotky);
			} else {
				Jednotka obrance = Jednotky[indexJednotky];
				Jednotka utocnik = Nepratele[indexNepritele];
				utok(utocnik, obrance);
				kontrolaHpJednotky(indexJednotky);
				utok(obrance, utocnik);
				kontrolaHpNepritele(indexNepritele);
			}
			pocetKol++;
		}
	}




	
	private void utok(Jednotka utocnik, Jednotka obrance) {
		if((utocnik.rasa == "ORK" && obrance.rasa=="ELF") ||
				(utocnik.rasa == "ORK" && obrance.rasa=="CLOVEK") ||
				(utocnik.rasa == "ELF" && obrance.rasa=="CLOVEK") ||
				(utocnik.typ == "RYTIR" && obrance.typ=="MAG")||
				(utocnik.typ == "STRELEC" && obrance.typ=="RYTIR")||
				(utocnik.typ == "MAG" && obrance.typ=="RYTIR")) {
			obrance.zivoty = (int) (obrance.zivoty - (utocnik.poskozeni * 1.3));
		} else {
			obrance.zivoty = obrance.zivoty - utocnik.poskozeni;
		}

		
	}
	

	private void kontrolaHpJednotky(int x) {
		if(Jednotky[x].zivoty <= 0 && x <=1 ) {
			indexJednotky++;
			System.out.println("Vase jednotka je mrtva!");
		}
	}
	
	private void kontrolaHpNepritele(int x) {
		if(Nepratele[x].zivoty <= 0 && x <=1 ) {
			indexNepritele++;
			System.out.println("Nepritel je zabit!");
		}
	}
	

	private void reorder() {
		info();
		Jednotka x;
		System.out.println("Zadejte, na jake pozici ma byt vase prvni jednotka: ");
		int cislo = keyboard.nextInt();
		if(cislo == 2) {
			x = Jednotky[1];
			Jednotky[1] = Jednotky[0];
			Jednotky[0] = x;
		} else if(cislo == 3) {
			x = Jednotky[2];
			Jednotky[2] = Jednotky[0];
			Jednotky[0] = x;
		}else if(cislo == 1) {
		}
		else {
			System.out.println("Spatne cislo, zkus to znovu!");
		}
		info();
		menu();
		volba();
	}


	private void inspect() {
		for(int i=0;i<3;i++) {
			System.out.println((i+1)+". "+ Nepratele[i].rasa + " " +Nepratele[i].typ + "| Zivoty: " + Nepratele[i].zivoty + " Poskozeni: " + Nepratele[i].poskozeni + " Rychlost: " + Nepratele[i].rychlost);
		}
	}


	private void vytvoreni_nepratel() {
		for(int i =0;i<3;i++) {
		int rnd = rand.nextInt(3);
			if (rnd == CLOVEK) {
				Nepratele[i] = new Clovek();
				Nepratele[i].rnd();
			}else if (rnd == ORK) {
				Nepratele[i] = new Ork();
				Nepratele[i].rnd();
			}else if (rnd == ELF) {
				Nepratele[i] = new Elf();
				Nepratele[i].rnd();
			}
		}
		
	}
	
	
	private void zmackniEnter() { 
	        System.out.println("Zmackni enter a pokracuj...");
	        try
	        {
	            System.in.read();
	            keyboard.nextLine();
	        }  
	        catch(Exception e)
	        {
						
					}  
	 }
	
	private void konec() {
		System.out.println("HRA UKONCENA!");
		System.exit(0);
	}



	private void info() {
		for(int i=0;i<3;i++) {
			System.out.println((i+1)+". "+ Jednotky[i].rasa + " " +Jednotky[i].typ + " lvl "+ Jednotky[i].uroven+ "| Zivoty: " + Jednotky[i].zivoty + " Poskozeni: " + Jednotky[i].poskozeni + " Rychlost: " + Jednotky[i].rychlost +" XP:"+ Jednotky[i].zkusenosti + "/" + Jednotky[i].max_zkusenosti);
		}
		System.out.println("   Pocet diamantu: " + pocet_diamantu);
	}


	public void menu() {
		System.out.println("1)inspect -> Prohlidnout sve protivniky a jejich pozice");
		System.out.println("2)fight -> zahajit souboj!");
		System.out.println("3)info -> vypise info o jednotkach + pocet ziskanych diamantu");
		System.out.println("4)reorder -> zmena poradi jednotek");
		System.out.println("5)RIP -> ukoncit hru! :(");
		System.out.print("> ");
	}
	
}
