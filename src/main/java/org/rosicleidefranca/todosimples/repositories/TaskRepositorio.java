package org.rosicleidefranca.todosimples.repositories;

import org.rosicleidefranca.todosimples.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepositorio extends JpaRepository<Task, Long> {
       // List<Task> findByUser_id(Long userId);
 //  @Query(value  = "SELECT t FROM Task  t WHERE t.user.id = : id")
  //  List<Task> findByUser_id(@Param("id") Long id);
   // @Query(value = SELECT * fROM task t WHERE t.user_id = :id", nativeQuerey = true)
  //  List<Task> findByUser(@Param("id") Long id);


}
