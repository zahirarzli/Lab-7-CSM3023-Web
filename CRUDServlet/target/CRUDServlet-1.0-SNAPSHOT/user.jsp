<%-- 
    Document   : user
    Created on : Jun 15, 2024, 4:29:12 PM
    Author     : S67554
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Record</title>
</head>

<body>
    <h1>New Record</h1>
    <form name="frmAddUser" action="UserController" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="userId" value="" size="25" required /></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" value="" size="40" /></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" value="" size="40" /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="insert" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" name="submit" />
                        <input type="reset" value="Cancel" name="cancel" />
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>

</html>
