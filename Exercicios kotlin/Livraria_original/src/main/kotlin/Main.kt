package org.example

abstract class Book(
    val title: String,
    val author: String,
    val publicationYear: Int,
    availableCopies: Int
) {
    var availableCopies: Int = availableCopies
        set(value) {
            if (value < 0) {
                println("Cannot set negative copies!")
            } else if (value == 0) {
                println("Warning: Book is now out of stock!")
                field = value
            } else {
                field = value
            }
        }

    fun getEra(): String {
        if (publicationYear < 1980) {
            return "Classic"
        } else if (publicationYear <= 2010) {
            return "Modern"
        } else {
            return "Contemporary"
        }
    }

    abstract fun getStorageInfo(): String

    override fun toString(): String {
        return "Title: $title | Author: $author | Era: ${getEra()} | Copies: $availableCopies | ${getStorageInfo()}"
    }

    init {
        println("Book created: $title by $author")
    }
}

class DigitalBook(
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    val fileSize: Double,
    val format: String
) : Book(title, author, publicationYear, availableCopies) {

    override fun getStorageInfo(): String {
        return "Stored digitally: $fileSize MB, Format: $format"
    }

    override fun toString(): String {
        return super.toString()
    }
}

class PhysicalBook(
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    val weight: Int,
    val hasHardcover: Boolean = true
) : Book(title, author, publicationYear, availableCopies) {

    override fun getStorageInfo(): String {
        val hardcoverText = if (hasHardcover) "Yes" else "No"
        return "Physical book: ${weight}g, Hardcover: $hardcoverText"
    }

    override fun toString(): String {
        return super.toString()
    }
}

class Library(val libraryName: String) {

    val books = mutableListOf<Book>()
// No Caso de ter mais de uma libraria companion object para criar uma especie de nuvem em certos valores
    var totalBooksCreated = 0


    fun addBook(book: Book) {
        books.add(book)
        totalBooksCreated = totalBooksCreated + 1
        println("${book.title} added to $libraryName!")
    }

    fun borrowBook(title: String) {
        var found = false
        for (book in books) {
            if (book.title == title) {
                found = true
                if (book.availableCopies > 0) {
                    book.availableCopies = book.availableCopies - 1
                    println("You borrowed ${book.title}. Copies left: ${book.availableCopies}")
                } else {
                    println("Sorry, ${book.title} is out of stock!")
                }
            }
        }
        if (found == false) {
            println("Book not found!")
        }
    }

    fun returnBook(title: String) {
        var found = false
        for (book in books) {
            if (book.title == title) {
                found = true
                book.availableCopies = book.availableCopies + 1
                println("You returned ${book.title}. Copies now: ${book.availableCopies}")
            }
        }
        if (found == false) {
            println("Book not found!")
        }
    }

    fun showBooks() {
        if (books.size == 0) {
            println("No books in $libraryName!")
        } else {
            println("\n--- Books in $libraryName ---")
            for (book in books) {
                println(book.toString())
            }
        }
    }

    fun searchByAuthor(author: String) {
        var found = false
        for (book in books) {
            if (book.author == author) {
                found = true
                println(book.toString())
            }
        }
        if (found == false) {
            println("No books found by $author!")
        }
    }
}

fun main() {
    val library = Library("Central Library")

    val digitalBook = DigitalBook(
        "Kotlin in Action",
        "Dmitry Jemerov",
        2017,
        5,
        4.5,
        "PDF"
    )
    val physicalBook = PhysicalBook(
        "Clean Code",
        "Robert C. Martin",
        2008,
        3,
        650,
        true
    )
    val classicBook = PhysicalBook(
        "1984",
        "George Orwell",
        1949,
        2,
        400,
        false
    )

    library.addBook(digitalBook)
    library.addBook(physicalBook)
    library.addBook(classicBook)

    library.showBooks()

    println("\n--- Borrowing Books ---")
    library.borrowBook("Clean Code")
    library.borrowBook("1984")
    library.borrowBook("1984")
    library.borrowBook("1984")

    println("\n--- Returning Books ---")
    library.returnBook("1984")

    println("\n--- Search by Author ---")
    library.searchByAuthor("George Orwell")

    println("\n--- Total Books Added ---")
    println("Total: ${library.totalBooksCreated}")
}