package org.emmanuelfranco.biblio.photolist.ui.adapters;

import android.widget.ImageView;

import org.emmanuelfranco.biblio.entities.Photo;

/**
 * Created by ACE.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
