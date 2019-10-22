package com.studyonline.service.impl;

import com.studyonline.entity.User;
import com.studyonline.repository.UserRepository;
import com.studyonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
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
            if (user.isStt() == true) {
                user.setStt(false);
            } else {
                user.setStt(true);
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



    @Override
    public Page<User> findUser(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
         List<User> list;
         List<User> users = userRepository.findAll();
        if (users.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, users.size());
            list = users.subList(startItem, toIndex);
        }

        Page<User> userPage
                = new PageImpl<User>(list, PageRequest.of(currentPage, pageSize), users.size());

        return userPage;
    }
}
