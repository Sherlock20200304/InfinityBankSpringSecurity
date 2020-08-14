package space.earth.dao;

import org.springframework.data.repository.CrudRepository;

import space.earth.entities.PrimaryAccount;

public interface PrimaryAccountDAO extends CrudRepository<PrimaryAccount, Integer> {

}
