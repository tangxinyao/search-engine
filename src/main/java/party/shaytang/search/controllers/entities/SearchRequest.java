package party.shaytang.search.controllers.entities;

public abstract class SearchRequest {
    private int page;
    private int size;
    private String key;

    SearchRequest() {
    }

    SearchRequest(int page, int size, String key) {
        this.page = page;
        this.size = size;
        this.key = key;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
