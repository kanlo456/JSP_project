package ict.tag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class CustomerTag extends SimpleTagSupport {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void doTag() {
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            out.print(name + "User Form");
        } catch (IOException e) {

        }
    }


}
