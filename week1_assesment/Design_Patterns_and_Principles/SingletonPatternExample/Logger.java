public class Logger {
    private static Logger instance; // instance - logger class

    private Logger() {
        // constructor
    }

    // method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void logMsg(String msg) {
        System.out.println("log- " + msg);
    }
}
