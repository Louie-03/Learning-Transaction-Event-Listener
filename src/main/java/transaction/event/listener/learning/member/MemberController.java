package transaction.event.listener.learning.member;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final Random random = new Random();

    @RequestMapping("/")
    public String join() {
        memberService.join("memeber" + random.nextInt());
        return "ok";
    }
}
