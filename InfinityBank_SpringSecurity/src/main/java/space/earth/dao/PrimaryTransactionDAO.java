package space.earth.dao;

import org.springframework.data.repository.CrudRepository;

import space.earth.entities.PrimaryTransaction;

public interface PrimaryTransactionDAO extends CrudRepository<PrimaryTransaction,Integer> {

}
