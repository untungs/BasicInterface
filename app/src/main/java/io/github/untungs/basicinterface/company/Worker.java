package io.github.untungs.basicinterface.company;

public class Worker {

    private final String name;
    private Manager manager;

    public Worker(String name) {
        this.name = name;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void doWork() {
        Document document = new Document(name);
        document.setBody("blablabla");

        manager.receiveDocument(document);
    }

}
