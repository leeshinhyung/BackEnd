package com.capstone.dayj.comment;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

public class CommentDto {
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id;
        private int parentId;
        private String content;
        private boolean commentIsAnonymous;
        private AppUser appUser;
        private Post post;
        
        public Comment toEntity() {
            return Comment.builder()
                    .id(id)
                    .parentId(parentId)
                    .content(content)
                    .commentIsAnonymous(commentIsAnonymous)
                    .appUser(appUser)
                    .post(post)
                    .build();
        }
    }
    
    @Getter
    public static class Response {
        private final int id;
        private final int parentId;
        private final String content;
        private final boolean commentIsAnonymous;
        private final String author;
        
        public Response(Comment comment) {
            this.id = comment.getId();
            this.parentId = comment.getParentId();
            this.content = comment.getContent();
            this.commentIsAnonymous = comment.isCommentIsAnonymous();
            this.author = comment.getAppUser().getNickname();
        }
    }
}
