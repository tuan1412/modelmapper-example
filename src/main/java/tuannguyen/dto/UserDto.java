package tuannguyen.dto;

import java.util.List;

public class UserDto {
	private long id;
	private String username;
	private String avatar;
	private String fullname;
	private List<TitleQuestion> questions;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<TitleQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<TitleQuestion> questions) {
		this.questions = questions;
	}


	public static final class TitleQuestion {
		private long id;
		private String title;
		
		public TitleQuestion() {
			
		}
		
		public TitleQuestion(long id, String title) {
			this.id = id;
			this.title = title;
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
	}
}
