public class Test1 {
    @SuppressWarnings("static-access")
    public static void main(String args[]) {
        Logger log1 = Logger.getInstance();
        log1.logMsg("1 log");
        Logger log2 = Logger.getInstance();
        log2.logMsg("2 log");
        if (log1 == log2)
            System.out.println("both logger is the same instance.");
        else
            System.out.println("both are different instance.");

    }
}
