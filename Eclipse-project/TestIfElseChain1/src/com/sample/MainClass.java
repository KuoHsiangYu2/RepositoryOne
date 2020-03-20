package com.sample;

public class MainClass {
	public static void main(String[] args) {
		String request = "request";
		String response = "response";

		IMethod[] methodArray = new IMethod[] { new DoSomething1(), new DoSomething2(), new DoSomething3() };
		String[] mappingKey = new String[] { "key1", "key2", "key3" };

		String URI = "key3";
		for (int i = 0; i < mappingKey.length; i++) {
			if (mappingKey[i].equals(URI)) {
				IMethod method = methodArray[i];
				method.execute(request, response);
				break;
			}
		}
	}// end of main mathod
}