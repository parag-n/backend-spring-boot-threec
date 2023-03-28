package com.threec.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TCUtil {
	
	public static String mySaltGenerator() {
		int left=48;
		int right=122;
		int targetLength=10;
		Random rand=new Random();
		
		String salt=rand.ints(left, right+1)
				.filter(i -> (i<=57 || i>=65)&&(i<=90 || i>=97))
				.limit(targetLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		return salt;
	}

}
