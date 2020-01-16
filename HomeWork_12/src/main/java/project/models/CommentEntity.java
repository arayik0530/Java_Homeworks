package project.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private PhotoEntity photo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    public CommentEntity(PhotoEntity photo, String comment) {
        this.photo = photo;
        this.comment = comment;
    }

    public CommentEntity() {
    }

    public Long getId () {
        return id;
    }

    private String comment;

    public void setId ( Long id ) {
        this.id = id;
    }

    public PhotoEntity getPhoto () {
        return photo;
    }

    public void setPhoto ( PhotoEntity photo ) {
        this.photo = photo;
    }

    public String getComment () {
        return comment;
    }

    public void setComment ( String comment ) {
        this.comment = comment;
    }

    public Date getCreated () {
        return created;
    }

    public void setCreated ( Date created ) {
        this.created = created;
    }

}
