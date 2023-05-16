
// Interface segregation principle (ISP)
// This interface is minimalistic and only contains the methods required by the Library class.
import java.time.LocalDate;
import java.util.List;
import java.util.*;

public class SolidPrinciples {
    public static void main(String[] args) {
        // create some books
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", LocalDate.of(1951, 7, 16), true);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11), false);
        FictionBook book3 = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", LocalDate.of(1954, 7, 29), true,
                "Fantasy");

        // create a library and add the books
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // search for books by author
        List<IBook> booksByAuthor = library.searchByAuthor("J.D. Salinger");
        System.out.println("Books by J.D. Salinger:");
        for (IBook book : booksByAuthor) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        // get all books in the library
        List<IBook> allBooks = library.getAllBooks();
        System.out.println("\nAll books in the library:");
        for (IBook book : allBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}

interface IBook {
    String getTitle();

    String getAuthor();

    LocalDate getPublicationDate();

    boolean isAvailable();

    void setAvailable(boolean available);
}

// Single responsibility principle (SRP)
// This class is responsible for holding information about a book.
class Book implements IBook {
    private String title;
    private String author;
    private LocalDate publicationDate;
    private boolean available;

    public Book(String title, String author, LocalDate publicationDate, boolean available) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}

// Dependency inversion principle (DIP)
// This class depends on the IBook interface instead of the Book class directly.
class Library {
    private List<IBook> books = new ArrayList<>();

    public void addBook(IBook book) {
        books.add(book);
    }

    public void removeBook(IBook book) {
        books.remove(book);
    }

    public List<IBook> getAllBooks() {
        return books;
    }

    public List<IBook> searchByAuthor(String author) {
        List<IBook> result = new ArrayList<>();
        for (IBook book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }
}

// Open/closed principle (OCP)
// This class is open for extension and closed for modification.
class FictionBook implements IBook {
    private String title;
    private String author;
    private LocalDate publicationDate;
    private boolean available;
    private String genre;

    public FictionBook(String title, String author, LocalDate publicationDate, boolean available, String genre) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.available = available;
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}