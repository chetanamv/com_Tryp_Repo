package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String getProperty(String key) throws Exception
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);

	}

}
