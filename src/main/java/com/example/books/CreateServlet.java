package com.example.books;

import com.example.books.MySQL.Book;
import com.example.books.MySQL.BookDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import com.example.books.MySQL.Book;
import com.example.books.MySQL.BookDB;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String bookName = request.getParameter("bookName");
            String bookAuthor = request.getParameter("bookAuthor");
            Book book = new Book(bookName, bookAuthor);
            BookDB.insert(book);
            response.sendRedirect(request.getContextPath() + "/library");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}