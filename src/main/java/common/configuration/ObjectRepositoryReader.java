package common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ObjectRepositoryReader {

    private static final Logger logger = LoggerFactory.getLogger(ObjectRepositoryReader.class);

    private static final String FILE_PATH = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"object.property";

    private ObjectRepositoryReader() {

    }

    /**
     * This method use to get the value from object repository file by passing parameter
     *
     * @param keyName
     * @return
     * @throws IOException
     */

    public static String readObjectRepo(String keyName) {

        try( FileInputStream inputStream = new FileInputStream(FILE_PATH)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(keyName);
        } catch (IOException e) {
            logger.info("Exception: {}", e.getMessage());

        }
        return null;
    }

}
