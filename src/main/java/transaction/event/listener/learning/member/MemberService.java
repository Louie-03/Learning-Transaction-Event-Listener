package transaction.event.listener.learning.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    public void join(String name) {

        Member member = new Member(name);
        memberRepository.save(member);

        publisher.publishEvent(new MemberJoinEvent(member));
    }
}
