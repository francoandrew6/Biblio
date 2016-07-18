package org.emmanuelfranco.biblio.photolist.ui;

import org.emmanuelfranco.biblio.entities.Photo;

/**
 * Created by ykro.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
