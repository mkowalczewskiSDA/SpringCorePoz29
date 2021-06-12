package com.example.zadanie1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//Napisz aplikacje w spring core, skonfiguruj beany za pomocą adnotacji.
//W beanie BookReader podczas inicjalizacji - wczytaj dane z pliku books.txt do listy zawierającej obiekty Book.
//następnie wypełnij obiekty Book cenami za książkę.
//Podczas niszczenia beana, zapisz zmodyfikowaną listę w nowym pliku o nazwie new_books.txt w podobnym formacie, uzupełnionym o ceny:
//z takiego formatu:
//JRR Tolkien;Lord of The Rings
//na taki
//JRR Tolkien;Lord of The Rings;15

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookReader bookReader = (BookReader) context.getBean("bookReader");
        bookReader.addPrices();
        context.registerShutdownHook();
    }
}
