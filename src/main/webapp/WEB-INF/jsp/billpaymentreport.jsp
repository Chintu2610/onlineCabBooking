<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PayZigo - CashOut Ledger</title>

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
                       
             
                    <h3 class="page-title">Bill Payment Report</h3>
						<ul class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
							<li class="breadcrumb-item active">Bill Payment Report</li>
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

    <form action="search_logs.jsp" method="get">
      <div class="row filter-row">
       <div class="col-sm-6 col-md-3">
        <div class="form-group">
     <label>Search by RefID/APITransactionID/OperRefID <span class="text-danger">*</span></label>
        <input name="" class="form-control" type="">
            </div>
            </div>
     <div class="col-sm-6 col-md-3">
        <div class="form-group">
        <label>From date <span class="text-danger">*</span></label>
        <input name="fromdate" class="form-control" type="date">	
            </div>
            </div>									
 <div class="col-sm-6 col-md-3">
        <div class="form-group">
        <label>To date <span class="text-danger">*</span></label>
        <input name="todate" class="form-control" type="date">
            </div>
            </div>										
<br>
 <div class="col-sm-6 col-md-3">
        <div class="form-group">
   <label for="">Service Type:</label>
        <select style="width: 120px;height: 28px;" name="" id="">
            <option>Recharge</option>
            <option>BBPS</option>
            <option>CMS</option>
        </select>
    </div>
            </div>
            
 <div class="col-sm-6 col-md-3">
        <div class="form-group">
      <label for="">Product Type:</label>
        <select style="width: 120px;height: 28px;" name="" id="">
          
        </select>
            </div>
            </div>
            
        <div class="col-sm-6 col-md-3">
        <div class="form-group">    
       <label for="">Select Operator:</label>
        <select style="width: 120px;height: 28px;" name="" id="">
          
        </select>
             </div>
            </div>
               
<br>
 <div class="col-sm-6 col-md-3">
        <div class="form-group">
          <label for="">Select Status:</label>
        <select style="width: 120px;height: 28px;" name="" id="">
            <option>ALL</option>
            <option>SUCCESS</option>
            <option>PENDING</option>
             <option>FAILED</option>
             <option>REFUND</option>
        </select>
            </div>
            </div>
            
         <div class="col-sm-6 col-md-3">
        <div class="form-group">
      <label for="Source">Source:</label>
        <select style="width: 120px;height: 28px;" name="source" id="Source">
            <option>ALL</option>
            <option>WEB</option>
            <option>MOBILE</option>
        </select>
            </div>
            </div>
        
         <div class="col-sm-6 col-md-3">
        <div class="form-group">
        <button type="submit">Search</button>
     </div>
            </div>
        <br>
    
     <div class="col-sm-6 col-md-3">
        <div class="form-group">
   <button type="submit">Download</button>
       </div>
            </div>
   <br>
   
    <div class="col-sm-6 col-md-3">
        <div class="form-group">
       <label for="Entries">Top Entries:</label>
        <select style="width: 120px;height: 28px;" name="Entries" id="Entries">
            <option>10</option>
            <option>25</option>
            <option>50</option>
            <option>100</option>
        </select>
            </div>
            </div>
        
        
        </div>
    </form>
      </div>        
	   <%@ include file="footer.jsp" %>
    
    </div>
  
    </div>
</body>
</html>
