package io.github.untungs.basicinterface.company;

class Document {

    private final String title;
    private String body;

    Document(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
