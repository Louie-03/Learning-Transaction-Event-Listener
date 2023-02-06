package transaction.event.listener.learning.member;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MemberEventListener {

    @EventListener
    public void printMemberLog(MemberJoinEvent event) {
        System.out.println("회원 가입 : " + event.getMember());
    }

}
