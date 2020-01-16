package project.models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity ( name = "users" )
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    public UserEntity(String username) {
        this.username = username;
    }

    public UserEntity() {
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public Date getCreated () {
        return created;
    }

    public void setCreated ( Date created ) {
        this.created = created;
    }
}
