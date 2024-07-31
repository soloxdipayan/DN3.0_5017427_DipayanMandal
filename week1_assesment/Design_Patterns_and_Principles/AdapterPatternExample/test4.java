public class test4 {
    public static void main(String[] args) {
        PaymentProcessor gpayProcessor = new GpayAdapter(new Gpay());
        gpayProcessor.processPayment(200.00);

        
        PaymentProcessor cashAppProcessor = new CashAppAdapter(new CashApp());
        cashAppProcessor.processPayment(300.00);
    }
}