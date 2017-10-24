package party.shaytang.search.controllers.entities;

import java.util.ArrayList;

public class PagingResponse<T> {
    private int page;
    private int size;
    private int totalPages;
    private int totalElements;
    private ArrayList<T> entities;

    public PagingResponse() {
    }

    public PagingResponse(int page, int size, int totalPages, int totalElements, ArrayList<T> entities) {
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.entities = entities;
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public ArrayList<T> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<T> entities) {
        this.entities = entities;
    }
}
