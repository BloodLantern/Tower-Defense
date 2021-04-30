package all;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public final class Misc {
	
	public static Font fontBlocks = new Font("Blocks", Font.PLAIN, 30);
	public static Font fontFuture = new Font("Future", Font.PLAIN, 30);
	public static Font fontFutureNarrow = new Font("Future Narrow", Font.PLAIN, 30);
	
	/**
	 * This method registers all text fonts that will be used in this game.
	 * It is called upon the game starts.
	 */
	public static boolean registerFonts(boolean operationSuccess) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font customFont = null;
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets\\Tower Defense\\textures\\fonts\\Blocks.ttf")).deriveFont(12f);
			ge.registerFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
			operationSuccess = false;
		} catch(FontFormatException e) {
			e.printStackTrace();
			operationSuccess = false;
		}
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets\\Tower Defense\\textures\\fonts\\Future Narrow.ttf")).deriveFont(12f);
			ge.registerFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
			operationSuccess = false;
		} catch(FontFormatException e) {
			e.printStackTrace();
			operationSuccess = false;
		}
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets\\Tower Defense\\textures\\fonts\\Future.ttf")).deriveFont(12f);
			ge.registerFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
			operationSuccess = false;
		} catch(FontFormatException e) {
			e.printStackTrace();
			operationSuccess = false;
		}
		
		return operationSuccess;
	}

	// Integer to Roman numbers converter. Works until the input number reaches 4000

	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

	static {

		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

	}
	
	/**
	 * Converts input Integer into Roman number
	 */
	public final String toRoman(int number) {
		int l = map.floorKey(number);
		if (number == l) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number - l);
	}

}
