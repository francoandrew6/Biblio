package org.emmanuelfranco.biblio.lib.base;

/**
 * Created by ACE.
 */
public interface ImageStorageFinishedListener {
    void onSuccess();
    void onError(String error);
}
