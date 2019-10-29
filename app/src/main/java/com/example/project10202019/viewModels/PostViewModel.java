package com.example.project10202019.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.example.project10202019.interfaces.PostApiService;
import com.example.project10202019.models.PostObject;
import com.example.project10202019.repositories.PostRepository;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import javax.inject.Inject;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {

    private PostRepository postRepository;
    private MutableLiveData<ArrayList<PostObject>> postMutableLiveData = new MutableLiveData<>();

    @Inject
    public PostViewModel(PostApiService apiService) {
        this.postRepository = new PostRepository(apiService);
        loadPosts();
    }

    public void loadPosts(){
        postRepository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ArrayList<PostObject>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ArrayList<PostObject> postObjects) {
                        getPostMutableLiveData().setValue(postObjects);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("_TAG",e.toString());
                    }
                });
    }

    public MutableLiveData<ArrayList<PostObject>> getPostMutableLiveData() {
        return postMutableLiveData;
    }


}
