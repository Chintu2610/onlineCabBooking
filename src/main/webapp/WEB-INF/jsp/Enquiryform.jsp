<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>Enquiryform</title>

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Feathericon CSS -->
    <link rel="stylesheet" href="css/feathericon.min.css">

    <!-- Datatables CSS -->
    <link rel="stylesheet" href="css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href="css/select.bootstrap4.min.css">
    <link rel="stylesheet" href="css/buttons.bootstrap4.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    
</head>

<body>
    <!-- Main Wrapper -->
     <!-- Main Wrapper -->
	 <%@ include file="sidebar.jsp" %>
    <div class="main-wrapper">
    	
        
        <%@ include file="header.jsp" %>
         <div class="page-wrapper">
            <div class="content container-fluid">
                <!-- Page Header -->
                <div class="page-header">
                    <div class="row">
                        <div class="col">
                            <h3 class="page-title">Enquiry</h3>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                                <li class="breadcrumb-item active">Add Enquiry</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /Page Header -->

              <div class="row">
 



        </div>
        <!-- End previous row and start a new row -->
        <div class="row">
			<div class="col mx-auto">
					       
					 
                        <form action="./AddEnquiryServlet" method="post">
                      
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" placeholder="Your Name*">
                            </div> 
                            <div class="form-group">
								    <input type="text" name="email" class="form-control"  placeholder="Enter Email">
								</div>
                            <div class="form-group">
                                <input type="text" name="phone" class="form-control" placeholder="Enter Phone">
                            </div>
                            
                            <div class="form-group">
                                <textarea class="form-control" name="message" placeholder="Enter Message"></textarea>
                            </div>
                             <div class="form-group" style="display:none;">
							    <input type="text" name="id" name="propertyId" value="" class="form-control custom-input" style="width: 300px;">
							</div>
                            <div class="form-group mt-4">
                                <button type="submit" class="btn btn-primary w-100">Submit Inquiry</button>
                            </div>
                            
                        </form>
                        
                        

</div>
</div>
</div>
</div>
</div>
    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>

    <!-- Bootstrap Core JS -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- Slimscroll JS -->
    <script src="js/jquery.slimscroll.min.js"></script>

    <!-- Datatables JS -->
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap4.min.js"></script>
    <script src="js/dataTables.responsive.min.js"></script>
    <script src="js/responsive.bootstrap4.min.js"></script>

    <script src="js/dataTables.select.min.js"></script>

    <script src="js/dataTables.buttons.min.js"></script>
    <script src="js/buttons.bootstrap4.min.js"></script>
    <script src="js/buttons.html5.min.js"></script>
    <script src="js/buttons.flash.min.js"></script>
    <script src="js/buttons.print.min.js"></script>

</body>

</html>

