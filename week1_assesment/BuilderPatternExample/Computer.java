public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String motherboard;
    private String GPU;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.motherboard = builder.motherboard;
        this.GPU = builder.GPU;

    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getGPU() {
        return GPU;
    }

    public String toString() {
        return "computer specification \nCPU= " + CPU +
                ",\nRAM= " + RAM + ",\nStorage= " + storage +
                ",\nMotherboard= " + motherboard +
                ",\nGPU= " + GPU ;
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String motherboard;
        private String GPU;

        // static nested builder class

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        // build method
        public Computer build() {
            return new Computer(this);
        }

    }
}
