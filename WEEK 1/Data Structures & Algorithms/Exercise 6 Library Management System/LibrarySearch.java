import java.util.Arrays;

public class LibrarySearch {

    // Linear search by title
    public static Book linearSearch(Book[] books, String targetTitle) {
        targetTitle = targetTitle.toLowerCase();
        for (Book book : books) {
            if (book.getTitle().equals(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title (assuming array is sorted)
    public static Book binarySearch(Book[] books, String targetTitle) {
        targetTitle = targetTitle.toLowerCase();
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareTo(targetTitle);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}
