package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.models.CommentEntity;
import project.models.PhotoEntity;
import project.models.UserEntity;
import project.repository.CommentRepository;
import project.repository.PhotoRepository;
import project.repository.UserRepository;

import java.util.Map;
import java.util.Optional;

@Controller("/")
public class Test {

    @Autowired
    UserRepository userRepo;
    @Autowired
    PhotoRepository photoRepo;
    @Autowired
    CommentRepository commentRepo;

    @GetMapping
    public String test(@RequestParam(required = false, defaultValue = "Guest") String name,
                       Map<String, Object> model) {

        model.put("name", "User");

        Iterable<UserEntity> users = userRepo.findAll();
        model.put("users", users);

        Iterable<PhotoEntity> photos = photoRepo.findAll();
        model.put("photos", photos);

        Iterable<CommentEntity> comments = commentRepo.findAll();
        model.put("comments", comments);

        return "index";
    }

    @PostMapping
    public String test(@RequestParam String url, @RequestParam String commentText, @RequestParam String userName,
                       Map<String, Object> model) {
        UserEntity user = new UserEntity(userName);
        PhotoEntity photo = new PhotoEntity(user, url);
        CommentEntity comment = new CommentEntity(photo, commentText);
        //  photo.getComments().add(comment);
        // comment.setPhoto(photo);

        userRepo.save(user);
        photoRepo.save(photo);
        commentRepo.save(comment);

        Iterable<UserEntity> users = userRepo.findAll();
        model.put("users", users);

        Iterable<PhotoEntity> photos = photoRepo.findAll();
        model.put("photos", photos);

        Iterable<CommentEntity> comments = commentRepo.findAll();
        model.put("comments", comments);


        return "index";
    }
}
