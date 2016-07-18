package org.emmanuelfranco.biblio.photolist;

import org.emmanuelfranco.biblio.entities.Photo;
import org.emmanuelfranco.biblio.photolist.events.PhotoListEvent;

/**
 * Created by ACE.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
