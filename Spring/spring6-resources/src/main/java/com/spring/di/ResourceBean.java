package com.spring.di;

import org.springframework.core.io.Resource;

/**
 * ClassName:ResourceBean
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/27 14:30
 * @Version 1.0
 */
public class ResourceBean {
    private Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }
    public Resource getResource() {
        return resource;
    }

    public void parse() {
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
    }
}
