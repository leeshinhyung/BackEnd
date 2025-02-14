package com.capstone.dayj.appUser;

import com.capstone.dayj.setting.Setting;
import com.capstone.dayj.setting.SettingDto;
import lombok.*;

public class AppUserDto {
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id; //기본키
        private String name; //유저 이름
        private String nickname; // 유저 닉네임, 중복 불가, 친구 그룹 추가에 사용
        private String password; //유저 비밀번호
        private String email; //유저 구글 이메일
        private String role; //유저 권한
        private String provider; //공급자
        private String providerId; //공급 아이디
        private Setting setting;
        
        public AppUser toEntity() {
            return AppUser.builder()
                    .id(id)
                    .name(name)
                    .nickname(nickname)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .setting(setting)
                    .build();
        }
    }
    
    @Getter
    public static class Response {
        private final int id; //기본키
        private final String name; //유저 이름
        private final String nickname; // 유저 닉네임, 중복 불가, 친구 그룹 추가에 사용
        private final String password; //유저 비밀번호
        private final String email; //유저 구글 이메일
        private final String role; //유저 권한
        private final String provider; //공급자
        private final String providerId; //공급 아이디
        private final SettingDto.Response setting;
        
        public Response(AppUser appUser) {
            this.id = appUser.getId();
            this.name = appUser.getName();
            this.nickname = appUser.getNickname();
            this.password = appUser.getPassword();
            this.email = appUser.getEmail();
            this.role = appUser.getRole();
            this.provider = appUser.getProvider();
            this.providerId = appUser.getProviderId();
            this.setting = new SettingDto.Response(appUser.getSetting());
        }
        
    }
}
