package party.shaytang.search.repositories.entites;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.ArrayList;

@Document(indexName = "articles", type = "articles", shards = 1, replicas = 0, refreshInterval = "-1")
public class Article implements Serializable {
    @Id
    private String id;
    @Field(type = FieldType.text, analyzer = "smartcn")
    private String title;
    @Field(type = FieldType.text, analyzer = "smartcn")
    private String author;
    @Field(type = FieldType.text, analyzer = "smartcn")
    private String major;
    @Field(type = FieldType.text, analyzer = "smartcn")
    private String degree;
    @Field(type = FieldType.text, analyzer = "smartcn")
    private String content;
    private Grade grades;
    @Field(type = FieldType.Object, analyzer = "smartcn")
    private ArrayList<String> tags;

    public Article() {
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

    public Grade getGrades() {
        return grades;
    }

    public void setGrades(Grade grades) {
        this.grades = grades;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
