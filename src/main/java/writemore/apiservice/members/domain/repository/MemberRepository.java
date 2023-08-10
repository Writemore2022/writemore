package writemore.apiservice.members.domain.repository;

import writemore.apiservice.members.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findByLoginId(String loginId);
    public Member findByMemberId(Long memberId);
    public List<Member> findAll();
    public Member delete(Member member);
    public void clearStore();
}
