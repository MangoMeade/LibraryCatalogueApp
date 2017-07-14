import java.time.LocalDate;
import java.util.Scanner;

// Created by jenny on 7/12/2017.


public class BookAdder extends CatalogueTextFile{
    public void addBook() {
        Scanner scnr = new Scanner(System.in);


        Status onShelf = Status.ON_SHELF;
        Genre fiction = Genre.FICTION;
        String title;
        String author;
        String dueDate;
        LocalDate dueDate1 = LocalDate.now();
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
        System.out.println("Is the book on shelf? (Type Reserved, On Shelf or Checked out");
        status = scnr.nextLine();
        System.out.println("What is the book genre?");
        genre = scnr.nextLine();

        Book book1 = new Book(title, author, dueDate1, braille, Status.getEnumVersion(status), Genre.getEnumVersion(genre));
        writeToCatalogue(book1.getTitle() + " " + book1.getAuthor() + " " + book1.getDueDate() + " " + book1.getBraille() + " " + book1.getStatus() + " " + book1.getGenre());
        readFromCatalogue();
        //System.out.println(book1.getTitle());

    }
}