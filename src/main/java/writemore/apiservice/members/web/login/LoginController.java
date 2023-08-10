package writemore.apiservice.members.web.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import writemore.apiservice.members.domain.Member;
import writemore.apiservice.members.util.LoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public interface LoginController {
    public Member login(@Valid @ModelAttribute LoginDto loginDto, HttpServletRequest request);
    public void logout();
    public Member signup(Member member);
    public void withdraw(Member member);

}
