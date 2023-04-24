package com.example.jsp_project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

import com.example.jsp_project.bean.Cart;

@WebServlet(name = "addToCart", urlPatterns = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Cart> cartList = new ArrayList<>();
            String id = request.getParameter("id");
            Cart cm = new Cart();
            cm.setId(id);
            cm.setQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                out.println("session created and added the list");
            } else {
                cartList = cart_list;
                boolean exist = false;

                for (Cart c : cart_list) {
                    if (Objects.equals(c.getId(), id)) {
                        exist = true;
                        out.println("product exist");
                    }
                }
                if (!exist) {
                    cartList.add(cm);
                    out.println("product added");
                }
            }
        }

    }
}
