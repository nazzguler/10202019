package com.example.project10202019;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.project10202019.dagger.ViewModelFactory;
import com.example.project10202019.models.PostObject;
import com.example.project10202019.viewModels.PostViewModel;
import java.util.ArrayList;
import javax.inject.Inject;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private PostViewModel postViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostViewModel.class);

        postViewModel.getPostMutableLiveData().observe(this, new Observer<ArrayList<PostObject>>() {
            @Override
            public void onChanged(@Nullable ArrayList<PostObject> postObjects) {
                for (PostObject postObject: postObjects) {
                    Log.d("_TAG",postObject.getTitle());
                }

            }
        });
    }
}
