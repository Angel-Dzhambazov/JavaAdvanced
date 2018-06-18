package seeburger.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Tests {


	public static void main(String[] args) throws IOException {
		 int[] x = {1};

		Runnable task = () -> {
			for (int i = 0; i < 100; i++) {
				x[0]++;

			}
			System.out.println(x[0]);
		};

		Thread moqtaNishka = new Thread(task);
		moqtaNishka.setDaemon(false);
		moqtaNishka.start();




		Map<String, String> testMap = new HashMap<>();
		testMap.put("Pesho", "Slab 2");
		testMap.put("Pesho", "prezapisvash li e?");
		for (Map.Entry<String, String> stringStringEntry : testMap.entrySet()) {
			System.out.println(stringStringEntry.getKey());
			System.out.println(stringStringEntry.getValue());
		}

		String xxxxxxx = "b";
		String xxxx = "c";

		System.out.println(xxxx.compareTo(xxxxxxx));

	}


}











