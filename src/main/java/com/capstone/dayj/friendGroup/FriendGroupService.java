package com.capstone.dayj.friendGroup;

import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import com.capstone.dayj.post.Post;
import com.capstone.dayj.post.PostDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendGroupService {
    private final FriendGroupRepository friendGroupRepository;

    public void createFriendGroup(FriendGroup group) {
        friendGroupRepository.save(group);
    }

    public List<FriendGroupDto.Response> readAllFriendGroup() {
        List<FriendGroup> friendGroups = friendGroupRepository.findAll();

        if (friendGroups.isEmpty())
            throw new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND);

        return friendGroups.stream().map(FriendGroupDto.Response::new).collect(Collectors.toList());
    }

    @Transactional
    public FriendGroupDto.Response readFriendGroupByEmail(String email) {
        FriendGroup friendGroup = friendGroupRepository.findByEmail(email)
                .orElseThrow(()-> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        return new FriendGroupDto.Response(friendGroup);
    }

    @Transactional
    public FriendGroupDto.Response readFriendGroupById(int id) {
        FriendGroup friendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        return new FriendGroupDto.Response(friendGroup);
    }

    @Transactional
    public void updateFriendGroup(int id, FriendGroupDto.Request dto) {
        FriendGroup existingFriendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        existingFriendGroup.update(dto.getGroupName());
    }

    public void deleteFriendGroupById(int id) {
        friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        friendGroupRepository.deleteById(id);
    }

    @Transactional
    public void exitFriendGroup(int id) {
        FriendGroup existFriendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        existFriendGroup.exitGroup();
        friendGroupRepository.save(existFriendGroup);
    }

    @Transactional
    public String getGroupGoal(int id) {
        FriendGroup friendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        return friendGroup.getGroupGoal();
    }

    @Transactional
    public void setGroupComplete(int id, boolean isComplete) {
        FriendGroup existingFriendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        existingFriendGroup.setComplete(isComplete);
        friendGroupRepository.save(existingFriendGroup);
    }
}
