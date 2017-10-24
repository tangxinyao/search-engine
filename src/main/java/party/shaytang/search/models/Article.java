package party.shaytang.search.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Article implements Serializable {
    private String id;
    private String title;
    private String author;
    private String major;
    private String degree;
    private String content;
    private Map<String, Float> grades;
    private ArrayList<String> tags = new ArrayList<>();

    public Article() {
    }

    public Article(String id, String title, String author, String major, String degree, String content,
                   Map<String, Float> grades, ArrayList<String> tags) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.major = major;
        this.degree = degree;
        this.content = content;
        this.grades = grades;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Float> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Float> grades) {
        this.grades = grades;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
