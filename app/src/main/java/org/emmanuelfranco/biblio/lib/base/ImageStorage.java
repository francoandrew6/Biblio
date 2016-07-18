package org.emmanuelfranco.biblio.lib.base;

import java.io.File;

/**
 * Created by ACE.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
