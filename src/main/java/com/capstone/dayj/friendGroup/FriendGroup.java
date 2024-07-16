package com.capstone.dayj.friendGroup;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class FriendGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "friendGroup")
    @JsonManagedReference
    @JsonIgnore
    private List<AppUserFriendGroup> appUserFriendGroup;
    
    @Column
    private String groupGoal;
    
    @Column(nullable = false)
    private String groupName;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean groupExit;

    public void update(String groupName) {
        this.groupName = groupName;
    }

    @Builder
    public FriendGroup(int id, List<AppUserFriendGroup> appUserFriendGroup, String groupGoal, String groupName, boolean groupExit) {
        this.id = id;
        this.groupGoal = groupGoal;
        this.groupName = groupName;
        this.groupExit = groupExit;
        this.appUserFriendGroup = appUserFriendGroup;
    }
}
