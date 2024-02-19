package com.example.books;

import com.example.books.MySQL.Book;
import com.example.books.MySQL.BookDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            BookDB.remove(id);
            response.sendRedirect(request.getContextPath()+"/library");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}