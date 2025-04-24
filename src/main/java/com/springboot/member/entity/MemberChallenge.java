package com.springboot.member.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.challenge.entity.Challenge;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MemberChallenge extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberChallengeId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChallengeStatus challengeStatus = ChallengeStatus.INCOMPLETE;

    public void setMember(Member member) {
        this.member = member;
        if (!member.getMemberChallenges().contains(this)) {
            member.setMemberChallenge(this);
        }
    }

    public enum ChallengeStatus {
        COMPLETE("도전과제 달성"),
        INCOMPLETE("도전과제 미달성");

        @Getter
        private String status;

        ChallengeStatus(String status) {
            this.status = status;
        }
    }
}
