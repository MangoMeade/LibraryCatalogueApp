import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Created by jenny on 7/12/2017.


public class BookAdder extends CatalogueTextFile{
    public void addBook() {
        Scanner scnr = new Scanner(System.in);


        Status onShelf = Status.ON_SHELF;
        Genre fiction = Genre.FICTION;
        String title;
        String author;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.now();
        Boolean braille;
        String status;
        String genre;

        System.out.println("Book title?");
        title = scnr.nextLine();
        System.out.println("Book author?");
        author = scnr.nextLine();

        System.out.println("Is this book braille?");
        braille = scnr.nextBoolean();
        scnr.nextLine();
        System.out.println("What is the book genre? (Biographical, Drama, Fiction, Nonfiction, Historical)");
        genre = scnr.nextLine();

        Book book1 = new Book(title, author, dueDate, braille, Status.ON_SHELF, Genre.getEnumVersion(genre));
        writeToCatalogue(book1.getTitle() + "," + book1.getAuthor() + "," + book1.getDueDate() + "," + book1.getBraille() + "," + book1.getStatus() + "," + book1.getGenre());
        readFromCatalogue();

    }

}

