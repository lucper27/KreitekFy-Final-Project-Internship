package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {AlbumMapper.class,ArtistMapper.class,StyleMapper.class})
public interface SongMapper extends EntityMapper<SongAdminDTO, Song> {

    @Override
    @Mapping(source="albumId",target = "album")
    @Mapping(source="artistId",target = "artist")
    @Mapping(source="styleId",target = "style")
    Song toEntity(SongAdminDTO dto);

    @Override
    @Mapping(source="album.title",target = "albumTitle")
    @Mapping(source="album.id",target = "albumId")
    @Mapping(source="artist.name",target = "artistName")
    @Mapping(source="artist.id",target = "artistId")
    @Mapping(source="style.name",target = "styleName")
    @Mapping(source="style.id",target = "styleId")
    SongAdminDTO toDto(Song entity);


}
