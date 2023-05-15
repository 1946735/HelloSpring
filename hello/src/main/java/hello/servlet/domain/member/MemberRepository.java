package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

	private Map<Long,Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	private static final MemberRepository instance = new MemberRepository();
	
//	회원 저장소는 싱글톤 패턴을 적용했다. 스프링을 사용하면 스프링 빈으로 등록하면 되지만, 지금은 최대한
//	스프링 없이 순수 서블릿 만으로 구현하는 것이 목적이다.
//	싱글톤 패턴은 객체를 단 하나만 생생해서 공유해야 하므로 생성자를 private 접근자로 막아둔다.
	
	// MemberRepository 로만 불러올 수 있다.
	public static MemberRepository getInstance() {
		return instance;
	}
	
	
	//싱글톤 생성
	private MemberRepository() {
	}
	
	public Member save (Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	public Member findById (Long Id) {
		return store.get(Id);
	}
	
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}
	
}
