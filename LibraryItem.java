// Abstract superclass
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName; // Encapsulation applied

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrowerName = null; // Initially not borrowed
    }

    public abstract int getLoanDuration(); // Abstract method for loan period

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Borrower: " + (borrowerName == null ? "Available" : borrowerName));
    }
}

// Interface for reservable items
interface Reservable {
    void reserveItem(String reserver);
    boolean checkAvailability();
}

// Subclass: Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }

    @Override
    public void reserveItem(String reserver) {
        System.out.println("Book reserved by " + reserver);
    }

    @Override
    public boolean checkAvailability() {
        return true; // Assume books are always available for reservation
    }
}

// Subclass: Magazine which can't be reserved so no need to implement interface
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // DVDs can be borrowed for 5 days
    }

    @Override
    public void reserveItem(String reserver) {
        System.out.println("DVD reserved by " + reserver);
    }

    @Override
    public boolean checkAvailability() {
        return false; // Assume DVDs have limited copies, so availability is false
    }

    public static void main(String[] args) {
        LibraryItem book = new Book("B1", "Core Java Programming", "Pranav");
        LibraryItem magazine = new Magazine("M2", "MARCA", "Nikhil");
        LibraryItem dvd = new DVD("D3", "Science", "National Geographic");

        book.getItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days\n");

        magazine.getItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days\n");

        dvd.getItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days\n");

        // Demonstrating Reservable functionality
        Reservable reservableBook = new Book("B10", "Python Basics", "Alice Brown");
        reservableBook.reserveItem("Akshay");
        System.out.println("Is Available? " + reservableBook.checkAvailability() + "\n");

        Reservable reservableDVD = new DVD("D40", "History of Space", "NASA");
        reservableDVD.reserveItem("Abhay");
        System.out.println("Is Available? " + reservableDVD.checkAvailability());
    }
}
