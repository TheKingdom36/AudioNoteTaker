package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo_;
import AudioApp.AudioNoteTaker.DAOs.AudioTag_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class AudioRecordingSpecificationBuilder {
    @Autowired
    CriteriaBuilder criteriaBuilder;





    public static Specification<AudioRecordingInfo> hasTags(List<String> tags) {
        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){

                Predicate predicate = root.join(AudioRecordingInfo_.audioTags).get(AudioTag_.name).in(tags);
                return predicate;

            }
        };

    }

    public static Specification<AudioRecordingInfo> withinDateRange(LocalDate start,LocalDate end) {
        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){

                Predicate lessThenEnd = cb.lessThan(root.get(AudioRecordingInfo_.DATE_RECORDED),end);
                Predicate greaterThenStart = cb.greaterThan(root.get(AudioRecordingInfo_.DATE_RECORDED),start);

                return cb.and(lessThenEnd,greaterThenStart);
            }
        };

    }


    public static Specification<AudioRecordingInfo> hasUserId(Long UserId) {
        return (Specification<AudioRecordingInfo>) (root ,query ,cb) -> cb.equal(root.get(AudioRecordingInfo_.ID),UserId);

    }

}
