package AudioApp.AudioNoteTaker.Repository.User;

import AudioApp.AudioNoteTaker.Entities.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

public class UserSpecifications {

    public static Specification<User> customerHasBirthday() {
        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root,CriteriaQuery<?> query,CriteriaBuilder cb){
                return null;
            }
        };


    }

}
