package org.emmanuelfranco.biblio.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.emmanuelfranco.biblio.domain.FirebaseAPI;
import org.emmanuelfranco.biblio.lib.base.EventBus;
import org.emmanuelfranco.biblio.lib.base.ImageStorage;
import org.emmanuelfranco.biblio.main.MainPresenter;
import org.emmanuelfranco.biblio.main.MainPresenterImpl;
import org.emmanuelfranco.biblio.main.MainRepository;
import org.emmanuelfranco.biblio.main.MainRepositoryImpl;
import org.emmanuelfranco.biblio.main.SessionInteractor;
import org.emmanuelfranco.biblio.main.SessionInteractorImpl;
import org.emmanuelfranco.biblio.main.UploadInteractor;
import org.emmanuelfranco.biblio.main.UploadInteractorImpl;
import org.emmanuelfranco.biblio.main.ui.MainView;
import org.emmanuelfranco.biblio.main.ui.adapters.MainSectionsPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by ACE.
 */
@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(MainView view, FragmentManager fragmentManager, Fragment[] fragments, String[] titles) {
        this.view = view;
        this.titles = titles;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @Singleton
    MainView providesMainView() {
        return this.view;
    }

    @Provides @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        return new MainPresenterImpl(view, eventBus, uploadInteractor, sessionInteractor);
    }

    @Provides @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository) {
        return new UploadInteractorImpl(repository);
    }

    @Provides @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository) {
        return new SessionInteractorImpl(repository);
    }

    @Provides @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides @Singleton
    MainSectionsPagerAdapter providesAdapter(FragmentManager fm, Fragment[] fragments, String[] titles){
        return new MainSectionsPagerAdapter(fm, fragments, titles);
    }

    @Provides @Singleton
    FragmentManager providesAdapterFragmentManager(){
        return this.fragmentManager;
    }

    @Provides @Singleton
    Fragment[] providesFragmentArrayForAdapter(){
        return this.fragments;
    }

    @Provides @Singleton
    String[] providesStringArrayForAdapter(){
        return this.titles;
    }



}
