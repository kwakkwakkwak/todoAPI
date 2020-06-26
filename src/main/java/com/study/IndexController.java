package com.study;

import com.study.domain.member.Member;
import com.study.domain.member.MemberRepository;
import com.study.domain.todo.Todo;
import com.study.domain.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    MemberRepository memberRepository;

    @PostMapping(value = "/findAll")
    public List<Todo> findAll(@RequestBody Member member)    {
        System.out.println("into findAll" + member);
        return todoRepository.findALLBySeq(member.getSeq());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Todo> insert(@RequestBody Todo todo  ){
        System.out.println(todo);
        try {
                todoRepository.save(todo);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return todoRepository.findALLBySeq(todo.getMember().getSeq());

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public List<Todo> delete(@RequestBody Todo todo){
        System.out.println(todo);

        try {
            todoRepository.delete(todo);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return todoRepository.findALLBySeq(todo.getMember().getSeq());
    }
    @RequestMapping(value = "member/delete", method = RequestMethod.DELETE)
    public Integer deleteMember(@RequestBody Member member){
        System.out.println(member);
        try{
            memberRepository.delete(member);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    @GetMapping(value = "member/save")
    public Integer saveMember(){
        Member member = new Member();
        String id = "kwak";
        member.setId(id);
        member.setPassword(id);
        try{
            memberRepository.save(member);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
