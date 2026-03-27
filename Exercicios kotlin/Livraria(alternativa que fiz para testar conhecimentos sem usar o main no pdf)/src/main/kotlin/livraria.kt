package org.example


open class Book(val title: String, val author: String, val publicationYear: Int, availableCopies: Int) {
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
}

class PhysicalBook(
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    val weight: Int,
    val hasHardcover: Boolean = true
) : Book(title, author, publicationYear, availableCopies) {
}

class Library {

    val books = mutableListOf<Book>()

    fun addBook() {
        println("What type of book? (1 = Digital, 2 = Physical):")
        val type = readLine()!!.toInt()

        println("Enter book title:")
        val title = readLine()!!

        println("Enter author name:")
        val author = readLine()!!

        println("Enter publication year:")
        val year = readLine()!!.toInt()

        println("Enter number of copies:")
        val copies = readLine()!!.toInt()

        if (type == 1) {
            println("Enter file size (MB):")
            val fileSize = readLine()!!.toDouble()

            println("Enter format (PDF, EPUB, MOBI):")
            val format = readLine()!!

            val book = DigitalBook(title, author, year, copies, fileSize, format)
            books.add(book)
            println("${book.title} added to the library!")

        } else if (type == 2) {
            println("Enter weight (grams):")
            val weight = readLine()!!.toInt()

            println("Does it have a hardcover? (true/false):")
            val hardcover = readLine()!!.toBoolean()

            val book = PhysicalBook(title, author, year, copies, weight, hardcover)
            books.add(book)
            println("${book.title} added to the library!")

        } else {
            println("Invalid type! Please enter 1 or 2")
        }
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
            println("No books in the library!")
        } else {
            for (book in books) {
                println("--------------------")
                println("Title: ${book.title}")
                println("Author: ${book.author}")
                println("Era: ${book.getEra()}")
                println("Copies: ${book.availableCopies}")
            }
        }
    }

    fun searchByAuthor(author: String) {
        var found = false
        for (book in books) {
            if (book.author == author) {
                found = true
                println("--------------------")
                println("Title: ${book.title}")
                println("Author: ${book.author}")
                println("Era: ${book.getEra()}")
                println("Copies: ${book.availableCopies}")
            }
        }
        if (found == false) {
            println("No books found by $author!")
        }
    }
}

fun main() {

    val library = Library()

    var running = true

    while (running) {
        println("-----")
        println("What do you want to do?")
        println("1 - Add a book")
        println("2 - Show all books")
        println("3 - Borrow a book")
        println("4 - Return a book")
        println("5 - Search by author")
        println("6 - Exit")

        val choice = readLine()!!.toInt()

        if (choice == 1) {
            library.addBook()

        } else if (choice == 2) {
            library.showBooks()

        } else if (choice == 3) {
            println("Enter the title of the book you want to borrow:")
            val title = readLine()!!
            library.borrowBook(title)

        } else if (choice == 4) {
            println("Enter the title of the book you want to return:")
            val title = readLine()!!
            library.returnBook(title)

        } else if (choice == 5) {
            println("Enter the author name you want to search:")
            val author = readLine()!!
            library.searchByAuthor(author)

        } else if (choice == 6) {
            running = false

        } else {
            println("Invalid option! Please enter a number between 1 and 6")
        }
    }
}