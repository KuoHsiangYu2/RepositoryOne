package com.sample;

import static java.lang.System.out;

public class DoSomething1 implements IMethod {
	@Override
	public void execute(String request, String response) {
		out.println("method 1");
		out.println("#1 execute user login");
	}
}