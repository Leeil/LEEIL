package com.study.server.Lee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class LeeApplication {
    @RequestMapping("/")
    public @ResponseBody String root_test()throws Exception{
        return "study server Lee Page";
    }
 
    @RequestMapping("/demo")
    public @ResponseBody String demo_test()throws Exception{
        return "이일경 페이지에 접속했습니다.";
    }
}
