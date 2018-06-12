package tuannguyen.dto;

public class QuestionDto {
	private Long id;
	private String title;
	private String content;
	private long userId;
	private String userUsername;
	private String avatarUser;
	
	public QuestionDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAvatarUser() {
		return avatarUser;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public void setAvatarUser(String avatarUser) {
		this.avatarUser = avatarUser;
	}
	
	
	
	
}
