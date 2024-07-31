public class test8 {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay via Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        context.executePayment(103.0);

        // Pay via PayPal
        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        context.executePayment(302.0);
    }
}
