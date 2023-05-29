package com.mylive.springcodingsession.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	public List<Group> retrieveAllGroups() {
		return groupRepository.findAll();
	}

	public Optional<Group> retrieveGroup(int id) {
		Optional<Group> group = groupRepository.findById(id);
		if(!group.isPresent()) {
			throw new GroupNotFoundException("Group not Found with id: "+id);
		}
		
		return group;
	}

	public ResponseEntity<Group> createGroup(Group group) {
		groupRepository.save(group);
		return new ResponseEntity<>(group, HttpStatus.CREATED);
	}
}