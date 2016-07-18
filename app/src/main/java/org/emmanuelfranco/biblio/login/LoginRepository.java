package org.emmanuelfranco.biblio.login;

/**
 * Created by ACE.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
