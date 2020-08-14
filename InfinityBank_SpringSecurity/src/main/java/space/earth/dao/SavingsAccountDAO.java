package space.earth.dao;

import org.springframework.data.repository.CrudRepository;

import space.earth.entities.SavingsAccount;

public interface SavingsAccountDAO extends CrudRepository<SavingsAccount, Integer> {

}
