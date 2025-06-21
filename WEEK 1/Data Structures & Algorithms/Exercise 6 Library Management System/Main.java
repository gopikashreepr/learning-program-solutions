import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen")
        };

        // Linear Search Test
        System.out.println("🔍 Linear Search for '1984':");
        Book result1 = LibrarySearch.linearSearch(books, "1984");
        System.out.println(result1 != null ? result1 : "Book not found");

        // Sort before Binary Search
        Arrays.sort(books);

        // Binary Search Test
        System.out.println("\n🔍 Binary Search for 'Pride and Prejudice':");
        Book result2 = LibrarySearch.binarySearch(books, "Pride and Prejudice");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
