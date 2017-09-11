package io.github.untungs.basicinterface.company;

public class Worker {

    private final String name;
    private Supervisor supervisor;

    public Worker(String name) {
        this.name = name;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public void doWork() {
        Document document = new Document(name);
        document.setBody("blablabla");

        supervisor.receiveDocument(document);
    }

}
