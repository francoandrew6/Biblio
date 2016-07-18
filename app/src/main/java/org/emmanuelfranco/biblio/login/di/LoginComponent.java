package org.emmanuelfranco.biblio.login.di;

import org.emmanuelfranco.biblio.PhotoFeedAppModule;
import org.emmanuelfranco.biblio.domain.di.DomainModule;
import org.emmanuelfranco.biblio.lib.di.LibsModule;
import org.emmanuelfranco.biblio.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ACE.
 */
@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
