package com.example.books;


import com.example.books.MySQL.Book;
import com.example.books.MySQL.BookDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = BookDB.selectOne(id);
            if (book != null) {
                request.setAttribute("book", book);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            } else {
                System.out.println("Not found");
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String bookName = request.getParameter("bookName");
            String bookAuthor = request.getParameter("bookAuthor");
            Book book = new Book(id, bookName, bookAuthor);
            BookDB.update(book);
            response.sendRedirect(request.getContextPath() + "/library");
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
