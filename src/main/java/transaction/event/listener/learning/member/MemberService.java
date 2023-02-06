package transaction.event.listener.learning.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public void join(String name, boolean throwException) {

        if (throwException) {
            throw new RuntimeException("예외가 발생했습니다.");
        }

        Member member = new Member(name);
        memberRepository.save(member);

        publisher.publishEvent(new MemberJoinEvent(member));
    }
}
