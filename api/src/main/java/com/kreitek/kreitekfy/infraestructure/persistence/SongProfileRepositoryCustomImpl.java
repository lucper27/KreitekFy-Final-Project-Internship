package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Profile;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.entity.SongProfile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

public class SongProfileRepositoryCustomImpl implements SongProfileRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAllSongsByRating() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Song> query = cb.createQuery(Song.class);

        Root<SongProfile> songProfile = query.from(SongProfile.class);
        Path<Song> songPath = songProfile.get("song");
        Order ratingOrder = cb.desc(cb.avg(songProfile.get("ratings")));

        query.select(songPath);
        query.groupBy(songPath.get("id"));
        query.orderBy(ratingOrder);

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }

//    @Override
//    public List<Song> findAllSongsByRatingAndStyleId(Long id) {
//        public List<Song> findAllSongsByRatingAndStyleId (Long styleId){
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Song> query = cb.createQuery(Song.class);
//            Root<Song> song = query.from(Song.class);
//
//            Path<Long> styleIdPath = song.get("style").get("id");
//            Order inclusionDateOrder = cb.desc(song.get("inclusionDate"));
//
//            Predicate styleIdPredicate = cb.equal(styleIdPath, styleId);
//
//            query.select(song).where(styleIdPredicate).orderBy(inclusionDateOrder);
//
//            return entityManager.createQuery(query).setMaxResults(5).getResultList();
//        }
//    }

}