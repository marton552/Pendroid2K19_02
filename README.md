# Pendroid2K19_02

nagy változók:
- %Áram
- %Pénz
- %Áramveszteség
- 5 elem állapota
ezeknek a szorzatából emelkedik a pénz összege
ezek is ki lesznek írva hogy mekkora az értékük

Dolgozz te surmo:
- Víz animáció de szigorúan pixeles lófasz
- Háttér külön
- Oldal nézetes cuccli: 
	- !Generátor
		- !!Áram termelés {+%Áram}
		- !!Áram to Pénz {+%Pénz}
		- !!Áttételek {+%Áramveszteség}
		- !!Új típus (csak akkor ha az előző öszes elem mind LVL3 fölött van)
		- ++Tűrőképesség {+%Lassabban megy tönkre}
	- !Lapát vagymi(képen)
		- !!Forgási sebesség {+%Áram}
		- !!Fogaskerekek {+%Áramveszteség}
		- !!Lapátok mérete {+%Áram}
		- !!Kerék mérete {+%Áram}
		- !!Új típus (csak akkor ha az előző összes elem mind LVL3 fölött van)
		- ++Tűrőképesség {+%Lassabban megy tönkre}
	- !A fal maga amúgy is külön elmként
		- !!Magasság 
		- !!Vastagság 
		- !!Tűrőképesség 
		- !!Új fal (csak akkor ha az előző összes elem mind LVL3 fölött van)
		- ++Tűrőképesség {+%Lassabban megy tönkre}
	- !Munkások
		- !!Munkaerő {+%Áram}
		- !!Szorgalom {+%Pénz}
		- !!Odafigyelés {+%Áramveszteség}
		- !!Adócsalás {+%Pénz}
		- !!Új munkások (csak akkor ha az előző összes elem mind LVL3 fölött van)
		- ++Tűrőképesség {+%Lassabban megy tönkre}
	- !Csővek
		- !!Szélesség {+%Áramveszteség}
		- !!Csőhálózat elrendezése {+%Áramveszteség}
		- !!Új csövek (csak akkor ha az előző összes elem mind LVL3 fölött van)
		- ++Tűrőképesség {+%Lassabban megy tönkre}
- Kokainos tasak.png
- Enemy: goblin szutyadék esetleg favágó , rosszabb esetbe egybe... :O
- Fegyver felsőnézet like doom: ak géppityú esetleg 'skinek'


MINIGAMEK:
Ezekkel tudja a játékos megjavítani az elemeket.
Ha:
- 75% fölött: 1.25x-ös szorzó
- 50%-75%-ig: 1x-es szorzó
- 25%-50%-ig: 0.75x-ös szorzó
- 25% alatt: 0.25x-ös szorzó
- 0%: 0.05x-ös szorzó (konkrétan szinte nulla pénz)

Az 5 minigame típusa (nehézségük változik annak fejében hogy mennyire van lemenve az élete)
	- Generátor: Lyukak betömése 3 csíkon. Adott a lyuk szám, és hogy mennyi ragasztód van +akadályok. Cél: ne fogyjon ela  ragasztó
	- Lapátok: Tisztítás Candy Crush Saga? :D
	- Fal: Goblinokat puff puff
	- Munkások: Csikizni kell a szőrös pocijukat (ne tűl gyorsan és ne túl lassan tap-tap)
	- Shoot em up szerű pucolás +ellenfelek
	
	
Ja meg kellenének achimentek meg mikrotranzakció
