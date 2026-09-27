# GLCS Library

A small desktop app I made for our school library. Students can look up a book, see which shelf it's on, and check it out or return it. Librarians can log in to see who has what and to add or remove books.

Built with Java Swing.

## What it does

- Search books by title. Spaces and letter case are ignored, so `자바의정석` finds "자바의 정석".
- Shows each book's location (floor and shelf) and whether it's available.
- Double-click a book to borrow or return it. Borrowing asks for the student's name and grade, and returning only works if the same name and grade are entered.
- Admin login (top-right button) opens the loan history: every book, who borrowed it, their grade and when. From there you can add a book (a barcode is generated automatically) or delete one.

## Running it

**Windows:** run `Library.exe`. You need Java 17 or newer installed. Data is saved to `books.dat` in the same folder.

**From source:**

```bash
javac -encoding UTF-8 -d out src/*.java src/LJY/*.java
java -cp out GUI
```

**IntelliJ IDEA:** open the folder and run `GUI.main()`. To build a jar, use *Build → Build Artifacts → Library:jar*.

## Project layout

```
src/
  GUI.java               main window (entry point)
  BookDetailGUI.java     book details, borrow / return
  LoginGUI.java          admin login
  BorrowHistoryGUI.java  loan history, add / delete books
  AddBookGUI.java        add-book form
  LJY/BookList.java      book data: search, loans, save / load
  Book.java              not used anymore (BookList.Book replaced it)
books.dat                saved book data
Library.exe              Windows build
```

## Notes

- Books are stored as a serialized `HashMap` (barcode → book) in `books.dat`. If the file is missing, the app starts with five sample books.
- Every change (borrow, return, add, delete) is written to `books.dat` right away.
- The admin ID and password are hardcoded in `src/LoginGUI.java`. Change them before using this anywhere real.
