Naszym zadaniem będzie stworzenie aplikacji, która będzie modelowała zoo. Będziemy krok po kroku rozbudowywali aplikację o kolejne elementy, pamiętając o technikach i dobrych zasadach, których nauczyliśmy się do tej pory. Logikę aplikacji będziemy tworzyli korzystając z TDD.

Stworzyliśmy odpowiednią hierarchię zwierząt. Jako kierownicy zoo będziemy sprawdzali czy każde zwierzę (Animal) żyje oraz ważyli je od czasu do czasu w ramach rutynowych badań.

Niestety nie udało się nam otrzymać dofinansowania od UE na nowy startup, więc na razie w naszym zoo będą się znajdowały tylko niedźwiedzie (Bear). Na początek będą się tam znajdowały niedźwiedzie czarne (BlackBear), niedźwiedzie brunatne (BrownBear) i niedźwiedzie polarne (PolarBear).

Nasze niedźwiedzie to nietypowe zwierzęta. Żeby sprawdzić czy żyją (isAlive) należy sprawdzić czy ich aktualna waga nie jest mniejsza niż ich waga urodzeniowa. Jeśli zwierzę waży mniej niż jego waga urodzeniowa, to jest nieżywe.

Aby utrzymywać nasze niedźwiedzie przy życiu powinniśmy żywić nasze zwierzaki. Każdy niedźwiedź powinien mieć możliwość jedzenia (eat). Wystarczy, by metoda odpowiednio zwiększała wagę misia. Zjedzenie powinno ożywiać niedźwiedzia.


**Importowanie kodu do IntelliJ**

Wybieracie opcję New -> Project From Version Control -> Git. Wklejacie link z Bitbucketa. Jeśli SDK nie jest ustawione (pliki dziwnie się wyświetlają w drzewie projektu), wybieracie Java 1.8. 
Na dolnej belce powinna pojawić się informacja Non-managed pom.xml file found. Klikając na to wyświetli się okienko z wiadomością 

Non-managed pom.xml file found: /home/krystian/code/sda/javalub-zoo/pom.xml 

Add as Maven Project or Disable notification

Wybieramy "Add as Maven Project" i jesteśmy gotowi do pracy.


**Struktura kodu**

W projekcie znajdują się 2 foldery src/main/java oraz src/test/java. W każdym z nich znajduje się pakiet pl.sdacademy. Piszcie swój kod w tym pakiecie (testy w src/test/java i kod aplikacji w src/main/java). W folderze main znajdują się już jakieś klasy, m.in. Bear.java, którą będziecie w pełni implementowali. W folderze test znajduje się plik BearTest.java oraz BearSpec.groovy. Testy powinniście zamieszczać w tym pierwszym.


**Zadania**

Wszystkie zadania należy wykonywać metodą TDD - najpierw piszemy niedziałający test, później implementację, a następnie polerujemy kod. Zakres zadań celowo jest bardzo prosty. Należy skupić się na sposobie programowania TDD, zamiast na zadaniach.

Niedźwiedź może przybierać lub tracić na wadzę.

1. Po zjedzeniu posiłku o danej masie, jego waga wzrasta o tę samą wartość. 
2. Po wypiciu wody (void drink(double waterWeight)) o danej masie, jego waga wzrasta o 3/4 tej wartości.
3. Po zrobieniu kupy (void poop()) masa misia spada o 5%.
4. Niedźwiedź żyje wtedy i tylko wtedy jeśli jego waga jest nie mniejsza niż jego masa urodzeniowa.
5. Niedźwiedź może zostać ożywiony po zjedzeniu posiłku lub wypiciu wody. 

Niedźwiedzie zapadają w sen zimowy. 

6. Niedźwiedzie czarne śpią (boolean isHibernating) od 20 listopada do 15 marca.

Praca domowa

1. Niedźwiedzie brunatne śpią od 1 grudnia do 20 kwietnia.
2. Niedźwiedzie polarna śpią od 5 maja do 10 października.
3. Karmienie lub pojenie misia w trakcie snu zimowego powinno wyrzucać wyjątek BearHibernatingException. 
4. Zmiana wymagań: niedźwiedzie nie mogą być ożywiane. Jeśli raz umrą, to już pozostają martwe (piąte wymaganie nie jest już prawdziwe).
5. Zmiana wymagań: niedźwiedzie mogą zostać obudzone ze snu zimowego. Jeśli miś śpi, to nakarmienie go powoduje jego obudzenie (tzn. isHibernating() zwraca false). Miś pozostaje obudzony na jeden dzień. Tzn. następnego dnia metoda isHibernate() powinna znów zwrócić true (o ile data przypada w okresie jego zimowania).