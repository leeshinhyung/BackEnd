package com.capstone.dayj.setting;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app-user/{user_id}/setting")
public class SettingController {
    private SettingService settingService;

    public SettingController(SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping
    public SettingDto.Response readSettingForUser(@PathVariable int user_id) {
        return settingService.readSettingById(user_id);
    }

    @PatchMapping
    public void patchSetting(@PathVariable int user_id, @RequestBody SettingDto.Request dto) {
        settingService.patchSetting(user_id, dto);
    }
}