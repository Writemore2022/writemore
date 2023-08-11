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
    @Column(name="article_id") //칼럼 이름 재설정
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member writer;
    @ManyToOne //One to one을 써도 되는지 모르겠음
    @JoinColumn(name="group_id") //얘는 대상이 mappedby를 해야 함
    private Group team;
    @Column
    private String memberName;
    @Column
    private String groupName;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date createdAt;
    @Column
    private Date modifiedAt;

    //POST용
    public Article(Member member, Group group, String memberName, String groupName, String title, String content) {
        this.writer=member;
        this.team = group;
        this.memberName = memberName;
        this.groupName = groupName;
        this.title = title;
        this.content = content;
        this.createdAt=new Date();
        this.modifiedAt=new Date();
    }

    //PUT,PATCH용
    public Article(Long id, Member member, Group group, String memberName, String groupName, String title, String content) {
        this.id=id;
        this.writer=member;
        this.team = group;
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
