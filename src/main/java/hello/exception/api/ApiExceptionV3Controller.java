package hello.exception.api;

import hello.exception.exceptions.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestControllerAdvice("hello.exception.api") 테스트용 클래스
 * ApiExceptionV2Controller 와 동일 코드
 * */
@Slf4j
@RestController
@RequestMapping("/api3")
public class ApiExceptionV3Controller {
    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){
        if(id.equals("ex")){
            throw new RuntimeException("잘못된 사용자 V3");
        }
        if(id.equals("bad")){
            throw new IllegalArgumentException("잘못된 입력 값 V3");
        }
        if(id.equals("user-ex")){
            throw new UserException("사용자 오류 V3");
        }
        return new MemberDto(id, "hello " + id);
    }
    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }
}
