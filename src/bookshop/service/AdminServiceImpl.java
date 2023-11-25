package bookshop.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import bookshop.dao.ProductDAO;
import bookshop.entity.Product;

@Service
public class AdminServiceImpl implements AdminService, ServletContextAware {
	
	private ServletContext servletContext;
	
	@Autowired
    private ProductDAO productDAO;

    
	@Override
	@Transactional
	public void addProduct(Product product) {
		System.out.println("bookservice is: "+product);
		productDAO.addProduct(product);
	}
	
	@Override
	public String saveImage(MultipartFile imageFile) {
		String uploadPath = servletContext.getRealPath("/resources/img/");
	    String fileName = UUID.randomUUID().toString()+ "_" + imageFile.getOriginalFilename();
	    
	    Path filePath = Paths.get(uploadPath +"/"+ fileName);
	    try {
	        Files.write(filePath, imageFile.getBytes());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return fileName;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}

	@Override
	public void deleteImage(String imageFileName) {
		String uploadPath = servletContext.getRealPath("/resources/img/");
        Path filePath = Paths.get(uploadPath + "/" + imageFileName);
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}


}
