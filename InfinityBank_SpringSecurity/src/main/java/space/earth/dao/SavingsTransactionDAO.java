package space.earth.dao;

import org.springframework.data.repository.CrudRepository;

import space.earth.entities.SavingsTransaction;

public interface SavingsTransactionDAO extends CrudRepository<SavingsTransaction, Integer> {

}
