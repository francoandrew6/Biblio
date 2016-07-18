package org.emmanuelfranco.biblio.photolist;

import org.emmanuelfranco.biblio.entities.Photo;

/**
 * Created by ACE.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}
