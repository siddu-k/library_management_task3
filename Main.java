package Library_Management_System;

import java.util.*;

// Book class to represent individual books
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;
    
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    
    // Getters
    public int getBookId() {
        return bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isIssued() {
        return isIssued;
    }
    
    // Setters
    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "ID=" + bookId +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Issued=" + isIssued +
                '}';
    }
}

// User class to represent library users
class User {
    private int userId;
    private String name;
    private List<Book> issuedBooks;
    
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }
    
    // Getters
    public int getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }
    
    // Methods to manage issued books
    public void addIssuedBook(Book book) {
        issuedBooks.add(book);
    }
    
    public void removeIssuedBook(Book book) {
        issuedBooks.remove(book);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "ID=" + userId +
                ", Name='" + name + '\'' +
                ", Issued Books=" + issuedBooks.size() +
                '}';
    }
}

// Library class to manage books and users
class Library {
    private List<Book> books;
    private List<User> users;
    
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }
    
    // Add a user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("User registered successfully: " + user.getName());
    }
    
    // Display all books
    public void displayBooks() {
        System.out.println("\n=== All Books ===");
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    // Display all users
    public void displayUsers() {
        System.out.println("\n=== All Users ===");
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    // Find book by ID
    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
    
    // Find user by ID
    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
    
    // Issue a book to a user
    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        
        if (book.isIssued()) {
            System.out.println("Book '" + book.getTitle() + "' is already issued.");
            return;
        }
        
        book.setIssued(true);
        user.addIssuedBook(book);
        System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName() + " successfully.");
    }
    
    // Return a book from a user
    public void returnBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        
        if (!book.isIssued()) {
            System.out.println("Book '" + book.getTitle() + "' is not currently issued.");
            return;
        }
        
        if (!user.getIssuedBooks().contains(book)) {
            System.out.println("Book '" + book.getTitle() + "' is not issued to " + user.getName());
            return;
        }
        
        book.setIssued(false);
        user.removeIssuedBook(book);
        System.out.println("Book '" + book.getTitle() + "' returned by " + user.getName() + " successfully.");
    }
    
    // Display books issued to a specific user
    public void displayUserBooks(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        
        System.out.println("\n=== Books issued to " + user.getName() + " ===");
        if (user.getIssuedBooks().isEmpty()) {
            System.out.println("No books issued to this user.");
        } else {
            for (Book book : user.getIssuedBooks()) {
                System.out.println(book);
            }
        }
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();
    
    public static void main(String[] args) {
        // Add some sample data
        initializeSampleData();
        
        System.out.println("Welcome to Library Management System!");
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    library.displayUsers();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    displayUserBooks();
                    break;
                case 8:
                    System.out.println("Thank you for using Library Management System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n=== Library Management System Menu ===");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Display All Books");
        System.out.println("4. Display All Users");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Display User's Books");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        
        Book book = new Book(bookId, title, author);
        library.addBook(book);
    }
    
    private static void addUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        
        User user = new User(userId, name);
        library.addUser(user);
    }
    
    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int bookId = scanner.nextInt();
        
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        
        library.issueBook(bookId, userId);
    }
    
    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = scanner.nextInt();
        
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        
        library.returnBook(bookId, userId);
    }
    
    private static void displayUserBooks() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        
        library.displayUserBooks(userId);
    }
    
    private static void initializeSampleData() {
        // Add sample books
        library.addBook(new Book(101, "The Java Programming Language", "James Gosling"));
        library.addBook(new Book(102, "Clean Code", "Robert C. Martin"));
        library.addBook(new Book(103, "Design Patterns", "Gang of Four"));
        
        // Add sample users
        library.addUser(new User(1, "Alice Johnson"));
        library.addUser(new User(2, "Bob Smith"));
        library.addUser(new User(3, "Charlie Brown"));
    }
}
