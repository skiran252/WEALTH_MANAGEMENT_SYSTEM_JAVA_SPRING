package demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String title;
	private String description;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Transaction> transactions;

	public Category(String title, String description) {
		this.title = title;
		this.description = description;

	}

	@Override
	public String toString() {
		return "Category [Id=" + Id + ", title=" + title + ", description=" + description + "]";
	}

	public Category(int id, String title, String description) {
		Id = id;
		this.title = title;
		this.description = description;
	}

	public Category() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}