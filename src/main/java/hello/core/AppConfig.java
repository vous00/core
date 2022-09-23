package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
//설정정보 나타낸다 configuration

    @Bean // 스피링 컨테이너에 등록됨
    public  MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }// 오더서비스 임플 반환하는데 메모리멤버레퍼지도리와 픽스 디스카운터를 참조하도록 함
    @Bean
    public DiscountPolicy discountPolicy(){
        return  new RateDiscountPolicy();
    }

}
