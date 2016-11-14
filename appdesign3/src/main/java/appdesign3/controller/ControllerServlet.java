package appdesign3.controller;

import java.io.IOException;
import java.util.List;

import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

import appdesign3.form.ProductForm;
import appdesign3.model.Product;
import appdesign3.action.SaveProductAction;
import appdesign3.validator.ProductValidator;

@WebServlet(name="ControllerServlet", urlPatterns = { "/input-product", "/save-product" })
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1579L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");

        String action = uri.substring(lastIndex + 1);
        String dispatchUrl = null;

        if("input-product".equals(action)) {
            dispatchUrl = "/jsp/ProductForm.jsp";
        } else if("save-product".equals(action)) {
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            ProductValidator productValidator = new ProductValidator();
            List<String> errors = productValidator.validate(productForm);
            if(errors.isEmpty()) {

                Product product = new Product();
                product.setName(productForm.getName());
                product.setDescription(productForm.getDescription());
                product.setPrice(new BigDecimal(productForm.getPrice()));

                //excecute action method
                SaveProductAction saveProductAction = new SaveProductAction();
                saveProductAction.save(product);

                request.setAttribute("product", product);
                dispatchUrl = "/jsp/ProductDetails.jsp";
            } else {
                request.setAttribute("errors", errors);
                request.setAttribute("form", productForm);
                dispatchUrl = "/jsp/ProductForm.jsp";
            }
        }

        if(dispatchUrl != null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
