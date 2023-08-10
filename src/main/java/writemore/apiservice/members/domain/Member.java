package writemore.apiservice.members.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Member {
    private String memberName;
    private Long memberId;
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
