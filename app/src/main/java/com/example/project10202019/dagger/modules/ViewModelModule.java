package com.example.project10202019.dagger.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.example.project10202019.dagger.ViewModelFactory;
import com.example.project10202019.dagger.ViewModelKey;
import com.example.project10202019.viewModels.PostViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    protected abstract ViewModel providePostViewModel(PostViewModel postViewModel);
}
