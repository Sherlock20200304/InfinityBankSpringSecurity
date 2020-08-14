package space.earth.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import space.earth.entities.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	

	 User findByUsername(String username);

}
