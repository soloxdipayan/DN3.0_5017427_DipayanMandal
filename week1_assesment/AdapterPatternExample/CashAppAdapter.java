public class CashAppAdapter implements PaymentProcessor {
    private CashApp cashApp;

    public CashAppAdapter(CashApp cashApp) {
        this.cashApp = cashApp;
    }

    @Override
    public void processPayment(double amount) {
        cashApp.makePayment(amount);
    }
}