package com.study;

import com.study.domain.Todo;
import com.study.domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/findAll")
    public List<Todo> findAll() {

        return todoRepository.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object insert(@RequestBody Todo todo){
        try {
            todoRepository.save(todo);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return todoRepository.findAll();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(@RequestBody Todo todo){
        try {
            todoRepository.delete(todo);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

        return todoRepository.findAll();
    }

//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public Object update(@RequestBody Todo todo){
//        System.out.println(todo);
//        try {
//            todoRepository.save(todo);
//        }catch (Exception e){
//            e.printStackTrace();
//            return -1;
//        }
//
//        return todoRepository.findAll();
//    }
}
