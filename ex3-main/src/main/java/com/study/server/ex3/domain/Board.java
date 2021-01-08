package com.study.server.ex3.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;
    @Column(nullable = false, length = 10)
    private String title;
    @Column(nullable = false, length = 5000)
    private String content;

    private String type;
    @Column(nullable = false, length = 255)

    @CreationTimestamp
    private LocalDateTime created_date;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addComments(Comment comment) {
        this.comments.add(comment);
        if (comment.getBoard() != this) {
            comment.setBoard(this);
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", type='" +type+'\''+
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


}
