package project.models;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name = "photos")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "photo")
    private List<CommentEntity> comments = new ArrayList<> ();

    @Column(name = "photo_url")
    private String url;

    public PhotoEntity(UserEntity user, String url) {
        this.user = user;
        this.url = url;
    }

    public PhotoEntity() {
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public UserEntity getUser () {
        return user;
    }

    public void setUser ( UserEntity user ) {
        this.user = user;
    }


    public String getUrl () {
        return url;
    }

    public void setUrl ( String url ) {
        this.url = url;
    }

    public List<CommentEntity> getComments () {
        return comments;
    }

    public void setComments ( List<CommentEntity> comments ) {
        this.comments = comments;
    }
}
