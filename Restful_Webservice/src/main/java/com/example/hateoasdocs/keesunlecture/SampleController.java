package com.example.hateoasdocs.keesunlecture;

import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public EntityModel<Hello> hello(){
        Hello hello = new Hello();
        hello.setPrefix("hey");
        hello.setName("jin");

        // HATEOAS
        EntityModel<Hello> resource = EntityModel.of(hello);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).hello());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }
}
