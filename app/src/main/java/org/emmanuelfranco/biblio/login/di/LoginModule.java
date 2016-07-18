package org.emmanuelfranco.biblio.login.di;

import org.emmanuelfranco.biblio.domain.FirebaseAPI;
import org.emmanuelfranco.biblio.lib.base.EventBus;
import org.emmanuelfranco.biblio.login.LoginInteractor;
import org.emmanuelfranco.biblio.login.LoginInteractorImpl;
import org.emmanuelfranco.biblio.login.LoginPresenter;
import org.emmanuelfranco.biblio.login.LoginPresenterImpl;
import org.emmanuelfranco.biblio.login.LoginRepository;
import org.emmanuelfranco.biblio.login.LoginRepositoryImpl;
import org.emmanuelfranco.biblio.login.SignupInteractor;
import org.emmanuelfranco.biblio.login.SignupInteractorImpl;
import org.emmanuelfranco.biblio.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ACE.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}
