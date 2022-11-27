#<span style="color:red"> Quest for carefour

## 1. Zadanie

Vytvor single player hru, kde má hráč na starosti malú skupinku dobrodruhov, ktorý potrebujú získať **7 častí diamantu**. Na začiatku hry si hráč zvolí **3 dobrodruhov**, z možných 5. Následne hráč bojuje s nepriateľmi v siedmich jaskyniach.

### 1.1 Bojovníci

- Dobrodruhovia aj nepriatelia budú mať

  - Meno
  - Hodnoty života
  - Hodnoty útoku
  - Hodnoty rýchlosti
  - Úroveň
  - Rasu
  - Typ

- Rasy:

  - človek
  - ork
  - elf

- Typy:

  - Mág
  - Strelec
  - Rytier

- Interakcie rás

  - Útoky Orkov sú efektívne proti Elfom a Ľuďom
  - Útoky Elfov sú efektívne proti ľuďom

- Interakcie typov

  - Útoky Rytiera sú efektívne proti Mágovi
  - Útoky Strelca sú efektívne proti rytierovi
  - Útoky Mága sú efektívne proti rytierovi

- Levelovanie je na tebe:
  - Progresívne (Zvyšuje sa počet skúseností potrebných na ďalšiu úroveň)
  - Konštantné (Počet skúseností potrebných na ďalšiu úroveň je konštantný)
  - Pri zvýšení levelu postavy sa postave zvýšia dovednosti

### 1.2 Boj

- Všetky zápasy prebiehajú štýlom 3 vs 3

[comment]: # "možno pridať počet nepriateľov závisiaci od typu jaskyne"

- Pred začiatkom zápasu sa hráč môže pozrieť do jaskyne, aby vedel ktorí nepriatelia strážia diamant, a v akom sú poradí.
- Zápasy prebiehajú automaticky po kolách

  1. Porovnajú sa rýchlosti najprednejšieho živého dobrodruha a nepriateľa - ten kto má väčšiu rýchlosť zaútočí prvý
  2. Prvý zaútočí
  3. Ak druhý prežije (Jeho život ostane pod nulou), zaútočí tiež
  4. Ak jeden z nich zomrie, prechádza sa na ďalšieho najbližšieho živého bojovníka z jeho týmu

- Pokiaľ hráč vyhrá, jeho dobrodruhovia dostanú skúsenosti v hodnote (1-99) (alebo tvoj rozsah)
- Pokiaľ hráč prehrá, jeho bojovníci utečú a dostanú len polovicu bodov

### 1.3 Hrateľnosť

- Hru bude možné spustiť pomocou metódy štart, ktorá bude deklarovaná v rozhraní IGame. Trieda, ktorá toto rozhranie implementuje, bude zodpovedná za celú hru.
- Hráčovi sa na začiatku zobrazí list dobroduhov, kde každý má úroveň jedna a žiadne skúsenosti, Ostatné vlastnosti vygeneruj ako uznáš za vhodné.
- Po výberu dobrodruhov môže hráč zadávať nasledujúce príkazy až do konca hry:
  1. inspect - hráč nahliadne do jaskyne. Do konzele sa mu vypíšu vhodné informácie, na základe ktorých môže zmeniť v akom poradí budú jeho dobroduhovia bojovať
  2. fight - spustí sa súboj, pri každom kole sa vypíšu informácie o boji
  3. info - vypíšu sa informácie o hráčových dobrodruhoch, ich vlastnosti, koľko má diamantov
  4. reorder a b c- hráčovi umožní zmeniť poradie, v akom budú jeho dobrodruhovia bojovať
     - hráč zadá a b c ako čísla
  5. rip - ukončí hru
     - vhodné použiť nekonečný cyklus a príkaz break
- Ak hráč zadá nevalídny príkaz, do konzole sa vypíše "Invalid command"
  \
  \
  \
  \
  Ak budeš chcieť aby sme nejako zadanie rozvynuli, rád ti s tým pomôžem :). Ak ti príde niečo príde príliš komplikované, neboj sa, môžeme si to spolu prejsť, pobaviť sa o tom, pokojne to zjednodušiť. Ak budeš mať akékoľvek nejasnosti, neváhaj sa pýtať :)
