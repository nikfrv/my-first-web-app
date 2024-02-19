<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<h2>Find a book</h2>
<body>
<style>
    .button {
        background-color: #1367fd;
        outline: none;
        border: 1px solid #1135dd;
        padding: 8px 16px;
        border-radius: 8px;
        color: #fff;
        cursor: pointer;
        font-size: 1rem;
        font-weight: 600;
    }

    .button:hover {
        background-color: #2475fd;
    }
</style>


<form method="get" action='<c:url value="/find?bookAuthor=${book.bookAuthor}" />'>
    <label>Enter author</label><br><br>
    <input name="bookAuthor" value="${book.bookAuthor}"><br><br>
    <button class="button" type="submit">Send</button>
</form>
<table>
    <tr><th>id</th><th> Book</th><th> Author</th><th></th></tr>
    <c:forEach var="book" items="${books}">
    <tr>
        <td>${book.id}</td>
        <td>${book.bookName}</td>
        <td>${book.bookAuthor}</td>
        <td>
    </c:forEach>
</table>
<a href ="library">
    <button>Go to library</button><br><br>
</a>
</body>
</html>
