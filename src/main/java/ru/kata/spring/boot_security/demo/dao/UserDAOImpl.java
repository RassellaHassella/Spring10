//package ru.kata.spring.boot_security.demo.dao;
//
//
//import org.springframework.stereotype.Repository;
//import ru.kata.spring.boot_security.demo.models.User;
//
//import javax.persistence.*;
//import java.util.List;
//
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private UserRepository userRepository;
//
//    public UserDAOImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public List<User> index() {
//        String jpql = "SELECT u FROM User u";
//        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
//
//        return query.getResultList();
//    }
//
//
//    public User findByEmail(String email) {
////        String jpql = "SELECT u FROM User u where u.email=:param1";
////        List<User> user = entityManager.createQuery(jpql, User.class)
////                .setParameter("param1", email).getResultList();
////        if (user.isEmpty()) {
////            return null;
////        }
////
////        return user.get(0);
////        {
//            if (userRepository.findByEmail(email).isEmpty()) {
//                throw new EntityNotFoundException("Пользователь не найден");
//            } else {
//                return userRepository.findByEmail(email).get();
//            }
//    }
//
//    @Override
//    public User show(Long id) {
//        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    public void save(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public void update(User updatedUser) {
//        entityManager.merge(updatedUser);
//    }
//
//
//
//
//
//    @Override
//    public void delete(Long id) {
//        User user = entityManager.find(User.class, id);
//        entityManager.remove(user);
//    }
//
//}
//
