<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PayZigo - Your Digital Financial Companion</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

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
	 <!-- Main Wrapper -->
	 <%@ include file="sidebar.jsp" %>
    <div class="main-wrapper">
    	
        
        <%@ include file="header.jsp" %>
         <div class="page-wrapper">
         <!-- Page Content -->
        <div class="content container-fluid">
 <div class="white-smoke-background">
            <!-- Page Header -->
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col">
                       
             
                    <h3 class="page-title">Enquiry</h3>
						<!-- <ul class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
							<li class="breadcrumb-item active">view Enquiry</li>
						</ul> -->
                    </div>
                    <div class="col-auto float-right ml-auto">
                         <div class="view-icons">
                         	 <button class="btn btn-primary" onclick="redirectToAddEnquiry()">Add Enquiry</button>
                    
                            </div>
                    </div>
                </div>
            </div>

            <!-- Search form -->
            <form action="./LeaveSearchSrv" method="post">
             
           <div class="row filter-row">
    

    <div class="col-sm-6 col-md-4">
        <div class="form-group form-focus">
            <label>Name</label>
            <input class="input form-control floating" name="Name" id="name" type="text">
        </div>
    </div>

    <div class="col-sm-6 col-md-4">
        <div class="form-group form-focus">
            <label>Amount</label>
            <input class="input form-control floating" name="Amount" id="Amount" type="text">
        </div>
    </div>
	
	<div class="col-sm-6 col-md-4">
        <div class="form-group form-focus">
            <label>Mobile</label>
            <input class="input form-control floating" name="Mobile" id="Amount" type="text">
        </div>
    </div>
    </div>
    <br>
   
	<div class="row filter-row">
	<div class="col-sm-6 col-md-3">
        <div class="form-group form-focus">
            <label>Remarks</label>
            <input class="input form-control floating" name="Mobile" id="Amount" type="text">
        </div>
    </div>
	</div>
	<br><br>
    <div class="col-sm-6 col-md-3">
        <div class="form-group">
            <label>&nbsp;</label>
            <input class="btn btn-success centre" type="submit" value="SUBMIT">
        </div>
    </div>
</div>

              
            </form>
        </div>        
	</div>
    	<%@ include file="footer.jsp" %>
    </div>
    

    <script>
        function redirectToAddEnquiry() {
        	
            window.location.href = "Enquiryform";
        }
    </script>
</body>
</html>