public class test6 {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        // Image image2 = new ProxyImage("image2.jpg");

    // to load img from remote servers
    
        image1.display();
        System.out.println("");

        // image2.display();
        // System.out.println("");

        // load from cache
        image1.display();
    }

}
