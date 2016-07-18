package org.emmanuelfranco.biblio.domain.di;

import org.emmanuelfranco.biblio.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ACE.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {
}
