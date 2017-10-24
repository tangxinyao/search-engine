package party.shaytang.search.services;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import party.shaytang.search.controllers.entities.SearchArticleRequest;
import party.shaytang.search.models.Article;
import party.shaytang.search.models.ArticleRepository;

import java.util.Optional;

public class ArticleService {
    private ArticleRepository repository;
    private ElasticsearchOperations operations;

    @Autowired
    public ArticleService(ArticleRepository repository, ElasticsearchOperations operations) {
        this.repository = repository;
        this.operations = operations;
    }

    public Optional<Article> retrieveArticle(String id) {
        return repository.findById(id);
    }

    public Page<Article> retrieveArticles(int page, int size) {
        Pageable pageable = new QPageRequest(page, size);
        return repository.findAll(pageable);
    }

    public void searchArticles(SearchArticleRequest request) {
        Pageable pageable = new QPageRequest(request.getPage(), request.getSize());
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withPageable(pageable);
        queryBuilder.withFilter(boolFilter()
                .must(matchQuery("major", request.getMajor()))
                .must(matchQuery("degree", request.getDegree())));

        SearchQuery searchQuery = queryBuilder.build();
    }

    private BoolQueryBuilder boolFilter() {
        return new BoolQueryBuilder();
    }

    private MatchQueryBuilder matchQuery(String field, String value) {
        return new MatchQueryBuilder(field, value);
    }
}
