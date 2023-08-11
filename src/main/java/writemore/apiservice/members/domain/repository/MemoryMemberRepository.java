//package writemore.apiservice.members.domain.repository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//import writemore.apiservice.members.domain.Member;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Repository
//@Slf4j
//public class MemoryMemberRepository implements MemberRepository {
//    private static Map<Long, Member> store = new ConcurrentHashMap<>();
//    private static long sequence = 0L;
//    @Override
//    public Member save(Member member) {
//        member.setMemberId(++sequence);
//        log.info("save: member={}", member);
//        store.put(member.getMemberId(), member);
//        return member;
//    }
//    @Override
//    public Optional<Member> findByLoginId(String loginId) {
//        return findAll().stream()
//                .filter(m -> m.getLoginId().equals(loginId))
//                .findFirst();
//    }
//
//    @Override
//    public Member findByMemberId(Long memberId) {
//        return store.get(memberId);
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    @Override
//    public Member delete(Member member) {
//        return store.remove(member.getMemberId());
//    }
//
//    @Override
//    public void clearStore() {
//        store.clear();
//    }
//}
