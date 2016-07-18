package org.emmanuelfranco.biblio.main.ui;

/**
 * Created by ACE.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
