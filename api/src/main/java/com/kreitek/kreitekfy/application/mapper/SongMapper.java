package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongAdminDTO;
import com.kreitek.kreitekfy.application.dto.SongPlayerDTO;
import com.kreitek.kreitekfy.application.dto.SongSimpleDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {AlbumMapper.class,ArtistMapper.class,StyleMapper.class})
public interface SongMapper extends EntityMapper<SongAdminDTO, Song> {

    @Override
    @Mapping(source="album.id",target = "album")
    @Mapping(source="artist.id",target = "artist")
    @Mapping(source="style.id",target = "style")
    Song toEntity(SongAdminDTO dto);

    SongSimpleDTO toSimpleDto(Song entity);

    List<SongSimpleDTO> toSimpleDto(List<Song> songs);

    default Song fromId(Long id) {
        if (id == null) return null;
        Song song = new Song();
        song.setId(id);
        return song;
    }

}
