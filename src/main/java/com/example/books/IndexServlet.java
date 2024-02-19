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

@WebServlet("/library")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        ArrayList<Book> books = BookDB.select();
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
