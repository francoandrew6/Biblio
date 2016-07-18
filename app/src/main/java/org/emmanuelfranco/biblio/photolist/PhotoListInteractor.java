package org.emmanuelfranco.biblio.photolist;

import org.emmanuelfranco.biblio.entities.Photo;

/**
 * Created by ACE.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
