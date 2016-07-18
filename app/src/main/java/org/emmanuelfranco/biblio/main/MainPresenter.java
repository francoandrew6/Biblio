package org.emmanuelfranco.biblio.main;

import android.location.Location;

import org.emmanuelfranco.biblio.main.events.MainEvent;

/**
 * Created by ACE.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
