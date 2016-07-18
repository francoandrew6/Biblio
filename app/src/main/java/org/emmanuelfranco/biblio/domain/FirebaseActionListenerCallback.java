package org.emmanuelfranco.biblio.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by ACE.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
