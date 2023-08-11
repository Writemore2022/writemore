package writemore.apiservice.members.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="my_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="group_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member leader;

    @Column
    private String groupContent;
    @Column
    private String groupName;
    @Column
    private Date startDate;

    public Group(Member leader, String groupContent, String groupName) {
        this.leader = leader;
        this.groupContent = groupContent;
        this.groupName = groupName;
        this.startDate=new Date();
    }

    public Group(Long id,String groupContent) {
        this.id = id;
        this.groupContent = groupContent;
    }

    public void patch(Group group) {
    }
}
