package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
   // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
   // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
   //FixDis를 RateDis로 변경하는 순간 OrderServiceImpl의 소스 코드도 함꼐 변경해야함. ocp 위반
    //변경후 ->
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
       this.memberRepository=memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        //단일 책임 원칙을 잘 지킴. 오더 구현체에서는 할인에 관해 건드리지 않음

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
