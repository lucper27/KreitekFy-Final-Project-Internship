package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;

import java.util.List;

public interface AlbumService {

    List<AlbumDTO> getAlbumsByName(String partialName);
}
