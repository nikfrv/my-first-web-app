<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Books</title>
</head>
<h2>Library</h2>
<body>
<a href ="library">
  <button>Go to library</button><br><br>
</a>
<a href ="create">
  <button>Create new book</button><br><br>
</a>
<a href ="find">
  <button>Find a book</button><br><br>
</a>
<form action="<c:url value="/library"/>" method="GET">
  <table>
  <tr><th>id</th><th> Book</th><th> Author</th><th></th></tr>
    <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.id}</td>
        <td>${book.bookName}</td>
        <td>${book.bookAuthor}</td>
        <td>
          <a href='<c:url value="/edit?id=${book.id}" />'>Edit</a> |
      <form method="post" action='<c:url value="/remove" />' style="display:inline;">
        <input type="hidden" name="id" value="${book.id}">
        <input type="submit" value="Delete">
      </form>
    </c:forEach>
  </table>
</form>
</body>
</html>