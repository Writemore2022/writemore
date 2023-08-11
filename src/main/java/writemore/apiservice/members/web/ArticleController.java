package writemore.apiservice.members.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import writemore.apiservice.members.domain.Article;
import writemore.apiservice.members.domain.service.ArticleService;
import writemore.apiservice.members.util.ArticleDto;
import writemore.apiservice.members.util.ArticleUpdateDto;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/api/article")
    public List<Article> index(){
        //1. DB로부터 게시글 List 받아와서 리턴
        return articleService.index();
    }
    /*
    * Dto로 반환하도록 리팩토링 필요
    * */


    @GetMapping("/api/article/{id}")
    public Article showArticle(@PathVariable Long id){
        return articleService.show(id);
    }

    //POST
    @PostMapping("/api/article")
    public ResponseEntity<Article> postArticle(@RequestBody ArticleDto dto){
        //1. Dto->Entity
        //2. Entity->DB
        //3. Entity->client
        Article created = articleService.create(dto);
        return (created!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    /*
    * build()의미 알기
    * ResponseEntity의미 알기
    * */

    //PATCH
    @PutMapping("/api/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateDto dto){
        //0. find Entity by using id
        //1. Dto->Entity
        //2. Entity->DB
        //3. Entity->client
        Article updated = articleService.update(id,dto);
        return (updated!=null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //DELETE
    @DeleteMapping("/api/article/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id){
        //0. find Entity by using id
        //1. delete
        Article deleted = articleService.delete(id);
        return (deleted!=null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
