package tuannguyen.model;

public class Question {
	private long id;
	private String title;
	private String content;
	private User user;
	
	public Question() {
		
	}
	
	public Question(long id, String title, String content, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
