package AudioApp.AudioNoteTaker.AudioRecording.Repository;

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


    public static Specification<AudioRecordingInfo> withTags(List<String> tags) {
        if(tags == null || tags.size()==0){
            return null;
        }

        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){

                Predicate predicate = root.join(AudioRecordingInfo_.TAGS).get(AudioTag_.NAME).in(tags);
                return predicate;

            }
        };

    }

    public static Specification<AudioRecordingInfo> withinDateRange(LocalDate start,LocalDate end) {


        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){

                Predicate lessThenEnd = cb.lessThan(root.get(AudioRecordingInfo_.CREATED_AT),end);
                Predicate greaterThenStart = cb.greaterThan(root.get(AudioRecordingInfo_.CREATED_AT),start);

                return cb.and(lessThenEnd,greaterThenStart);
            }
        };

    }

    public static Specification<AudioRecordingInfo> withName(String name){
        System.out.println(name);
        if(name==null){
            return null;
        }

        return new Specification<AudioRecordingInfo>() {

            @Override
            public Predicate toPredicate(Root<AudioRecordingInfo> root,CriteriaQuery<?> query,CriteriaBuilder cb){

                return cb.like(root.get(AudioRecordingInfo_.NAME),"%"+name+"%");
            }
        };
    }


    public static Specification<AudioRecordingInfo> hasUserId(Long UserId) {
        return (Specification<AudioRecordingInfo>) (root ,query ,cb) -> cb.equal(root.get((AudioRecordingInfo_.USER)).get("ID"),UserId);

    }

}
