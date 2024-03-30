package com.example.restfulcrud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    // Create
    public void save(User user) {
        em.persist(user);
    }

    // Update
    public void update(Long id, UserDTO userDTO) {
        User user = findById(id);
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
    }

    // Delete
    public void remove(Long id) {
        User user = findById(id);
        em.remove(user);
    }

    // Read
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public User findByName(String findName) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name = :findName", User.class);
        query.setParameter("findName", findName);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
}
