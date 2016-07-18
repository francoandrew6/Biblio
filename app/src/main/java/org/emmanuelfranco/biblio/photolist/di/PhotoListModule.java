package org.emmanuelfranco.biblio.photolist.di;

import org.emmanuelfranco.biblio.domain.FirebaseAPI;
import org.emmanuelfranco.biblio.domain.Util;
import org.emmanuelfranco.biblio.entities.Photo;
import org.emmanuelfranco.biblio.lib.base.EventBus;
import org.emmanuelfranco.biblio.lib.base.ImageLoader;
import org.emmanuelfranco.biblio.photolist.PhotoListInteractor;
import org.emmanuelfranco.biblio.photolist.PhotoListInteractorImpl;
import org.emmanuelfranco.biblio.photolist.PhotoListPresenter;
import org.emmanuelfranco.biblio.photolist.PhotoListPresenterImpl;
import org.emmanuelfranco.biblio.photolist.PhotoListRepository;
import org.emmanuelfranco.biblio.photolist.PhotoListRepositoryImpl;
import org.emmanuelfranco.biblio.photolist.ui.PhotoListView;
import org.emmanuelfranco.biblio.photolist.ui.adapters.OnItemClickListener;
import org.emmanuelfranco.biblio.photolist.ui.adapters.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ACE.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }

}
