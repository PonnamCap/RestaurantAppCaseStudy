package com.paymentservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//POJO class

@Document(collection="Payments")
public class PaymentDetails {
	
	//attributes
	    @Id  //primary key
	    private int orderId;
		private int amount;
	    private String paymentStatus;
	    private String txId;
	    
	    //parameterized constructor
		public PaymentDetails(int orderId, int amount, String paymentStatus, String txId) {
			this.orderId = orderId;
			this.amount = amount;
			this.paymentStatus = paymentStatus;
			this.txId = txId;
		}
		
		// getters and setters
		
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public String getTxId() {
			return txId;
		}
		public void setTxId(String txId) {
			this.txId = txId;
		}
		
		//toString
		
		@Override
		public String toString() {
			return "PaymentDetails [orderId=" + orderId + ", amount=" + amount + ", paymentStatus=" + paymentStatus
					+ ", txId=" + txId + "]";
		}
	    

}
