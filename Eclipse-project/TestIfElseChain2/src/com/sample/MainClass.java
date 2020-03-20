package com.sample;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
	public static void main(String[] args) {
		String request = "request";
		String response = "response";

		Map<String, IMethod> mappingMethod = new HashMap<String, IMethod>();
		mappingMethod.put("key1", new DoSomething1());
		mappingMethod.put("key2", new DoSomething2());
		mappingMethod.put("key3", new DoSomething3());

		String URI = "key3";
		IMethod method = mappingMethod.get(URI);
		if (method != null) {
			method.execute(request, response);
		}
	}// end of main mathod
}