package AudioApp.AudioNoteTaker.User.Repository;

import AudioApp.AudioNoteTaker.DAOs.*;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecificationsBuilder {

    public static Specification<User> hasId(Long Id) {
                return (Specification<User>) (root ,query ,cb) -> cb.equal(root.get(User_.ID),Id);
    };

    public static Specification<User> hasUsername(String username) {
        return (Specification<User>) (root ,query ,cb) -> cb.equal(root.get(User_.USERNAME),username);
    };


}
