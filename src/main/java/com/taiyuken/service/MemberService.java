package com.taiyuken.service;

import com.taiyuken.dto.member.CreateMemberRequest;
import com.taiyuken.dto.member.PopulatedMember;
import com.taiyuken.exception.MemberNotFoundException;
import com.taiyuken.mapper.MemberMapper;
import com.taiyuken.model.BoardGame;
import com.taiyuken.model.Member;
import com.taiyuken.model.VideoGame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final VideoGameService videoGameService;
    private final BoardGameService boardGameService;
    private final MemberMapper memberMapper;

    private final List<Member> members = new ArrayList<>(List.of(
            new Member(1, "Yoking", "Simplemente es Yoking, (No tomar nada enserio con el), le gusta el humor negro, hace chistes malos, solo quiere divertirse :p", "Xbox y pc", 1, 3),
            new Member(2, "jefeUri", "Es hermano de Axol y Momo, es de los mas sociables de taiyuken, es un amante de los lentes y las fiestas y le gusta bailar", "pc", 3, 1),
            new Member(3, "Momo", "momo es una jugadora casual que disfruta de los juegos de granja, no le gustan los juegos violentos y constantemente intenta que Taiyuken juegue Stardew Valley con ella", "pc", 1, 3),
            new Member(4, "Dau", "Dau es un apasionado por los juegos de dificultad, es un cazador de logros, Es un programador, Cuidado si dice que es malo en algo(Es un tryhard >:3)", "pc", 1, 3),
            new Member(5, "AxolGames", "Es hermano de jefeUri y Momo, Es un tryhard en juegos campaña, le gustan las cosas referentes a la musica metal y toca la guitarra", "pc", 1, 3),
            new Member(6, "Chino", "ChinoLee, mejor conocido como Chino, es un jugador  de la primera generacion de Taiyuken. Tiene un especial interés por los juegos de automatización y es considerado el miembro más temperamental del team", "pc", 1, 3),
            new Member(7, "Yisus", "YisusFrank, Mejor conocido como Yisus, es el jugador más Nintendero de Taiyuken. Cuenta con su proyecto personal de contenido de Nintendo. Es un jugador bastante chill", "Nintendo", 1, 3),
            new Member(8, "Teacher", "teacher es un jugador de TCG y juegos de pelea, cuidado si dice que va a recostarse (se quedara dormido)", "pc, Xbox, Nintendo", 1, 3)
    ));

    public MemberService(VideoGameService videoGameService,BoardGameService boardGameService, MemberMapper memberMapper){
        this.videoGameService = videoGameService;
        this.boardGameService = boardGameService;
        this.memberMapper = memberMapper;
    }

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




    public Optional<PopulatedMember> getPopulatedMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                //si encontro al member :)
                // :u? -_-? =( "-"?  >-<?  #-# L-L  ?-? {O-o} J-J
                Optional<VideoGame> videoGame = this.videoGameService.getVideoGameById(member.getFavoriteVideoGame());
                Optional<BoardGame> boardGame = this.boardGameService.getBoardGameById(member.getFavoriteBoardGame());
                PopulatedMember populatedMember = this.memberMapper.mapToPopulatedMember(member,videoGame.get(),boardGame.get());
                return Optional.of(populatedMember);
            }
        }
        return Optional.empty();
    }






    public Member getMemberOrFail(int id) {
        Optional<Member> optionalMember = getMemberById(id);
        if (optionalMember.isEmpty()) {
            throw new MemberNotFoundException("Member not found");
        }
        return optionalMember.get();
    }


    public PopulatedMember getPopulatedMemberOrFail(int id) {
        Optional<PopulatedMember> optionalPopulatedMember = getPopulatedMemberById(id);
        if (optionalPopulatedMember.isEmpty()) {
            throw new MemberNotFoundException("Member not found");
        }
        return optionalPopulatedMember.get();
    }







    public Member createMember(CreateMemberRequest request) {
        int id = members.size() + 1;
        Member member = new Member(id, request.getNickname(), request.getDescription(), request.getPlatform(), request.getFavoriteVideoGame(), request.getFavoriteBoardGame());
        members.add(member);
        return member;
    }
}
