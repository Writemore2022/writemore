package writemore.apiservice.members.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    private String memberName;

    private String loginId;
    private String password;
    private String email;
    private Boolean isMale; //True -> male False -> female
    private Integer age;
    private Date birthDate;
    private Date startDate;
    private String address;

    public Member(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
