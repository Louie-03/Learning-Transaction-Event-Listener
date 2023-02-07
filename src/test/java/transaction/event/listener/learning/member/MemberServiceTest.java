package transaction.event.listener.learning.member;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    void 회원가입에_실패해도_printMemberLog_메서드가_호출된다() {
        assertThatThrownBy(() -> memberService.join("memberA", true))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("예외가 발생했습니다.");

        verify(memberEventListener, never()).printMemberLog(any());
    }

}
