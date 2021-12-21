package _21_design_pattern.practice.singleton;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("BEGIN TESTING SINGLETON PATTERN");
        BorrowBook bookBorrower1 = new BorrowBook();
        BorrowBook bookBorrower2 = new BorrowBook();

        bookBorrower1.borrowBook();
        System.out.println("BookBorrower1 asked to borrow the book");
        System.out.println("BookBorrower1 Author and Title: ");
        System.out.println(bookBorrower1.getAuthorAndTitle());

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 asked to borrow the book");
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(bookBorrower2.getAuthorAndTitle());

        bookBorrower1.returnBook();
        System.out.println("BookBorrower1 returned the book");

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(bookBorrower1.getAuthorAndTitle());

        System.out.println("END TESTING SINGLETON PATTERN");
    }
}
