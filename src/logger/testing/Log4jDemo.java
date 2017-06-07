package logger.testing;

import org.apache.log4j.Logger;

/**
 * This customized Log4j appender will seperate the log messages based on their
 * LEVELS and will write them' into separate files. For example, all DEBUG
 * messages will go to a file and all INFO messages will go to a different file.
 * 
 * @author Amit Kumar
 * 
 */
public class Log4jDemo {

	private static final Logger logger = Logger.getLogger(Log4jDemo.class);

	public static void main(String args[]) {
		logger.debug("This is a debug message");
		logger.info("This is a information message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		logger.debug("This is another debug message");
		logger.info("This is another information message");
		logger.warn("This is another warning message");
		logger.error("This is another error message");
		logger.fatal("This is another fatal message");
	}

}
