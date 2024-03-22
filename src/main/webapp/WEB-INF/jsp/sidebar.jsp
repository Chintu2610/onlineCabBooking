<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    aside {
        width: 230px;
        background-color: #2c3e50;
        margin-top: 50px;
        padding: 20px;
        height: 100vh;
        position: fixed;
        box-sizing: border-box; /* Include padding and borders in the total height */
    }

    .sublist {
        display: none;
        margin-left: 10px;
    }

    .sublist li {
        list-style-type: none;
        margin-bottom: 5px;
    }

    .toggle {
        cursor: pointer;
        text-decoration: underline;
        color: #000;
    }
</style>
</head>
<body>
<aside>
    <ul class="list-group">
        
        <li class="list-group-item"><a href="dashboard">Dashboard</a></li>
        <li class="list-group-item toggle" onclick="toggleSublist('sublist-activation')">Transfers</li>
        <ul class="sublist" id="sublist-activation">
            <li class="list-group-item"><a href="SendMoney">Payouts</a></li>            
        </ul>
        <li class="list-group-item toggle" onclick="toggleSublist('sublist-activation')">Bill Payments</li>
        <ul class="sublist" id="sublist-activation">
            <li class="list-group-item"><a href="RechargePlans">Recharges</a></li>
            <li class="list-group-item"><a href="BillPayments">BBPS</a></li>
            <li class="list-group-item"><a href="CreditcardPayment">credit card payments</a></li>
        </ul>
        <a href="WalletTopUp"><li class="list-group-item">Wallet TopUp</li></a>
        <li class="list-group-item toggle" onclick="toggleSublist('sublist-activation')">Activation</li>
        <ul class="sublist" id="sublist-activation">
            <li class="list-group-item"><a href="PromotionActivation">Promotion Activation</a></li>
            <li class="list-group-item"><a href="FranchiseActivation">Franchise Activation</a></li>
        </ul>
        <a href="Enquiry"><li class="list-group-item">Enquiry</li></a>
        <li class="list-group-item toggle" onclick="toggleSublist('sublist-activation')">Reports</li>
         <ul class="sublist" id="sublist-activation">
 
             <li class="list-group-item"><a href="walletledger">Ledger</a></li>
             <li class="list-group-item"><a href="cashoutledger">CashOut Ledger</a></li>
             <li class="list-group-item"><a href="rewardwalletledger">Rewards Ledger</a></li>
             <li class="list-group-item"><a href="transactionlist">Payout List</a></li>
             <li class="list-group-item"><a href="paymentlinkdeposit"> Payment link Deposit </a></li>
             <li class="list-group-item"><a href="creditcardpayments"> Credit card Payments</a></li>
             <li class="list-group-item"><a href="paymentgateway">Payment Gateway</a></li>
             <li class="list-group-item"><a href="billpaymentpg">Bill Payment PG Report</a></li>
             <li class="list-group-item"><a href="billpaymentreport"> Bill Payment Report</a></li>
             <li class="list-group-item"><a href="customerbillpayments">Customer Bill Payments B2C</a></li>
             <li class="list-group-item"><a href="activationreport"> Activation Report</a></li>
             <li class="list-group-item"><a href="settlementreport">Settlement Report</a></li>
            <li class="list-group-item"><a href="loginlogsreport"> Login Logs Report</a></li>
          
        </ul>
    
    </ul>
</aside>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function() {
        // Add click event to toggle sublist
        $('.toggle').click(function() {
            $(this).next('.sublist').slideToggle();
        });

        // Prevent sublist items from closing the sublist
        $('.sublist li').click(function(event) {
            event.stopPropagation();
        });
    });
</script>

</body>
</html>