package party.shaytang.search.entites;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(indexName = "articles", type = "articles", shards = 1, replicas = 0, refreshInterval = "-1")
public class Article implements Serializable {
    @Id
    private String id;

    @Field(type = FieldType.text, analyzer = "smartcn")
    private String title;

    @Field(type = FieldType.text, analyzer = "smartcn")
    private String content;

    @Field(type = FieldType.text, analyzer = "smartcn")
    private ArrayList<String> tags;

    @Field(type = FieldType.text, analyzer = "smartcn")
    private String author;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
