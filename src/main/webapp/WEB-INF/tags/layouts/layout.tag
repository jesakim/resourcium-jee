<%@tag description="layout Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Layout</title>
</head>
<body>
<div id="header">
    <!-- Header content -->
    This is the header.
    <h1>Welcome, ${sessionScope.username}</h1>
</div>

<div id="content">
    <jsp:doBody />
</div>

<div id="footer">
    <!-- Footer content -->
    This is the footer.
</div>
</body>
</html>