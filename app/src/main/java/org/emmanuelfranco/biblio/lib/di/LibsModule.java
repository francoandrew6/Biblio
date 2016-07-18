package org.emmanuelfranco.biblio.lib.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import org.emmanuelfranco.biblio.lib.CloudinaryImageStorage;
import org.emmanuelfranco.biblio.lib.GlideImageLoader;
import org.emmanuelfranco.biblio.lib.GreenRobotEventBus;
import org.emmanuelfranco.biblio.lib.base.EventBus;
import org.emmanuelfranco.biblio.lib.base.ImageLoader;
import org.emmanuelfranco.biblio.lib.base.ImageStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ACE.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);
        return imageStorage;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }
}
