package pl.adamdylus;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Pracownik[] pracownicy = new Pracownik[100];
        String nazwaPlikuDoOdczytu = "dane.txt";
        String nazwaPlikuDoZapisu = "plik1.txt";

        System.out.println(Pracownik.wczytajZPlikuTekstowego(nazwaPlikuDoOdczytu, pracownicy));
        System.out.println(Pracownik.srednieZarobki(pracownicy, 3, 'K'));
        Pracownik.zapiszDoPliku(nazwaPlikuDoZapisu, pracownicy);
        Pracownik.odczytZPliku(nazwaPlikuDoZapisu, pracownicy);
    }
}
