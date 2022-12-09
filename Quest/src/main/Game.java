package main;

import java.util.Random;
import java.util.Scanner;


public class Game implements lGame{
	Jednotka jednotka1 = new Jednotka();
	Jednotka jednotka2 = new Jednotka();
	Jednotka jednotka3 = new Jednotka();
	int pocet_diamantu = 0;
	
	Jednotka nepritel1 = new Jednotka();
	Jednotka nepritel2 = new Jednotka();
	Jednotka nepritel3 = new Jednotka();
	
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);
	
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
	
	int min_xp = 45;
	int max_xp = 125;

	String[] poradi = {"prvni", "druhy", "treti"};
	public static void main(String[] args) {
		Game g = new Game();
		g.start();
		
	}//KONEC MAINU


	
	@Override
	public void start() {


		
		System.out.println("			****** HRA JE OVLADANA POUZE CISLICEMI ******");
		System.out.println("Zdravim te, dobrodruhu! Pro zvoleni rasy a typu jednotky pouzij cislice! Zvol si sve 3 cleny druziny:");
		System.out.println("");
		System.out.println("1. Jednotka:");
		System.out.println("1) CLOVEK -> velky pocet zivotu, male poskozeni, stredne rychlý!");
		System.out.println("2) ORK    -> velke poskozeni, stredne zivotuy, pomaly! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK A ELF");
		System.out.println("3) ELF    -> rychla jednotka, stredni poskozeni, malo zivotu! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK");
		
		
		//1. JEDNOTKA
		

		//RASA
		int cislo = keyboard.nextInt();
		if (cislo == 1) {
			System.out.println("Zvolen CLOVEK!");
			jednotka1.rasa = "CLOVEK";
			jednotka1.zivoty = 700;
			jednotka1.max_zivoty = 700;
			jednotka1.poskozeni = 45;
			jednotka1.rychlost = 15;
		} else if (cislo == 2) {
			System.out.println("Zvolen ORK!");
			jednotka1.rasa = "ORK";
			jednotka1.zivoty = 550;
			jednotka1.max_zivoty = 550;
			jednotka1.poskozeni = 90;
			jednotka1.rychlost = 10;
		} else if (cislo == 3) {
			System.out.println("Zvolen ELF!");
			jednotka1.rasa = "ELF";
			jednotka1.zivoty = 400;
			jednotka1.max_zivoty = 400;
			jednotka1.poskozeni = 75;
			jednotka1.rychlost = 25;
		} else {
			while(true) {
				System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
				cislo = keyboard.nextInt();
				if (cislo == 1) {
					System.out.println("Zvolen CLOVEK!");
					jednotka1.rasa = "CLOVEK";
					jednotka1.zivoty = 700;
					jednotka1.max_zivoty = 700;
					jednotka1.poskozeni = 45;
					jednotka1.rychlost = 15;
					break;
				} else if (cislo == 2) {
					System.out.println("Zvolen ORK!");
					jednotka1.rasa = "ORK";
					jednotka1.zivoty = 550;
					jednotka1.max_zivoty = 550;
					jednotka1.poskozeni = 90;
					jednotka1.rychlost = 10;
					break;
				} else if (cislo == 3) {
					System.out.println("Zvolen ELF!");
					jednotka1.rasa = "ELF";
					jednotka1.zivoty = 400;
					jednotka1.max_zivoty = 400;
					jednotka1.poskozeni = 750;
					jednotka1.rychlost = 25;
					break;
				}
			}
		}

		
		//TYP
		System.out.println("1) RYTIR   -> Jeho utoky jsou efektivni proti MAG!");
		System.out.println("2) MAG     -> Jeho utoky jsou efektivni proti RYTIR!");//2x rytir?
		System.out.println("3) STRELEC -> Jeho utoky jsou efektivni proti RYTIR!");
		cislo = keyboard.nextInt();
		if (cislo == 1) {
			jednotka1.typ = "RYTIR";
			System.out.println("Zvolen RYTIR! Tva 1. jednotka je " + jednotka1.rasa + " " + jednotka1.typ);
		} else if (cislo == 2) {
			jednotka1.typ = "MAG";
			System.out.println("Zvolen MAG! Tva 1. jednotka je " + jednotka1.rasa + " " + jednotka1.typ);
		} else if (cislo == 3) {
			jednotka1.typ = "STRELEC";
			System.out.println("Zvolen STRELEC! Tva 1. jednotka je " + jednotka1.rasa + " " + jednotka1.typ);
		} else {
			while(true) {
				System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
				cislo = keyboard.nextInt();
				if (cislo == 1) {
					jednotka1.typ = "RYTIR";
					System.out.println("Zvolen RYTIR! Tva 1. jednotka je " + jednotka1.rasa + " " + jednotka1.typ);
					break;
				} else if (cislo == 2) {
					jednotka1.typ = "MAG";
					System.out.println("Zvolen MAG! Tva 1. jednotka je " + jednotka1.rasa + " " + jednotka1.typ);
					break;
				} else if (cislo == 3) {
					jednotka1.typ = "STRELEC";
					System.out.println("Zvolen STRELEC! Tva 1. jednotka je " + jednotka1.rasa + " " +jednotka1.typ);
					break;
				}
			}
		}
		poradi[0] = "prvni";

	//2. JEDNOTKA
		System.out.println("2. Jednotka:");
		System.out.println("1) CLOVEK -> velky pocet zivotu, male poskozeniy stredne rychlý!");
		System.out.println("2) ORK    -> velke poskozeni, stredne zivotuy, pomaly! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK A ELF");
		System.out.println("3) ELF    -> rychla jednotka, stredni poskozeni, malo zivotu! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK");
		
		
		
		//RASA
		cislo = keyboard.nextInt();
		if (cislo == 1) {
			System.out.println("Zvolen CLOVEK!");
			jednotka2.rasa = "CLOVEK";
			jednotka2.zivoty = 700;
			jednotka2.max_zivoty = 700;
			jednotka2.poskozeni = 45;
			jednotka2.rychlost = 15;
		} else if (cislo == 2) {
			System.out.println("Zvolen ORK!");
			jednotka2.rasa = "ORK";
			jednotka2.zivoty = 550;
			jednotka2.max_zivoty = 550;
			jednotka2.poskozeni = 90;
			jednotka2.rychlost = 10;
		} else if (cislo == 3) {
			System.out.println("Zvolen ELF!");
			jednotka2.rasa = "ELF";
			jednotka2.zivoty = 400;
			jednotka2.max_zivoty = 400;
			jednotka2.poskozeni = 750;
			jednotka2.rychlost = 25;
		} else {
			while(true) {
				System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
				cislo = keyboard.nextInt();
				if (cislo == 1) {
					System.out.println("Zvolen CLOVEK!");
					jednotka2.rasa = "CLOVEK";
					jednotka2.zivoty = 700;
					jednotka2.max_zivoty = 700;
					jednotka2.poskozeni = 45;
					jednotka2.rychlost = 15;
					break;
				} else if (cislo == 2) {
					System.out.println("Zvolen ORK!");
					jednotka2.rasa = "ORK";
					jednotka2.zivoty = 550;
					jednotka2.max_zivoty = 550;
					jednotka2.poskozeni = 90;
					jednotka2.rychlost = 10;
					break;
				} else if (cislo == 3) {
					System.out.println("Zvolen ELF!");
					jednotka2.rasa = "ELF";
					jednotka2.zivoty = 400;
					jednotka2.max_zivoty = 400;
					jednotka2.poskozeni = 750;
					jednotka2.rychlost = 25;
					break;
				}
			}
		}

		
		//TYP
		System.out.println("1) RYTIR   -> Jeho utoky jsou efektivni proti MAG!");
		System.out.println("2) MAG     -> Jeho utoky jsou efektivni proti RYTIR!");//2x rytir?
		System.out.println("3) STRELEC -> Jeho utoky jsou efektivni proti RYTIR!");
		cislo = keyboard.nextInt();
		if (cislo == 1) {
			jednotka2.typ = "RYTIR";
			System.out.println("Zvolen RYTIR! Tva 1. jednotka je " + jednotka2.rasa + " " + jednotka2.typ);
		} else if (cislo == 2) {
			jednotka2.typ = "MAG";
			System.out.println("Zvolen MAG! Tva 1. jednotka je " + jednotka2.rasa + " " + jednotka2.typ);
		} else if (cislo == 3) {
			jednotka2.typ = "STRELEC";
			System.out.println("Zvolen STRELEC! Tva 1. jednotka je " + jednotka2.rasa + " " + jednotka2.typ);
		} else {
			while(true) {
				System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
				cislo = keyboard.nextInt();
				if (cislo == 1) {
					jednotka2.typ = "RYTIR";
					System.out.println("Zvolen RYTIR! Tva 1. jednotka je " + jednotka2.rasa + " " + jednotka2.typ);
					break;
				} else if (cislo == 2) {
					jednotka2.typ = "MAG";
					System.out.println("Zvolen MAG! Tva 1. jednotka je " + jednotka2.rasa + " " + jednotka2.typ);
					break;
				} else if (cislo == 3) {
					jednotka2.typ = "STRELEC";
					System.out.println("Zvolen STRELEC! Tva 1. jednotka je " + jednotka2.rasa + " " +jednotka2.typ);
					break;
				}
			}
		}
		
		poradi[1] = "druhy";
		
		//3. JEDNOTKA
		
		System.out.println("1. Jednotka:");
		System.out.println("1) CLOVEK -> velky pocet zivotu, male poskozeniy stredne rychlý!");
		System.out.println("2) ORK    -> velke poskozeni, stredne zivotuy, pomaly! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK A ELF");
		System.out.println("3) ELF    -> rychla jednotka, stredni poskozeni, malo zivotu! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK");
		
		
		
		//RASA
		cislo = keyboard.nextInt();
		if (cislo == 1) {
			System.out.println("Zvolen CLOVEK!");
			jednotka3.rasa = "CLOVEK";
			jednotka3.zivoty = 700;
			jednotka3.max_zivoty = 700;
			jednotka3.poskozeni = 45;
			jednotka3.rychlost = 15;
		} else if (cislo == 2) {
			System.out.println("Zvolen ORK!");
			jednotka3.rasa = "ORK";
			jednotka3.zivoty = 550;
			jednotka3.max_zivoty = 550;
			jednotka3.poskozeni = 90;
			jednotka3.rychlost = 10;
		} else if (cislo == 3) {
			System.out.println("Zvolen ELF!");
			jednotka3.rasa = "ELF";
			jednotka3.zivoty = 400;
			jednotka3.max_zivoty = 400;
			jednotka3.poskozeni = 750;
			jednotka3.rychlost = 25;
		} else {
			while(true) {
				System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
				cislo = keyboard.nextInt();
				if (cislo == 1) {
					System.out.println("Zvolen CLOVEK!");
					jednotka3.rasa = "CLOVEK";
					jednotka3.zivoty = 700;
					jednotka3.max_zivoty = 700;
					jednotka3.poskozeni = 45;
					jednotka3.rychlost = 15;
					break;
				} else if (cislo == 2) {
					System.out.println("Zvolen ORK!");
					jednotka3.rasa = "ORK";
					jednotka3.zivoty = 550;
					jednotka3.max_zivoty = 550;
					jednotka3.poskozeni = 90;
					jednotka3.rychlost = 10;
					break;
				} else if (cislo == 3) {
					System.out.println("Zvolen ELF!");
					jednotka3.rasa = "ELF";
					jednotka3.zivoty = 400;
					jednotka3.max_zivoty = 400;
					jednotka3.poskozeni = 750;
					jednotka3.rychlost = 25;
					break;
				}
			}
		}

		
		//TYP
		System.out.println("1) RYTIR   -> Jeho utoky jsou efektivni proti MAG!");
		System.out.println("2) MAG     -> Jeho utoky jsou efektivni proti RYTIR!");//2x rytir?
		System.out.println("3) STRELEC -> Jeho utoky jsou efektivni proti RYTIR!");
		cislo = keyboard.nextInt();
		if (cislo == 1) {
			jednotka3.typ = "RYTIR";
			System.out.println("Zvolen RYTIR! Tva 3. jednotka je " + jednotka3.rasa + " " + jednotka3.typ);
		} else if (cislo == 2) {
			jednotka3.typ = "MAG";
			System.out.println("Zvolen MAG! Tva 3. jednotka je " + jednotka3.rasa + " " + jednotka3.typ);
		} else if (cislo == 3) {
			jednotka3.typ = "STRELEC";
			System.out.println("Zvolen STRELEC! Tva 3. jednotka je " + jednotka3.rasa + " " + jednotka3.typ);
		} else {
			while(true) {
				System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
				cislo = keyboard.nextInt();
				if (cislo == 1) {
					jednotka3.typ = "RYTIR";
					System.out.println("Zvolen RYTIR! Tva 3. jednotka je " + jednotka3.rasa + " " + jednotka3.typ);
					break;
				} else if (cislo == 2) {
					jednotka3.typ = "MAG";
					System.out.println("Zvolen MAG! Tva 3. jednotka je " + jednotka3.rasa + " " + jednotka3.typ);
					break;
				} else if (cislo == 3) {
					jednotka3.typ = "STRELEC";
					System.out.println("Zvolen STRELEC! Tva 3. jednotka je " + jednotka3.rasa + " " +jednotka3.typ);
					break;
				}
			}
		}
		poradi[2] = "treti";

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
		
		
	}//konec start
	
	//*****************************FUNKCE**************************
	
	private void volba() {
		int cislo = keyboard.nextInt();
		if (cislo == 1) {
			inspect();
			System.out.println("");
			menu();
			volba();
		} else if (cislo==2) {
			fight();
		} else if (cislo == 3) {
			info();
		} else if(cislo == 4) {
			reorder();
		} else if(cislo == 5) {
			konec();
		}else  {
			System.out.println("SPATNE CISLO/ZNAK, ZADEJ ZNOVU: ");
			menu();
			volba();
		}
	}
	
	
	private void fight() {
		int i = 0;
		int n = 1;
		while(true) {
			
			if(jednotka1.zivoty<=0) {
				if (jednotka2.zivoty <=0) {
					if(jednotka3.zivoty <= 0) {
						System.out.println("PROHRAL JSI!");
						prohra_zisk_xp();
						System.out.println("");
						System.out.println("TVE JEDNOTKY SI MUSI ODPOCINOUT!");
						System.out.println("");
						break;
					}
				}
			}
				
			System.out.println(n+".KOLO");
			System.out.println(jednotka1.zivoty);
			System.out.println(jednotka2.zivoty);
			System.out.println(jednotka3.zivoty);
			System.out.println("");
			System.out.println(nepritel1.zivoty);
			System.out.println(nepritel2.zivoty);
			System.out.println(nepritel3.zivoty);
			if (poradi[i] == "prvni") {
				if(jednotka1.zivoty >0) {
					if(nepritel1.zivoty > 0) {//zivy 1nepratel
						//ODSUD KOPÍROVAT
						if(jednotka1.rychlost > nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NASI JEDNOTKY
							if(jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka1.zivoty = jednotka1.zivoty - nepritel1.poskozeni ;
									}
								}
							}else if(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka1.zivoty = jednotka1.zivoty - nepritel1.poskozeni ;
									}
								}
							}else if(jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka1.zivoty = jednotka1.zivoty - nepritel1.poskozeni ;										
									}
								}
							}else {
								//1NORMALNI UTOK NASI JEDNOTKY
								nepritel1.zivoty = nepritel1.zivoty - jednotka1.poskozeni;
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka1.zivoty = jednotka1.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}
							
							
							
							//UTOK NEPRATELE
						}else if(jednotka1.rychlost<nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
							if(nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") {
								jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka1.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									}else if(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else if(jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka1.poskozeni ;
									}
								}
							}else if(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
								jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka1.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									}else if(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else if(jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka1.poskozeni ;
									}
								}
							}else if(nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR") {
								jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka1.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									}else if(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else if(jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka1.poskozeni ;
									}
								}
							}else {
								//1NORMALNI UTOK NEPRATESKE JEDNOTKY
								jednotka1.zivoty = jednotka1.zivoty - nepritel1.poskozeni;
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka1.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									}else if(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else if(jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka1.poskozeni ;
									}
								}
							}
						}
					
					
						//PODSUD KOPIROVAT
					}else if(nepritel1.zivoty <= 0) {//mrtvy 1nepratel 
						if(nepritel2.zivoty > 0) {//zivy 2nepratel
							//ZDE NAKOPIROVAT PREDCHOZI TEXT*
							if(jednotka1.rychlost > nepritel2.rychlost) {
								//1EFEKTIVNI UTOK NASI JEDNOTKY
								if(jednotka1.typ == "RYTIR" && nepritel2.typ == "MAG") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka1.typ == "MAG") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka1.zivoty = jednotka1.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else if(jednotka1.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka1.typ == "MAG") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka1.zivoty = jednotka1.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else if(jednotka1.typ == "MAG" && nepritel2.typ == "RYTIR") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka1.typ == "MAG") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka1.zivoty = jednotka1.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else {
									//1NORMALNI UTOK NASI JEDNOTKY
									nepritel2.zivoty = nepritel2.zivoty - jednotka1.poskozeni;
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka1.typ == "MAG") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka1.typ == "RYTIR") {
											jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka1.zivoty = jednotka1.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}
								
								
								
								//UTOK NEPRATELE
							}else if(jednotka1.rychlost<nepritel2.rychlost) {
								//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
								if(nepritel2.typ == "RYTIR" && jednotka1.typ == "MAG") {
									jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka1.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka1.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										}else if(jednotka1.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else if(jednotka1.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka1.poskozeni ;
										}
									}
								}else if(nepritel2.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
									jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka1.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka1.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										}else if(jednotka1.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else if(jednotka1.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka1.poskozeni ;
										}
									}
								}else if(nepritel2.typ == "MAG" && jednotka1.typ == "RYTIR") {
									jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka1.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka1.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										}else if(jednotka1.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else if(jednotka1.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka1.poskozeni ;
										}
									}
								}else {
									//1NORMALNI UTOK NEPRATESKE JEDNOTKY
									jednotka1.zivoty = jednotka1.zivoty - nepritel2.poskozeni;
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka1.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka1.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										}else if(jednotka1.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else if(jednotka1.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka1.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka1.poskozeni ;
										}
									}
								}
							}
						}else if(nepritel2.zivoty <=0) {//mrtvy 2neprtatel
							if(nepritel3.zivoty > 0) {//zivy 3nepratel
								//ZDE NAKOPIROVAT PREDCHOZI TEXT*
								if(jednotka1.rychlost > nepritel3.rychlost) {
									//1EFEKTIVNI UTOK NASI JEDNOTKY
									if(jednotka1.typ == "RYTIR" && nepritel3.typ == "MAG") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka1.typ == "MAG") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka1.zivoty = jednotka1.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else if(jednotka1.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka1.typ == "MAG") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka1.zivoty = jednotka1.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else if(jednotka1.typ == "MAG" && nepritel3.typ == "RYTIR") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka1.typ == "MAG") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka1.zivoty = jednotka1.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else {
										//1NORMALNI UTOK NASI JEDNOTKY
										nepritel3.zivoty = nepritel3.zivoty - jednotka1.poskozeni;
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka1.typ == "MAG") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka1.typ == "RYTIR") {
												jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka1.zivoty = jednotka1.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}
									
									
									
									//UTOK NEPRATELE
								}else if(jednotka1.rychlost<nepritel3.rychlost) {
									//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
									if(nepritel3.typ == "RYTIR" && jednotka1.typ == "MAG") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka1.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka1.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											}else if(jednotka1.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else if(jednotka1.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka1.poskozeni ;
											}
										}
									}else if(nepritel3.typ == "STRELEC" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka1.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka1.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											}else if(jednotka1.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else if(jednotka1.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka1.poskozeni ;
											}
										}
									}else if(nepritel3.typ == "MAG" && jednotka1.typ == "RYTIR") {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka1.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka1.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											}else if(jednotka1.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else if(jednotka1.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka1.poskozeni ;
											}
										}
									}else {
										//1NORMALNI UTOK NEPRATESKE JEDNOTKY
										jednotka1.zivoty = jednotka1.zivoty - nepritel3.poskozeni;
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka1.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka1.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											}else if(jednotka1.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else if(jednotka1.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka1.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka1.poskozeni ;
											}
										}
									}
								}
							}else if(nepritel3.zivoty <= 0) {//mrtvy 3nepratel
								System.out.println("VYBORNE, ZABL JSI VSECHNY NEPRATELE! ZDE JE TVA CAST DIAMANTU!");//VYHRA
								pocet_diamantu++;
								vyhra_zisk_zk();
								break;
							}
						}
					}
				}else if (jednotka1.zivoty<=0) {
					System.out.println("VASE " +(i+1)+". JEDNOTKA JE MRTVA!");
					i++;
				}
			}else if(poradi[i] == "druhy") {
				if(jednotka2.zivoty >0) {
					if(nepritel1.zivoty > 0) {//zivy 1nepratel
						//ODSUD KOPÍROVAT
						if(jednotka2.rychlost > nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NASI JEDNOTKY
							if(jednotka2.typ == "RYTIR" && nepritel1.typ == "MAG") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka2.typ == "MAG") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka2.zivoty = jednotka2.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}else if(jednotka2.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka2.typ == "MAG") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka2.zivoty = jednotka2.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}else if(jednotka2.typ == "MAG" && nepritel1.typ == "RYTIR") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka2.typ == "MAG") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka2.zivoty = jednotka2.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}else {
								//1NORMALNI UTOK NASI JEDNOTKY
								nepritel1.zivoty = nepritel1.zivoty - jednotka2.poskozeni;
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka2.typ == "MAG") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka2.zivoty = jednotka2.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}
							
							
							
							//UTOK NEPRATELE
						}else if(jednotka2.rychlost<nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
							if(nepritel1.typ == "RYTIR" && jednotka2.typ == "MAG") {
								jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka2.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka2.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									}else if(jednotka2.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else if(jednotka2.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka2.poskozeni ;
									}
								}
							}else if(nepritel1.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
								jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka2.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka2.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									}else if(jednotka2.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else if(jednotka2.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka2.poskozeni ;
									}
								}
							}else if(nepritel1.typ == "MAG" && jednotka2.typ == "RYTIR") {
								jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka2.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka2.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									}else if(jednotka2.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else if(jednotka2.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka2.poskozeni ;
									}
								}
							}else {
								//1NORMALNI UTOK NEPRATESKE JEDNOTKY
								jednotka2.zivoty = jednotka2.zivoty - nepritel1.poskozeni;
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka2.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka2.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									}else if(jednotka2.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else if(jednotka2.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka2.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka2.poskozeni ;
									}
								}
							}
						}
					
					
						//PODSUD KOPIROVAT
					}else if(nepritel1.zivoty <= 0) {//mrtvy 1nepratel 
						if(nepritel2.zivoty > 0) {//zivy 2nepratel
							//ZDE NAKOPIROVAT PREDCHOZI TEXT*
							if(jednotka2.rychlost > nepritel2.rychlost) {
								//1EFEKTIVNI UTOK NASI JEDNOTKY
								if(jednotka2.typ == "RYTIR" && nepritel2.typ == "MAG") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka2.typ == "MAG") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka2.zivoty = jednotka2.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else if(jednotka2.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka2.typ == "MAG") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka2.zivoty = jednotka2.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else if(jednotka2.typ == "MAG" && nepritel2.typ == "RYTIR") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka2.typ == "MAG") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka2.zivoty = jednotka2.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else {
									//1NORMALNI UTOK NASI JEDNOTKY
									nepritel2.zivoty = nepritel2.zivoty - jednotka2.poskozeni;
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka2.typ == "MAG") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka2.typ == "RYTIR") {
											jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka2.zivoty = jednotka2.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}
								
								
								
								//UTOK NEPRATELE
							}else if(jednotka2.rychlost<nepritel2.rychlost) {
								//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
								if(nepritel2.typ == "RYTIR" && jednotka2.typ == "MAG") {
									jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka2.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka2.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										}else if(jednotka2.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else if(jednotka2.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka2.poskozeni ;
										}
									}
								}else if(nepritel2.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
									jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka2.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka2.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										}else if(jednotka2.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else if(jednotka2.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka2.poskozeni ;
										}
									}
								}else if(nepritel2.typ == "MAG" && jednotka2.typ == "RYTIR") {
									jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka2.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka2.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										}else if(jednotka2.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else if(jednotka2.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka2.poskozeni ;
										}
									}
								}else {
									//1NORMALNI UTOK NEPRATESKE JEDNOTKY
									jednotka2.zivoty = jednotka2.zivoty - nepritel2.poskozeni;
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka2.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka2.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										}else if(jednotka2.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else if(jednotka2.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka2.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka2.poskozeni ;
										}
									}
								}
							}
						}else if(nepritel2.zivoty <=0) {//mrtvy 2neprtatel
							if(nepritel3.zivoty > 0) {//zivy 3nepratel
								//ZDE NAKOPIROVAT PREDCHOZI TEXT*
								if(jednotka2.rychlost > nepritel3.rychlost) {
									//1EFEKTIVNI UTOK NASI JEDNOTKY
									if(jednotka2.typ == "RYTIR" && nepritel3.typ == "MAG") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka2.typ == "MAG") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka2.zivoty = jednotka2.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else if(jednotka2.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka2.typ == "MAG") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka2.zivoty = jednotka2.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else if(jednotka2.typ == "MAG" && nepritel3.typ == "RYTIR") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka2.typ == "MAG") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka2.zivoty = jednotka2.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else {
										//1NORMALNI UTOK NASI JEDNOTKY
										nepritel3.zivoty = nepritel3.zivoty - jednotka2.poskozeni;
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka2.typ == "MAG") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka2.typ == "RYTIR") {
												jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka2.zivoty = jednotka2.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}
									
									
									
									//UTOK NEPRATELE
								}else if(jednotka2.rychlost<nepritel3.rychlost) {
									//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
									if(nepritel3.typ == "RYTIR" && jednotka2.typ == "MAG") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka2.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka2.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											}else if(jednotka2.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else if(jednotka2.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka2.poskozeni ;
											}
										}
									}else if(nepritel3.typ == "STRELEC" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka2.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka2.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = jednotka2.zivoty - (int) (jednotka2.poskozeni * 1.3);
											}else if(jednotka2.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else if(jednotka2.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka2.poskozeni ;
											}
										}
									}else if(nepritel3.typ == "MAG" && jednotka2.typ == "RYTIR") {
										jednotka2.zivoty = jednotka2.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka2.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka2.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											}else if(jednotka2.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else if(jednotka2.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka2.poskozeni ;
											}
										}
									}else {
										//1NORMALNI UTOK NEPRATESKE JEDNOTKY
										jednotka2.zivoty = jednotka2.zivoty - nepritel3.poskozeni;
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka2.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka2.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											}else if(jednotka2.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = jednotka2.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else if(jednotka2.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka2.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka2.poskozeni ;
											}
										}
									}
								}
							}else if(nepritel3.zivoty <= 0) {//mrtvy 3nepratel
								System.out.println("VYBORNE, ZABL JSI VSECHNY NEPRATELE! ZDE JE TVA CAST DIAMANTU!");//VYHRA
								pocet_diamantu++;
								vyhra_zisk_zk();
								break;
							}
						}
					}
				}else if (jednotka2.zivoty<=0) {
					System.out.println("VASE " +(i+1)+". JEDNOTKA JE MRTVA!");
					i++;
				}
			}else if(poradi[i] == "treti") {
				if(jednotka3.zivoty >0) {
					if(nepritel1.zivoty > 0) {//zivy 1nepratel
						//ODSUD KOPÍROVAT
						if(jednotka3.rychlost > nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NASI JEDNOTKY
							if(jednotka3.typ == "RYTIR" && nepritel1.typ == "MAG") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka3.typ == "MAG") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka3.zivoty = jednotka3.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}else if(jednotka3.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka3.typ == "MAG") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka3.zivoty = jednotka3.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}else if(jednotka3.typ == "MAG" && nepritel1.typ == "RYTIR") {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka3.typ == "MAG") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka3.zivoty = jednotka3.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}else {
								//1NORMALNI UTOK NASI JEDNOTKY
								nepritel1.zivoty = nepritel1.zivoty - jednotka3.poskozeni;
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if(nepritel1.typ == "RYTIR" && jednotka3.typ == "MAG") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									}else if(nepritel1.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else if(nepritel1.typ == "MAG" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
										
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka3.zivoty = jednotka3.zivoty - nepritel1.poskozeni ;
										
									}
								}
							}
							
							
							
							//UTOK NEPRATELE
						}else if(jednotka3.rychlost<nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
							if(nepritel1.typ == "RYTIR" && jednotka3.typ == "MAG") {
								jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka3.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka3.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									}else if(jednotka3.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else if(jednotka3.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka3.poskozeni ;
									}
								}
							}else if(nepritel1.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
								jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka3.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka3.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									}else if(jednotka3.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else if(jednotka3.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka3.poskozeni ;
									}
								}
							}else if(nepritel1.typ == "MAG" && jednotka3.typ == "RYTIR") {
								jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka3.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka3.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									}else if(jednotka3.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else if(jednotka3.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka3.poskozeni ;
									}
								}
							}else {
								//1NORMALNI UTOK NEPRATESKE JEDNOTKY
								jednotka3.zivoty = jednotka3.zivoty - nepritel1.poskozeni;
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka3.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if(jednotka3.typ == "RYTIR" && nepritel1.typ == "MAG") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									}else if(jednotka3.typ == "STRELEC" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else if(jednotka3.typ == "MAG" && nepritel1.typ == "RYTIR") {
										nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka3.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										nepritel1.zivoty = nepritel1.zivoty - jednotka3.poskozeni ;
									}
								}
							}
						}
					
					
						//PODSUD KOPIROVAT
					}else if(nepritel1.zivoty <= 0) {//mrtvy 1nepratel 
						if(nepritel2.zivoty > 0) {//zivy 2nepratel
							//ZDE NAKOPIROVAT PREDCHOZI TEXT*
							if(jednotka3.rychlost > nepritel2.rychlost) {
								//1EFEKTIVNI UTOK NASI JEDNOTKY
								if(jednotka3.typ == "RYTIR" && nepritel2.typ == "MAG") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka3.typ == "MAG") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka3.zivoty = jednotka3.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else if(jednotka3.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka3.typ == "MAG") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka3.zivoty = jednotka3.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else if(jednotka3.typ == "MAG" && nepritel2.typ == "RYTIR") {
									nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka3.typ == "MAG") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka3.zivoty = jednotka3.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}else {
									//1NORMALNI UTOK NASI JEDNOTKY
									nepritel2.zivoty = nepritel2.zivoty - jednotka3.poskozeni;
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
									if(nepritel2.zivoty > 0) {
										//EFEKTIVNI UTOK NEPRITELE
										if(nepritel2.typ == "RYTIR" && jednotka3.typ == "MAG") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										}else if(nepritel2.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else if(nepritel2.typ == "MAG" && jednotka3.typ == "RYTIR") {
											jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
											
										} else {
											//NORMALNI UTOK NEPRITELE
											jednotka3.zivoty = jednotka3.zivoty - nepritel2.poskozeni ;
											
										}
									}
								}
								
								
								
								//UTOK NEPRATELE
							}else if(jednotka3.rychlost<nepritel2.rychlost) {
								//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
								if(nepritel2.typ == "RYTIR" && jednotka3.typ == "MAG") {
									jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka3.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka3.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										}else if(jednotka3.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else if(jednotka3.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka3.poskozeni ;
										}
									}
								}else if(nepritel2.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
									jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka3.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka3.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										}else if(jednotka3.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else if(jednotka3.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka3.poskozeni ;
										}
									}
								}else if(nepritel2.typ == "MAG" && jednotka3.typ == "RYTIR") {
									jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel2.poskozeni * 1.3);
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka3.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka3.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										}else if(jednotka3.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else if(jednotka3.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka3.poskozeni ;
										}
									}
								}else {
									//1NORMALNI UTOK NEPRATESKE JEDNOTKY
									jednotka3.zivoty = jednotka3.zivoty - nepritel2.poskozeni;
									//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
									if(jednotka3.zivoty > 0) {
										//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
										if(jednotka3.typ == "RYTIR" && nepritel2.typ == "MAG") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										}else if(jednotka3.typ == "STRELEC" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else if(jednotka3.typ == "MAG" && nepritel2.typ == "RYTIR") {
											nepritel2.zivoty = nepritel2.zivoty - (int) (jednotka3.poskozeni * 1.3);
										} else {
											//NORMALNI UTOK NEPRITELE
											nepritel2.zivoty = nepritel2.zivoty - jednotka3.poskozeni ;
										}
									}
								}
							}
						}else if(nepritel2.zivoty <=0) {//mrtvy 2neprtatel
							if(nepritel3.zivoty > 0) {//zivy 3nepratel
								//ZDE NAKOPIROVAT PREDCHOZI TEXT*
								if(jednotka3.rychlost > nepritel3.rychlost) {
									//1EFEKTIVNI UTOK NASI JEDNOTKY
									if(jednotka3.typ == "RYTIR" && nepritel3.typ == "MAG") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka3.typ == "MAG") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka3.zivoty = jednotka3.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else if(jednotka3.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka3.typ == "MAG") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka3.zivoty = jednotka3.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else if(jednotka3.typ == "MAG" && nepritel3.typ == "RYTIR") {
										nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka3.typ == "MAG") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka3.zivoty = jednotka3.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}else {
										//1NORMALNI UTOK NASI JEDNOTKY
										nepritel3.zivoty = nepritel3.zivoty - jednotka3.poskozeni;
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
										if(nepritel3.zivoty > 0) {
											//EFEKTIVNI UTOK NEPRITELE
											if(nepritel3.typ == "RYTIR" && jednotka3.typ == "MAG") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											}else if(nepritel3.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else if(nepritel3.typ == "MAG" && jednotka3.typ == "RYTIR") {
												jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
												
											} else {
												//NORMALNI UTOK NEPRITELE
												jednotka3.zivoty = jednotka3.zivoty - nepritel3.poskozeni ;
												
											}
										}
									}
									
									
									
									//UTOK NEPRATELE
								}else if(jednotka3.rychlost<nepritel3.rychlost) {
									//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
									if(nepritel3.typ == "RYTIR" && jednotka3.typ == "MAG") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka3.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka3.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											}else if(jednotka3.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else if(jednotka3.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka3.poskozeni ;
											}
										}
									}else if(nepritel3.typ == "STRELEC" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka3.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka3.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											}else if(jednotka3.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else if(jednotka3.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka3.poskozeni ;
											}
										}
									}else if(nepritel3.typ == "MAG" && jednotka3.typ == "RYTIR") {
										jednotka3.zivoty = jednotka3.zivoty - (int) (nepritel3.poskozeni * 1.3);
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka3.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka3.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											}else if(jednotka3.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else if(jednotka3.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka3.poskozeni ;
											}
										}
									}else {
										//1NORMALNI UTOK NEPRATESKE JEDNOTKY
										jednotka3.zivoty = jednotka3.zivoty - nepritel3.poskozeni;
										//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
										if(jednotka3.zivoty > 0) {
											//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
											if(jednotka3.typ == "RYTIR" && nepritel3.typ == "MAG") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											}else if(jednotka3.typ == "STRELEC" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else if(jednotka3.typ == "MAG" && nepritel3.typ == "RYTIR") {
												nepritel3.zivoty = nepritel3.zivoty - (int) (jednotka3.poskozeni * 1.3);
											} else {
												//NORMALNI UTOK NEPRITELE
												nepritel3.zivoty = nepritel3.zivoty - jednotka3.poskozeni ;
											}
										}
									}
								}
							}else if(nepritel3.zivoty <= 0) {//mrtvy 3nepratel
								System.out.println("VYBORNE, ZABL JSI VSECHNY NEPRATELE! ZDE JE TVA CAST DIAMANTU!");//VYHRA
								pocet_diamantu++;
								vyhra_zisk_zk();
								break;
							}
						}
					}
				}else if (jednotka3.zivoty<=0) {
					System.out.println("VASE " +(i+1)+". JEDNOTKA JE MRTVA!");
					i++;
				}
			}
			n++;
			
		}//konec while
		
		jednotka1.zivoty = jednotka1.max_zivoty;
		jednotka2.zivoty = jednotka2.max_zivoty;
		jednotka3.zivoty = jednotka3.max_zivoty;
	}



	private void vyhra_zisk_zk() {
		jednotka1.zkusenosti = rand.nextInt(max_xp - min_xp) + min_xp;
		jednotka2.zkusenosti = rand.nextInt(max_xp - min_xp) + min_xp;
		jednotka3.zkusenosti = rand.nextInt(max_xp - min_xp) + min_xp;
		kontrola_xp();
		
	}



	private void prohra_zisk_xp() {
		jednotka1.zkusenosti = (rand.nextInt(max_xp - min_xp) + min_xp)/2;
		jednotka2.zkusenosti = (rand.nextInt(max_xp - min_xp) + min_xp)/2;
		jednotka3.zkusenosti = (rand.nextInt(max_xp - min_xp) + min_xp)/2;
		kontrola_xp();
	}



	private void kontrola_xp() {
		if(jednotka1.zkusenosti >= jednotka1.max_zkusenosti) {
			jednotka1.max_zkusenosti = jednotka1.max_zkusenosti + 25;
			jednotka1.zkusenosti = 0;
			jednotka1.max_zivoty = jednotka1.max_zivoty + rand.nextInt(30-15)+15;
			jednotka1.poskozeni = jednotka1.poskozeni + rand.nextInt(15-2)+2;
			System.out.println(jednotka1.rasa+" "+jednotka1.typ+" zvysil svou uroven!");
		}
		if(jednotka2.zkusenosti >= jednotka2.max_zkusenosti) {
			jednotka2.max_zkusenosti = jednotka2.max_zkusenosti + 25;
			jednotka2.zkusenosti = 0;
			jednotka2.max_zivoty = jednotka2.max_zivoty + rand.nextInt(30-15)+15;
			jednotka2.poskozeni = jednotka2.poskozeni + rand.nextInt(15-2)+2;
			System.out.println(jednotka2.rasa+" "+jednotka2.typ+" zvysil svou uroven!");
		}
		if(jednotka3.zkusenosti >= jednotka3.max_zkusenosti) {
			jednotka3.max_zkusenosti = jednotka3.max_zkusenosti + 25;
			jednotka3.zkusenosti = 0;
			jednotka3.max_zivoty = jednotka3.max_zivoty + rand.nextInt(30-15)+15;
			jednotka3.poskozeni = jednotka3.poskozeni + rand.nextInt(15-2)+2;
			System.out.println(jednotka3.rasa+" "+jednotka3.typ+" zvysil svou uroven!");
		}
	}



	private void reorder() {
		info();
		String x = "";
		System.out.println("Zadejte, na jake pozici ma byt vase prvni jednotka: ");
		int cislo = keyboard.nextInt();
		if(cislo == 2) {
			x = poradi[1];
			poradi[1] = poradi[0];
			poradi[0] = x;
		} else if(cislo == 3) {
			x = poradi[2];
			poradi[2] = poradi[0];
			poradi[0] = x;
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
		System.out.println("1. "+ nepritel1.rasa + " " +nepritel1.typ + "| Zivoty: " + nepritel1.zivoty + " Poskozeni: " + nepritel1.poskozeni + " Rychlost: " + nepritel1.rychlost);
		System.out.println("2. "+ nepritel2.rasa + " " +nepritel2.typ + "| Zivoty: " + nepritel2.zivoty + " Poskozeni: " + nepritel2.poskozeni + " Rychlost: " + nepritel2.rychlost);
		System.out.println("3. "+ nepritel3.rasa + " " +nepritel3.typ +" | Zivoty: " + nepritel3.zivoty + " Poskozeni: " + nepritel3.poskozeni + " Rychlost: " + nepritel3.rychlost);
	}



	
	
	private void vytvoreni_nepratel() {
		int prvni = rand.nextInt(9);
		int druhy = rand.nextInt(9);
		int treti = rand.nextInt(9);

		
		//prvni
		if (prvni == 0) {
			nepritel1.rasa = "CLOVEK";
			nepritel1.typ = "RYTIR";
			nepritel1.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
			nepritel1.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel1.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (prvni == 1) {
			nepritel1.rasa = "CLOVEK";
			nepritel1.typ = "MAG";
			nepritel1.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
			nepritel1.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel1.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (prvni == 2) {
			nepritel1.rasa = "CLOVEK";
			nepritel1.typ = "STRELEC";
			nepritel1.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
			nepritel1.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel1.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (prvni == 3) {
			nepritel1.rasa = "ORK";
			nepritel1.typ = "RYTIR";
			nepritel1.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel1.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel1.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (prvni == 4) {
			nepritel1.rasa = "ORK";
			nepritel1.typ = "MAG";
			nepritel1.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel1.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel1.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (prvni == 5) {
			nepritel1.rasa = "ORK";
			nepritel1.typ = "STRELEC";
			nepritel1.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel1.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel1.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (prvni == 6) {
			nepritel1.rasa = "ELF";
			nepritel1.typ = "RYTIR";
			nepritel1.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel1.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel1.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}else if (prvni == 7) {
			nepritel1.rasa = "ELF";
			nepritel1.typ = "MAG";
			nepritel1.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel1.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel1.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}else if (prvni == 8) {
			nepritel1.rasa = "ELF";
			nepritel1.typ = "STRELEC";
			nepritel1.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel1.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel1.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}
		
		//druhy
		if (druhy == 0) {
			nepritel2.rasa = "CLOVEK";
			nepritel2.typ = "RYTIR";
			nepritel2.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
			nepritel2.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel2.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (druhy == 1) {
			nepritel2.rasa = "CLOVEK";
			nepritel2.typ = "MAG";
			nepritel2.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
			nepritel2.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel2.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (druhy == 2) {
			nepritel2.rasa = "CLOVEK";
			nepritel2.typ = "STRELEC";
			nepritel2.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;
			nepritel2.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel2.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (druhy == 3) {
			nepritel2.rasa = "ORK";
			nepritel2.typ = "RYTIR";
			nepritel2.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel2.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel2.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (druhy == 4) {
			nepritel2.rasa = "ORK";
			nepritel2.typ = "MAG";
			nepritel2.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel2.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel2.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (druhy == 5) {
			nepritel2.rasa = "ORK";
			nepritel2.typ = "STRELEC";
			nepritel2.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel2.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel2.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (druhy == 6) {
			nepritel2.rasa = "ELF";
			nepritel2.typ = "RYTIR";
			nepritel2.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel2.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel2.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}else if (druhy == 7) {
			nepritel2.rasa = "ELF";
			nepritel2.typ = "MAG";
			nepritel2.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel2.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel2.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}else if (druhy == 8) {
			nepritel2.rasa = "ELF";
			nepritel2.typ = "STRELEC";
			nepritel2.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel2.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel2.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}
		
		//treti
		if (treti == 0) {
			nepritel3.rasa = "CLOVEK";
			nepritel3.typ = "RYTIR";
			nepritel3.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;;
			nepritel3.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel3.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (treti == 1) {
			nepritel3.rasa = "CLOVEK";
			nepritel3.typ = "MAG";
			nepritel3.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;;
			nepritel3.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel3.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (treti == 2) {
			nepritel3.rasa = "CLOVEK";
			nepritel3.typ = "STRELEC";
			nepritel3.zivoty = rand.nextInt(hp_clovek_max - hp_clovek) + hp_clovek;;
			nepritel3.poskozeni = rand.nextInt(poskozeni_clovek_max - poskozeni_clovek) + poskozeni_clovek;
			nepritel3.rychlost = rand.nextInt(rychlost_clovek_max - rychlost_clovek) + rychlost_clovek;
		}else if (treti == 3) {
			nepritel3.rasa = "ORK";
			nepritel3.typ = "RYTIR";
			nepritel3.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel3.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel3.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (treti == 4) {
			nepritel3.rasa = "ORK";
			nepritel3.typ = "MAG";
			nepritel3.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel3.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel3.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (treti == 5) {
			nepritel3.rasa = "ORK";
			nepritel3.typ = "STRELEC";
			nepritel3.zivoty = rand.nextInt(hp_ork_max - hp_ork) + hp_ork;
			nepritel3.poskozeni = rand.nextInt(poskozeni_ork_max - poskozeni_ork) + poskozeni_ork;
			nepritel3.rychlost = rand.nextInt(rychlost_ork_max - rychlost_ork) + rychlost_ork;
		}else if (treti == 6) {
			nepritel3.rasa = "ELF";
			nepritel3.typ = "RYTIR";
			nepritel3.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel3.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel3.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}else if (treti == 7) {
			nepritel3.rasa = "ELF";
			nepritel3.typ = "MAG";
			nepritel3.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel3.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel3.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
		}else if (treti == 8) {
			nepritel3.rasa = "ELF";
			nepritel3.typ = "STRELEC";
			nepritel3.zivoty = rand.nextInt(hp_elf_max - hp_elf) + hp_elf;
			nepritel3.poskozeni = rand.nextInt(poskozeni_elf_max - poskozeni_elf) + poskozeni_elf;
			nepritel3.rychlost = rand.nextInt(rychlost_elf_max - rychlost_elf) + rychlost_elf;
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
	        {}  
	 }
	
	private void konec() {
		System.out.println("HRA UKONCENA!");
		System.exit(0);
	}



	private void info() {
		String a ="1. "+ jednotka1.rasa + " " +jednotka1.typ + " lvl "+ jednotka1.uroven+ "| Zivoty: " + jednotka1.zivoty + " Poskozeni: " + jednotka1.poskozeni + " Rychlost: " + jednotka1.rychlost +" XP:"+ jednotka1.zkusenosti + "/" + jednotka1.max_zkusenosti;
		String b ="2. "+ jednotka2.rasa + " " +jednotka2.typ + " lvl "+ jednotka2.uroven+"| Zivoty: " + jednotka2.zivoty + " Poskozeni: " + jednotka2.poskozeni + " Rychlost: " + jednotka2.rychlost+" XP:"+ jednotka2.zkusenosti + "/" + jednotka2.max_zkusenosti;
		String c ="3. "+ jednotka3.rasa + " " +jednotka3.typ + " lvl "+ jednotka3.uroven+"| Zivoty: " + jednotka3.zivoty + " Poskozeni: " + jednotka3.poskozeni + " Rychlost: " + jednotka3.rychlost+" XP:"+ jednotka3.zkusenosti + "/" + jednotka3.max_zkusenosti;
		String dia ="   Pocet diamantu: " + pocet_diamantu;
		
		if(poradi[0] == "prvni") {
			if(poradi[1] == "druhy") {
				if(poradi[2] == "treti") {
					System.out.println(a);
					System.out.println(b);
					System.out.println(c);
					System.out.println(dia);
				}
			}
		}
		if(poradi[0] == "prvni") {
			if(poradi[1] == "treti") {
				if(poradi[2] == "druhy") {
					System.out.println(a);
					System.out.println(c);
					System.out.println(b);
					System.out.println(dia);
				}
			}
		}
		if(poradi[0] == "druhy") {
			if(poradi[1] == "prvni") {
				if(poradi[2] == "treti") {
					System.out.println(b);
					System.out.println(a);
					System.out.println(c);
					System.out.println(dia);
				}
			}
		}
		if(poradi[0] == "druhy") {
			if(poradi[1] == "treti") {
				if(poradi[2] == "prvni") {
					System.out.println(b);
					System.out.println(c);
					System.out.println(a);
					System.out.println(dia);
				}
			}
		}
		if(poradi[0] == "treti") {
			if(poradi[1] == "druhy") {
				if(poradi[2] == "prvni") {
					System.out.println(c);
					System.out.println(b);
					System.out.println(a);
					System.out.println(dia);
				}
			}
		}
		if(poradi[0] == "treti") {
			if(poradi[1] == "prvni") {
				if(poradi[2] == "druhy") {
					System.out.println(c);
					System.out.println(a);
					System.out.println(b);
					System.out.println(dia);
				}
			}
		}
	}



	public void menu() {

		System.out.println("1)inspect -> Prohlidnout sve protivniky a jejich pozice");
		System.out.println("2)fight -> zahajit souboj!");
		System.out.println("3)info -> vypise info o jednotkach + pocet ziskanych diamantu");
		System.out.println("4)reorder -> zmena poradi jednotek");
		System.out.println("5)RIP -> ukoncit hru! :(");
	}
	
}
