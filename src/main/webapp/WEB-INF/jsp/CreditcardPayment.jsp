<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PayZigo - Your Digital Financial Companion</title>

<!-- Bootstrap CSS CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
	<%@ include file="sidebar.jsp"%>
	<div class="main-wrapper">
		<%@ include file="header.jsp"%>
		<div class="page-wrapper">
		  <div class="content container-fluid">
                 <div class="white-smoke-background">
			  <section>
              
                    <div class="col-md-12">
                        <div class="row" style="margin-left: 30px;">
                            <h1>Credit card</h1>
       <form action="" method="post" class="form-container">
        <div class="row">
        <div class="col-md-6 col-sm-12">
                <div class="form-group">
    <label for="productType">Product type<span class="text-danger">*</span></label>
    <select id="productType" name="productType" class="form-control">
        <option value="1">Option 1</option>
        <option value="2">Option 2</option>
        <option value="3">Option 3</option>
        <!-- Add more options as needed -->
    </select>
</div>

            </div>
            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>Name <span class="text-danger">*</span></label>
                    <input required name="username" class="form-control" type="text">
                </div>
            </div>

            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>Mobile<span class="text-danger">*</span></label>
                    <input required name="firstname" class="form-control" type="text">
                </div>
            </div>
           <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>Card number<span class="text-danger">*</span></label>
                    <input required name="lastname" class="form-control" type="text">
                </div>
            </div>
           <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label>Amount<span class="text-danger">*</span></label>
                    <input required name="lastname" class="form-control" type="text">
                </div>
            </div>
             
             <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <label for="productType">Network<span class="text-danger">*</span></label>
    <select id="productType" name="productType" class="form-control">
        <option value="1">Option 1</option>
        <option value="2">Option 2</option>
        <option value="3">Option 3</option>
        <!-- Add more options as needed -->
    </select>
                </div>
            </div>
             
            
            </div><br><br>
              <button class="btn btn-success centre" type="submit">Submit</button>
            </form>
                        </div>
                    </div>
                </div>
            </section>
            </div>
		</div>


		
	</div>


</body>
</html>