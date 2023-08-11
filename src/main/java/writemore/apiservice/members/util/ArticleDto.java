package writemore.apiservice.members.util;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import writemore.apiservice.members.domain.Article;
import writemore.apiservice.members.domain.Group;
import writemore.apiservice.members.domain.Member;

import java.util.Date;

@AllArgsConstructor
public class ArticleDto {
    Long id;
    Member member;
    Group group;
    String memberName;
    String groupName;
    String title;
    String content;
    Date createdAt;
    Date modifiedAt;

    public Article toEntity(){
        return new Article(member,group,memberName,groupName,title,content);
    }
}
