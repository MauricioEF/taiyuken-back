package com.taiyuken.service;

import com.taiyuken.dto.member.CreateMemberRequest;
import com.taiyuken.exception.MemberNotFoundException;
import com.taiyuken.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final List<Member> members = new ArrayList<>(List.of(
            new Member(1, "Yoking", "Simplemente es Yoking, (No tomar nada enserio con el), le gusta el humor negro, hace chistes malos, solo quiere divertirse :p", "Xbox y pc", 1, 3),
            new Member(2, "jefeUri", "Es hermano de Axol y Momo, es de los mas sociables de taiyuken, es un amante de los lentes y las fiestas y le gusta bailar", "pc", 3, 1)
    ));

    public List<Member> getMembers() {
        return members;
    }

    public Optional<Member> getMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Member getMemberOrFail(int id) {
        Optional<Member> optionalMember = getMemberById(id);
        if(optionalMember.isEmpty()){
            throw new MemberNotFoundException("Member not found");
        }
        return optionalMember.get();
    }

    public Member createMember(CreateMemberRequest request){
        int id = members.size()+1;
        Member member = new Member(id,request.getNickname(),request.getDescription(),request.getPlatform(),request.getFavoriteVideoGame(),request.getFavoriteBoardGame());
        members.add(member);
        return member;
    }
}
