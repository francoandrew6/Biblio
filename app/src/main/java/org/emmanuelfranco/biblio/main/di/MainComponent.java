package org.emmanuelfranco.biblio.main.di;

import org.emmanuelfranco.biblio.PhotoFeedAppModule;
import org.emmanuelfranco.biblio.domain.di.DomainModule;
import org.emmanuelfranco.biblio.lib.di.LibsModule;
import org.emmanuelfranco.biblio.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ACE.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
