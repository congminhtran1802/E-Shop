<%-- 
    Document   : update-book
    Created on : May 17, 2023, 8:45:22 PM
    Author     : TGDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="container">
            <h1>update-student-form</h1>
            <hr>
            <form action="AdminController" method="GET">
                <input type="hidden" name="command" value="UPDATE">
                <input type="hidden" name="bookId"
                       value="${THE_BOOK.id}">
                  <table border="0">
                <tbody>
                    
                  
                    <tr>
                        <td><label>Tên Sách </label> </td>
                        <td><input type="text" name="title" value="${THE_BOOK.title}" /></td>
                    </tr>
                    <tr>
                        <td><label>Tác Giả </label> </td>
                        <td><input type="text" name="author"value="${THE_BOOK.author}" /></td>
                    </tr>
                    <tr>
                        <td><label>thời gian </label> </td>
                        <td><input type="text" name="publisherDate" value="${THE_BOOK.publisherDate}" /></td>
                    </tr>
                    <tr>
                        <td><label>thể loại </label> </td>
                        <td><input type="text" name="category" value="${THE_BOOK.category}" /></td>
                    </tr>
                    <tr>
                        <td><label>chi tiết </label> </td>
                        <td><input type="text" name="description" value="${THE_BOOK.description}" /></td>
                    </tr>
                    <tr>
                        <td><label>Price: </label> </td>
                        <td><input type="text" name="price" value="${THE_BOOK.price}" /></td>
                    </tr>
                      <tr>
                        <td><label>Image </label></td>
                        <td><input type="text" name="image" value="${THE_BOOK.image}"/></td>
                    </tr>
                    <tr>
                        <input type="submit" value="UPDATE" class="save" />
                    </tr>
                </tbody>
            </table>


            </form>

        </div>
    </body>
</html>
