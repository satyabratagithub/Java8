package com.java8.supplier;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class OTPGeneration {

	public static void main(String[] args) {
		
		Supplier<String> otp= ()->{
			String randomNo = "";
			for (int i = 1; i <=4; i++) {
				randomNo = randomNo + (int)(Math.random()*10);
			}
			return randomNo;
		};

		System.out.println(otp.get());
		System.out.println(otp.get());
		System.out.println(otp.get());
		System.out.println(otp.get());
		UUID id = UUID.randomUUID();//fromString("satsya");
		System.out.println(id);
	
	}
	
	
}
