Kamil Luwa�ski 
nr Indeksu: 136763
grupa I3, 
zaj�cia poniedzia�kowe, godz. 11:45-13:15(przenios�em si� na t� godzin�)

Instrukcja Obs�ugi:

W razie problemu z odpaleniem programu, prosz� sprawdzi�, czy do biblioteki
zosta�y podpi�te pliki *.JAR przes�ane w za��czniku (niezb�dne dla wykresu).
W razie, gdyby nie by�y podpi�te, to prosz� i podpi�cie ich.
Po podpi�ciu powinny si� tam znajdowa� poni�sze pliki *.jar :
hamcrest-core-1.3.jar
jcommon-1.0.23.jar
jfreechart-1.0.19.jar
jfreechart-1.0.19-experimental.jar
jfreechart-1.0.19-swt.jar
jfreesvg-2.0.jar
junit-4.11.jar
orsoncharts-1.4-eval-nofx.jar
orsonpdf-1.6-eval.jar
servlet.jar
swtgraphics2d.jar

Po odpaleniu programu natychmiast uruchamia si� jeden dystrybutor,
kt�ry zaczyna dzia�a�. Mo�na go nie odpala� poprzez zakomentowanie lini
"initial_Data(db.getDistributors());" w pliku VoD.java w main, w g��wnej jednostce projektu.

Dla u�atwienia analizy symulacji data, kt�ra w niej obowi�zuje, oraz ilo�� zarobionych pieni�dzy
s� podawane na wyj�cie konsoli za ka�dym razem, gdy data w symulacji si� zmienia. Mo�na wy��czy� wy�wietlanie, poprzez
zakomentowanie lini wy�wietlaj�cych w klasie ProgressGenerator w funkcji run.

Aby doda� jakikowlwiek obiekt, zmieni� cen� abonamentu, wczyta� lub zserializowa� dane,
nale�y wybra� odpowiedni� opcj� w oknie zatytu�owanym "Panel kontrolny". Nale�y zwr�ci� uwag�, 
czy pola nie s� oznaczone gwiazdk�, poniewa� bez ich wype�nienia program b�dzie informowa� 
o konieczno�ci ich wype�nienia.

Aby obejrze� klient�w, dystrybutor�w, produkt, lub dokona� czynno�ci z nimi zwi�zanych 
jak, np. usuni�cie obiektu, nale�y wybra� odpowiedni� opcj� w okienku zatytu�owanym
"Okno Aplikacji".