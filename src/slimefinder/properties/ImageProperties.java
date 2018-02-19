package slimefinder.properties;

import java.io.IOException;

public class ImageProperties extends AbstractProperties {
	
	private static final long serialVersionUID = -6731944457024405660L;
	
	public static final String
		INPUT_FILE = "input-file",
		OUTPUT_DIR = "output-dir",
		BLOCK_WIDTH = "block-width",
		GRID_WIDTH = "grid-width",
		DRAW_SLIME_CHUNKS = "draw-slime-chunks",
		DRAW_BLOCK_MASK = "draw-block-mask",
		DRAW_CHUNK_MASK = "draw-chunk-mask",
		DRAW_CENTER_BLOCK = "draw-center-block";
	private final static String[] propertyNames = {
		INPUT_FILE,
		OUTPUT_DIR,
		BLOCK_WIDTH,
		GRID_WIDTH,
		DRAW_SLIME_CHUNKS,
		DRAW_BLOCK_MASK,
		DRAW_CHUNK_MASK,
		DRAW_CENTER_BLOCK
	};
	public int 
		wBlock = 5, 
		wGrid = 1;
	public boolean 
		drawSlimeChunks = true,
		drawBlockMask = true,
		drawChunkMask = true,
		drawCenterBlock = false;
	public String 
		inputFile,
		outputDir;
	
	public boolean hasAllProperties() {
		for (int i = 0; i < propertyNames.length; i++) {
			if (!containsKey(propertyNames[i])) return false;
		}
		return true;
	}
	
	public void loadProperties(String filename) throws IOException {
		super.loadProperties(filename);
		
		if ((inputFile = getProperty(INPUT_FILE)) == null) {
			throw new IOException("Output directory not specified.");
		}
		if ((outputDir = getProperty(OUTPUT_DIR)) == null) {
			outputDir = "";
		}
		try {wBlock = Integer.parseInt(getProperty(BLOCK_WIDTH));} catch (NumberFormatException e) {
			defaultWarning(BLOCK_WIDTH, "" + wBlock);
		} try {wGrid = Integer.parseInt(getProperty(GRID_WIDTH));} catch (NumberFormatException e) {
			defaultWarning(BLOCK_WIDTH, "" + wGrid);
		}
		
		try {drawSlimeChunks = Boolean.parseBoolean(getProperty(DRAW_SLIME_CHUNKS));} catch (Exception e) {
			defaultWarning(DRAW_SLIME_CHUNKS, "" + drawSlimeChunks);
		} try {drawBlockMask = Boolean.parseBoolean(getProperty(DRAW_BLOCK_MASK));} catch (Exception e) {
			defaultWarning(DRAW_BLOCK_MASK, "" + drawBlockMask);
		} try {drawChunkMask = Boolean.parseBoolean(getProperty(DRAW_CHUNK_MASK));} catch (Exception e) {
			defaultWarning(DRAW_CHUNK_MASK, "" + drawChunkMask);
		} try {drawCenterBlock = Boolean.parseBoolean(getProperty(DRAW_CENTER_BLOCK));} catch (Exception e) {
			defaultWarning(DRAW_CENTER_BLOCK, "" + drawCenterBlock);
		}
	}
	
	
	
}
