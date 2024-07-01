package com.capstone.dayj.setting;


import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.appUser.AppUserRepository;
import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SettingService {
    private SettingRepository settingRepository;
    private AppUserRepository appUserRepository;

    public SettingService(SettingRepository settingRepository, AppUserRepository appUserRepository) {
        this.settingRepository = settingRepository;
        this.appUserRepository = appUserRepository;
    }

    @Transactional
    public SettingDto.Response readSettingById(int user_id) {
        AppUser appUser = appUserRepository.findById(user_id)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        return new SettingDto.Response(appUser.getSetting());
    }

    @Transactional
    public void patchSetting(int user_id, SettingDto.Request dto) {
        AppUser appUser = appUserRepository.findById(user_id)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        Setting setting = appUser.getSetting();

        setting.update(dto.isPlanAlarm(),
                dto.isFriendGroupAlarm(),
                dto.isPostAlarm(),
                dto.isAppAlarm(),
                dto.getProfilePhoto());
    }
}
