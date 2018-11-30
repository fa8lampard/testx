package ma.sqli.tests.cloudinfrastructure;

public class Document {
    private final String name;

    public Document(String name) {
        this.name = name;
    }

    public String display() {
        return name;
    }
}
