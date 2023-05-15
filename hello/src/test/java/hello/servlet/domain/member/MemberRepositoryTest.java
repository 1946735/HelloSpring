package hello.servlet.domain.member;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
	
	MemberRepository memberRepository = MemberRepository.getInstance();
	
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		//given 주어졌을 때
		Member member = new Member("hello",20);
		
		//when 이걸 실행했을 때
		Member savedMember = memberRepository.save(member);
		
		//then 결과가 이거여야 돼		
		Member findMember = memberRepository.findById(savedMember.getId());
		Assertions.assertThat(findMember).isEqualTo(savedMember); 
	}
	
	//모든걸 조회하는 Test
	@Test 
	void findAll() {
		//given 주어졌을 때
		Member member1 = new Member("spring", 20);
		Member member2 = new Member("spring2", 22);
		
		memberRepository.save(member1);
		memberRepository.save(member2);
		
		//when 이걸 실행했을 때
		List<Member> result = memberRepository.findAll();
		
		//then 결과가 이거여야 돼	
		Assertions.assertThat(result.size()).isEqualTo(2);
		Assertions.assertThat(result).contains(member1,member2);
		
	}
	
}

