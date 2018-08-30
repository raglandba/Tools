/*
 * Copyright (C) Brandon Alexander Ragland - All Rights Reserved
 * Unauthorized viewing of this file, via any medium is strictly prohibited
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Unauthorized editing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Brandon Alexander Ragland <host@raglandba.com>
 */
package com.raglandba.tools.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Brandon Alexander Ragland
 */
public class ReflectionFieldTools{
	
	/**
	 * Get a list of fields from the supplied object.
	 * @param object The object to list fields from.
	 * @return An ArrayList of fields.
	 */
	public static List<Field> getFields(Object object){
		return getFields(object.getClass());
	}
	
	/**
	 * Get a list of fields from the supplied class type. Returned fields will not have runtime values!
	 * @param clazz The class type to list fields from.
	 * @return An ArrayList of fields.
	 */
	public static List<Field> getFields(Class clazz){
		List<Field> fields = new ArrayList<>();
		while(clazz != Object.class){
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		return fields;
	}
}
