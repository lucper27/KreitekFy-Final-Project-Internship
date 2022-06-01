package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Reproduction;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.entity.SongProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class SongRepositoryCustomImpl implements SongRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAllNewsById(Long styleId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Song> query = cb.createQuery(Song.class);
        Root<Song> song = query.from(Song.class);

        Path<Long> styleIdPath = song.get("style").get("id");
        Order inclusionDateOrder = cb.desc(song.get("inclusionDate"));

        Predicate styleIdPredicate = cb.equal(styleIdPath, styleId);
        query.select(song).where(styleIdPredicate).orderBy(inclusionDateOrder);

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }


    @Override
    public List<Song> findAllSongsByRating() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Song> query = cb.createQuery(Song.class);

        Root<SongProfile> songProfile = query.from(SongProfile.class);
        Path<Song> songPath = songProfile.get("song");
        Order ratingOrder = cb.desc(cb.avg(songProfile.get("rating")));

        query.select(songPath);
        query.groupBy(songPath.get("id"));
        query.orderBy(ratingOrder);

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }

    @Override
    public List<Song> findAllSongsByRatingAndStyleSorted(Long styleId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Song> query = cb.createQuery(Song.class);

        Root<SongProfile> songProfile = query.from(SongProfile.class);
        Path<Song> songPath = songProfile.get("song");
        Order ratingOrder = cb.desc(cb.avg(songProfile.get("rating")));

        Path<Long> styleIdPath = songPath.get("style").get("id");
        Predicate styleIdPredicate = cb.equal(styleIdPath, styleId);

        query.select(songPath);
        query.where(styleIdPredicate);
        query.groupBy(songPath.get("id"));
        query.orderBy(ratingOrder);

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }


    @Override
    public List<Song> findMoreReproduced() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Song> query = cb.createQuery(Song.class);
        Root<Reproduction> reproduction = query.from(Reproduction.class);

        Path<Song> songPath = reproduction.get("song");

        query.select(songPath);
        query.groupBy(songPath.get("id"));
        query.orderBy(cb.desc(cb.count(songPath)));

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }

    @Override
    public List<Song> findMoreReproducedByStyle(Long styleId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Song> query = cb.createQuery(Song.class);
        Root<Reproduction> reproduction = query.from(Reproduction.class);

        Path<Song> songPath = reproduction.get("song");
        Path<Long> styleIdPath = songPath.get("style").get("id");
        Predicate styleIdPredicate = cb.equal(styleIdPath, styleId);

        query.select(songPath);
        query.where(styleIdPredicate);
        query.groupBy(songPath.get("id"));
        query.orderBy(cb.desc(cb.count(songPath)));

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }


}
