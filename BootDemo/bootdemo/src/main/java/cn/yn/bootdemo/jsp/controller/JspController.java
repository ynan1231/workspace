package cn.yn.bootdemo.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 引入jsp
 * 1. 引jar包
 *      <dependency>
 *             <groupId>org.apache.tomcat.embed</groupId>
 *             <artifactId>tomcat-embed-jasper</artifactId>
 *             <scope>provided</scope>
 *         </dependency>
 *         <dependency>
 *             <groupId>javax.servlet</groupId>
 *             <artifactId>jstl</artifactId>
 *         </dependency>
 *  2. 配置
 *  spring.mvc.view.prefix=/WEB-INF/jsp/
 * spring.mvc.view.suffix=.jsp
 * 3. 新建目录
 *  webapp/WEB-INF/jsp
 *  必须在webapp/WEB-INF 下,不然找不到文件
 *  4. 修改run configuration
 *  指定 working directory 到项目根目录
 * 如果是idea下 需要在build下resources配置
 *
 /*    <resource>
     <directory>src/main/webapp</directory>
     <targetPath>META-INF/resources</targetPath>
     <includes>
     <include>**//**.*</include>
    </includes>
    </resource>*/
@Controller
public class JspController {
    @RequestMapping("/jsp/index")
    public String index(Model model){
        System.out.println("------------jsp in ----------------");
        model.addAttribute("name","Tom");
        return  "index";
    }
}
