package appdesign1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;

import appdesign1.form.ProductForm;
import appdesign1.model.Product;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/input-product", "/save-product" })
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1579L;

    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        int lastIndex = uril.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        String dispatchUrl = null;
        if("input-product".equals(action)) {
            dispatchUrl = "/jsp/ProductForm.jsp";
        } else {
            //create form
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription( request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            //create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());

            try {
                product.setPrice(new BigDecimal(productForm.getPrice()));
            } catch (NumberFormatException e) {}

            //execute action method
            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);

            //store model in a scope variable for the view
            request.setAttribute("product", product);
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }

        if(dispatchUrl != null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}

