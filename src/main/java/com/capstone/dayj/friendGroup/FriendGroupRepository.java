package com.capstone.dayj.friendGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendGroupRepository extends JpaRepository<FriendGroup, Integer> {
    Optional<FriendGroup> findByEmail(String email);
}