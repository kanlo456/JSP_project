package com.example.jsp_project.tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class ManagementText extends SimpleTagSupport {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void doTag() throws JspException, IOException {
        getJspContext().getOut().println( name + "User Form");
    }

}
