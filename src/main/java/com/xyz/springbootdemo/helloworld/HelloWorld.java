package com.xyz.springbootdemo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping(path = "/hello-world")
    public String index() {
        return "Hello World\n";
    }

    @RequestMapping(path = "/path/{name}")
    public HelloWorldBean index_new(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World: %s", name));
    }
}
