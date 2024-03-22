
 
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PayZigo - Reward Wallet Ledger</title>

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
                       
             
                    <h3 class="page-title">Reward Wallet Ledger</h3>
						
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
            <div class="col-sm-6 col-md-3">
        <div class="form-group">
        <label for="">Transaction Type:</label>
        <select class="input" style="width: 120px;height: 28px;" name="" id="">
            <option>ALL</option>
            <option>Credit</option>
            <option>Debit</option>
            
        </select>  
         </div>
                </div> 									
    <div class="col-sm-6 col-md-3">
        <div class="form-group">
   <label for="">Product Type:</label>
        <select class="input" style="width: 120px;height: 28px;" name="" id="">
            <option>ALL</option>
            <option>PaymentLinks</option>
            <option>RewardsTopUp</option>
             <option>Promoter Activation</option>
            
        </select>
 </div>
                </div>

    <div class="col-sm-6 col-md-3">
        <div class="form-group">
<label>Ref.Id<span class="text-danger">*</span></label>
        <input name="" class="form-control" type="text">
         </div>
                </div>
        
            <div class="col-sm-6 col-md-3">
        <div class="form-group">
        <label>Points<span class="text-danger">*</span></label>
        <input name="" class="form-control" type="text">
        
 </div>
                </div>

   <br>
       <div class="col-sm-6 col-md-3">
        <div class="form-group">
       <label for="Entries">Top Transactions:</label>
        <select class="input" style="width: 120px;height: 28px;" name="Entries" id="Entries">
            <option>10</option>
            <option>25</option>
            <option>50</option>
            <option>100</option>
        </select>
         </div>
                </div>
        </div>
        
  <br><div class="col-sm-6 col-md-3">
        
        <button type="submit" class="btn btn-success centre">Search</button>
   <button type="submit" class="btn btn-success centre">Download</button>
    </div>
              
    </form>
      </div>        
    
    </div>
     <%@ include file="footer.jsp" %>
    </div>
    </div>
</body>
</html>
