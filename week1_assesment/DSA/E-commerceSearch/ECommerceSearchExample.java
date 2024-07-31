public class ECommerceSearchExample {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Book", "Books"),new Product("4", "Shoes", "Fashion")
        };

        // Linear Search

        Product foundProduct = LinearSearch.linearSearch(products, "2");
        if (foundProduct != null) {
            System.out.println("Linear Search: Found " + foundProduct.getProductName());
        } else {
            System.out.println("Linear Search: Product not found");
        }

        // Binary Search
    
        foundProduct = BinarySearch.binarySearch(products, "4");
        if (foundProduct != null) {
            System.out.println("Binary Search: Found " + foundProduct.getProductName());
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}
