package transaction.event.listener.learning.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class MemberEventListener {

    private final MemberRepository memberRepository;

    @EventListener
    public void printMemberLog(MemberJoinEvent event) {
        System.out.println("회원 가입 : " + event.getMember());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(MemberJoinEvent event) {
        memberRepository.save(new Member("afterCommit"));
        System.out.println("MemberEventListener.afterCommit");
    }
}
