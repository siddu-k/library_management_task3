# 📚 Library Management System

A comprehensive Java console application for managing library books and users with complete book issue and return functionality.

## 🎯 Project Objective

Develop a mini system to manage books and users in a library environment, providing essential operations like book issuing, returning, and user management.

## 🏗️ System Architecture

### Core Classes

#### 📖 Book Class
- **Properties:**
  - `bookId` (int): Unique identifier for each book
  - `title` (String): Book title
  - `author` (String): Book author
  - `isIssued` (boolean): Current issue status

- **Methods:**
  - Getters and setters for all properties
  - `toString()` for formatted display

#### 👤 User Class  
- **Properties:**
  - `userId` (int): Unique identifier for each user
  - `name` (String): User's name
  - `issuedBooks` (List<Book>): List of books currently issued to user

- **Methods:**
  - Book management (add/remove issued books)
  - Getters for user information
  - `toString()` for formatted display

#### 🏛️ Library Class
- **Properties:**
  - `books` (List<Book>): Collection of all library books
  - `users` (List<User>): Collection of all registered users

- **Core Features:**
  - ✅ Add books and users
  - ✅ Issue books to users
  - ✅ Return books from users
  - ✅ Display all books and users
  - ✅ Find books and users by ID
  - ✅ Display user-specific issued books

## 🚀 Features

### 📋 Menu-Driven Interface
1. **Add Book** - Register new books in the library
2. **Add User** - Register new library users
3. **Display All Books** - View complete book catalog
4. **Display All Users** - View all registered users
5. **Issue Book** - Assign a book to a user
6. **Return Book** - Process book returns
7. **Display User's Books** - View books issued to specific user
8. **Exit** - Close the application

### 🔍 Smart Validation
- **Duplicate Issue Prevention**: Cannot issue already issued books
- **User Verification**: Validates user existence before operations
- **Book Availability Check**: Confirms book availability before issuing
- **Return Validation**: Ensures only issued books can be returned

### 📊 Sample Data
Pre-loaded with demonstration data:
- **Books**: Java Programming, Clean Code, Design Patterns
- **Users**: Alice Johnson, Bob Smith, Charlie Brown

## 🛠️ How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command Line Interface (Terminal/PowerShell)

### Compilation and Execution

1. **Navigate to project directory:**
   ```bash
   cd C:\sid\java\Library_Management_System
   ```

2. **Compile the Java file:**
   ```bash
   javac Main.java
   ```

3. **Run the application:**
   ```bash
   java Library_Management_System.Main
   ```

## 💡 Usage Examples

### Adding a New Book
```
Enter your choice: 1
Enter Book ID: 104
Enter Book Title: Effective Java
Enter Author Name: Joshua Bloch
Book added successfully: Effective Java
```

### Issuing a Book
```
Enter your choice: 5
Enter Book ID to issue: 101
Enter User ID: 1
Book 'The Java Programming Language' issued to Alice Johnson successfully.
```

### Returning a Book
```
Enter your choice: 6
Enter Book ID to return: 101
Enter User ID: 1
Book 'The Java Programming Language' returned by Alice Johnson successfully.
```

## 🗂️ Project Structure

```
Library_Management_System/
├── Main.java          # Main application file containing all classes
└── README.md          # Project documentation
```

## 🎯 Key Implementation Highlights

- **Object-Oriented Design**: Clean separation of concerns with distinct classes
- **Data Integrity**: Robust validation prevents invalid operations
- **User Experience**: Intuitive menu system with clear feedback
- **Scalability**: ArrayList-based storage allows dynamic growth
- **Error Handling**: Comprehensive validation with user-friendly messages

## 🔧 Technical Details

- **Language**: Java
- **Data Structures**: ArrayList for dynamic collections
- **Input Handling**: Scanner for user interaction
- **Design Pattern**: Simple MVC-like structure
- **Package**: `Library_Management_System`

## 📈 Future Enhancements

- Database integration for persistent storage
- Advanced search functionality (by title, author)
- Due date tracking and fine calculation
- Book reservation system
- Multiple copies management
- User authentication and roles

## 👨‍💻 Author

**Siddu K**
- GitHub: [@siddu-k](https://github.com/siddu-k)
- Repository: [library_management_task3](https://github.com/siddu-k/library_management_task3)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

*Built with ❤️ for learning Java programming and system design concepts.*