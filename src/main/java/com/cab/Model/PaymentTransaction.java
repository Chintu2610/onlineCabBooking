package com.cab.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PaymentTransactions")
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private Long bookingId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amountPaid;

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false, unique = true, length = 100)
    private String invoiceNumber;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal commission;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private PayoutStatus payoutStatus;

    public enum PayoutStatus {
        PROCESSED, PENDING
    }

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public PayoutStatus getPayoutStatus() {
		return payoutStatus;
	}

	public void setPayoutStatus(PayoutStatus payoutStatus) {
		this.payoutStatus = payoutStatus;
	}


}

