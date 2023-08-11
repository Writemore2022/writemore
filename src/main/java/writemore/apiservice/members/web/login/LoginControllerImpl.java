//package writemore.apiservice.members.web.login;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RestController;
//import writemore.apiservice.members.domain.Member;
//import writemore.apiservice.members.domain.service.LoginService;
//import writemore.apiservice.members.util.LoginDto;
//import writemore.apiservice.members.util.SessionConst;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//@Slf4j
//@RequiredArgsConstructor
//@RestController
//public class LoginControllerImpl implements LoginController{
//
//    @Autowired
//    private final LoginService loginService;
//    @Override
//    public Member login(@Valid @ModelAttribute LoginDto loginDto, HttpServletRequest request) {
//
//        Member member = loginService.login(loginDto);
//        log.info("login {}", member);
//
//        //로그인 예외처리
//
//
//        //로그인 성공처리
//        HttpSession session = request.getSession();
//        session.setAttribute(SessionConst.MEMBER_ID, member.getMemberId());
//        return member;
//    }
//
//    @Override
//    public void logout() {
//
//    }
//
//    @Override
//    public Member signup(Member member) {
//        return null;
//    }
//
//    @Override
//    public void withdraw(Member member) {
//
//    }
//}
