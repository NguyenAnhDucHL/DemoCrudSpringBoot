package com.studyonline.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyonline.entity.User;
import com.studyonline.repository.UserRepository;
import com.studyonline.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManagerFactory emf;
    
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

	@Override
	public User blockUser(int id) {
		EntityManager em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);
        EntityTransaction entityTransaction = em.getTransaction();
        User user = null;
        
        try {
			entityTransaction.begin();
			user = em.find(User.class, id);
			if(user != null) {
				user.setStt(false);
			}
			em.merge(user);
			
			entityTransaction.commit();
		} catch (Exception e) {
			if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
            user = null;
		} finally {
			em.close();
		}
        return user;
	}
}
