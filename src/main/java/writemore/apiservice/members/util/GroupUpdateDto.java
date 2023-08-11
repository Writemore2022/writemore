package writemore.apiservice.members.util;

import writemore.apiservice.members.domain.Group;
import writemore.apiservice.members.domain.Member;

import java.util.Date;

public class GroupUpdateDto {
    private Long id;
    private Member leader;
    private String groupContent;
    private String groupName;
    private Date startDate;

    public Group toEntity() {
        return new Group(id,groupContent);
    }
}
