package com.example.project10202019.dagger;

import android.app.Application;
import com.example.project10202019.BaseApplication;
import com.example.project10202019.dagger.modules.ActivityModule;
import com.example.project10202019.dagger.modules.ContextModule;
import com.example.project10202019.dagger.modules.NetworkingModule;
import com.example.project10202019.dagger.modules.ViewModelModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {
        ActivityModule.class,
        NetworkingModule.class,
        ContextModule.class,
        ViewModelModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface  Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(BaseApplication baseApplication);

}

