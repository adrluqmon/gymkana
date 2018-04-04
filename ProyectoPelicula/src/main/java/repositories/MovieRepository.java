package repositories;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.repository.CrudRepository;

import domain.Movie;

@Transactional
public interface MovieRepository extends CrudRepository<Movie, Integer> {


}
