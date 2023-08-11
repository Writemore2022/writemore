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
public class MemberGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberOfGroup;
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group groupOfMember;
    @Column
    private Date startDate;
}
