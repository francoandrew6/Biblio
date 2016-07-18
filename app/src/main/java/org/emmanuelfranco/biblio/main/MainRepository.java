package org.emmanuelfranco.biblio.main;

import android.location.Location;

/**
 * Created by ACE.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
