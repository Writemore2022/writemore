package writemore.apiservice.members.util;

import lombok.AllArgsConstructor;
import writemore.apiservice.members.domain.Article;

import java.util.Date;

@AllArgsConstructor
public class ArticleUpdateDto {
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
        return new Article(id,memberId,groupId,memberName,groupName,title,content);
    }
}
