package builder;

public class Main {
    public static void main(String[] args) {
        // Basic configuration
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        basicComputer.displayConfig();

        // Gaming configuration
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setGraphicsCard("NVIDIA RTX 4080")
            .setStorage("2TB SSD")
            .setOperatingSystem("Windows 11 Pro")
            .build();
        gamingComputer.displayConfig();

        // Workstation configuration
        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB")
            .setStorage("1TB SSD + 2TB HDD")
            .setOperatingSystem("Linux Ubuntu")
            .build();
        workstation.displayConfig();
    }
}
