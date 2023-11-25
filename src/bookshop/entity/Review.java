package bookshop.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Username")
	private String userName;
	
	@Column(name = "ProductId")
	private int productId;
	
	@Column(name = "Content")
	private String content;
	
	@Column(name = "ReviewDate")
	private LocalDate reviewDate;
	
	

	public Review() {
	}
	
	

	public Review(String userName, int productId, String content, LocalDate reviewDate) {
		super();
		this.userName = userName;
		this.productId = productId;
		this.content = content;
		this.reviewDate = reviewDate;
	}
	
	



	public Review(int id, String userName, int productId, String content, LocalDate reviewDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.productId = productId;
		this.content = content;
		this.reviewDate = reviewDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", userName=" + userName + ", productId=" + productId + ", content=" + content
				+ ", reviewDate=" + reviewDate + "]";
	}
	
	
	
}
