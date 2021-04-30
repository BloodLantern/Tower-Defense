package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class DisplayMap extends JPanel {
	
	private int selectedMap = 1;
	private int mapCount = 2;
	private int mapSize = 10;
	private Tile tile;
	/**
	 * Used to place tile's textures on the
	 * map. This map is divided
	 * in tiles, one per array's place.
	 */
	private Tile[][] tileArray = new Tile[mapSize][mapSize];
	
	/**
	 * Same as tileArray[][] but rendered
	 * after. It is then used for foreground
	 * textures
	 */
	private Image[][] foreImgArray1 = new Image[mapSize][mapSize];
	/**
	 * Same as foreImgArray1[][] but rendered
	 * after.
	 */
	private Image[][] foreImgArray2 = new Image[mapSize][mapSize];
	/**
	 * Same as foreImgArray2[][] but rendered
	 * after.
	 */
	private Image[][] foreImgArray3 = new Image[mapSize][mapSize];
	/**
	 * Same as foreImgArray3[][] but rendered
	 * after.
	 */
	private Image[][] foreImgArray4 = new Image[mapSize][mapSize];
	
	public DisplayMap(int map) {
		
		// Displays correct map in terms of map's integer
		if (map >= 1 && map <= mapCount) {
			
			System.out.println("Selecting map " + map);
			this.selectedMap = map;
			
			switch (selectedMap) {
			
			case 1:
				
				this.mapSize = 10;
				
				/**
				 * Map 1:
				 * 
				 * 0  1  0  0  0  0  0  0  0  0
				 * 0  2  0  6  7  8  9  10 11 0
				 * 0  3  4  5  0  0  0  0  12 0
				 * 0  0  0  18 17 16 15 14 13 0
				 * 0  25 26 19 28 29 0  0  0  0
				 * 0  24 0  20 0  30 0  0  0  0
				 * 0  23 22 21 0  31 32 33 34 35
				 * 0  0  0  0  0  0  0  0  0  36
				 * 0  45 44 43 42 41 40 39 38 37
				 * 0  46 0  0  0  0  0  0  0  0
				 * 
				 * 
				 * 19 is 27 as well
				 */
				
				// Drawing grass everywhere
				tile = new Tile("grass\\grass1", false, 0);
				for (int y = 0; y <= 9; y++) {
					for (int x = 0; x <= 9; x++) {
						tileArray[x][y] = tile;
					}
				}
				
				// Drawing dirt path - BACKGROUND
				tile = new Tile("dirt\\dirt1", false, 1);
				
				// 1-3
				for (int i = 0; i <= 2; i++) {
					tile.setNumber(i + 1);
					tileArray[1][i] = tile;
				}
				
				// 4-5
				for (int i = 2; i <= 3; i++) {
					tile.setNumber(i + 2);
					tileArray[i][2] = tile;
				}
				
				// 6-11
				for (int i = 3; i <= 8; i++) {
					tile.setNumber(i + 3);
					tileArray[i][1] = tile;
				}
				
				// 12
				tile.setNumber(12);
				tileArray[8][2] = tile;
				
				// 13-18
				for (int i = 8; i >= 3; i--) {
					switch (i) {
					case 8:
						tile.setNumber(13);
					break;
					case 7:
						tile.setNumber(14);
					break;
					case 6:
						tile.setNumber(15);
					break;
					case 5:
						tile.setNumber(16);
					break;
					case 4:
						tile.setNumber(17);
					break;
					case 3:
						tile.setNumber(18);
					break;
					}
					tileArray[i][3] = tile;
				}
				
				// 19-21
				for (int i = 4; i <= 6; i++) {
					tile.setNumber(i + 15);
					if (i == 4) {
						tile.setSecondNumber(27);
					} else {
						tile.setSecondNumber(-1);
					}
					tileArray[3][i] = tile;
				}
				
				// 22
				tile.setNumber(22);
				tileArray[2][6] = tile;
				
				
				// 23-25
				for (int i = 4; i <= 6; i++) {
					tile.setNumber(i + 19);
					tileArray[1][i] = tile;
				}
				
				// 26-29
				for (int i = 2; i <= 5; i++) {
					tile.setNumber(i + 24);
					tileArray[i][4] = tile;
				}
				
				// 30
				tile.setNumber(30);
				tileArray[5][5] = tile;
				
				// 31-35
				for (int i = 5; i <= 9; i++) {
					tile.setNumber(i + 26);
					tileArray[i][6] = tile;
				}
				
				// 36
				tile.setNumber(36);
				tileArray[9][7] = tile;
				
				// 37-45
				for (int i = 9; i >= 1; i--) {
					switch (i) {
					case 9:
						tile.setNumber(37);
					break;
					case 8:
						tile.setNumber(38);
					break;
					case 7:
						tile.setNumber(39);
					break;
					case 6:
						tile.setNumber(40);
					break;
					case 5:
						tile.setNumber(41);
					break;
					case 4:
						tile.setNumber(42);
					break;
					case 3:
						tile.setNumber(43);
					break;
					case 2:
						tile.setNumber(44);
					break;
					case 1:
						tile.setNumber(45);
					break;
					}
					tileArray[i][8] = tile;
				}
				
				// 46
				tile.setNumber(46);
				tileArray[1][9] = tile;
				
				// Assigning posX and posY for all tileArray's tiles
				
				for (int y = 0; y <= 9; y++) {
					for (int x = 0; x <= 9; x++) {
						tileArray[x][y].setPosX(x*64);
						tileArray[x][y].setPosY(y*64);
					}
				}
				
				
				// Drawing grass path border - FOREGROUND
				
				// 1-2
				for (int i = 0; i <= 2; i++) {
					tile = new Tile("grass\\pathSide2", false, 0);
					foreImgArray1[1][i] = tile.getTexture();
					tile = new Tile("grass\\pathSide4", false, 0);
					foreImgArray2[1][i] = tile.getTexture();
				}
				
				// 3
				tile = new Tile("grass\\pathOuterCorner2", false, 0);
				foreImgArray1[1][2] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner2", false, 0);
				foreImgArray2[1][2] = tile.getTexture();
				
				// 4
				tile = new Tile("grass\\pathSide1", false, 0);
				foreImgArray1[2][2] = tile.getTexture();
				tile = new Tile("grass\\pathSide3", false, 0);
				foreImgArray2[2][2] = tile.getTexture();
				
				// 5
				tile = new Tile("grass\\pathOuterCorner3", false, 0);
				foreImgArray1[3][2] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner3", false, 0);
				foreImgArray2[3][2] = tile.getTexture();
				
				// 6
				tile = new Tile("grass\\pathOuterCorner1", false, 0);
				foreImgArray1[3][1] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner1", false, 0);
				foreImgArray2[3][1] = tile.getTexture();
				
				// 7-10
				for (int i = 4; i <= 7; i++) {
					tile = new Tile("grass\\pathSide1", false, 0);
					foreImgArray1[i][1] = tile.getTexture();
					tile = new Tile("grass\\pathSide3", false, 0);
					foreImgArray2[i][1] = tile.getTexture();
				}
				
				// 11
				tile = new Tile("grass\\pathOuterCorner4", false, 0);
				foreImgArray1[8][1] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner4", false, 0);
				foreImgArray2[8][1] = tile.getTexture();
				
				// 12
				tile = new Tile("grass\\pathSide2", false, 0);
				foreImgArray1[8][2] = tile.getTexture();
				tile = new Tile("grass\\pathSide4", false, 0);
				foreImgArray2[8][2] = tile.getTexture();
				
				// 13
				tile = new Tile("grass\\pathOuterCorner3", false, 0);
				foreImgArray1[8][3] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner3", false, 0);
				foreImgArray2[8][3] = tile.getTexture();
				
				// 14-17
				for (int i = 7; i >= 4; i--) {
					tile = new Tile("grass\\pathSide1", false, 0);
					foreImgArray1[i][3] = tile.getTexture();
					tile = new Tile("grass\\pathSide3", false, 0);
					foreImgArray2[i][3] = tile.getTexture();
				}
				
				// 18
				tile = new Tile("grass\\pathOuterCorner1", false, 0);
				foreImgArray1[3][3] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner1", false, 0);
				foreImgArray2[3][3] = tile.getTexture();
				
				// 19/27
				tile = new Tile("grass\\pathOuterCorner1", false, 0);
				foreImgArray1[3][4] = tile.getTexture();
				tile = new Tile("grass\\pathOuterCorner2", false, 0);
				foreImgArray2[3][4] = tile.getTexture();
				tile = new Tile("grass\\pathOuterCorner3", false, 0);
				foreImgArray3[3][4] = tile.getTexture();
				tile = new Tile("grass\\pathOuterCorner4", false, 0);
				foreImgArray4[3][4] = tile.getTexture();
				
				// 20
				tile = new Tile("grass\\pathSide2", false, 0);
				foreImgArray1[3][5] = tile.getTexture();
				tile = new Tile("grass\\pathSide4", false, 0);
				foreImgArray2[3][5] = tile.getTexture();
				
				// 21
				tile = new Tile("grass\\pathOuterCorner3", false, 0);
				foreImgArray1[3][6] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner3", false, 0);
				foreImgArray2[3][6] = tile.getTexture();
				
				// 22
				tile = new Tile("grass\\pathSide1", false, 0);
				foreImgArray1[2][6] = tile.getTexture();
				tile = new Tile("grass\\pathSide3", false, 0);
				foreImgArray2[2][6] = tile.getTexture();
				
				
				// 23
				tile = new Tile("grass\\pathOuterCorner2", false, 0);
				foreImgArray1[1][6] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner2", false, 0);
				foreImgArray2[1][6] = tile.getTexture();
				
				// 24
				tile = new Tile("grass\\pathSide2", false, 0);
				foreImgArray1[1][5] = tile.getTexture();
				tile = new Tile("grass\\pathSide4", false, 0);
				foreImgArray2[1][5] = tile.getTexture();
				
				// 25
				tile = new Tile("grass\\pathOuterCorner1", false, 0);
				foreImgArray1[1][4] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner1", false, 0);
				foreImgArray2[1][4] = tile.getTexture();
				
				// 26
				tile = new Tile("grass\\pathSide1", false, 0);
				foreImgArray1[2][4] = tile.getTexture();
				tile = new Tile("grass\\pathSide3", false, 0);
				foreImgArray2[2][4] = tile.getTexture();
				
				// 28
				tile = new Tile("grass\\pathSide1", false, 0);
				foreImgArray1[4][4] = tile.getTexture();
				tile = new Tile("grass\\pathSide3", false, 0);
				foreImgArray2[4][4] = tile.getTexture();
				
				// 29
				tile = new Tile("grass\\pathOuterCorner4", false, 0);
				foreImgArray1[5][4] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner4", false, 0);
				foreImgArray2[5][4] = tile.getTexture();
				
				// 30
				tile = new Tile("grass\\pathSide2", false, 0);
				foreImgArray1[5][5] = tile.getTexture();
				tile = new Tile("grass\\pathSide4", false, 0);
				foreImgArray2[5][5] = tile.getTexture();
				
				// 31
				tile = new Tile("grass\\pathOuterCorner2", false, 0);
				foreImgArray1[5][6] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner2", false, 0);
				foreImgArray2[5][6] = tile.getTexture();
				
				// 32-34
				for (int i = 6; i <= 8; i++) {
					tile = new Tile("grass\\pathSide1", false, 0);
					foreImgArray1[i][6] = tile.getTexture();
					tile = new Tile("grass\\pathSide3", false, 0);
					foreImgArray2[i][6] = tile.getTexture();
				}
				
				// 35
				tile = new Tile("grass\\pathOuterCorner4", false, 0);
				foreImgArray1[9][6] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner4", false, 0);
				foreImgArray2[9][6] = tile.getTexture();
				
				// 36
				tile = new Tile("grass\\pathSide2", false, 0);
				foreImgArray1[9][7] = tile.getTexture();
				tile = new Tile("grass\\pathSide4", false, 0);
				foreImgArray2[9][7] = tile.getTexture();
				
				// 37
				tile = new Tile("grass\\pathOuterCorner3", false, 0);
				foreImgArray1[9][8] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner3", false, 0);
				foreImgArray2[9][8] = tile.getTexture();
				
				// 38-44
				for (int i = 8; i >= 2; i--) {
					tile = new Tile("grass\\pathSide1", false, 0);
					foreImgArray1[i][8] = tile.getTexture();
					tile = new Tile("grass\\pathSide3", false, 0);
					foreImgArray2[i][8] = tile.getTexture();
				}
				
				// 45
				tile = new Tile("grass\\pathOuterCorner1", false, 0);
				foreImgArray1[1][8] = tile.getTexture();
				tile = new Tile("grass\\pathInnerCorner1", false, 0);
				foreImgArray2[1][8] = tile.getTexture();
				
				// 46
				tile = new Tile("grass\\pathSide2", false, 0);
				foreImgArray1[1][9] = tile.getTexture();
				tile = new Tile("grass\\pathSide4", false, 0);
				foreImgArray2[1][9] = tile.getTexture();
				
				
				// Adding buildable tiles
				tile = new Tile("grass\\grass1Buildable", true, 0);
				
				foreImgArray1[2][1] = tile.getTexture();
				foreImgArray1[4][2] = tile.getTexture();
				foreImgArray1[7][2] = tile.getTexture();
				foreImgArray1[2][5] = tile.getTexture();
				foreImgArray1[6][4] = tile.getTexture();
				foreImgArray1[4][6] = tile.getTexture();
				foreImgArray1[2][7] = tile.getTexture();
				foreImgArray1[8][7] = tile.getTexture();
				
				// Adding rocks
				tile = new Tile("stone\\pathAround", false, 0);

				foreImgArray1[0][0] = tile.getTexture();
				foreImgArray1[9][5] = tile.getTexture();
				foreImgArray1[2][3] = tile.getTexture();
				foreImgArray1[5][9] = tile.getTexture();
				
				
			break;
			
			case 2:
				
				/*
				 * Map 2:
				 * 
				 */
				
				// Drawing stone everywhere
				tile = new Tile("stone\\stone1", false, 0);
				for (int y = 0; y <= 9; y++) {
					for (int x = 0; x <= 9; x++) {
						tileArray[x][y] = tile;
					}
				}
				
			break;
			
			}
			
		} else {
			
			System.err.println("Incorrect map display selection -> " + map + "\nMust be 1-2");
			
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		tile = new Tile("dirt\\dirt1",false,0);
		// Render background
		
		for (int y = 0; y <= 9; y++) {
			for (int x = 0; x <= 9; x++) {
				g.drawImage(tileArray[x][y].getTexture(), x*64, y*64, this);
				if (tileArray[x][y].getTexture() == tile.getTexture()) {
					g.drawString(tileArray[x][y].getNumber() + "", x*64, y*64);
				}
			}
		}
		
		// Render foreground
		
		for (int y = 0; y <= 9; y++) {
			for (int x = 0; x <= 9; x++) {
				g.drawImage(foreImgArray1[x][y], x*64, y*64, this);
			}
		}
		for (int y = 0; y <= 9; y++) {
			for (int x = 0; x <= 9; x++) {
				g.drawImage(foreImgArray2[x][y], x*64, y*64, this);
			}
		}
		for (int y = 0; y <= 9; y++) {
			for (int x = 0; x <= 9; x++) {
				g.drawImage(foreImgArray3[x][y], x*64, y*64, this);
			}
		}
		for (int y = 0; y <= 9; y++) {
			for (int x = 0; x <= 9; x++) {
				g.drawImage(foreImgArray4[x][y], x*64, y*64, this);
			}
		}
		
	}

	public int getSelectedMap() {
		return selectedMap;
	}

	public void setSelectedMap(int selectedMap) {
		this.selectedMap = selectedMap;
	}

	public int getMapCount() {
		return mapCount;
	}

	public void setMapCount(int mapCount) {
		this.mapCount = mapCount;
	}
	
}