package com.sample;

import static java.lang.System.out;

public class DoSomething2 implements IMethod {
	@Override
	public void execute(String request, String response) {
		out.println("method 2");
		out.println("#2 execute user logout");
	}
}