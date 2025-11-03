# Finanzmanager 
## Ziel der Applikation

Die Applikation soll Benutzern ermöglichen, ihre Finanzen zu verwalten. Dazu gehören:

Einnahmen erfassen

Ausgaben erfassen

Budgetkontrolle

Berichte und Statistiken
## Use Cases
### Einnahme hinzufügen

Benutzer gibt Betrag, Datum und Beschreibung ein

System speichert die Transaktion als Income

### Ausgabe hinzufügen

Benutzer gibt Betrag, Datum und Beschreibung ein

System speichert die Transaktion als Expense

### Budget überprüfen

System prüft, ob Ausgaben das gesetzte Budget überschreiten

### Reports generieren

Summe, Durchschnitt oder Trend der Transaktionen

Flexible Berechnung über das Strategy Pattern

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


## Architektur & OO-Struktur
Klassenübersicht (mindestens 8 Klassen)

Account – speichert Kontoinformationen, Transaktionen und Budget

Transaction (abstract) – Basis für alle Transaktionen

Income – Unterklasse von Transaction

Expense – Unterklasse von Transaction

Budget – enthält Limit und prüft Überschreitung

AccountManager – Singleton für zentrale Kontoverwaltung

ReportStrategy (Interface) – Strategy Pattern für Reports

SumStrategy, AverageStrategy, TrendStrategy – konkrete Berechnungen

ReportService – erstellt Reports über ReportGenerator

TransactionFactory – erzeugt Income/Expense Objekte

AccountController – Konsolen-UI für Benutzerinteraktionen


## Vererbung: Transaction → Income / Expense
Begründung: Gemeinsame Attribute (amount, date, description) und Methoden (getNetAmount(), getType()) werden in der Basisklasse verwaltet. Polymorphismus erlaubt, dass Listen von Transaction Objekten einheitlich verarbeitet werden können.

Interface: ReportStrategy, Reportable
Begründung: Strategie-Pattern ermöglicht flexible Auswahl von Berechnungslogik für Reports, ohne dass der Konsolen-Code geändert werden muss.

Singleton: AccountManager
Begründung: Stellt sicher, dass es nur eine zentrale Kontoverwaltung gibt. Dies verhindert Inkonsistenzen und erleichtert den globalen Zugriff auf Konten.

## Clean-Code Prinzipien

Methoden sind klein und erfüllen Single Responsibility (createAccount(), addTransactionToAccount(), showAccounts())

Aussagekräftige Namen: Methoden und Variablen klar benannt

Trennung von Schichten: UI (AccountController), Logik (Account, AccountManager, Transaction), Reports (ReportService, ReportStrategy)

Exception Handling: Ungültige Eingaben lösen InvalidTransactionException oder BudgetExceededException aus
