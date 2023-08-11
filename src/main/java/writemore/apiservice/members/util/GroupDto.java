package writemore.apiservice.members.util;

import jakarta.persistence.*;
import writemore.apiservice.members.domain.Group;
import writemore.apiservice.members.domain.Member;

import java.util.Date;

public class GroupDto {

    private Long id;
    private Member leader;
    private String groupContent;
    private String groupName;
    private Date startDate;

    //DB에 넣기 위함이니, id는 필요없음(자동배정)
    public Group toEntity() {
        return new Group(leader,groupContent,groupName);
    }
}
