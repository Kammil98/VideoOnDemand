Kamil Luwañski 
nr Indeksu: 136763
grupa I3, 
zajêcia poniedzia³kowe, godz. 11:45-13:15(przenios³em siê na t¹ godzinê)

Instrukcja Obs³ugi:

W razie problemu z odpaleniem programu, proszê sprawdziæ, czy do biblioteki
zosta³y podpiête pliki *.JAR przes³ane w za³¹czniku (niezbêdne dla wykresu).
W razie, gdyby nie by³y podpiête, to proszê i podpiêcie ich.
Po podpiêciu powinny siê tam znajdowaæ poni¿sze pliki *.jar :
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

Po odpaleniu programu natychmiast uruchamia siê jeden dystrybutor,
który zaczyna dzia³aæ. Mo¿na go nie odpalaæ poprzez zakomentowanie lini
"initial_Data(db.getDistributors());" w pliku VoD.java w main, w g³ównej jednostce projektu.

Dla u³atwienia analizy symulacji data, która w niej obowi¹zuje, oraz iloœæ zarobionych pieniêdzy
s¹ podawane na wyjœcie konsoli za ka¿dym razem, gdy data w symulacji siê zmienia. Mo¿na wy³¹czyæ wyœwietlanie, poprzez
zakomentowanie lini wyœwietlaj¹cych w klasie ProgressGenerator w funkcji run.

Aby dodaæ jakikowlwiek obiekt, zmieniæ cenê abonamentu, wczytaæ lub zserializowaæ dane,
nale¿y wybraæ odpowiedni¹ opcjê w oknie zatytu³owanym "Panel kontrolny". Nale¿y zwróciæ uwagê, 
czy pola nie s¹ oznaczone gwiazdk¹, poniewa¿ bez ich wype³nienia program bêdzie informowa³ 
o koniecznoœci ich wype³nienia.

Aby obejrzeæ klientów, dystrybutorów, produkt, lub dokonaæ czynnoœci z nimi zwi¹zanych 
jak, np. usuniêcie obiektu, nale¿y wybraæ odpowiedni¹ opcjê w okienku zatytu³owanym
"Okno Aplikacji".