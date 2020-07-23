package cn.yn.bootdemo.freemark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
             *1.引入jar
             * <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-freemarker</artifactId>
 *         </dependency>
 *        2. 修改配置
 *        当前版本默认后缀是.ftlh,如果是ftl文件需要修改.
 *        默认加载路径是 templates下
 *
 */
@Controller
public class FreemarkController {
@RequestMapping("/freemark/hi")
    public String hello(Model model) {
    System.out.println("----------freeMark in-----------");
      model.addAttribute("name","Jreeyd大官人");
     return "hello";
    }
}
