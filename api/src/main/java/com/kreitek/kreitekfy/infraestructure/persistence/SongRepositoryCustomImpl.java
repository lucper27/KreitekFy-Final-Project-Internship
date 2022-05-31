package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
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
}
