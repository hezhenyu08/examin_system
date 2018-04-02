package com.soa.controller;

import java.util.UUID;

public class Test {
	 public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			String string = UUID.randomUUID().toString();
			System.out.println(string);
		}
	}
}
