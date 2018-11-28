package com.java8.supplier;

import java.util.function.Supplier;

//length should be 8 chars
//2,4,6,8 place only digit
//1,3,5,7 place alphabets and symbols
public class RandomPwdGenerator {

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyz!@#$";
		char[] ch =str.toCharArray();
		Supplier<String> generatePwd = ()->{
			String otp="";
			Supplier<String> generateRandomString=()->{
				String str1="";
				str1=String.valueOf(str.toUpperCase().charAt(((int)(Math.random()*30))));
				return str1;
			};
			Supplier<Integer> generateRandomNo=()->{
				 int x =0;
				x=x+(int)(Math.random()*10);
				return x;
			};
			
			for (int i = 1; i <=8; i++) {
				if(i%2!=0) {
					otp = otp +generateRandomString.get();
					//otp = otp + str.toUpperCase().charAt(((int)(Math.random()*10)));
				}else{
					otp = otp+generateRandomNo.get();
				}
				
			}
			return otp;
		};
		
		System.out.println(generatePwd.get());

	}

}
