<%@ tag import="com.resourcium1.models.User" %>
<%@tag description="layout Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Layout</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<div id="header">
    <!-- Header content -->
    This is the header.
    <%
        User user = (User) session.getAttribute("user");
    %>

    <h1>Welcome, <a href="me" ><%= user.getUsername() %> </a> !</h1>
</div>

<div id="content">
    <jsp:doBody />
</div>

<div id="footer">
    <!-- Footer content -->
    This is the footer.
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>