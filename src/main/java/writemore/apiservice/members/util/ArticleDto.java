package writemore.apiservice.members.util;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import writemore.apiservice.members.domain.Article;

import java.util.Date;

@AllArgsConstructor
public class ArticleDto {
    Long id;
    Long memberId;
    Long groupId;
    String memberName;
    String groupName;
    String title;
    String content;
    Date createdAt;
    Date modifiedAt;

    public Article toEntity(){
        return new Article(memberId,groupId,memberName,groupName,title,content);
    }
}
