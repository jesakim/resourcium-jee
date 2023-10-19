<%@ page import="com.resourcium1.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/layouts" %>

<%
  User user = (User) session.getAttribute("user");
%>

<t:layout>
    <jsp:body>
        <div class="container">
            <form action="me?action=changeinfo" class="my-5" method="POST">
                <div class="mb-3">
                    <label class="form-label">Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Username" name="username" value="${user.getUsername()}">
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Email" name="email" value="${user.getEmail()}">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary w-100">Save Changes</button>

            </form>

            <form action="me?action=changepassword" class="mt-5" method="POST">
                <div class="mb-3">
                    <label class="form-label">Old Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" placeholder="Old Password" name="oldpassword">
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">New Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" placeholder="New Password" name="newpassword">
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">New Password Confirmation</label>
                    <div class="input-group">
                        <input type="password" class="form-control" placeholder="New Password Confirmation" name="confirmpassword">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary w-100">Change Password</button>

            </form>

        </div>
    </jsp:body>
</t:layout>
