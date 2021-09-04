package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.DAOs.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

public class UserSpecificationsBuilder {

    public static Specification<User> hasId(Long Id) {
                return (Specification<User>) (root ,query ,cb) -> cb.equal(root.get(User_.ID),Id);
    };

    public static Specification<User> hasUsername(String username) {
        return (Specification<User>) (root ,query ,cb) -> cb.equal(root.get(User_.USERNAME),username);
    };


}
