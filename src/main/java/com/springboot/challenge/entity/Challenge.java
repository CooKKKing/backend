package com.springboot.challenge.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.category.entity.ChallengeCategory;
import com.springboot.title.entity.Title;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Challenge extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long challengeId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int goalCount;

    @Column(nullable = false)
    private int challengeLevel; // 각 도전과제 마다 일정 횟수 달성 시 레벨을 부여함
    // 예를 들면 한식 5가지 요리로 한식 초보를 따면 한식 도전과제 레벨이 2로 올라감 (처음에는 1)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id")
    private Title title;

    @ManyToOne
    @JoinColumn(name = "challengeCategory_id")
    private ChallengeCategory challengeCategory;

    public void setChallengeCategory(ChallengeCategory challengeCategory) {
        this.challengeCategory = challengeCategory;
        if (!challengeCategory.getChallenges().contains(this)) {
            challengeCategory.setChallenge(this);
        }
    }

}
