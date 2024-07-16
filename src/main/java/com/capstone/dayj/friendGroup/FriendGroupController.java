package com.capstone.dayj.friendGroup;

import com.capstone.dayj.post.PostDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friend-group")
public class FriendGroupController {
    FriendGroupService friendGroupService;
    
    
    public FriendGroupController(FriendGroupService friendGroupService) {
        this.friendGroupService = friendGroupService;
    }
    
    @PostMapping
    public void createFriendGroup(@Valid @RequestBody FriendGroup friendGroup) {
        friendGroupService.createFriendGroup(friendGroup);
    }
    
    @GetMapping
    public List<FriendGroupDto.Response> readAllFriendGroup() {
        return friendGroupService.readAllFriendGroup();
    }

    @GetMapping("/{id}")
    public FriendGroupDto.Response readFriendGroupById(@PathVariable int id) { return friendGroupService.readFriendGroupById(id); }
    
    @PatchMapping("/{id}")
    public void patchFriendGroup(@PathVariable int id, @Valid @RequestBody FriendGroupDto.Request dto) {
        friendGroupService.updateFriendGroup(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteFriendGroupById(@PathVariable int id) {
        friendGroupService.deleteFriendGroupById(id);
    }
}
