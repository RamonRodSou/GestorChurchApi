package br.com.technosou.gestor.user.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@Tag(name = "member", description = "Controler to Get, List, Update and Delete Members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Transactional
    @PostMapping
    @Operation(summary = "Save a new member", description = "Method to save members")
    @ApiResponse(responseCode = "201", description = "Sucess to save a new member")
    @ApiResponse(responseCode = "400", description = "Member already exists")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<MemberResponse> save(@RequestBody @Valid MemberRequest request) {
        MemberResponse saved = memberService.save(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    @Operation(summary = "Find members", description = "Method to list all members")
    @ApiResponse(responseCode = "201", description = "Members found")
    @ApiResponse(responseCode = "400", description = "Members not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<List<MemberResponse>> findAll() {
        List<MemberResponse> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }
}
