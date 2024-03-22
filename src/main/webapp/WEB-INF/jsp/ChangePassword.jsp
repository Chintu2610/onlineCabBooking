
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

<meta name="description" content="xm-s1 Admin Template">
<meta name="keywords"
	content="admin, Cryptocurrency, account management">
<meta name="author" content="Weblabs - Admin Template">
<meta name="robots" content="noindex, nofollow">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Passwords</title>

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/LOGOTrade.jpg">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Lineawesome CSS -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

    <!-- Select2 CSS -->
    <link rel="stylesheet" href="css/select2.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tstyles.css">

      <style>
     
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            display: flex;
        }

        main {
            flex: 1;
            overflow-y: auto; /* Enable vertical scrolling */
        }

        section {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            padding: 20px;
        }

        .feature {
            width: 30%;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 10px;
            padding: 20px;
            box-sizing: border-box;
        }

        .feature img {
            max-width: 100%;
            border-radius: 4px;
        }

        footer {
            background-color: #2c3e50;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
  .white-smoke-background {
    background-color: whitesmoke;
    height: 530px;
    width : 1200px;
    padding: 50px 80px; /* Increase padding for wider frame and more height */
    border-radius: 12px; /* Increase border-radius for smoother corners */
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Optional: Adjust shadow */
    margin-right: 20px; /* Increase margin towards the right */
}

        </style>
</head>
<body>

 <%@ include file="sidebar.jsp"%>
	<div class="main-wrapper">
		<%@ include file="header.jsp"%>


		<div class="page-wrapper">
		<h1 style="text-align: center;">Welcome <%=username %></h1>
                  <div class="white-smoke-background">
                  <h3 class="page-title">Change Password</h3><br>
    <form action="/ChangePasswords" method="post" class="form-container">
        <div class="row">
       

            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>User Name <span class="text-danger">*</span></label>
                    <input required name="username" readonly class="form-control" type="text" value="<%=username %>">
                </div>
            </div>
           
           <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>Old Password<span class="text-danger">*</span></label>
                    <input required name="oldpass" class="form-control" type="password">
                </div>
            </div>
           
           <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>New Password<span class="text-danger">*</span></label>
                    <input required name="password" class="form-control" type="password">
                </div>
            </div>
            
            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>Confirm Password<span class="text-danger">*</span></label>
                    <input required name="password" id="password" type="password" class="form-control">
                </div>
            </div>
            
            

        </div>
        <div class="col-md-12">
            <button  type="submit" class="btn btn-success centre">Update</button>
        </div>
        
    </form>
</div>


<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/app.js"></script>
<%@ include file="footer.jsp" %>
</div>
</div>
</body>
</html>
