package party.shaytang.search.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import party.shaytang.search.repositories.entites.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
}
