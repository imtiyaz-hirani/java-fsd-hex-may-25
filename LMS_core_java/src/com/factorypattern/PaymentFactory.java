package com.factorypattern;

public class PaymentFactory {

	public static Payment getInstance(PaymentType paymentType){
		
		switch(paymentType) {
		
			case PaymentType.UPI:
				return new UPI();
				 
			case PaymentType.NEFT:
				return new NEFT();
				
			case PaymentType.IMPS:
				return new IMPS();
			 
			default:
				return null;
			
			
		}
	}
}
