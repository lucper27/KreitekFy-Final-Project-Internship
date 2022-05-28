package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Album;

import java.util.List;

public interface AlbumPersistence {

    List<Album> getAlbumsByName(String partialName);
}
