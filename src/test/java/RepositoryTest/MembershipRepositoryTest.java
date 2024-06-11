package RepositoryTest;

import Entity.MemberShipEntity;
import Repository.MemberShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MembershipRepositoryTest {
    @Autowired
    private MemberShipRepository memberShipRepository;

    @Test
    public void MemberShipRepositoryNotStatus() {
        System.out.println("현재 상태 = " + memberShipRepository);
    }

    @Test
    public void PostMemberShip() {
        // 1. given - 테스트를 준비하는 과정, 변수, 입력값등 정의, Mock 객체를 정의하는 구문도 Given에 포함
        final MemberShipEntity memberShipEntity = new MemberShipEntity().builder()
                .memberShipId("memberShipId")
                .memberShipType(MemberShipEntity.MemberShipType.NAVER)
                .point(1000)
                .build();
        // 2. when - 실제로 액션을 하는 테스트를 실행하는 과정
        final MemberShipEntity result = memberShipRepository.save(memberShipEntity);

        // 3. Then - 마지막은 테스트를 검증하는 과정
        assertThat(result.getId()).isNotNull();
        assertThat(result.getMemberShipId()).isEqualTo("userId");
        assertThat(result.getMemberShipType()).isEqualTo(MemberShipEntity.MemberShipType.NAVER);
        assertThat(result.getPoint()).isEqualTo(10000);

        System.out.println("ID: " + result.getId());
        System.out.println("MemberShipId: " + result.getMemberShipId());
        System.out.println("Expected MemberShipId: userId");
        System.out.println("Actual MemberShipId: " + result.getMemberShipId());
        System.out.println("MemberShipType: " + result.getMemberShipType());
        System.out.println("Expected MemberShipType: " + MemberShipEntity.MemberShipType.NAVER);
        System.out.println("Actual MemberShipType: " + result.getMemberShipType());
        System.out.println("Point: " + result.getPoint());
        System.out.println("Expected Point: 10000");
        System.out.println("Actual Point: " + result.getPoint());

    }



}
