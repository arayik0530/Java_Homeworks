import project.models.CommentEntity;
import project.models.PhotoEntity;
import project.models.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    private SessionFactory sessionFactory;

    public static void main(String[] args) {

        Main m = new Main();
        m.setUp();

        Session ses = m.sessionFactory.getCurrentSession();
        ses.getTransaction().begin();
        UserEntity user = m.addUser ( "Arayik" );
        CommentEntity comment = m.addComment ( "Hello World" );
        PhotoEntity photo = m.addPhoto ( "web.am", comment );
        photo.setUser(user);
        photo.getComments().add(comment);
        comment.setPhoto(photo);
        ses.save ( user );
        ses.save ( photo );
        ses.save ( comment );
        ses.getTransaction().commit();
    }

    private UserEntity addUser (String name) {
        UserEntity user = new UserEntity();
        user.setUsername(name);
        return user;
    }

    private PhotoEntity addPhoto ( String url, CommentEntity comment ) {
        PhotoEntity photo = new PhotoEntity ();
        photo.getComments ().add ( comment );
        photo.setUrl ( url );
        return photo;
    }

    private CommentEntity addComment ( String commentContent ) {
        CommentEntity comment = new CommentEntity ();
        comment.setComment ( commentContent );
        return comment;
    }
    private  void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        MetadataSources sources = new MetadataSources(registry);
        sources.addPackage("project/models");
        sources.addAnnotatedClass( UserEntity.class);
        sources.addAnnotatedClass( PhotoEntity.class);
        sources.addAnnotatedClass( CommentEntity.class);

        Metadata metadata = sources.buildMetadata();


        try {
            sessionFactory = metadata.buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
