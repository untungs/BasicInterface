package io.github.untungs.basicinterface.company;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Worker> workers;
    private List<Document> documents = new ArrayList<>();

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
        briefWorkers();
    }

    private void briefWorkers() {
        System.out.println("Hellow, I'm your manager");
        for (Worker worker : workers) {
            worker.setManager(this);
        }
    }

    public void receiveDocument(Document document) {
        documents.add(document);
    }

    public void assignWork() {
        for (Worker worker : workers) {
            worker.doWork();
        }
    }

    public String report() {
        String reportString = "";
        for (Document document : documents) {
            reportString += document.getTitle() + " " + document.getBody() + "\n";
        }

        return reportString;
    }
}
