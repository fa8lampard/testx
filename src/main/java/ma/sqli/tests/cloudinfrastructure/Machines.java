package ma.sqli.tests.cloudinfrastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Machines {
    private List<Machine> machines;

    public Machines() {
        this.machines = new LinkedList<>();
    }

    public void addMachine(String name, String operatingSystem, String diskSize, String memorySize) {
        this.machines.add(new Machine(name, operatingSystem, diskSize, memorySize));
    }

    public String display() {
        return this.machines.stream().map(Machine::display).collect(Collectors.joining("||"));
    }

    public void start(String name) {
        updateState(name, State.RUNNING);
    }

    public void stop(String name) {
        updateState(name, State.STOPPED);
    }

    private void updateState(String name, State newState) {
        findMachine(name).ifPresent(machine -> machine.updateState(newState));
    }

    public int usedMemory(String name) {
        return findMachine(name).get().usedMemory();
    }

    public double usedDisk(String name) {
        return findMachine(name).isPresent() ? findMachine(name).get().usedDisk() : 0 ;
    }

    public double globalUsedDisk() {
        return this.machines.stream()
                .mapToDouble(Machine::usedDisk)
                .sum();
    }

    public int globalUsedMemory() {
        return this.machines.stream()
                .mapToInt(Machine::usedMemory)
                .sum();
    }

    private Optional<Machine> findMachine(String name) {
        return this.machines.stream()
                .filter(machine -> machine.hasThisName(name))
                .findFirst();
    }
}
