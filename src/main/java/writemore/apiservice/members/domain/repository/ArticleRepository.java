package writemore.apiservice.members.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import writemore.apiservice.members.domain.Article;

import java.util.ArrayList;

//@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Override
    ArrayList<Article> findAll();
}
