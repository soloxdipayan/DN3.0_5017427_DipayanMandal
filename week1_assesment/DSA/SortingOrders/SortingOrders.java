public class SortingOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "Alice", 250.0),
            new Order("2", "Bob", 150.0),
            new Order("3", "Charlie", 300.0),
            new Order("4", "David", 200.0)
        };

        // Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("Orders sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order.getCustomerName() + ": $" + order.getTotalPrice());
        }

        // Quick Sort
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order order : orders) {
            System.out.println(order.getCustomerName() + ": $" + order.getTotalPrice());
        }
    }

}
