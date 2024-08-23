package com.cab.Controller;

import com.cab.Model.PaymentTransaction;
import com.cab.Service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-transactions")
public class PaymentTransactionController {

    @Autowired
    private PaymentTransactionService paymentTransactionService;

    @GetMapping
    public List<PaymentTransaction> getAllTransactions() {
        return paymentTransactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransaction> getTransactionById(@PathVariable(value = "id") Long transactionId) {
        Optional<PaymentTransaction> transaction = paymentTransactionService.getTransactionById(transactionId);
        if (transaction.isPresent()) {
            return ResponseEntity.ok().body(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PaymentTransaction createTransaction(@RequestBody PaymentTransaction transaction) {
        return paymentTransactionService.createTransaction(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentTransaction> updateTransaction(@PathVariable(value = "id") Long transactionId, @RequestBody PaymentTransaction transactionDetails) {
        PaymentTransaction updatedTransaction = paymentTransactionService.updateTransaction(transactionId, transactionDetails);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable(value = "id") Long transactionId) {
        paymentTransactionService.deleteTransaction(transactionId);
        return ResponseEntity.noContent().build();
    }
}

