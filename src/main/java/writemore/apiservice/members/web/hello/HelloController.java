package writemore.apiservice.members.web.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import writemore.apiservice.members.domain.Article;
import writemore.apiservice.members.domain.repository.ArticleRepository;

@RestController
public class HelloController {
    //저장 후 JSON내보내볼까
    private ArticleRepository articleRepository ;
    @Autowired
    public HelloController(ArticleRepository articleRepository){this.articleRepository=articleRepository;}
    @GetMapping("/")
    public Article hello(){
        Article art =new Article(1L,1L,"jaehyeon","writemore","title","content");
        articleRepository.save(art);
        return art;
    }

    @GetMapping("/delete")
    public String deleteA(){
        articleRepository.deleteAll();
        return "finish";
    }
}
