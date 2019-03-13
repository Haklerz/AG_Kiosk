# AG_Kiosk
Kiosk prosjekt i OOP

Krav til applikasjonen
Følgende type lesestoff skal kunne håndteres av systemet:

Aviser, blader, tidsskrifter
Dette er lesestoff som ikke har en fast forfatter, og som kommer ut periodisk (en gang i uken, en
gang i måneden, hver dag etc.).
Lesestoffet her har tittel og utgiver (forlag). I tillegg er det interessant å vite antall utgivelser pr. år,
type lesestoff (avis, ukeblad, tidsskrift) og fagområde/sjanger (sport, reiser, foto, familieblad,
ungdomsblad etc.).

Bøker – enkeltstående, og serier
Dette er lesestoff som utkommer ikke-periodisk, og omfatter all type litteratur som har en enkelt
forfatter.
Lesestoff av denne typen, har tittel og utgiver (forlag). I tillegg er det interessant å vite hvem
forfatteren er.
For enkeltstående bøker, er det ønskelig å vite antall utgaver (type ”1. opplag”, ”2. opplag” etc.).
For serier registreres seriens tittel og forfatter på samme måte som for enkeltstående bok. I tillegg
ønsker mann å ha med opplysninger om alle utgivelsene (tittel og dato på den enkelte utgivelsen)
som inngår i serien.

Funksjonalitet
• Det skal være mulig å registrere lesestoff av alle typer definert ovenfor.
• Det skal være mulig å skrive ut innholdet i hele registeret.
• Det skal være mulig å søke i registeret på tittel og utgiver for å finne ett konkret lesestoff.
• Det skal være mulig å søke i registeret etter alt lesestoff fra en bestemt utgiver.
• Det skal være mulig å gjøre om en enkeltstående bok om til en serie.
I tillegg kan dere utvide applikasjonen med funksjonalitet dere mener hører hjemme i en slik
applikasjon som for eksempel mer avansert søk, bygge inn salgs-støtte (kassa-apparat (POS)) osv.

Literature(title, publisher)
    Book(author, edition, datePublished)
    BookSeries()
    Periodical(editionsPerYear, type, genre)
