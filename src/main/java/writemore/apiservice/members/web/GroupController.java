package writemore.apiservice.members.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import writemore.apiservice.members.domain.Group;
import writemore.apiservice.members.domain.service.GroupService;
import writemore.apiservice.members.util.GroupDto;
import writemore.apiservice.members.util.GroupUpdateDto;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/api/group")
    public List<Group> indexGroup(){
        return groupService.index();
    }

    @GetMapping("/api/group/{id}")
    public Group showGroup(@PathVariable Long id){
        return groupService.show(id);
    }

    @PostMapping("/api/group")
    public ResponseEntity<Group> createGroup(GroupDto dto){
        //여기서 Entity를 만들 이유가 없다!! Controller다.
        Group created = groupService.create(dto);
        return (created!=null)?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/api/group/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, GroupUpdateDto dto){
        //Dto->Entity
        //여기서 Entity를 만들 이유가 없다!! Controller다.
        Group updated = groupService.update(id,dto);
        return (updated!=null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        //find by id에 Entity

    }

    @DeleteMapping("/api/group/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Long id){
        Group deleted = groupService.delete(id);
        return (deleted!=null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
