public class GpayAdapter implements PaymentProcessor {
    private Gpay gpay;

    public GpayAdapter(Gpay gpay) {
        this.gpay = gpay;
    }


    public void processPayment(double amount) {
        gpay.processTransaction(amount);
    }
}