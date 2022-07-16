package codegym.model;

public class Mailbox {
    private String language;
    private String size;
    private Boolean spamsFilter;
    private String signature;

    public Mailbox() {
    }

    public Mailbox(String language, String size, Boolean spamsFilter, String signature) {
        this.language = language;
        this.size = size;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(Boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
