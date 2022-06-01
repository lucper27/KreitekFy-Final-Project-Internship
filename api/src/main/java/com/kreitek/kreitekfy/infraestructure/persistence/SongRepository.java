package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface SongRepository  extends JpaRepository<Song,Long>, JpaSpecificationExecutor<Song>, SongRepositoryCustom {
//    Page<Song> findAllByAlbumId(Long albumId, Pageable pageable);
//    Page<Song> findAllByArtistId(Long artistId, Pageable pageable);
//    Page<Song> findAllByStyleId(Long styleId, Pageable pageable);

    @Query(value = "SELECT * FROM SONGS ORDER BY INCLUSION_DATE DESC LIMIT 5", nativeQuery = true)
    List<Song> findByDateSorted();

    List<Song> findAllNewsById(Long id);

    Song findSongById(Long id);

    List<Song> findAllWMoreReproductionsById(Long styleId);

    List<Song> findAllSongsByRating();


    List<Song> findAllSongsByRatingAndStyleSorted(Long id);


    @Query(value="SELECT SONGS.* \n" +
            "FROM SONGS \n" +
            "INNER JOIN REPRODUCTIONS ON SONGS.ID = REPRODUCTIONS.SONG_ID  \n" +
            "INNER JOIN PROFILES_SONGS  ON SONGS.ID = PROFILES_SONGS.SONG_ID\n" +
            "WHERE STYLE_ID IN ( \n" +
            "SELECT SONGS.STYLE_ID\n" +
            "FROM REPRODUCTIONS \n" +
            "INNER JOIN SONGS ON REPRODUCTIONS.SONG_ID = SONGS.ID\n" +
            "WHERE PROFILE_ID = ?1\n" +
            "GROUP BY STYLE_ID\n" +
            "ORDER BY COUNT(SONG_ID) DESC\n" +
            "LIMIT 2\n" +
            ")\n" +
            "GROUP BY REPRODUCTIONS.SONG_ID\n" +
            "HAVING AVG(PROFILES_SONGS.RATING) > 2\n" +
            "ORDER BY COUNT(REPRODUCTIONS.SONG_ID) DESC",nativeQuery = true)
    List<Song> findAllSongsRecommended(Long profileId);
}
