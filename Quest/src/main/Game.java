package main;

import java.util.Random;
import java.util.Scanner;


public class Game implements lGame{

	int pocet_diamantu =0;
	Jednotka[] Jednotky = new Jednotka[3];
	Jednotka[] Nepratele = new Jednotka[3];
	
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
		
		
	}//konec start

	//*****************************FUNKCE**************************
	
	private void volbaJednotky() {
		
		for(int i=0;i<3;i++) {
			System.out.println((i+1)+". Jednotka:");
			System.out.println("1) CLOVEK -> velky pocet zivotu, male poskozeni, stredne rychly!");
			System.out.println("2) ORK    -> velke poskozeni, stredne zivotuy, pomaly! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK A ELF");
			System.out.println("3) ELF    -> rychla jednotka, stredni poskozeni, malo zivotu! JEHO UTOKY JSOU EFEKTIVNI PROTI CLOVEK");
			int cislo = keyboard.nextInt();


			// TODO
			if (cislo == 1) {
				// TODO opat tu pouzivas magicke cisla, idealne si tieto konstanty pomenovat ako metode volba
				System.out.println("Zvolen CLOVEK!");
				Jednotky[i] = new Clovek();
			} else if (cislo == 2) {
				System.out.println("Zvolen ORK!");
				Jednotky[i] = new Ork();
			} else if (cislo == 3) {
				System.out.println("Zvolen ELF!");
				Jednotky[i] = new Elf();
			} else {
				while(true) {
					System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
					cislo = keyboard.nextInt();
					if (cislo == 1) {
						System.out.println("Zvolen CLOVEK!");
						Jednotky[i] = new Clovek();
						break;
					} else if (cislo == 2) {
						System.out.println("Zvolen ORK!");
						Jednotky[i] = new Ork();
						break;
					} else if (cislo == 3) {
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
			cislo = keyboard.nextInt();
			// TODO opat tu pouzivas magicke cisla, idealne si tieto konstanty pomenovat ako metode volba
			if (cislo == 1) {
				Jednotky[i].typ = "RYTIR";
				System.out.println("Zvolen RYTIR! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
			} else if (cislo == 2) {
				Jednotky[i].typ = "MAG";
				System.out.println("Zvolen MAG! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
			} else if (cislo == 3) {
				Jednotky[i].typ = "STRELEC";
				System.out.println("Zvolen STRELEC! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
			} else {
				while(true) {
					System.out.println("ZADAL SI SPATNY PRIKAZ, ZKUS TO ZNOVU!");
					cislo = keyboard.nextInt();
					if (cislo == 1) {
						Jednotky[i].typ = "RYTIR";
						System.out.println("Zvolen RYTIR! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
						break;
					} else if (cislo == 2) {
						Jednotky[i].typ = "MAG";
						System.out.println("Zvolen MAG! Tva "+(i+1)+". jednotka je " + Jednotky[i].rasa + " " + Jednotky[i].typ);
						break;
					} else if (cislo == 3) {
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
		// TODO tieto konstanty si mozes vytiahnut na class level, ako atributy, aby si ich mohol znova niekde inde pouzivat
		final int INSPECT = 1;
		final int FIGHT = 2;
		final int INFO = 3;
		final int REORDER = 4;
		final int KONEC = 5;
		if (cislo == INSPECT) {
			inspect();
			System.out.println("");
			menu();
			volba();
		} else if (cislo==FIGHT) {
			//fight();
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
	
	/*
	private void fight() {
		int i = 0;
		int n = 1;
		while(true) {
			//  TODO 4. namiesto niekolko nasobneho zanorovania vies kombinovat podmienky do jednej
			// 	TODO teda namiesto if(...){if(...){}} vies urobit if(... && ...){}
			if(jednotka1.zivoty<=0 && jednotka2.zivoty <= 0 && jednotka3.zivoty <= 0) {
				System.out.println("PROHRAL JSI!");
				Jednotky[0].zisk_xp(2);
				System.out.println("");
				System.out.println("TVE JEDNOTKY SI MUSI ODPOCINOUT!");
				System.out.println("");
				break;
			}
				
			System.out.println(n+".KOLO");
			// TODO 5. tunak by ti pomohlo mat zoznam/pole jednotiek, kedy by si vypisoval zivoty kazdej jednotky zo zoznamu, namiesto vypisovania kazdej jednotky ktoru mas ako atribut

			if (poradi[i] == "prvni" && jednotka1.zivoty >0 && nepritel1.zivoty > 0) {
					//zivy 1nepratel
						//ODSUD KOPÍROVAT
						// TODO 6. ziadne ze odtialto kopirovat :DDDD, ak musis kod koprovat, mozes ho extrahovat do samostatnej funkcie/metody
						if(jednotka1.rychlost > nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NASI JEDNOTKY
							if((jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") ||(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") || (jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR")) {
								nepritel1.zivoty = nepritel1.zivoty - (int) (jednotka1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK NEPRATELE
								if(nepritel1.zivoty > 0) {
									//EFEKTIVNI UTOK NEPRITELE
									if((nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") ||(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") || (nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR")) {
										jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
									} else {
										//NORMALNI UTOK NEPRITELE
										jednotka1.zivoty = jednotka1.zivoty - nepritel1.poskozeni ;
									}

							//UTOK NEPRATELE
						}else if(jednotka1.rychlost<nepritel1.rychlost) {
							//1EFEKTIVNI UTOK NEPRATELSKE JEDNOTKY
							if((nepritel1.typ == "RYTIR" && jednotka1.typ == "MAG") ||(nepritel1.typ == "STRELEC" && jednotka1.typ == "RYTIR") || (nepritel1.typ == "MAG" && jednotka1.typ == "RYTIR")) {
								jednotka1.zivoty = jednotka1.zivoty - (int) (nepritel1.poskozeni * 1.3);
								//KONTROLA PO 1. UTOKU A NASLEDNY UTOK PRATELSKE JEDNOTKY
								if(jednotka1.zivoty > 0) {
									//EFEKTIVNI UTOK PRATELSKE JEDNOTKY
									if((jednotka1.typ == "RYTIR" && nepritel1.typ == "MAG") ||(jednotka1.typ == "STRELEC" && nepritel1.typ == "RYTIR") || (jednotka1.typ == "MAG" && nepritel1.typ == "RYTIR")) {
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
*/


	



	



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
		System.out.println("1. "+ Nepratele[0].rasa + " " +Nepratele[0].typ + "| Zivoty: " + Nepratele[0].zivoty + " Poskozeni: " + Nepratele[0].poskozeni + " Rychlost: " + Nepratele[0].rychlost);
		System.out.println("2. "+ Nepratele[1].rasa + " " +Nepratele[1].typ + "| Zivoty: " + Nepratele[1].zivoty + " Poskozeni: " + Nepratele[1].poskozeni + " Rychlost: " + Nepratele[1].rychlost);
		System.out.println("3. "+ Nepratele[2].rasa + " " +Nepratele[2].typ +" | Zivoty: " + Nepratele[2].zivoty + " Poskozeni: " + Nepratele[2].poskozeni + " Rychlost: " + Nepratele[2].rychlost);
	}


	
	
	private void vytvoreni_nepratel() {
		for(int i =0;i<3;i++) {
		int rnd = rand.nextInt(9);
//		TODO namiesto jedneho cisla ktore reprezentuje typ a rasu na tomto mieste, si mozes napriklad vygenerovat dve cisla
			// Prve by reprzentovalo rasu, druhe typ (rytir, mag, strelec). Druhe cislo by si dal ako argument metode .rnd_clovek(typ)
			// A ona by uz vyvtorila cloveka so spravnym typom. usetris si tym tri dost if statementov
			// Taktiez mozes namiesto if pouzit switch, ale to je len drobnost
			if (rnd == 0) {
				Nepratele[i] = new Clovek();
				Nepratele[i].typ = "RYTIR";
				Nepratele[i].rnd_clovek();
			}else if (rnd == 1) {
				Nepratele[i] = new Clovek();
				Nepratele[i].typ = "MAG";
				Nepratele[i].rnd_clovek();
			}else if (rnd == 2) {
				Nepratele[i] = new Clovek();
				Nepratele[i].typ = "STRELEC";
				Nepratele[i].rnd_clovek();
			}else if (rnd == 3) {
				Nepratele[i] = new Ork();
				Nepratele[i].typ = "RYTIR";
				Nepratele[i].rnd_ork();
			}else if (rnd == 4) {
				Nepratele[i] = new Ork();
				Nepratele[i].typ = "MAG";
				Nepratele[i].rnd_ork();
			}else if (rnd == 5) {
				Nepratele[i] = new Ork();
				Nepratele[i].typ = "STRELEC";
				Nepratele[i].rnd_ork();
			}else if (rnd == 6) {
				Nepratele[i] = new Elf();
				Nepratele[i].typ = "RYTIR";
				Nepratele[i].rnd_elf();
			}else if (rnd == 7) {
				Nepratele[i] = new Elf();
				Nepratele[i].typ = "MAG";
				Nepratele[i].rnd_elf();
			}else if (rnd == 8) {
				Nepratele[i] = new Elf();
				Nepratele[i].typ = "STRELEC";
				Nepratele[i].rnd_elf();
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
						// TOTO je antipattern
					}  
	 }
	
	private void konec() {
		System.out.println("HRA UKONCENA!");
		System.exit(0);
	}



	private void info() {
		// TODO toto vies vytiahnut do for cyklu ako na riadku 105
		System.out.println("1. "+ Jednotky[0].rasa + " " +Jednotky[0].typ + " lvl "+ Jednotky[0].uroven+ "| Zivoty: " + Jednotky[0].zivoty + " Poskozeni: " + Jednotky[0].poskozeni + " Rychlost: " + Jednotky[0].rychlost +" XP:"+ Jednotky[0].zkusenosti + "/" + Jednotky[0].max_zkusenosti);
		System.out.println("2. "+ Jednotky[1].rasa + " " +Jednotky[1].typ + " lvl "+ Jednotky[1].uroven+ "| Zivoty: " + Jednotky[1].zivoty + " Poskozeni: " + Jednotky[1].poskozeni + " Rychlost: " + Jednotky[1].rychlost +" XP:"+ Jednotky[1].zkusenosti + "/" + Jednotky[1].max_zkusenosti);
		System.out.println("3. "+ Jednotky[2].rasa + " " +Jednotky[2].typ + " lvl "+ Jednotky[2].uroven+ "| Zivoty: " + Jednotky[2].zivoty + " Poskozeni: " + Jednotky[2].poskozeni + " Rychlost: " + Jednotky[2].rychlost +" XP:"+ Jednotky[2].zkusenosti + "/" + Jednotky[2].max_zkusenosti);
		System.out.println("   Pocet diamantu: " + pocet_diamantu);
	}



	public void menu() {

		System.out.println("1)inspect -> Prohlidnout sve protivniky a jejich pozice");
		System.out.println("2)fight -> zahajit souboj!");
		System.out.println("3)info -> vypise info o jednotkach + pocet ziskanych diamantu");
		System.out.println("4)reorder -> zmena poradi jednotek");
		System.out.println("5)RIP -> ukoncit hru! :(");
	}
	
}
