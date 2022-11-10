package com.exalt.resourcemanagementsystem.repository;
import com.exalt.resourcemanagementsystem.dbconfiguration.Database;
import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;

/**
 * The type User repository.
 */
public class UserRepositoryImpl implements UserRepository{

  /**
   * The Aerospike.
   */
  Database aerospike = Database.getInstance();
  @Override
  public void saveUser(UserDao user){
    aerospike.mapper.save(user);
  }
  @Override

  public UserDao getUserById(int id){
    return aerospike.mapper.read(UserDao.class, id);
  }


}
