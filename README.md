# A projektről
Ez a projekt a 'Mobilszoftver laboratórium' című tárgyhoz elkészített Android alkalmazást tartalmazza.
Az elkészült alkalmazás így néz ki:

![](https://github.com/VancsodiMelinda/CoronaInfoApp/blob/master/images/finished%20screens%20transparent.png)

Az alkalmazást fázisokban kellet elkészíteni, az egyes fázisok lépései, eredményei és a használt technológiák az alábbiakban kerülnek bemutatásra.

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
- magyarországi adatok lekérdezése:
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

Az applikáció tervezési lépéseként különféle wireframe-ek lettel ekészítve [Justinmind](https://www.justinmind.com/) használatával.

## Content wireframe:
![](https://github.com/VancsodiMelinda/CoronaInfoApp/blob/master/images/content%20wireframe%20transparent.png)

## Lo-fi (low-fidelity) wireframe:
![](https://github.com/VancsodiMelinda/CoronaInfoApp/blob/master/images/lofi%20wireframe%20transparent.png)

# Architektúra
Az alkalmazás architektúrája: Model-View-Presenter (MVP)

Az architektúra szerint minden egyes képernyőhöz tartozik egy Activity, mely implementálja a hozzá tartozó Screen interface-t, és a kettő közötti kapcsolatot a Presenter valósítja meg.

A projekt az alábbi eszközöket/könyvtárakat használja:
- függőségkezelő könyvtár: [Dagger](https://dagger.dev/)
- continuous integration eszköz: [Travis CI](https://travis-ci.org/)

## Hálózati réteg
A hálózati hívások API leírása a [swagger editor](https://editor.swagger.io/) segítségével előállított .yaml formátumban került előállításra, melyből aztán a [Swagger Generator](https://github.com/swagger-api/swagger-codegen) segítségével lettek a szükséges api és modell osztályok legenerálva. A generált api interface-ek [Retrofit](https://square.github.io/retrofit/)-el kompatibilisek.

## Adatbázis réteg
Az adatbázis réteghez szükséges adatbázis, entity osztályok és az adatokhoz való hozzáférést biztosító DAO interface-ek létrehozása a [Room](https://developer.android.com/training/data-storage/room) könyvtár segítségével történik.

# Analitika
Az alkalmazásba integrálva lettek a [Firebase](https://firebase.google.com/) által nyújtott funkcionalitások, mint például crash-ek reportolására való [Crashlytics](https://firebase.google.com/docs/crashlytics), és az alkalmazás használatáról különféle analitikát gyűjtő [Google Analytics](https://firebase.google.com/docs/analytics).

