<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit book</title>
</head>
<body>
<h3>Edit Book</h3>
<form method="post">
    <input type="hidden" value="${book.id}" name="id"/>
    <label>Book name</label><br>
    <input name="bookName" value="${book.bookName}" /><br><br>
    <label>Book author</label><br>
    <input name="bookAuthor" value="${book.bookAuthor}" /><br><br>
    <input type="submit" value="Send">
</form>
</body>
</html>
