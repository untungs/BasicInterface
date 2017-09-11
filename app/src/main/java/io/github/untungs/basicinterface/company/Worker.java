package io.github.untungs.basicinterface.company;

import android.os.Handler;

public class Worker {

    private final String name;
    private final long speed;
    private Supervisor supervisor;

    public Worker(String name, long speed) {
        this.name = name;
        this.speed = speed;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public void doWork() {
        final Document document = new Document(name);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                document.setBody("blablabla");
                supervisor.receiveDocument(document);
            }
        }, speed);
    }

}
