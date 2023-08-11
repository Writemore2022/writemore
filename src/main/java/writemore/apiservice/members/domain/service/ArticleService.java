package writemore.apiservice.members.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import writemore.apiservice.members.domain.Article;
import writemore.apiservice.members.domain.repository.ArticleRepository;
import writemore.apiservice.members.util.ArticleDto;
import writemore.apiservice.members.util.ArticleUpdateDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleDto dto) {
        Article article = dto.toEntity();
        //밑의 로직 왜 있는지 이해 못 함
        //여기서 id가 안 들어온다는 뜻임!!
        if (article.getId()!=null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleUpdateDto dto) {
        //1. DTO->ENTITY
        //updateDto에 넣었으므로, 이번에는 id까지 들어감
        Article article = dto.toEntity();

        log.info("id: {}, article: {}", id, article.toString());

        //2. 타겟 조회
        Article target=articleRepository.findById(id).orElse(null);

        //내가 오해한 점 1. Entity class에서 @Id를 선언한 것은, DB에서나 유효하다.
        //즉, id가 같은 Article은 만들어질 수 있음
        //Generated 어노테이션은 결국, DB에서 생성해준다는 것임(값을 넣지 않아도 됨)
        //결국 우리는 DB에 있는 값을 객체로 꺼내고, Dto에 해당하는 객체를 만들었을 때 id가 같은 지 확인해야 하는거임
        //id가 같아야 수정을 할 수 있음!!
        //repository에서 update함수를 지원하지 않기에, 우리가 dto에 id를 포함하는 수밖에 없음
        //3. 잘못된 요청 처리
        if (target==null || id!=article.getId()){
            // 400번, 잘못된 요청 응답!
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null;
        }
        //4. 업데이트 및 정상응답(200)하기
        target.patch(article);
        //target과 updated는 엄연히 다른 객체
        Article updated=articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        //1. 대상 찾기
        Article target=articleRepository.findById(id).orElse(null);

        //2. 잘못된 요청 처리
        if (target==null){
            return null;
        }

        //3. 대상 삭제
        //target객체는 메모리에 있음
        //delete는 DB에서 없애는 것임(쿼리를 보낸다구!)
        //그래서 이 return은 null을 반환하지 않음
        articleRepository.delete(target);
        return target;
    }
}
