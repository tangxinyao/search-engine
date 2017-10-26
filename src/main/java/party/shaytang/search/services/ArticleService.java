package party.shaytang.search.services;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import party.shaytang.search.repositories.ArticleRepository;
import party.shaytang.search.entites.Article;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository repository;

    @Autowired
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Optional<Article> retrieveArticleById(String id) {
        return repository.findById(id);
    }

    public Page<Article> retrieveArticles(int page, int size) {
        Pageable pageable = new QPageRequest(page, size);
        return repository.findAll(pageable);
    }

    public Boolean createArticle(Article article) {
        repository.save(article);
        return true;
    }

    public Boolean updateArticle(Article article) {
        repository.save(article);
        return true;
    }

    public Boolean deleteArticle(String id) {
        repository.deleteById(id);
        return true;
    }

    public Page<Article> searchArticles(int page, int size, String key) {

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        Pageable pageable = new QPageRequest(page, size);
        queryBuilder.withPageable(pageable);

        queryBuilder.withQuery(new MatchQueryBuilder("_all", key));

        return repository.search(queryBuilder.build());
    }

}
