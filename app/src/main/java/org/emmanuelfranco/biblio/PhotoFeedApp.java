package org.emmanuelfranco.biblio;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import org.emmanuelfranco.biblio.domain.di.DomainModule;
import org.emmanuelfranco.biblio.lib.di.LibsModule;
import org.emmanuelfranco.biblio.login.di.DaggerLoginComponent;
import org.emmanuelfranco.biblio.login.di.LoginComponent;
import org.emmanuelfranco.biblio.login.di.LoginModule;
import org.emmanuelfranco.biblio.login.ui.LoginView;
import org.emmanuelfranco.biblio.main.di.DaggerMainComponent;
import org.emmanuelfranco.biblio.main.di.DaggerMainComponent;
import org.emmanuelfranco.biblio.main.di.MainComponent;
import org.emmanuelfranco.biblio.main.di.MainModule;
import org.emmanuelfranco.biblio.main.ui.MainView;
import org.emmanuelfranco.biblio.photolist.di.DaggerPhotoListComponent;
import org.emmanuelfranco.biblio.photolist.di.PhotoListComponent;
import org.emmanuelfranco.biblio.photolist.di.PhotoListModule;
import org.emmanuelfranco.biblio.photolist.ui.PhotoListView;
import org.emmanuelfranco.biblio.photolist.ui.adapters.OnItemClickListener;

/**
 * Created by ACE.
 */
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";

    private LibsModule libsModule;

    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        photoFeedAppModule = new PhotoFeedAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        libsModule.setFragment(fragment);

        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();

    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[]fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .mainModule(new MainModule(view, manager, fragments, titles))
                .build();
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }
}
