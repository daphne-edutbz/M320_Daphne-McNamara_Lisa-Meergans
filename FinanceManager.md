## Use Cases
Einnahme hinzufügen: Benutzer gibt Betrag, Datum, Beschreibung ein; System speichert als Income.

Ausgabe hinzufügen: Benutzer gibt Betrag, Datum, Beschreibung ein; System speichert als Expense.

Budget überprüfen: System überprüft, ob Budget überschritten ist.UC4: Bericht / Statistik erstellenBenutzer wählt Report-Typ (Summe, Durchschnitt, Trend); System erzeugt Report.

## Ziel:  Die Applikation soll Benutzern ermöglichen, ihre Finanzen zu verwalten. Dazu gehören Einnahmen, Ausgaben, Budgets und Berichte.

1. Verwaltung von Konten und Transaktionen:
Ein Konto speichert alle Einnahmen und Ausgaben eines Benutzers.
Transaktionen werden in einer Liste gespeichert und enthalten Betrag, Datum und Beschreibung.
2. Einnahmen und Ausgaben erfassen:
Benutzer kann neue Einnahmen und Ausgaben hinzufügen.
Das System validiert Eingaben
3. Budgetkontrolle: 
Benutzer kann ein Budget festlegen.
System prüft, ob Ausgaben das Budget überschreiten.
4. Berichte und Statistiken: 
Benutzer kann Berichte über Transaktionen generieren (Summe, Durchschnitt).
Reports werden flexibel über unterschiedliche Berechnungsstrategien erstellt (Strategy Pattern).
5. Objektorientierte Struktur: 
Vererbung: Transaction -> Income / Expense
Interface Reportable für alle reportfähigen Objekte
Singleton für zentrale Kontoverwaltung (Account)
6. Clean-Code-Prinzipien und Exception Handling: 
Saubere Trennung von UI, Logik und Persistenz
Methoden kurz und aussagekräftig benannt
Fehlerhafte Eingaben werden abgefangen und als Exception behandelt
7. Design Patterns: 
Singleton: Account (eine Instanz speichert alle Daten)
Strategy: ReportGenerator wählt Berechnungsstrategie für Reports
8. Technische Anforderungen: 
Mindestens 8 selbstgeschriebene Klassen
Mindestens 500 Zeilen Code
Optional SpringBoot oder einfache Konsolen-UI
KI-Hilfe im Code kenntlich machen

