package tw.com.museum.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.museum.collection.domin.CollectionVo;
import tw.com.museum.collection.service.CollectionServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CollectionController {

	@Autowired
	private CollectionServiceImpl service;
	
	@GetMapping("/collectionAll")
	public ResponseEntity<Object> collectionAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/collectionAdd")
	public ResponseEntity<Object> collectionAdd(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.add(collection), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/collectionGetOne")
	public ResponseEntity<Object> collectionGetOne(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.findId(collection.getCollectionID()), HttpStatus.OK);
		
	}
	
	@PostMapping("/collectionGetOneName")
	public ResponseEntity<Object> collectionGetOneName(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.findName(collection.getCollectionTitle()), HttpStatus.OK);
		
	}
	
	@PostMapping("/collectionGetOneEar")
	public ResponseEntity<Object> collectionGetOneEar(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.findEar(collection.getCollectionEar()), HttpStatus.OK);
		
	}
	
	@PostMapping("/collectionGetOneMaterial")
	public ResponseEntity<Object> collectionGetOneMaterial(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.findMaterial(collection.getCollectionMaterial()), HttpStatus.OK);
		
	}
		
	@PostMapping("/collectionEdit")
	public ResponseEntity<Object> collectionEdit(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.edit(collection), HttpStatus.OK);
		
	}
	
	@PostMapping("/collectionDelete")
	public ResponseEntity<Object> collectionDelete(@RequestBody CollectionVo collection) {
		return new ResponseEntity<>(service.deleteId(collection.getCollectionID()), HttpStatus.OK);
		
	}
}
