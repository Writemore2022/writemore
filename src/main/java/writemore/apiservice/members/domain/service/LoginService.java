package writemore.apiservice.members.domain.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import writemore.apiservice.members.domain.Member;
import writemore.apiservice.members.util.LoginDto;

public interface LoginService {

    public Member login(LoginDto loginDto);
}
