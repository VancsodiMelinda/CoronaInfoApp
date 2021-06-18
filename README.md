# A projektről
Ez a projekt a 'Mobilszoftver laboratórium' című tárgyhoz elkészített Android alkalmazást tartalmazza.
Az elkészült alkalmazás így néz ki:

![](https://github.com/VancsodiMelinda/CoronaInfoApp/blob/master/images/finished%20screens%20transparent.png)

# Specifikáció
Célom egy olyan egyszerű, 3 ablakos mobil applikáció készítése volt, mely a koronavírus járvánnyal kapcsolatos információkat szolgáltat a felhasználó számára. Az ehhez szükséges adatok lekérdezése [nyílt API](https://github.com/M-Media-Group/Covid-19-API) segítségével történt.
Az alkalmazás célplatformja az Android operációs rendszer, és álló helyzetű mobilra lett elkészítve.

Fejlesztőkörnyezet: Android Studio

Programozási nyelv: Java

# Funkcionális kövelemények
Az alkalmazás informatív jellegéből adódóan a megvalósítandó főbb funkciók a megfelelő adatok lekérdezéséhez és megjelenítéséhez kapcsolódnak:
- összesített világadatok lekérdezése:
  -	eddigi összes azonosított fertőzöttek száma
  -	eddigi összes felgyógyultak száma
  -	eddigi összes halálesetek száma
- Magyarországi adatok lekérdezése:
  -	eddigi összes azonosított fertőzöttek száma
  -	eddigi összes halálesetek száma
  -	az előző 7-10 nap adatainak (napi új fertőzöttek és halálesetek száma) listázása
- az előzőekben lekérdezett adatok felhasználói felületen való megjelentése
- az applikáció 3 ablaka közötti lépkedés

# Use case diagram
![](https://github.com/VancsodiMelinda/CoronaInfoApp/blob/master/images/use-case%20diagram%20resized.png)

# Wireframe
Az alkalmazás elrendezésének vázlatos ismertetése (lásd content és lofi wireframe-ek):
-	Global screen: Ez az alkalmazás kezdő képernyője. A képernyő felső részén világtérkép kerül megjelenítésre, ezzel utalva, hogy itt a világszintű adatok szerepelnek. A kép alatt pedig a megfelelő összesített adatok kiírása történik.
-	Hungary screen: A bal felső sarokban egy Magyarország térkép megjelenítése, tekintve hogy itt hazai adatok lesznek megjelenítve. Mellette az összesített hazai adatok kiírása. Ezek alatt pedig görgethető listaként az előző 7-10 nap adatainak megjelenítése.
-	About screen: Itt kerül megjelenítésre az alkalmazás logója, az app neve és copyright információk.

Content wireframe:

![](https://github.com/VancsodiMelinda/CoronaInfoApp/blob/master/images/content%20wireframe%20transparent.png)

Lo-fi (low-fidelity) wireframe:

