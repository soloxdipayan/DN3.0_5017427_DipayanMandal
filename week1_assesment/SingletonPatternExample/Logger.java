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

    // methode to verify that only one instance of Logger
    // is created and used across the application.
    public static void logMsg(String msg) {
        System.out.println("log- " + msg);
    }
}

// test class to verify that only one instance of Logger is
// created and used across the application
