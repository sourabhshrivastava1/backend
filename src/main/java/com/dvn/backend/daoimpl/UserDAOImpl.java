package com.dvn.backend.daoimpl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvn.backend.dao.UserDAO;
import com.dvn.backend.model.User;






@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	
	 private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
		 
		@Autowired(required=true)
		private SessionFactory sessionFactory;


		public UserDAOImpl(SessionFactory sessionFactory) {
			try {
				this.sessionFactory = sessionFactory;
			} catch (Exception e) {
				log.error(" Unable to connect to db");
				e.printStackTrace();
			}
		}

		@Transactional
		public List<User> list() {
			 return sessionFactory.getCurrentSession().createQuery("from User").list();

		}
		
	/*	@Transactional
		public List<User> list() {
			String hql = "from User";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
*/
		@Transactional
		public boolean update(User user) {
			log.debug("->->Starting of the method update");
			try {
				sessionFactory.getCurrentSession().update(user);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Transactional
		public boolean save(User user) {
			log.debug("->->Starting of the method save");
			try {
				sessionFactory.getCurrentSession().save(user);
				log.debug("->->User is created successfully");
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
			


		@Transactional
		public boolean delete(String id)
		{
			log.debug("Starting of the method delete");
			log.debug("Trying to delte the record : " + id);
			try
			{
			
			sessionFactory.getCurrentSession().delete(get(id));
			log.debug("successfully delted the record :" + id);
			}catch(Exception e)
			{
				log.debug("record does not exist with the id " + id);
				return false;
				
			}
			log.debug("Ending of the method delete");
			return true;
		}


		@Transactional
		public User get(String id, String password) {
			log.debug("->->Starting of the method get");
			log.debug("->->id : " + id);
			log.debug("->->password : " + password);
			String hql = "from User where id=" + "'"+ id+"'  and password = "
					+"'" + password + "'";
		   return getUser(hql);
		}
		
	
		public User get(String id) {
			 User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
			 
			 return user;
		}
		
		private User getUser(String hql)
		{
			log.debug("->->Starting of the method getUser");
			log.debug("->->hql : " +hql);
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		}
		
		@Transactional
		public User authenticate(String id, String password) {
			log.debug("->->Starting of the method isValidUserDetails");
			String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
			
			log.debug("Query is : "+hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
		}




		@Transactional
		public boolean saveOrupdate(User user) {
			
			log.debug("Starting of the Save Method");
			
				try {
					sessionFactory.getCurrentSession().saveOrUpdate(user);
					log.info("id"+user.getId());
				
					log.info("address"+user.getPassword());
					
					return true;
				} catch (HibernateException e) {
					e.printStackTrace();
					log.debug("Ending of the Save Method");
					return false;
				}
			}


		public User isValidCredentials(String id, String password) {
			User user =  (User) sessionFactory.getCurrentSession().createQuery("from User where id ='"+id+"' and password = '"+password+"' ").uniqueResult();
		
		return user;

		}


		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Transactional
		public User oneuser(String id) {
			String hql = "from Users where id= " + "'" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			List<User> list = query.list();

			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
		}


		@Transactional
		public User validate(String id,String password){
			//String hql="select * from c_user_detail where id='"+id+"' and password='"+password+"'";
			String hql=" from User u " ;
					
			
		System.out.println("inside validation1");
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> users=query.list();
		for(User user : users)
		{
			System.out.println("id is "+user.getId()+"  password "+user.getPassword());
			
		}
			for(User user : users)
			{
				System.out.println("id is "+user.getId()+"  password "+user.getPassword());
				if(user.getId().equals(id) && user.getPassword().equals(password.trim()))
				{
					return user;
				}
			}
			    /*if(query.list().size()==0)
			    {
			    	System.out.println("inside validation2");
			    	return null;
			    }
			    else
			    {
			    	System.out.println("inside validation3");
			    	return (User)query.list().get(0); }
		}*/
			return null;
		}

		/*@Override
		public User login(User user)
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where userid = ? and password = ?");
			query.setString(0, user.getId()());
			query.setString(1, user.getPassword());
			//session.flush();
			//session.close();
			return (User)query.uniqueResult();
		}*/

			
	}


		
		
		



