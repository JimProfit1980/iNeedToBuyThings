package pageObjects;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class resources {
	/*****
	 * Returns the the items in the file in the form of a list
	 * @return
	 * @throws IOException
	 */
	
	public static List<String> getSearchedItemsFileList() throws IOException {
		File rootAppDirectory = new File(System.getProperty("user.dir"));
		List<String> searchedItemsFile = Files.readAllLines(Paths.get(rootAppDirectory + "/resources/shoppingFiles.txt"));			
		return searchedItemsFile;
	}

}
