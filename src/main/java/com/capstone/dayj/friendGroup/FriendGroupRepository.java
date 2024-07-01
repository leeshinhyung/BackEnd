package com.capstone.dayj.friendGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendGroupRepository extends JpaRepository<FriendGroup, Integer> {
}
