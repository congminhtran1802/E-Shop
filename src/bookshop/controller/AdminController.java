package bookshop.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import bookshop.entity.Product;
import bookshop.entity.User;
import bookshop.service.AdminService;
import bookshop.service.ProductService;
import bookshop.service.OrderService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private AdminService adminService;
	
	@Autowired
    private ProductService productService;
	
	
	@GetMapping("list")
	public String listBooks(Model model,HttpSession session) {
		User auth = (User) session.getAttribute("account");
        List<Product> products = productService.getProductsBySeller(auth.getUsername());
        model.addAttribute("productlist", products);
        return "admin"; // View name
    }
	
	@GetMapping("/showFormAdd")
    public String showFormAdd(Model theModel,HttpSession session) {
		User auth = (User) session.getAttribute("account");
		Product theProduct = new Product();
		theModel.addAttribute("auth",auth);
		theModel.addAttribute("product",theProduct);
        return "add-product";
    }

	@PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product theProduct,
                                             @RequestParam("imageFile") MultipartFile imageFile,HttpSession session) {
        String imageFileName = adminService.saveImage(imageFile);
        theProduct.setImage(imageFileName);
        User auth = (User) session.getAttribute("account");
        theProduct.setSeller(auth.getUsername());
		adminService.addProduct(theProduct);
		return "redirect:/admin/list";
    }
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
		Product theProduct = productService.findProductById(theId);
		theModel.addAttribute("product",theProduct);
		return "add-product";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
	    Product product = productService.findProductById(theId);
	    if (product != null) {
	        // Lấy tên file ảnh từ sản phẩm
	        String imageFileName = product.getImage();

	        // Xoá sản phẩm khỏi cơ sở dữ liệu
	        productService.deleteProduct(theId);

	        // Xoá tập tin ảnh tương ứng từ thư mục resource
	        if (imageFileName != null) {
	            adminService.deleteImage(imageFileName);
	        }
	    }

	    return "redirect:/admin/list";
	}
}
