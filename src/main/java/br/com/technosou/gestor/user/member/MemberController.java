package br.com.technosou.gestor.user.member;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Transactional
    @PostMapping("/new")
    public ResponseEntity<MemberResponse> save(@RequestBody @Valid MemberRequest request) {
        MemberResponse saved = memberService.save(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> findAll() {
        List<MemberResponse> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API funcionando");
    }
}
