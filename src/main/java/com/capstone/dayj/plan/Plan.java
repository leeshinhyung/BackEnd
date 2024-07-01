package com.capstone.dayj.plan;

import com.capstone.dayj.appUser.AppUser;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"appUser"})
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // @Column(nullable = false)
    private LocalDateTime planAlarmDate;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime planCreateDate;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime planUpdateDate;
    
    @Column(nullable = false)
    private LocalDateTime planTime; // 그 날 몇 시부터 몇 시까지
    @Column(nullable = false)
    private LocalDateTime planDay; // 며칠부터 며칠까지
    
    @Column(nullable = false)
    private String planTag;
    @Column(nullable = false)
    private String goal;
    private String planPhoto;
    
    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean isComplete;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean isPublic;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    
    public void update(LocalDateTime planAlarmDate, String planTag, String goal, String planPhoto, LocalDateTime planTime, LocalDateTime planDay, boolean isPublic, boolean isComplete) {
        this.planAlarmDate = planAlarmDate;
        this.planTag = planTag;
        this.goal = goal;
        this.planPhoto = planPhoto;
        this.planTime = planTime;
        this.planDay = planDay;
        this.isPublic = isPublic;
        this.isComplete = isComplete;
    }
    
    @Builder
    public Plan(int id, LocalDateTime planAlarmDate, LocalDateTime planCreateDate, LocalDateTime planUpdateDate, LocalDateTime planTime, LocalDateTime planDay, String planTag, String goal, String planPhoto, boolean isComplete, boolean isPublic, AppUser appUser) {
        this.id = id;
        this.planAlarmDate = planAlarmDate;
        this.planCreateDate = planCreateDate;
        this.planUpdateDate = planUpdateDate;
        this.planTime = planTime;
        this.planDay = planDay;
        this.planTag = planTag;
        this.goal = goal;
        this.planPhoto = planPhoto;
        this.isComplete = isComplete;
        this.isPublic = isPublic;
        this.appUser = appUser;
    }
}

