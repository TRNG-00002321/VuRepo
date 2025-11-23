import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogDemo.class);

        logger.debug("This is a debug message");

        logger.info("This is info message");

        logger.warn("This is warn message");

        logger.error("This is error message");

    }
}
