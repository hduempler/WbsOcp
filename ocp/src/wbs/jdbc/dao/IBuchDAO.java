package wbs.jdbc.dao;

import java.util.List;

public interface IBuchDAO {
	
	public void save(Buch buch) throws PersistenceException;
	public List<Buch> findAll() throws PersistenceException;

}
