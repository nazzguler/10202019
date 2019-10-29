package com.example.project10202019.repositories;

import com.example.project10202019.interfaces.PostApiService;
import com.example.project10202019.models.PostObject;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;

@Singleton
public class PostRepository {

    private PostApiService postApiService;

    @Inject
    public PostRepository(PostApiService postApiService) {
        this.postApiService = postApiService;
    }

    public Single<ArrayList<PostObject>> getPosts(){ return postApiService.getPosts();}
}
