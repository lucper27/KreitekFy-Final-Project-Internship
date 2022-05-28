package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.mapper.AlbumMapper;
import com.kreitek.kreitekfy.application.service.AlbumService;
import com.kreitek.kreitekfy.domain.entity.Album;
import com.kreitek.kreitekfy.domain.persistence.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumPersistence albumPersistence;

    private final AlbumMapper albumMapper;
    @Autowired
    public AlbumServiceImpl(AlbumPersistence albumPersistence, AlbumMapper albumMapper) {
        this.albumPersistence = albumPersistence;
        this.albumMapper = albumMapper;
    }

    @Override
    public List<AlbumDTO> getAlbumsByName(String partialName) {
        List<Album> albums = this.albumPersistence.getAlbumsByName(partialName);
        return this.albumMapper.toDto(albums);
    }
}
