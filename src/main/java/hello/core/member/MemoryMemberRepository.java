package hello.core.member;
//메모리 회원 저장소 구현체
import java.util.HashMap;
import java.util.Map;

//class가 인터페이스를 사용할 때 implements를 쓴다.
//부모 객체는 선언만 하며, 정의 내용은 자식에서 오버라이드(재정의)해서 사용해야한다.
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
//Map은 "이름=홍길동' 처럼 대응관계를 쉽게 표현할 수 있게 해주는 자료형
//HashMap은 Map 중 유용하게 쓰임, Map 역시 인터페이스.
//put(입력) get(출력)


    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        //findById 하면 스토어에서 겟 해서 넘어온 아이디 찾음
        return store.get(memberId);
    }
}
