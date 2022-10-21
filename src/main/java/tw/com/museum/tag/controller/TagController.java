package tw.com.museum.tag.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.museum.collection.domin.CollectionVo;
import tw.com.museum.tag.domin.TagVo;
import tw.com.museum.tag.service.TagServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TagController {
	@Autowired
	private TagServiceImpl service;
	
	@GetMapping("/tagAll")
	public ResponseEntity<Object> tagAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/tagAdd")
	public ResponseEntity<Object> tagAdd(@RequestBody TagVo tag) {
		return new ResponseEntity<>(service.addTag(tag), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/tagEdit")
	public ResponseEntity<Object> tagEdit(@RequestBody TagVo tag) {
	System.out.println(tag);
		return new ResponseEntity<>(service.editTag(tag), HttpStatus.OK);
		
	}
	@GetMapping("/tagDelete/{tagId}")
	public ResponseEntity<Object> tagDelete(@PathVariable Integer tagId) {
		
		
		return new ResponseEntity<>(service.deleteId(tagId), HttpStatus.OK);
		
	}

}
