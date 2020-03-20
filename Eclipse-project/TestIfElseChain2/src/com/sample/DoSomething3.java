package com.sample;

import static java.lang.System.out;

public class DoSomething3 implements IMethod {
	@Override
	public void execute(String request, String response) {
		out.println("method 3");
		out.println("#3 save data in Microsoft SQL Server Database");
	}
}