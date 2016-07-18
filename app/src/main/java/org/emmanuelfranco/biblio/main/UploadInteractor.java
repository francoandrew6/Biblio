package org.emmanuelfranco.biblio.main;

import android.location.Location;

/**
 * Created by ACE.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
