package all;

import gui.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		Player.isFirstLaunch();
		
		if (Player.firstLaunch) {
			Misc.registerFonts(true);
			MainWindow mWindow = new MainWindow();
		} else {
			Player.init();
			MainWindow mWindow = new MainWindow();
		}
	}

}
