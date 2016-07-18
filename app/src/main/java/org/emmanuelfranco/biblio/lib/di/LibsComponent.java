package org.emmanuelfranco.biblio.lib.di;


import org.emmanuelfranco.biblio.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ACE.
 */
@Singleton
@Component(modules = {LibsModule.class, PhotoFeedAppModule.class})
public interface LibsComponent {
}
