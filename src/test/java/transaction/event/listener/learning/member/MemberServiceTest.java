package transaction.event.listener.learning.member;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberEventListener memberEventListener;

    @Test
    void 회원가입을_한다면_printMemberLog_메서드가_호출된다() {
        memberService.join("memberA", false);

        verify(memberEventListener).printMemberLog(any());
    }

}
