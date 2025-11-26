package org.rosicleidefranca.todosimples.repositories;

import org.rosicleidefranca.todosimples.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<User, Long> {
}
