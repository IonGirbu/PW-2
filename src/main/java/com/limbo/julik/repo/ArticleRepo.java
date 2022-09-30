package com.limbo.julik.Repo;

import com.limbo.julik.Model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Long> {
}
