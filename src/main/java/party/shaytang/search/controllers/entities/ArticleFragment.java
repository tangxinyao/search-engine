package party.shaytang.search.controllers.entities;

import party.shaytang.search.models.Article;

public class ArticleFragment {
    private Article article;

    public ArticleFragment() {
    }

    public ArticleFragment(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
