package br.com.technosou.gestor.user.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MapperMember mapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, MapperMember mapper) {
        this.memberRepository = memberRepository;
        this.mapper = mapper;
    }

    public MemberResponse save(MemberRequest memberRequest) {
        Member member = mapper.toEntity(memberRequest);
        Member saved = memberRepository.save(member);
        return mapper.toResponse(saved);
    }

    public List<MemberResponse> findAll() {
        List<Member> members = memberRepository.findAll();
        return members
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
