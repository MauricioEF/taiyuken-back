package com.taiyuken.controller;

import com.taiyuken.dto.member.CreateMemberRequest;
import com.taiyuken.model.Member;
import com.taiyuken.model.VideoGame;
import com.taiyuken.response.MessageResponse;
import com.taiyuken.response.PayloadResponse;
import com.taiyuken.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController (MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllMembers(){
        List<Member> members = this.memberService.getMembers();
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",members));
    }

    @PostMapping
    public ResponseEntity<Object> createMember(@RequestBody CreateMemberRequest request){
        if(request.getNickname()==null||request.getDescription()==null||request.getPlatform()==null){
            return ResponseEntity.badRequest().body(new MessageResponse("error","Incomplete values"));
        }
        Member member = this.memberService.createMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PayloadResponse("success",member));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Object> getMemberById(@PathVariable("memberId")int memberId){
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",this.memberService.getMemberOrFail(memberId)));
    }

    @GetMapping("/{memberId}/populated")
    public ResponseEntity<Object> getPopulatedMemberById(@PathVariable("memberId")int memberId){
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("succes",this.memberService.getPopulatedMemberOrFail(memberId) ));
    }
}
