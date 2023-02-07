package transaction.event.listener.learning.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("@TransactionEventListener 학습 테스트")
@Transactional
@SpringBootTest
class TransactionEventListenerTest {

    @Autowired
    private MemberService memberService;

//    @MockBean
    private MemberEventListener memberEventListener;

    @Nested
    @DisplayName("AFTER_COMMIT 옵션은")
    class Describe_after_commit {

        @Nested
        @DisplayName("트랜잭션이 커밋된다면")
        class Context_transaction_commit {

            @Test
            @DisplayName("@TransactionEventListener를 실행한다.")
            void it_execute_transaction_event_listener() {
                memberService.join("memberA", false);

                System.out.println("끝");
//                verify(memberEventListener).afterCommit(any());
            }
        }


    }

}
