Ez a projekt a 'Mobilszoftver laboratórium' című tárgyhoz elkészített Android alkalmazást tartalmazza.

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
