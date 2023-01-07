package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataReader {
	
private static Properties property;
	
	static {
		
		try {
			File file = new File("./resources/testData.properties");
			FileInputStream input = new FileInputStream(file);
			property = new Properties();
			property.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getData(String key) {
		return property.getProperty(key);
	}

}
