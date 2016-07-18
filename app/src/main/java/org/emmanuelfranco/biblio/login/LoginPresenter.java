package org.emmanuelfranco.biblio.login;

import org.emmanuelfranco.biblio.login.events.LoginEvent;

/**
 * Created by ACE.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
