public class FinancialForecasting {

    public static double predictFutureValue(double initialValue, double growthRate, int years) {

        if (years == 0) {
            return initialValue;
        }

        // Recursive case: Calculate the future value for one less year and multiply by (1 + growthRate)
        return (1 + growthRate) * predictFutureValue(initialValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; 
        double growthRate = 0.05;     // 5% growth rate
        int years = 10;               // Predicting 10 years

        double futureValue = predictFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value: " + futureValue);
    }
}
