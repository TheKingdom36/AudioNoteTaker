package AudioApp.AudioNoteTaker.Repository.AudioRecording;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo_;
import AudioApp.AudioNoteTaker.DAOs.Tag_;
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

                Predicate predicate = root.join(AudioRecordingInfo_.tags).get(Tag_.name).in(tags);
                //EntityType<AudioRecordingInfo> AudioRecordingInfo_ = root.getModel();

                //((CriteriaQuery<AudioRecordingInfo>)query).select(root.join("tags")).where();
                //query.
                /*
                Join<AudioRecordingInfo,Tag> groupJoin = root.join("tags");

                Expression<String> expression = groupJoin.get("name");

                Predicate predicate = expression.in(tags);
*/
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



}
