package com.example.books.MySQL;

import java.sql.*;
import java.util.ArrayList;

public class BookDB {

    private static String url = "jdbc:mysql://localhost:3306/booksdb";
    private static String username = "root";
    private static String password = "qwertyrf2016";

    public static ArrayList<Book> select() {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String bookName = resultSet.getString(2);
                    String bookAuthor = resultSet.getString(3);
                    Book book = new Book(id, bookName, bookAuthor);
                    books.add(book);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return books;
    }

    public static Book selectOne(int id) {
        Book book = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM books WHERE idBooks = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        int bookId = resultSet.getInt(1);
                        String bookName = resultSet.getString(2);
                        String bookAuthor = resultSet.getString(3);
                        book = new Book(bookId, bookName, bookAuthor);
                        System.out.println("Book with ID " + id + " Was found: " + book.getBookName());
                    } else {
                        throw new RuntimeException("Book with id " + id + " not found.");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return book;
    }

    public static int insert(Book book) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO books (bookName, bookAuthor) Values (?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, book.getBookName());
                    preparedStatement.setString(2, book.getBookAuthor());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int remove(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "DELETE FROM books WHERE idBooks = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        id = 1;
                    }
                    return rowsAffected;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Book book) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE books SET bookName = ?, bookAuthor = ? WHERE idBooks = ? ";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, book.getBookName());
                    preparedStatement.setString(2, book.getBookAuthor());
                    preparedStatement.setInt(3, book.getId());

                    return preparedStatement.executeUpdate();
                }
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<Book> selectByAuthor(String bookAuthor) {
        ArrayList <Book> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM books WHERE bookAuthor = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, bookAuthor);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        int bookId = resultSet.getInt(1);
                        String bookName = resultSet.getString(2);
                        Book book = new Book(bookId, bookName, bookAuthor);
                        books.add(book);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return books;
    }
}
