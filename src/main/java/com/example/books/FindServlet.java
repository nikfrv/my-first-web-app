package com.example.books;

import com.example.books.MySQL.Book;
import com.example.books.MySQL.BookDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/find")
public class FindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String bookAuthor = request.getParameter("bookAuthor");
            ArrayList<Book> books = BookDB.selectByAuthor(bookAuthor);
            request.setAttribute("books", books);
            getServletContext().getRequestDispatcher("/find.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}