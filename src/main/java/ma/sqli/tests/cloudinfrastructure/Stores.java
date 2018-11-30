package ma.sqli.tests.cloudinfrastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stores {

    private List<Store> stores;

    public Stores() {
        this.stores = new LinkedList<>();
    }

    public void addNewStore(String storeName) {
        if (this.contains(storeName))
            throw new CreateStoreException();
        this.stores.add(new Store(storeName));
    }

    public void uploadDocument(String storeName, String ... documents) {
        findStore(storeName).ifPresent(store -> store.upload(documents));
    }

    public String display() {
        return this.stores.stream().map(Store::display).collect(Collectors.joining("||"));
    }

    public void delete(String storeName) {
        this.stores = this.stores.stream()
                .filter(store -> !store.hasThisName(storeName))
                .collect(Collectors.toList());
    }

    public void clear(String storeName) {
        findStore(storeName).ifPresent(Store::clear);
    }

    public double usedDisk(String name) {
        return findStore(name).isPresent() ? findStore(name).get().usedDisk() : 0 ;
    }

    private Optional<Store> findStore(String storeName) {
        return this.stores.stream()
                .filter(store -> store.hasThisName(storeName))
                .findFirst();
    }

    public double globalUsedDisk() {
        return this.stores.stream()
                .mapToDouble(Store::usedDisk)
                .sum();
    }

    private boolean contains(String storeName) {
        return this.stores.stream().anyMatch(store -> store.hasThisName(storeName));
    }
}
