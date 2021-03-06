package com.odabasioglu.data.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import com.odabasioglu.data.dao.TbLastvisitDAO;
import com.odabasioglu.data.dao._RootDAO;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseTbLastvisitDAO extends com.odabasioglu.data.dao._RootDAO {

	public static TbLastvisitDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static TbLastvisitDAO getInstance () {
		if (null == instance) instance = new TbLastvisitDAO();
		_RootDAO.initialize();
		return instance;
	}

	/**
	 * com.odabasioglu.data.dao._RootDAO _RootDAO.getReferenceClass()
	 */
	public Class getReferenceClass () {
		return com.odabasioglu.data.TbLastvisit.class;
	}
	
	public com.odabasioglu.data.TbLastvisit load(java.lang.Integer key)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		return (com.odabasioglu.data.TbLastvisit) load(getReferenceClass(), key);
	}

	public com.odabasioglu.data.TbLastvisit load(java.lang.Integer key, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		return (com.odabasioglu.data.TbLastvisit) load(getReferenceClass(), key, s);
	}

	public com.odabasioglu.data.TbLastvisit loadInitialize(java.lang.Integer key, Session s) 
			throws HibernateException/* net.sf.hibernate.HibernateException*/ { 
		com.odabasioglu.data.TbLastvisit obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param tbLastvisit a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.odabasioglu.data.TbLastvisit tbLastvisit)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		return (java.lang.Integer) super.save(tbLastvisit);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param tbLastvisit a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.odabasioglu.data.TbLastvisit tbLastvisit, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		return (java.lang.Integer) super.save(tbLastvisit, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param tbLastvisit a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.odabasioglu.data.TbLastvisit tbLastvisit)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.saveOrUpdate(tbLastvisit);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param tbLastvisit a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.odabasioglu.data.TbLastvisit tbLastvisit, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.saveOrUpdate(tbLastvisit, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param tbLastvisit a transient instance containing updated state
	 */
	public void update(com.odabasioglu.data.TbLastvisit tbLastvisit) 
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.update(tbLastvisit);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param tbLastvisit a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.odabasioglu.data.TbLastvisit tbLastvisit, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.update(tbLastvisit, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.delete(load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.delete(load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param tbLastvisit the instance to be removed
	 */
	public void delete(com.odabasioglu.data.TbLastvisit tbLastvisit)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.delete(tbLastvisit);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param tbLastvisit the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.odabasioglu.data.TbLastvisit tbLastvisit, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.delete(tbLastvisit, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.odabasioglu.data.TbLastvisit tbLastvisit, Session s)
		throws HibernateException/* net.sf.hibernate.HibernateException*/ {
		super.refresh(tbLastvisit, s);
	}

    public String getDefaultOrderProperty () {
		return null;
    }

}