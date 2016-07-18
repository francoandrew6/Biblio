package org.emmanuelfranco.biblio.main;

import android.location.Location;

import org.emmanuelfranco.biblio.domain.FirebaseAPI;
import org.emmanuelfranco.biblio.entities.Photo;
import org.emmanuelfranco.biblio.lib.base.EventBus;
import org.emmanuelfranco.biblio.lib.base.ImageStorage;
import org.emmanuelfranco.biblio.lib.base.ImageStorageFinishedListener;
import org.emmanuelfranco.biblio.main.events.MainEvent;

import java.io.File;

/**
 * Created by ACE.
 */
public class MainRepositoryImpl implements MainRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;
    private ImageStorage imageStorage;

    public MainRepositoryImpl(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        this.eventBus = eventBus;
        this.firebase = firebase;
        this.imageStorage = imageStorage;
    }

    @Override
    public void logout() {
        firebase.logout();
    }

    @Override
    public void uploadPhoto(Location location, String path) {
        final String newPhotoId = firebase.create();
        final Photo photo = new Photo();
        photo.setId(newPhotoId);
        photo.setEmail(firebase.getAuthEmail());
        if (location != null) {
            photo.setLatitutde(location.getLatitude());
            photo.setLongitude(location.getLongitude());
        }

        post(MainEvent.UPLOAD_INIT);
        imageStorage.upload(new File(path), photo.getId(), new ImageStorageFinishedListener(){

            @Override
            public void onSuccess() {
                String url = imageStorage.getImageUrl(photo.getId());
                photo.setUrl(url);
                firebase.update(photo);

                post(MainEvent.UPLOAD_COMPLETE);
            }

            @Override
            public void onError(String error) {
                post(MainEvent.UPLOAD_ERROR, error);
            }
        });
    }

    private void post(int type){
        post(type, null);
    }

    private void post(int type, String error){
        MainEvent event = new MainEvent();
        event.setType(type);
        event.setError(error);
        eventBus.post(event);
    }
}
