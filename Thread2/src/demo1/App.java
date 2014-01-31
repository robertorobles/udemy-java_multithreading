package demo1;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {

		while (running) {
			System.out.println("Running");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.start();

		// Wait for the enter key
		new Scanner(System.in).nextLine();

		pro.shutdown();
	}

}