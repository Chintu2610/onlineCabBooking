package com.cab.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewController {
	
	
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String viewDashboardPage(ModelMap map) {
    	
        return "dashboard";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistrationPage(ModelMap map) {
        return "registration";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLoginPage(ModelMap map) {
        return "login";
    }
//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  public ModelAndView viewLoginPage(ModelMap map) {
//  	ModelAndView mv=new ModelAndView();
//  	mv.setViewName("login");
//      return mv;
//  }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String viewLogoutPage(ModelMap map) {
        return "logout";
    }
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public String viewForgotPassword(ModelMap map) {
        return "forgot-password";
    }
    @RequestMapping(value = "/EnterOtp", method = RequestMethod.GET)
    public String viewEnterOtp(ModelMap map) {
        return "EnterOtp";
    }

    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public String viewHeader(ModelMap map) {
        return "header";
    }

    @RequestMapping(value = "/resetpass", method = RequestMethod.GET)
    public String viewResetPassword(ModelMap map) {
        return "reset_password";
    }

    @RequestMapping(value = "/SendMoney", method = RequestMethod.GET)
    public String viewSendMoney(ModelMap map) {
        return "SendMoney";
    }

    @RequestMapping(value = "/RechargePlans", method = RequestMethod.GET)
    public String viewRechargePlans(ModelMap map) {
        return "RechargePlans";
    }

    @RequestMapping(value = "/loginlogsreport", method = RequestMethod.GET)
    public String viewLoginLogsReportPage(ModelMap map) {
        return "loginlogsreport";
    }

    @RequestMapping(value = "/settlementreport", method = RequestMethod.GET)
    public String viewSettlementReportPage(ModelMap map) {
        return "settlementreport";
    }

    @RequestMapping(value = "/activationreport", method = RequestMethod.GET)
    public String viewActivationReportPage(ModelMap map) {
        return "activationreport";
    }

    @RequestMapping(value = "/customerbillpayments", method = RequestMethod.GET)
    public String viewCustomerBillPaymentsPage(ModelMap map) {
        return "customerbillpayments";
    }

    @RequestMapping(value = "/billpaymentreport", method = RequestMethod.GET)
    public String viewBillPaymentReportPage(ModelMap map) {
        return "billpaymentreport";
    }

    @RequestMapping(value = "/billpaymentpg", method = RequestMethod.GET)
    public String viewBillPaymentPgPage(ModelMap map) {
        return "billpaymentpg";
    }

    @RequestMapping(value = "/paymentgateway", method = RequestMethod.GET)
    public String viewPaymentGatewayPage(ModelMap map) {
        return "paymentgateway";
    }

    @RequestMapping(value = "/creditcardpayments", method = RequestMethod.GET)
    public String viewCreditCardPaymentsPage(ModelMap map) {
        return "creditcardpayments";
    }

    @RequestMapping(value = "/paymentlinkdeposit", method = RequestMethod.GET)
    public String viewPaymentLinkDepositPage(ModelMap map) {
        return "paymentlinkdeposit";
    }

    @RequestMapping(value = "/transactionlist", method = RequestMethod.GET)
    public String viewTransactionListPage(ModelMap map) {
        return "transactionlist";
    }

    @RequestMapping(value = "/rewardwalletledger", method = RequestMethod.GET)
    public String viewRewardWalletLedgerPage(ModelMap map) {
        return "rewardwalletledger";
    }

    @RequestMapping(value = "/cashoutledger", method = RequestMethod.GET)
    public String viewCashOutLedgerPage(ModelMap map) {
        return "cashoutledger";
    }

    @RequestMapping(value = "/walletledger", method = RequestMethod.GET)
    public String viewWalletLedgerPage(ModelMap map) {
        return "walletledger";
    }

    @RequestMapping(value = "/BillPayments", method = RequestMethod.GET)
    public String viewBillPayments(ModelMap map) {
        return "BillPayments";
    }

    @RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
    public String viewChangePassword(ModelMap map) {
        return "ChangePassword";
    }

    @RequestMapping(value = "/CreditcardPayment", method = RequestMethod.GET)
    public String viewCreditCardPayment(ModelMap map) {
        return "CreditcardPayment";
    }

    @RequestMapping(value = "/WalletTopUp", method = RequestMethod.GET)
    public String viewWalletTopUp(ModelMap map) {
        return "WalletTopUp";
    }

    @RequestMapping(value = "/PromotionActivation", method = RequestMethod.GET)
    public String viewPromotionActivation(ModelMap map) {
        return "PromotionActivation";
    }

    @RequestMapping(value = "/FranchiseActivation", method = RequestMethod.GET)
    public String viewFranchiseActivation(ModelMap map) {
        return "FranchiseActivation";
    }

    @RequestMapping(value = "/Enquiry", method = RequestMethod.GET)
    public String viewEnquiry(ModelMap map) {
        return "Enquiry";
    }
    @RequestMapping(value = "/EnquiryForm", method = RequestMethod.GET)
    public String AddEnquiry(ModelMap map) {
        return "EnquiryForm";
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewProfile(ModelMap map) {    	
        return "profile";
    }
    
    
}