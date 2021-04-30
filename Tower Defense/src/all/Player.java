package all;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import gui.MainWindow;

public abstract class Player {
	
	private static int balance; //Balance in the main menu
	private static int killCount;
	private static String username;
	private static long currentMoney; // Balance in-game
	private static File file = new File("variables.properties");
	public static boolean firstLaunch = false;
	
	public static void init() {
		
		boolean operationSuccess = true;
		FileWriter writer = null;
		operationSuccess = isFirstLaunch();
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			operationSuccess = false;
		}
		
		// If it isn't the first game launch then read properties file
		if (!firstLaunch) {
			// Reading file
			String[] current = new String[2];
			while (sc.hasNextLine()) {
				
				current = sc.nextLine().split(":");
				
				if (current[0].equalsIgnoreCase("balance")) {
					Player.setBalance(Integer.parseInt(current[1]));
				}
				if (current[0].equalsIgnoreCase("killCount")) {
					Player.setKillCount(Integer.parseInt(current[1]));
				}
				if (current[0].equalsIgnoreCase("username")) {
					Player.setUsername(current[1]);
				}
			
			}
			
		} else /* Else statement writes default properties values */ {
			
			try {
				
				writer = new FileWriter(file);
				writer.write("balance:0\nkillCount:0\nusername:" + MainWindow.getUsername());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				operationSuccess = false;
			} catch (IOException e) {
				e.printStackTrace();
				operationSuccess = false;
			} finally {
				
				try {
					if (writer != null)
						writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					operationSuccess = false;
				}
				
			}
			
		}
		
		operationSuccess = Misc.registerFonts(operationSuccess);
		
		if (MainWindow.getUsername() == "")
			operationSuccess = false;
		
		sc.close();
		
		if (operationSuccess) {
			System.out.println("Player init success ?\t" + operationSuccess);
		} else {
			System.err.println("Player init success ?\t" + operationSuccess);
		}
		
	}
	
	public static boolean isFirstLaunch() {
		boolean success = true;
		try {
			if (!file.exists()) {
				file.createNewFile();
				firstLaunch = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public static int getBalance() {
		return balance;
	}

	public static int getKillCount() {
		return killCount;
	}

	public static String getUsername() {
		return username;
	}

	public static long getCurrentMoney() {
		return currentMoney;
	}

	public static void setBalance(int balance) {
		Player.balance = balance;
	}

	public static void setKillCount(int killCount) {
		Player.killCount = killCount;
	}

	public static void setUsername(String username) {
		Player.username = username;
	}

	public static void setCurrentMoney(long currentMoney) {
		Player.currentMoney = currentMoney;
	}

}
