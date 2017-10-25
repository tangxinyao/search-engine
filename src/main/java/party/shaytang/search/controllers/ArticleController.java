package party.shaytang.search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import party.shaytang.search.controllers.entities.PageResponse;
import party.shaytang.search.controllers.entities.SearchArticleRequest;
import party.shaytang.search.repositories.entites.Article;
import party.shaytang.search.services.ArticleService;

import java.util.Optional;

@RestController
@RequestMapping(value = "elasticsearch/article")
public class ArticleController {
    private ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Article> retrieveArticle(@RequestParam String id) {
        Optional<Article> result = service.retrieveArticleById(id);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "all")
    public ResponseEntity<PageResponse<Article>> retrieveArticles(@RequestParam int page,
                                                                  @RequestParam int size) {
        Page<Article> result = service.retrieveArticles(page, size);
        return new ResponseEntity<>(new PageResponse<>(page, size, result.getTotalPages(),
                result.getTotalElements(), result.getContent()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createArticle(@RequestBody Article article) {
        Boolean result = service.createArticle(article);
        if (result) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "search")
    public ResponseEntity<PageResponse<Article>> searchArticle(@RequestBody SearchArticleRequest request) {
        Page<Article> result = service.searchArticles(request);
        return new ResponseEntity<>(new PageResponse<>(request.getPage(), request.getSize(), result.getTotalPages(),
                result.getTotalElements(), result.getContent()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateArticle(@RequestBody Article article) {
        if (article.getId() != null) {
            Boolean result = service.updateArticle(article);
            if (result) {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity deleteArticle(String id) {
        if (id != null) {
            Boolean result = service.deleteArticle(id);
            if (result) {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
