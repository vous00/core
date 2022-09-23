package hello.core.member;
//회원서비스 구현체
public class MemberServiceImpl implements  MemberService{

//private final로 선언을 하면 직접적으로 값을 참조할 수 없지만, 생성자를 통해 값 참조 가능

    private final MemberRepository memberRepository;

public MemberServiceImpl(MemberRepository memberRepository){
    this.memberRepository=memberRepository;
}
//구현체 없이 null이면 터짐, 구현객체 넣어야함.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //join에서 save를 호출하면 다형성에 의해서 오버라이드한 MemberRepositoy에 있는
        //세이브가 호출됨.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
