package org.example.Repository.UserDetailsRepository;

import config.EntityManagerConfig;
import org.example.model.User;
import org.example.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository{
    private EntityManager entityManager = EntityManagerConfig.getEntityManager();
    @Override
    public UserDetails save(UserDetails u) {
        if (u.getId()!=null){
            entityManager.getTransaction().begin();
            u.setFirstName(u.getFirstName());
            u.setLastName(u.getLastName());
            u.setEmail(u.getEmail());
            u.setPhoneNumber(u.getPhoneNumber());
            entityManager.getTransaction().commit();
            System.out.println("User Details successfully updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(u);
            entityManager.getTransaction().commit();
            System.out.println("User Details successfully added");
        }
        return u;
    }

    @Override
    public Optional<UserDetails> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(UserDetails.class,id));
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> result = entityManager.createQuery("SELECT ud from UserDetails ud", UserDetails.class);
        return result.getResultList();
    }

    @Override
    public UserDetails delete(UserDetails u) {
        UserDetails userDetails = entityManager.find(UserDetails.class,u.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(userDetails);
        entityManager.getTransaction().commit();
        return userDetails;
    }
}
