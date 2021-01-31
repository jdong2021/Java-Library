/***
 * @author Hugo DeMorales
 * @author Jonathan Dong
 */

import java.util.Objects;

public class Book {
    private final String number; // a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    Book(String number) {
        this.number = number;
    }

    Book(String number, String name, Date datePublished) {
        this.number = number;
        this.name = name;
        this.datePublished = datePublished;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book targetBook = (Book) obj;
        return Objects.equals(number, targetBook.number);
    }

    @Override
    public String toString() {
        String isAvailable;

        if (this.checkedOut) {
            isAvailable = "is not available";
        } else {
            isAvailable = "is available";
        }

        // ex: Book#10007::Design Patterns::5/30/1996::is available.
        return "Book#" + this.number + "::" + this.name + "::" + datePublished.toString() + "::" + isAvailable;
    }

    public boolean getCheckedOut() {
        return checkedOut;
    }

    private String getNumber() {
        return number;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public static Boolean isGreaterNumber(Book book1, Book book2) {
        return Integer.parseInt(book1.getNumber()) > Integer.parseInt(book2.getNumber());
    }

    void checkOut() {
        this.checkedOut = true;
    }

    void checkIn() {
        this.checkedOut = false;
    }
}