package writemore.apiservice.members.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import writemore.apiservice.members.domain.Group;
import writemore.apiservice.members.domain.repository.GroupRepository;
import writemore.apiservice.members.util.GroupDto;
import writemore.apiservice.members.util.GroupUpdateDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    //왜 List가 자동으로 가능해지지?
    public List<Group> index() {
        return groupRepository.findAll();
    }

    public Group show(Long id) {
        return groupRepository.findById(id).orElse(null);
    }


    public Group create(GroupDto dto) {
        //dto -> entity
        Group created = dto.toEntity();
        if (created.getId()!=null){
            return null;
        }
        return groupRepository.save(created);
        //entity->DB

        //return
    }

    public Group update(Long id, GroupUpdateDto dto) {
        //dto -> entity
        Group group = dto.toEntity();
        //find by id
        Group target= groupRepository.findById(id).orElse(null);
        if (target==null || group.getId()!=id){
            return null;
        }
        //기존에 entity덮어씌움
        target.patch(group);
        //이게 id를 지정해놓고 DB에 쿼리를 날리게 되면, 덮어씌움!!
        Group updated = groupRepository.save(target);

        //return
        return updated;
    }

    public Group delete(Long id) {
        //find by id -> 있으면 삭제
        Group deleted = groupRepository.findById(id).orElse(null);
        if (deleted==null){
            return null;
        }
        groupRepository.delete(deleted);
        return deleted;
    }
}
