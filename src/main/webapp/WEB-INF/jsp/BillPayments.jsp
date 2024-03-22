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
        
        /* Hide form containers by default */
        .form-container {
            display: none;
        }
    </style>
    
    <script>
    function showForm(plan) {

        var prepaidForm = document.getElementById('prepaidForm');
        var postpaidForm = document.getElementById('postpaidForm');
        var dthForm = document.getElementById('dthForm');

        if (plan === 'prepaid') {
            prepaidForm.style.display = 'block';
            postpaidForm.style.display = 'none';
            dthForm.style.display = 'none';
        } else if (plan === 'postpaid') {
            prepaidForm.style.display = 'none';
            postpaidForm.style.display = 'block';
            dthForm.style.display = 'none';
        } else if (plan === 'dth') {
            prepaidForm.style.display = 'none';
            postpaidForm.style.display = 'block'; // Show postpaid form
            dthForm.style.display = 'none';
        }
    }

    </script>
</head>

<body>
	 <!-- Main Wrapper -->
	 <%@ include file="sidebar.jsp" %>
    <div class="main-wrapper">
        <%@ include file="header.jsp" %>
         <div class="page-wrapper">
         <section>
            <div class="content container-fluid">
                <div class="col-md-12" style="width: 1000px;">       
                    <div class="row" style="height: 400px;">
                        <div class="col-md-5" style="  box-shadow: 0 0 8px rgba(0,0,0,0.5);width: 500px;height:500px;">
                            <div class=" box box-primary card">
                                <div class="box-body">
          <div class="nav-tabs-custom">
                                      
		<div class="col-md-12">
		 <label for="role">Select Role:</label>			
		<select id="role" name="role">
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select>
							
                                    </div>
            </div>
                            </div>
                        </div>
                             </div>                
                <div class="col-md-5" style="  box-shadow: 0 0 8px rgba(0,0,0,0.5);margin-left: 10px;width: 500px;">   
                       <div class=" box box-primary card">
                                <div class="box-body">
                                      <div class="nav-tabs-custom">
                                      	<div class="col-md-12">
                                            <h3 class="box-title">Recent Transactons</h3>
                                        </div>
                                           
                                    </div>
                                </div>
                                                  
                            </div>
                       
                        </div>
                        
                    </div>
                </div>
            </div> 
          
        </section>
         <%@ include file="footer.jsp" %>
    </div>
    
</div>
   
</body>
</html>
