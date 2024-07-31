public class Test3 {
    public static void main(String[] args) {
        // Creating a basic computer
        Computer Computer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setMotherboard("asus rog")
                .setGPU("nvdia RTX4080 Ti")
                .build();

        System.out.println(Computer);
    }
}
