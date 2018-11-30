package ma.sqli.tests.cloudinfrastructure;

public class CloudInfrastructure {

    private final Stores stores;
    private final Machines machines;

    public CloudInfrastructure() {
        this.stores = new Stores();
        this.machines = new Machines();
    }

    public void createStore(String storeName) {
        this.stores.addNewStore(storeName);
    }

    public void uploadDocument(String storeName, String... documents) {
        this.stores.uploadDocument(storeName, documents);
    }

    public String listStores() {
        return this.stores.display();
    }

    public void deleteStore(String storeName) {
        this.stores.delete(storeName);
    }

    public void emptyStore(String storeName) {
        this.stores.clear(storeName);
    }

    public void createMachine(String name, String operatingSystem, String diskSize, String memorySize) {
        this.machines.addMachine(name, operatingSystem, diskSize, memorySize);
    }

    public String listMachines() {
        return this.machines.display();
    }

    public void startMachine(String name) {
        this.machines.start(name);
    }

    public void stopMachine(String name) {
        this.machines.stop(name);
    }

    public int usedMemory(String name) {
        return this.machines.usedMemory(name);
    }

    public double usedDisk(String name) {
        return this.machines.usedDisk(name) + this.stores.usedDisk(name);
    }

    public double globalUsedDisk() {
        return this.machines.globalUsedDisk() + this.stores.globalUsedDisk();
    }

    public int globalUsedMemory() {
        return this.machines.globalUsedMemory();
    }
}
