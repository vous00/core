package hello.core.member;
//인터페이스 - 극단적으로 동일한 목적 하에 동일한 기능을 보장하게 하기 위함
//자바의 다형성을 이용하여 개발 코드 수정을 줄이고 유지보수 높임.

public interface MemberRepository {

    void save(Member member);
    //회원 저장
    Member findById(Long memberId);

}
