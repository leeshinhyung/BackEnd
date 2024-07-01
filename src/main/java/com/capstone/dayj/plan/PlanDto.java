package com.capstone.dayj.plan;

import com.capstone.dayj.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

public class PlanDto {
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id;
        private LocalDateTime planAlarmDate;
        private LocalDateTime planCreateDate;
        private LocalDateTime planUpdateDate;
        private LocalDateTime planTime;
        private LocalDateTime planDay;
        private String planPhoto;
        private String planTag;
        private String goal;
        private boolean isComplete;
        private boolean isPublic;
        private AppUser appUser;
        
        public Plan toEntity() {
            return Plan.builder()
                    .id(id)
                    .planAlarmDate(planAlarmDate)
                    .planCreateDate(planCreateDate)
                    .planUpdateDate(planUpdateDate)
                    .planTime(planTime)
                    .planDay(planDay)
                    .planPhoto(planPhoto)
                    .planTag(planTag)
                    .goal(goal)
                    .isComplete(isComplete)
                    .isPublic(isPublic)
                    .appUser(appUser)
                    .build();
        }
    }
    
    @Getter
    public static class Response {
        private final int id;
        private final LocalDateTime planAlarmDate;
        private final LocalDateTime planCreateDate;
        private final LocalDateTime planUpdateDate;
        private final LocalDateTime planTime;
        private final LocalDateTime planDay;
        private final String planPhoto;
        private final String planTag;
        private final String goal;
        private final boolean isComplete;
        private final boolean isPublic;
        @JsonIgnore
        private final AppUser appUser;
        
        /* Entity -> Dto */
        public Response(Plan plan) {
            this.id = plan.getId();
            this.planAlarmDate = plan.getPlanAlarmDate();
            this.planCreateDate = plan.getPlanCreateDate();
            this.planUpdateDate = plan.getPlanUpdateDate();
            this.planTime = plan.getPlanTime();
            this.planDay = plan.getPlanDay();
            this.planTag = plan.getPlanTag();
            this.planPhoto = plan.getPlanPhoto();
            this.goal = plan.getGoal();
            this.isComplete = plan.isComplete();
            this.isPublic = plan.isPublic();
            this.appUser = plan.getAppUser();
        }
    }
}
