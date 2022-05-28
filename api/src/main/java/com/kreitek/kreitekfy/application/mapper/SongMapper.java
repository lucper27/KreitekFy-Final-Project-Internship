package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongSimpleDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {AlbumMapper.class,ArtistMapper.class,StyleMapper.class})
public interface SongMapper extends EntityMapper<SongAdminDTO, Song> {

    @Override
    @Mapping(source="album.id",target = "album")
    @Mapping(source="artist.id",target = "artist")
    @Mapping(source="style.id",target = "style")
    Song toEntity(SongAdminDTO dto);


//    @Mapping(source="album.id",target = "album")
//    @Mapping(source="artist.id",target = "artist")
//    @Mapping(target="style",ignore = true)
//    @Mapping(target="duration", ignore = true)
//    @Mapping(target="inclusionDate", ignore = true)
//    Song toEntity(SongSimpleDTO dto);


//    @Override
//    @Mapping(source="album.id",target = "album")
//    @Mapping(source="artist.id",target = "artist")
//    @Mapping(source="style.id",target = "style")
//    SongAdminDTO toDto(Song entity);

    SongSimpleDTO toSimpleDto(Song entity);




}
