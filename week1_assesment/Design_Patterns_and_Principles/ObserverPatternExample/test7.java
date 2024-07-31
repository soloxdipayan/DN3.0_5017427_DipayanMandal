public class test7 {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice(100.50);
        stockMarket.setStockPrice(102.75);

        stockMarket.deregister(mobileApp);
        stockMarket.setStockPrice(105.00);
    }

}
