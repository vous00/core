package hello.core.discount;

import hello.core.member.Member;
// import = 자바의 라이브러리 패키지의 클래스를 사용하거나 사용자의 다른 패키지 안의
//클래스를 사용할 때 import 명령어를 사용하면 클래스 이름으로 사용할 수 있게 해줌.
public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */

    int discount(Member member, int price);


}
