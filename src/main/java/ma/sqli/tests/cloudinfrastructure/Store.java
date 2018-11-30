package ma.sqli.tests.cloudinfrastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private final String name;
    private List<Document> documentList;
    private static final double PRECISION = 0.1;

    public Store(String name) {
        this.name = name;
        this.documentList = new LinkedList<>();
    }

    public boolean hasThisName(String storeName) {
        return name.equals(storeName);
    }

    public void upload(String... documents) {
        this.documentList.addAll(Arrays.stream(documents).map(Document::new).collect(Collectors.toList()));
    }

    public String display() {
        return String.format("%s:%s", name,
                documentList.isEmpty() ? "empty" : documentList.stream().map(Document::display).collect(Collectors.joining(", ")));
    }

    public void clear() {
         //this.documentList.removeAll(this.documentList);
        this.documentList.clear();
        // or this.documentList.removeIf(Document.class::isInstance); // this one is better i guess
    }

    public double usedDisk() {
        return this.documentList.size() * PRECISION;
    }
}
