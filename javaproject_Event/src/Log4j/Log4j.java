package Log4j;

import org.apache.log4j.Logger;

public class Log4j {
	private static Logger logger = Logger.getLogger(Log4j.class);
	
	public static void logger() {
		logger.error("실행되지 않았습니다.");
	}
}
