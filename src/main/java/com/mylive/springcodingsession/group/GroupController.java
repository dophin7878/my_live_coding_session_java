package com.mylive.springcodingsession.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {
	
	@Autowired
    GroupService groupService;
	
	@GetMapping("/groups")
	public List<Group> retrieveAllGroups() {
		return groupService.retrieveAllGroups();
	}
	
	@GetMapping("/group/{id}")
	public Optional<Group> retrieveGroup(@PathVariable("id") int id) {
		return groupService.retrieveGroup(id);
	}

	@PostMapping("/group")
	public ResponseEntity<Group> createGroup(@RequestBody Group group) {
		return groupService.createGroup(group);
	}
}