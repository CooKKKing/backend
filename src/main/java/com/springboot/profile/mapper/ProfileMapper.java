package com.springboot.profile.mapper;

import com.springboot.member.entity.Member;
import com.springboot.member.entity.MemberProfileImage;
import com.springboot.profile.dto.ProfileDto;
import com.springboot.profile.entity.ProfileImage;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileDto.Response ProfileImageToProfileResponseDto(ProfileImage profileImage);
    List<ProfileDto.Response> ProfileImageToProfileDtoList(List<ProfileImage> profileImage);
    default MemberProfileImage profileDtoToMemberProfileImage(ProfileDto.PurchaseRequest profileDto) {
        MemberProfileImage memberProfileImage = new MemberProfileImage();
        Member member = new Member();
        member.setMemberId(profileDto.getMemberId());
        memberProfileImage.setMember(member);
        ProfileImage profileImage = new ProfileImage();
        profileImage.setProfileImageId(profileDto.getProfileId());
        memberProfileImage.setProfileImage(profileImage);

        return memberProfileImage;
    }

    default List<ProfileDto.OwnershipResponse> profileImagesToOwnershipDtos(List<ProfileImage> profileImages, long memberId) {
        return profileImages.stream().map(profileImage -> {
            ProfileDto.OwnershipResponse response = new ProfileDto.OwnershipResponse();
            response.setProfileId(profileImage.getProfileImageId());
            response.setImagePath(profileImage.getImagePath());
            response.setPrice(profileImage.getPrice());
            boolean isOwned = profileImage.getMemberProfileImages().stream()
                    .anyMatch(mpi -> mpi.getMember().getMemberId() == memberId);
            response.setOwned(isOwned);
            return response;
        }).collect(Collectors.toList());
    }

}