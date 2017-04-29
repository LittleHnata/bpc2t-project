# bpc2t-project
Předpokládejme továrnu s řadou CNC strojů, kde každý stroj má vlastní identifikační číslo a může vykonávat určité činnosti odpovídající danému typu stroje. Přičemž existují 3 různé typů strojů, kde každý typ stroje má vedle specifické činnosti i svou energetickou náročnost a kapacitu (tj. počet vyráběných součástek za hodinu). Každý stroj umí vyrábět podložky.
a)	Stroj typu A má energetickou náročnost 4W/souč. a kapacitu 70 souč./h
b)	Stroj typu B má energetickou náročnost 3W/souč. a kapacitu 50 souč./h a navíc dokáže vyrábět šroubky
c)	Stroj typu C má energetickou náročnost 2W/souč. a kapacitu 150 souč./h, ale kvůli své velikosti může být v továrně pouze jeden 
Každý stroj (s výjimkou typu A) se může občas porouchat a do doby opravy je nutné, aby práci tohoto stroje převzal jiný stroj/stroje (pokud je to možné). V případě, že stroj nevykonává žádnou činnost, je jeho energetická náročnost nulová.
Vytvořte v programovacím jazyce JAVA ve vývojovém prostředí Eclipse databázový program, který umožní uživateli následující:
a)	Přidávat nové stroje do továrny - uživatel si vždy pouze vybere typ stroje, který chce přidat a zadá jeho identifikační číslo.
b)	Zadávání práce strojům - uživatel si pouze vybere, jakou součástku chce vyrábět a v jaké kapacitě (souč./h.), tj. součástí řešení bude efektivní rozdělení práce mezi existující stroje s ohledem na minimální energetickou náročnost. Činnost může být rozdělena mezi několik strojů (i různého typu).
Pozn. pokud uživatel zadá výrobu např. šroubků a stroje typu B mají nedostatečnou kapacitu, ale tuto kapacitu lze získat, pokud se sníží výroba podložek prováděná těmito stroji, je nutno výrobu podložek (v dané kapacitě) přesunout na jiné typy strojů a začít vyrábět i šroubky. 
c)	Rušení práce strojů -  uživatel si pouze vybere, výrobu jaké součástky chce snížit a o kolik (souč./h.), součástí řešení bude opět efektivní rozdělení práce mezi existující stroje s ohledem na minimální energetickou náročnost, tj. rušení probíhá od energeticky náročnějších strojů.
d)	Odstranění stroje z továrny – uživatel zadá identifikační číslo stroje, který chce odstranit a ten bude z databáze smazán, přičemž veškeré činnosti, které tento stroj prováděl, budou efektivně rozděleny mezi zbývající stroje (pokud je to možné, pokud ne, bude o tom uživatel informován)
e)	Porucha stroje – uživatel zadá identifikační číslo stroje, který se porouchal. Veškeré činnosti tohoto stroje budou efektivně rozděleny mezi zbývající stroje (pokud je to možné, pokud ne, bude o tom uživatel informován). Tomuto stroji nebude možné zadávat žádnou činnost až do jeho opravy.
f)	Oprava stroje - uživatel zadá identifikační číslo porouchaného stroje, který byl opraven. Od této doby lze stroji přidělovat činnost. (Po opravě stroje není třeba řešit přerozdělení aktuálních činností).
g)	Výpis počtu strojů v jednotlivých kategoriích a jejich aktuálně volné kapacity
h)	Výpis celkové aktuální energetické náročnosti všech strojů (jedno číslo ve W/h)
i)	Výpis aktuálně vyráběných součástek všemi stroji včetně jejich množství (souč./h)
j)	Uložení celé databáze do souboru
k)	Načtení celé databáze ze souboru

Doporučené bodové hodnocení:
a)	Splnění zadání (rozsah) - 10 b.
b)	Efektivita řešení (tj. způsob programové implementace – dědičnost, dynamické datové struktury, práce se soubory, apod.) -10b.
c)	Vlastní obhajoba projektu (představení projektu, reakce na otázky) – 10 b.
Pozn. V případě, že autor projektu nebude schopen adekvátně reagovat na otázky vyučujícího, má vyučující právo dle svého uvážení snížit počet bodů z jednotlivých kategorií až na 0, a to i v případě, že se bude jednat o kvalitní projekt.
