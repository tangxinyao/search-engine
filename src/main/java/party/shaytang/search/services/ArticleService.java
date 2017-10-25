package party.shaytang.search.services;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import party.shaytang.search.controllers.entities.SearchArticleRequest;
import party.shaytang.search.repositories.ArticleRepository;
import party.shaytang.search.repositories.entites.Article;

import java.util.List;
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

    public Page<Article> searchArticles(SearchArticleRequest request) {

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        Pageable pageable = new QPageRequest(request.getPage(), request.getSize());
        queryBuilder.withPageable(pageable);

        queryBuilder.withQuery(new MatchQueryBuilder("_all", request.getKey()));

        BoolQueryBuilder boolFilter = new BoolQueryBuilder();
        if (request.getDegree() != null) {
            boolFilter.must(new MatchQueryBuilder("degree", request.getDegree()));
        }
        if (request.getMajor() != null) {
            boolFilter.must(new MatchQueryBuilder("major", request.getMajor()));
        }
        queryBuilder.withFilter(boolFilter);

        List<SearchArticleRequest.GradeParam> gradeParams = request.getGradeParams();

        if (gradeParams != null) {
            for (SearchArticleRequest.GradeParam gradeParam : gradeParams) {
                System.out.println(gradeParam.getType());
                queryBuilder.withQuery(new RangeQueryBuilder(gradeParam.getType())
                        .from(gradeParam.getMinScore())
                        .to(gradeParam.getMaxScore())
                        .includeUpper(true)
                        .includeLower(true));
            }
        }

        return repository.search(queryBuilder.build());
    }

}
