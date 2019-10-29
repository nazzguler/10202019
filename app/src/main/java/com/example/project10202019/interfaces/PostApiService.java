package com.example.project10202019.interfaces;

import com.example.project10202019.models.PostObject;
import java.util.ArrayList;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface PostApiService {

    @GET("posts")
    Single<ArrayList<PostObject>> getPosts();
}
