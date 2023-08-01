package app.it_bootcamp.test_task.dao;

import app.it_bootcamp.test_task.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    <S extends User> S save(S entity);

    Page<User> findAll(Pageable pageable);
}
