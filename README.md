# Útěk z Azkabanu

Textová hra zasazená do světa Harryho Pottera. Ocitáš se uvězněn v nejstřeženější čarodějnické věznici na světě. Tvůj cíl je jediný – utéct.

Proslechlo se, že jedinou cestou ven je Hlavní brána. Její zámek je ale zamčen. Budeš muset prozkoumat věznici, posbírat správné předměty, promluvit si se starými vězni a najít klíč, který ti otevře cestu na svobodu.



## Spuštění
java -jar .\jackson-demo.jar
- vyzaduje Java 17 nebo novejsi



## Příkazy

- jdi <místnost> – přesune hráče do sousední místnosti

- prozkoumej – prozkoumá aktuální místnost

- vezmi <předmět> – vezme předmět do inventáře

- poloz <předmět> – položí předmět z inventáře

- pouzij <předmět> – použije předmět z inventáře

- mluv <postava> – zahájí rozhovor s postavou

- inventar – zobrazí obsah inventáře

- pomoc – zobrazí seznam příkazů

- napoveda – zobrazí nápovědu

- konec – ukončí hru



## Svět hry

Věznice se skládá z 8 propojených místností, každá s vlastním popisem, předměty a postavami:

- Cela vězně – tvůj startovní bod

- Chodba cel – centrální chodba, zde potká starého vězně, který zná cestu ven

- Strážní stanoviště – hlídkovna dozorců, najdeš tu trochu jídla

- Sklad předmětů – plný haraburdí, ale někde tu leží Rezavý klíč

- Věž dozorců – výhledy na okolí, ale pozor na stráže

- Knihovna magie – plná prastarých knih, cítis tu magii

- Magický uzel – srdce věznice, pulzuje fialová energie

- Hlavní brána – cíl útěku



## Použité technologie

- Java 17

- Maven

- Jackson Databind 2.17.1 - nacitani ze souboru

- JUnit Jupiter 5.10.2 - testovani hry


## Autor

Jakub Eliášek
