package org.emmanuelfranco.biblio.photolist.di;

import org.emmanuelfranco.biblio.PhotoFeedAppModule;
import org.emmanuelfranco.biblio.domain.di.DomainModule;
import org.emmanuelfranco.biblio.lib.di.LibsModule;
import org.emmanuelfranco.biblio.photolist.ui.PhotoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ACE.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
