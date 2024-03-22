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

            <!-- Page Header -->
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col">
                       
             
                    <h3 class="page-title">TopUp</h3>
						<ul class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
							<li class="breadcrumb-item active">TopUp</li>
						</ul>
                    </div>
                    <div class="col-auto float-right ml-auto">
                         <div class="view-icons">
                           <!--  <a href="leaves.jsp" title="Grid View" class="grid-view btn btn-link active"><i class="fa fa-th"></i></a>
                            <a href="leaves-list.jsp" title="Tabular View" class="list-view btn btn-link"><i class="fa fa-bars"></i></a> -->
                        </div>
                    </div>
                </div>
            </div>

            <!-- Search form -->
            <form action="./LeaveSearchSrv" method="post">
             
           <div class="row filter-row">
    <div class="col-sm-6 col-md-3">
        <div class="form-group">
            <label>Product Type</label>
            <select class="form-control">
            	<option selected>Select Product Type</option>
                <option>PG-2(Normal cards)</option>
                <option>PG-2(Normal and corporation cards)</option>
                <option>PG-2(Normal cards)</option>
                <option>PG-2(Normal cards)</option>
            </select>
        </div>
    </div>

    <div class="col-sm-6 col-md-3">
        <div class="form-group form-focus">
            <label>Name</label>
            <input class="input form-control floating" name="Name" id="name" type="text">
        </div>
    </div>

    <div class="col-sm-6 col-md-3">
        <div class="form-group form-focus">
            <label>Amount</label>
            <input class="input form-control floating" name="Amount" id="Amount" type="text">
        </div>
    </div>
	
	<div class="col-sm-6 col-md-3">
        <div class="form-group form-focus">
            <label>Mobile</label>
            <input class="input form-control floating" name="Mobile" id="Amount" type="text">
        </div>
    </div>
    </div>
	<div class="row filter-row">
	<div class="col-sm-6 col-md-3">
        <div class="form-group form-focus">
            <label>Remarks</label>
            <input class="input form-control floating" name="Mobile" id="Amount" type="text">
        </div>
    </div>
	
    <div class="col-sm-6 col-md-3">
        <div class="form-group">
            <label>&nbsp;</label>
            <input class="search btn btn-primary" type="submit" value="SUBMIT">
        </div>
    </div>
</div>

              <!-- <div class="col-sm-6 col-md-3"> 
				<div class="custom-input-field form-group form-focus d-flex align-items-center">
				 <label>StarDate</label>
			            <input class="input" class="form-control floating" type="date" value="" name="start_date" id="start_date" placeholder=" ">
			        </div>
			    </div>
		

                <div class="col-sm-6 col-md-3"> 
				<div class="custom-input-field form-group form-focus d-flex align-items-center">
				 <label>EndDate</label>
			     <input class="input" class="form-control floating" type="date" value="" name="end_date" id="end_date" placeholder=" ">     
			        </div>
			    </div>
                <div class="col-sm-6 col-md-3" id = "flag">
                    <label>Records per page:</label>
                    <select id="recordsPerPage" onchange="changeRecordsPerPage()">
                    <option value="5" hidden>5</option>
				   	<option value="5">5</option>
				    <option value="10">10</option>
				    <option value="20">20</option>
				     </select>
                </div> -->
            </form>
        </div>        
	
    	<%@ include file="footer.jsp" %>
    </div>
    
    </div>
</body>
</html>
