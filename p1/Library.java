public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag
    private int currentSerialNumber;
    private final int sizeFactor = 4;

    // default constructor to create an empty bag
    public Library() {
        books = new Book[sizeFactor];
        numBooks = 0;
        currentSerialNumber = 10001;
    } 

    // helper method to find a book in the bag
    private int find(Book book) {
        int indexOfBook = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book)) {
                indexOfBook = i;
                break;
            }
        }
        return indexOfBook;
    } 

    // helper method to grow the capacity by 4
    private void grow() {
        // create new array of length current + 4
        Book[] newBag = new Book[books.length + sizeFactor];

        // copy over all elements from current to new array
        for(int i = 0; i < books.length; i++){
            newBag[i] = books[i];
        }

        // set new array as the books property
        books = newBag;
    }

    // helper method to generate serial numbers
    public String getNewSerialNumber() {
        return Integer.toString(currentSerialNumber++);
    }

    // adds a book to the bag
    // grows bag if needed
    public void add(Book book) {
        if (numBooks == books.length - 1) {
            grow();
        }

        books[numBooks] = book;
        numBooks++;
    }


    // removes a book if it exists
    public boolean remove(Book book) {
        int indexOfBook = find(book);

        // case book not found
        if(indexOfBook == -1) {
            return false;
        }

        for(int i = 0; i < books.length; i++) {
            // last elem will always be null by virtue of one being removed
            if(i+1 == books.length) {
                books[i] = null;
                break;
            }
            // from the target index to end, shift elements to the left
            if(i >= indexOfBook) {
                books[i] = books[i+1];
            }
        }

        return true;
    }

    // checks out a book if available
    public boolean checkOut(Book book) {
        int indexOfBook = find(book);

        // if book not found or is already checked out
        if(indexOfBook == -1 || books[indexOfBook].getCheckedOut()) {
            return false;
        }

        books[indexOfBook].checkOut();
        return true;
    }

    // returns a book if possible
    public boolean returns(Book book) {
        int indexOfBook = find(book);

        if(indexOfBook == -1) {
            return false;
        }

        books[indexOfBook].checkIn();
        return true;

    }

    // print the list of books in the bag
    public void print() {
        // Todo
    }

    // print the list of books by datePublished (ascending)
    public void printByDate() {
        // Todo
    }

    // print the list of books by number (ascending)
    public void printByNumber() {
        // Todo
    }
}
