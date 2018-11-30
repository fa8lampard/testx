package ma.sqli.tests.cloudinfrastructure;

public class Machine {

    private final String name;
    private final String operatingSystem;
    private final int diskSize;
    private final int memorySize;
    private State currentState;

    public Machine(String name, String operatingSystem, String diskSize, String memorySize) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.diskSize = Integer.parseInt(diskSize.substring(0, diskSize.length() - 2));
        this.memorySize = Integer.parseInt(memorySize.substring(0, memorySize.length() - 2));
        this.currentState = State.INACTIVE;
    }

    public String display() {
        return String.format("%s:%s", name, currentState.display());
    }

    public boolean hasThisName(String name) {
        return this.name.equals(name);
    }

    public void updateState(State state) {
        if (alreadyRunning(state))
            throw new MachineStateException();
        this.currentState = state;
    }

    public int usedDisk() {
        return diskSize;
    }

    public int usedMemory() {
        return currentState == State.RUNNING ? memorySize : 0;
    }

    private boolean alreadyRunning(State state) {
        return this.currentState == State.RUNNING && state == State.RUNNING;
    }
}
