package com.example.zadanie1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookReader {

    File file = new File("src\\main\\resources\\zadanie\\books");

    List<Book> books;

    @PreDestroy
    public void destroy() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(file.getAbsolutePath()+"_modified"))) {
            for (Book book : books) {
                bufferedWriter.write(book.getAuthor()+";"+book.getTitle()+";"+book.getPrice());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPrices() {
        books.forEach(book -> book.setPrice(new Random().nextInt(100)));
    }

    @PostConstruct
    public void postConstruct() {
        books = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] lineArray = line.split(";");
                books.add(new Book(lineArray[0], lineArray[1]));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
