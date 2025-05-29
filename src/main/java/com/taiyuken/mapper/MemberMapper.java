package com.taiyuken.mapper;

import com.taiyuken.dto.member.PopulatedMember;
import com.taiyuken.model.BoardGame;
import com.taiyuken.model.Member;
import com.taiyuken.model.VideoGame;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public PopulatedMember mapToPopulatedMember(Member member, VideoGame videoGame, BoardGame boardGame){
        PopulatedMember populatedMember = new PopulatedMember();
        populatedMember.setId(member.getId());
        populatedMember.setDescription(member.getDescription());
        populatedMember.setPlatform(member.getPlatform());
        populatedMember.setNickname(member.getNickname());
        populatedMember.setFavoriteBoardGame(boardGame);
        populatedMember.setFavoriteVideoGame(videoGame);

        return populatedMember;
    }
}
