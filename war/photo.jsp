<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a id="btn-choose-image" class="active btn" onclick="togglePhotoPost(true)">Choose an image</a>
        <div id="upload-form" style="display:none">
          <form action="<%= serviceManager.getUploadUrl() %>" method="post"
            enctype="multipart/form-data">
            <input class="inactive file btn" type="file" name="photo">
            <textarea name="title" placeholder="Write a description"></textarea>
            <input class="active btn" type="submit" value="Post">
            <a class="cancel" onclick="togglePhotoPost(false)">Cancel</a>
          </form>
        </div>

</body>
</html>