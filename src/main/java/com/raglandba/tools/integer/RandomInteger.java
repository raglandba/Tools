/*
 * Copyright (C) Brandon Alexander Ragland - All Rights Reserved
 * Unauthorized viewing of this file, via any medium is strictly prohibited
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Unauthorized editing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Brandon Alexander Ragland <host@raglandba.com>
 */
package com.raglandba.tools.integer;

/**
 *
 * @author Brandon Alexander Ragland
 */
public class RandomInteger{

	public static int betweenRange(int min, int max){
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}
	
	public static int randomPositive(){
		return betweenRange(0, Integer.MAX_VALUE);
	}
	
	public static int randomNegative(){
		return betweenRange(Integer.MIN_VALUE, 0);
	}
	
	public static int random(){
		return betweenRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
