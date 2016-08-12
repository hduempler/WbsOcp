package wbs.jdbc.dao;

import java.util.List;

public interface IBuchDAO {
	
	public void save(Buch buch) throws PersistenceException;
	public void update(Buch buch) throws PersistenceException;
	public void delete(Buch buch) throws PersistenceException;
	public void delete(String isbn) throws PersistenceException;
	public List<Buch> findAll() throws PersistenceException;

}
