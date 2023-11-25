package bookshop.service;

import org.springframework.web.multipart.MultipartFile;

import bookshop.entity.Product;

public interface AdminService {
	
	void addProduct(Product product);

	String saveImage(MultipartFile imageFile);
	
	void deleteImage(String imageFileName);
}
