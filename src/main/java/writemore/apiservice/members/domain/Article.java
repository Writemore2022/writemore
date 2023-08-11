package writemore.apiservice.members.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//import javax.persistence.*;
import java.util.Date;
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ARTICLE_ID") //칼럼 이름 재설정
    private Long id;

    @Column
    Long memberId;
    @Column
    Long groupId;
    @Column
    String memberName;
    @Column
    String groupName;
    @Column
    String title;
    @Column
    String content;
    @Column
    Date createdAt;
    @Column
    Date modifiedAt;

    //POST용
    public Article(Long memberId, Long groupId, String memberName, String groupName, String title, String content) {
        this.memberId=memberId;
        this.groupId = groupId;
        this.memberName = memberName;
        this.groupName = groupName;
        this.title = title;
        this.content = content;
        this.createdAt=new Date();
        this.modifiedAt=new Date();
    }

    //PUT,PATCH용
    public Article(Long id, Long memberId, Long groupId, String memberName, String groupName, String title, String content) {
        this.id=id;
        this.memberId=memberId;
        this.groupId = groupId;
        this.memberName = memberName;
        this.groupName = groupName;
        this.title = title;
        this.content = content;
        this.createdAt=new Date();
        this.modifiedAt=new Date();
    }

    //this에 article의 값을 덮어씌우는 함수
    //제목, 내용, 수정일자만 바꾸면 됨
    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;

        if (article.modifiedAt != null) {
            this.modifiedAt = new Date();
        }

    }
}
