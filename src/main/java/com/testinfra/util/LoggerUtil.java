package com.testinfra.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * This class contains various utilty functions for logging
 * @author Ayush Verma
 */
public class LoggerUtil {
	/**
	 * Give an object returns the json representation of the string
	 * @param Object
	 */
	public static String prettyPrintJson(final Object obj){
		Gson gsonObjToStr = new GsonBuilder().serializeSpecialFloatingPointValues().serializeNulls().create();
		Gson gsonUglyToPretty = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(gsonObjToStr.toJson(obj));
		String prettyJsonString = gsonUglyToPretty.toJson(je);
		System.out.println(prettyJsonString);
		return prettyJsonString;
	}
}
