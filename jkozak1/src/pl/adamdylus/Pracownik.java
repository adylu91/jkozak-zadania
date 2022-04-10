package pl.adamdylus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pracownik {
    public String imie;
    public String nazwisko;
    public int placa;
    public char plec;
    public int dzial;

    public Pracownik(String imie, String nazwisko, int placa, char plec, int dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    public static int wczytajZPlikuTekstowego(String nazwaPliku, Pracownik[] pracownicy) throws FileNotFoundException {
        File plik = new File(nazwaPliku);
        Scanner odczyt = new Scanner(plik);
        String[] arr;
        int nextLineInt = 0;

        while(odczyt.hasNextLine()){
            arr = odczyt.nextLine().split(" ");
            pracownicy[nextLineInt] = new Pracownik(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3].charAt(0), Integer.parseInt(arr[4]));
            nextLineInt++;
        }

        return nextLineInt;
    }
    public static float srednieZarobki(Pracownik[] pracownicy, int numerDzialu, char plec){
        float licznikWystapien = 0;
        float sumaPlaca = 0;

        for(Pracownik p : pracownicy){
            if (p != null) {
                if(p.dzial == numerDzialu && p.plec == plec){
                    licznikWystapien++;
                    sumaPlaca += p.placa;
                }
            } else {
                break;
            }
        }
        return sumaPlaca / licznikWystapien;
    }
    public static void zapiszDoPliku(String nazwaPliku, Pracownik[] pracownicy) throws FileNotFoundException {
        String str = "";
        PrintWriter printWriter = new PrintWriter(nazwaPliku);
        for(Pracownik p: pracownicy){
            if (p != null) {
                str += p.imie + " ";
                str += p.nazwisko + " ";
                str += p.placa + " ";
                str += p.plec + " ";
                str += p.dzial;
                str += "\n";
            } else {
                break;
            }
        }
        str = str.trim();
        printWriter.println(str);
        printWriter.close();
    }
    public static void odczytZPliku(String nazwaPliku, Pracownik[] pracownicy) throws FileNotFoundException {
        wczytajZPlikuTekstowego(nazwaPliku, pracownicy);
    }
}

