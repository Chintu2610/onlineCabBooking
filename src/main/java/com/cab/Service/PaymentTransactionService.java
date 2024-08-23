package com.cab.Service;



import com.cab.Model.PaymentTransaction;
import com.cab.Repositary.PaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTransactionService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    public List<PaymentTransaction> getAllTransactions() {
        return paymentTransactionRepository.findAll();
    }

    public Optional<PaymentTransaction> getTransactionById(Long transactionId) {
        return paymentTransactionRepository.findById(transactionId);
    }

    public PaymentTransaction createTransaction(PaymentTransaction transaction) {
        return paymentTransactionRepository.save(transaction);
    }

    public PaymentTransaction updateTransaction(Long transactionId, PaymentTransaction transactionDetails) {
        PaymentTransaction transaction = paymentTransactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + transactionId));

        transaction.setBookingId(transactionDetails.getBookingId());
        transaction.setAmountPaid(transactionDetails.getAmountPaid());
        transaction.setPaymentMethod(transactionDetails.getPaymentMethod());
        transaction.setPaymentDate(transactionDetails.getPaymentDate());
        transaction.setInvoiceNumber(transactionDetails.getInvoiceNumber());
        transaction.setCommission(transactionDetails.getCommission());
        transaction.setPayoutStatus(transactionDetails.getPayoutStatus());

        return paymentTransactionRepository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        paymentTransactionRepository.deleteById(transactionId);
    }
}

