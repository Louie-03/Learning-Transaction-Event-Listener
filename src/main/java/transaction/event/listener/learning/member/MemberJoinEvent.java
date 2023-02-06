package transaction.event.listener.learning.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberJoinEvent {

    private final Member member;

}
