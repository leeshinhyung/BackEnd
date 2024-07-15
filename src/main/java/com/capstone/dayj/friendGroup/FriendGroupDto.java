package com.capstone.dayj.friendGroup;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import lombok.*;

import java.util.List;

public class FriendGroupDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private int id;
        private String email;
        private String groupGoal;
        private String groupName;
        private boolean groupExit;
        private boolean isComplete;

        public FriendGroup toEntity(){
            return FriendGroup.builder()
                    .id(id)
                    .email(email)
                    .groupGoal(groupGoal)
                    .groupName(groupName)
                    .groupExit(groupExit)
                    .isComplete(isComplete)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final int id;
        private final String email;
        private final String groupGoal;
        private final String groupName;
        private final boolean groupExit;
        private final boolean isComplete;
        private final List<AppUserFriendGroup> appUserFriendGroup;

        public Response(FriendGroup friendGroup){
            this.id = friendGroup.getId();
            this.email = friendGroup.getEmail();
            this.groupGoal = friendGroup.getGroupGoal();
            this.groupName = friendGroup.getGroupName();
            this.groupExit = friendGroup.isGroupExit();
            this.isComplete = friendGroup.isComplete();
            this.appUserFriendGroup = friendGroup.getAppUserFriendGroup();
        }

    }
}

