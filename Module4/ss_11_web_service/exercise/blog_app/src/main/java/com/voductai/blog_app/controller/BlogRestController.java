//package com.voductai.blog_app.controller;
//
//import com.voductai.blog_app.model.Categorise;
//import com.voductai.blog_app.service.ICategoriseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/blog")
//public class BlogRestController {
//    @Autowired
//    private ICategoriseService categoriseService;
//    public ResponseEntity <Iterable< Categorise >> categoriseList() {
//        List< Categorise > categoriseList = (List<Categorise>)categoriseService.findAll();
//        if(categoriseList.size() ==0) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(categoriseList,HttpStatus.OK);
//    }
//}
