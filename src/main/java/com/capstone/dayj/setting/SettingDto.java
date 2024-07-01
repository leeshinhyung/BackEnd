package com.capstone.dayj.setting;

import com.capstone.dayj.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

public class SettingDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id;
        private boolean planAlarm;
        private boolean friendGroupAlarm;
        private boolean postAlarm;
        private boolean appAlarm;
        private String profilePhoto;
        private AppUser appUser;

        public Setting toEntity() {
            return Setting.builder()
                    .id(id)
                    .planAlarm(planAlarm)
                    .friendGroupAlarm(friendGroupAlarm)
                    .postAlarm(postAlarm)
                    .appAlarm(appAlarm)
                    .profilePhoto(profilePhoto)
                    .appUser(appUser)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final int id;
        private final boolean planAlarm;
        private final boolean friendGroupAlarm;
        private final boolean postAlarm;
        private final boolean appAlarm;
        private final String profilePhoto;
        @JsonIgnore
        private final AppUser appUser;

        public Response(Setting setting) {
            this.id = setting.getId();
            this.planAlarm = setting.isPlanAlarm();
            this.friendGroupAlarm = setting.isFriendGroupAlarm();
            this.postAlarm = setting.isPostAlarm();
            this.appAlarm = setting.isAppAlarm();
            this.profilePhoto = setting.getProfilePhoto();
            this.appUser = setting.getAppUser();
        }

    }
}
