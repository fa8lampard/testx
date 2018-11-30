package ma.sqli.tests.cloudinfrastructure;

enum State {
    INACTIVE("inactive"),
    RUNNING("running"),
    STOPPED("stopped");

    private String name;

    State(String name) {
        this.name = name;
    }

    String display() {
        return name;
    }
}
