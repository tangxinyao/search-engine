package party.shaytang.search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import party.shaytang.search.controllers.entities.SearchArticleRequest;
import party.shaytang.search.models.Article;
import party.shaytang.search.services.ArticleService;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "elasticsearch/article")
public class ArticleController {
    private ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Article> retrieveArticle() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<ArrayList<Article>> retrieveArticles() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "search")
    public ResponseEntity<ArrayList<Article>> searchArticle(@RequestBody SearchArticleRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Article> deleteArticle(String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
