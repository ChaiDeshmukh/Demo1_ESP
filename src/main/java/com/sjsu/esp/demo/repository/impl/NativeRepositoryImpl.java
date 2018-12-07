package com.sjsu.esp.demo.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.sjsu.esp.demo.model.Activities;
import com.sjsu.esp.demo.model.IdealWeight;
import com.sjsu.esp.demo.model.User;
import com.sjsu.esp.demo.model.UserActivity;
import com.sjsu.esp.demo.repository.NativeRepository;


public class NativeRepositoryImpl implements NativeRepository  {
	
	@Autowired
	EntityManager entityManager;
	
	public User getUserInfo(String email) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> projeto = cq.from(User.class);
		cq.where(cb.equal(projeto.get("email_id"), email));
		TypedQuery<User> query = entityManager.createQuery(cq);
	    try {
	    		return query.getSingleResult();	
	    } catch (NoResultException ex) {
	    		return null; 
	    }	    
	}
	
	public IdealWeight getIdealWeight(String height, String gender) {
		
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<IdealWeight> cq = cb.createQuery(IdealWeight.class);
	    Root<IdealWeight> projeto = cq.from(IdealWeight.class);
	    cq.select(projeto);
	    cq.where(cb.and(
	        cb.equal(projeto.get("height"), height),
	        cb.equal(projeto.get("gender"), gender)
	    ));
	    TypedQuery<IdealWeight> query = entityManager.createQuery(cq);
	    try {
	    		return query.getSingleResult();	
	    } catch (NoResultException ex) {
	    		return null; 
	    }	    
	}
	
	public List<Activities> getActivities(String muscle) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Activities> cq = cb.createQuery(Activities.class);
		Root<Activities> projeto = cq.from(Activities.class);
		cq.where(cb.equal(projeto.get("muscle"), muscle));
		TypedQuery<Activities> query = entityManager.createQuery(cq);
	    try {
	    		return query.getResultList();
	    } catch (NoResultException ex) {
	    		return null; 
	    }	   
	}
	
	public List<Activities> getAllActivities(){
		
		CriteriaQuery<Activities> criteria = entityManager.getCriteriaBuilder().createQuery(Activities.class);
	    criteria.select(criteria.from(Activities.class));
	    List<Activities> activities = entityManager.createQuery(criteria).getResultList();
	    return activities;
	}
	
	public List<UserActivity> getUserActivities(int userId) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserActivity> cq = cb.createQuery(UserActivity.class);
		Root<UserActivity> projeto = cq.from(UserActivity.class);
		cq.where(cb.equal(projeto.get("userid"), userId));
		TypedQuery<UserActivity> query = entityManager.createQuery(cq);
	    try {
	    		return query.getResultList();
	    } catch (NoResultException ex) {
	    		return null; 
	    }
	}
	
	@Override
	@Transactional 
	public int clearRecords(int userId) {
		
		CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
		CriteriaDelete<UserActivity> query = cb.createCriteriaDelete(UserActivity.class);
		Root<UserActivity> projeto = query.from(UserActivity.class);
		query.where(cb.equal(projeto.get("userid"), userId));
		return entityManager.createQuery(query).executeUpdate();
	}
}