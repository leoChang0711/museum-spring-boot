package tw.com.museum.collectionImg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.museum.collectionImg.domin.ColImgVo;
import tw.com.museum.collectionImg.service.ColImgServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ColImgController {

	@Autowired ColImgServiceImpl service;
	
	
	@PostMapping("/imgAdd")
	public ResponseEntity<Object> imgAdd(@RequestBody ColImgVo colImgVo) {
		System.out.println(colImgVo.getImageName()+"imgAdd");
		return new ResponseEntity<>(service.add(colImgVo), HttpStatus.OK);
	}
	
	@GetMapping("/getAllImg")
	public ResponseEntity<Object> getAllImg() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/getImgName")
	public ResponseEntity<Object> getImgName(@RequestBody ColImgVo colImgVo) {
		return new ResponseEntity<>(service.getImgName(colImgVo), HttpStatus.OK);
	}
}
