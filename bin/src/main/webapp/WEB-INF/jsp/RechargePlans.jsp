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
                    <div class="row">
                        <div class="col-md-5" style="  box-shadow: 0 0 8px rgba(0,0,0,0.5);">
                            <div class=" box box-primary card">
                                <div class="box-body">
                                    <div class="nav-tabs-custom" style="cursor: move;height:600px;">
                                        <!-- Tabs within a box -->
                                        <ul class="nav nav-tabs pull-left ui-sortable-hanabs" id="myTabs">
                                            <li><a id="body_tab_Mobile" aria-expanded="true" href="javascript:__doPostBack(&#39;ctl00$body$tab_Mobile&#39;,&#39;&#39;)"><img src="/assets/Recharges.png" /><b>Mobile</b></a></li>
                                           <!-- DTH Tab -->
<li><a id="body_tab_DTH" aria-expanded="false" href="javascript:__doPostBack(&#39;ctl00$body$tab_DTH&#39;,&#39;&#39;)" onclick="showForm('dth')"><img style="height:20px;" src="/assets/broadband.png" />&nbsp;&nbsp;<b>DTH</b></a></li>
   </ul>
                                        <input type="hidden" name="ctl00$body$hdnselectedtab" id="body_hdnselectedtab" value="Mobile" />
                                        <label>
                                            <input type="radio" name="plan" value="prepaid" onclick="showForm('prepaid')"> Prepaid
                                        </label>
                                        <label>
                                            <input type="radio" name="plan" value="postpaid" onclick="showForm('postpaid')"> Postpaid
                                        </label>

                                        <div id="prepaidForm" class="form-container" >
                                           <label for="mobile">Customer's Mobile:</label>
											    <input type="text" id="mobile" name="mobile" placeholder="Enter mobile number"><br><br>
											    
											    <label for="selectPlan">Select Plan:</label>
											    <select id="selectPlan" name="selectPlan">
											        <option value="plan1"> 1</option>
											        <option value="plan2"> 2</option>
											        <option value="plan3"> 3</option>
											    </select><br><br>
											    
											    <label for="amount">Amount:</label>
											    <input type="number" id="amount" name="amount" placeholder="Enter amount"><br><br>
											    
											    <button class="btn btn-success centre" type="submit">Submit</button>
                                        </div>

                                        <div id="postpaidForm" class="form-container">
                                            <label for="mobile">Customer's Mobile:</label>
											    <input type="text" id="mobile" name="mobile" placeholder="Enter mobile number"><br><br>
											    
											    <label for="selectPlan">Select Plan:</label>
											    <select id="selectPlan" name="selectPlan">
											        <option value="plan1">Option 1</option>
											        <option value="plan2">Option 2</option>
											        <option value="plan3">Option 3</option>
											    </select><br><br>
											    
											    <label for="amount">Amount:</label>
											    <input type="number" id="amount" name="amount" placeholder="Enter amount"><br><br>
											    
											    <button class="btn btn-success centre" type="submit">Submit</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

<div id="dthForm" class="form-container">
    <form id="dthForm" action="submit_dth_form.php" method="post">
        <label for="selectPackage">Select Package:</label>
        <select id="selectPackage" name="selectPackage">
            <option value="package1">Package 1</option>
            <option value="package2">Package 2</option>
            <option value="package3">Package 3</option>
            <option value="package 4">nazma</option>
        </select><br><br>
        
        <label for="customerMobile">Customer's Mobile:</label>
        <input type="text" id="customerMobile" name="customerMobile" placeholder="Enter mobile number"><br><br>
        
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" placeholder="Enter amount"><br><br>
        
        <button class="btn btn-success centre" type="submit">Submit</button>
    </form>
</div>
                                            
                                            
                        <div id="body_viewplans" class="col-md-7" style="display:block;">
                            <div id="body_updatepanel_rechrggrid">
	
                                <div class=" box  box-primary card">
                                    <div class="box-body"  id="recent-trans"  style="box-shadow: 0 0 8px rgba(0,0,0,0.5); overflow: scroll;height: 565px;">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">Recent Transactons</h3>
                                        </div>
                                        <div id="dvCustomers">
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
