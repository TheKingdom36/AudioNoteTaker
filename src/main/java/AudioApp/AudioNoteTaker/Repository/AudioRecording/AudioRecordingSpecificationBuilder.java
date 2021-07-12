package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Entities.Tag;
import AudioApp.AudioNoteTaker.Entities.User;
import org.apache.tomcat.jni.Local;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;

public class AudioRecordingSpecificationBuilder {
    @Autowired
    CriteriaBuilder criteriaBuilder;





    public static Specification<AudioRecordingInfo> withTags(List<String> tags) {
        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){


                Join<AudioRecordingInfo,Tag> groupJoin = root.join("tags");

                Expression<String> expression = groupJoin.get("name");

                Predicate predicate = expression.in(tags);

                return predicate;

            }
        };

    }

    public static Specification<AudioRecordingInfo>  withDateRange(LocalDateTime start, LocalDateTime end) {
        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){

                Predicate lessThenEnd = cb.lessThan(root.get("dateRecorded"),end);
                Predicate greaterThenStart = cb.greaterThan(root.get("dateRecorded"),start);

                return cb.and(lessThenEnd,greaterThenStart);
            }
        };

    }



}
