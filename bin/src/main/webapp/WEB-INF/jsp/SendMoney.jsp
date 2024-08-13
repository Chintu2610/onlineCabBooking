<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SendMoney</title>

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
  </head>

<body>
	 <!-- Main Wrapper -->
	 <%@ include file="sidebar.jsp" %>
    <div class="main-wrapper">
        <%@ include file="header.jsp" %>
         <div class="page-wrapper">
         <section>
            <div class="content container-fluid">
                <div class="col-md-12">       
                    <div class="row">
                        <div class="col-md-5" style="  box-shadow: 0 0 8px rgba(0,0,0,0.5);padding-right:600px;">
                           
                                <div class="box-body" >
                                    <div class="nav-tabs-custom" style="cursor: move;height:300px;padding-right: 600px;width:400px; ">
           
                          
<div class="row">
		<div class="col-md-12" style="width: 400px;">
		 <label for="role" style="width: 400px;">Select Role:</label>			
		<select id="role" name="role" style="width: 400px;padding: 10px;">
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select>
							</div>
							</div>
							 <div id="body_viewplans" class="col-md-7">
                  <div id="body_updatepanel_rechrggrid">
	
                        <div class=" box  box-primary card">
                           <div class="box-body"   id="recent-trans"  style="box-shadow: 0 0 8px rgba(0,0,0,0.2); overflow: scroll;height: 530px;border-radius:10px;">
                              <div class="box-header with-border">
                                 <h3 class="box-title" style="color: #334D88; margin-top: 10px;font-size: 23px;font-weight:bold">Recent Transactons</h3>
                                  <img src="../Images/Capture1.png" style="float:right !important;width:10%;" >
                              </div>
                              
                           </div>
                        </div>
                     
</div>
               </div>
								</div>																
				</div>
                        </div></div>
                </div>
                </div>
                        </section>
  <%@ include file="footer.jsp" %>
            </div> 
    </div>

   
</body>
</html>
