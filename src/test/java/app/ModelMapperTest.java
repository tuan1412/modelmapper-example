package app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import tuannguyen.dto.QuestionDto;
import tuannguyen.dto.UserDto;
import tuannguyen.dto.UserDto.TitleQuestion;
import tuannguyen.model.Question;
import tuannguyen.model.User;

public class ModelMapperTest {
	
	private User user = new User();
	private List<Question> questions = new ArrayList<Question>();
	
	@Before
	public void initTest() {
		user.setAvatar("avatar.png");
		user.setId(1L);
		user.setUsername("tuannguyen");
		user.setPassword("123456");
		
		Question firstQuestion = new Question(1l, "title1", "content1", user);
		Question secondQuestion = new Question(2l, "title2", "content2", user);
		Question thirdQuestion = new Question(3l, "title3", "content3", user);
		questions.addAll(Arrays.asList(firstQuestion, secondQuestion, thirdQuestion));
		user.setQuestions(questions);
		
	}
	@Test
	public void testMapQuestionDto() {
		ModelMapper modelMapper = new ModelMapper();
		Question question = questions.get(0);
		QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
		assertEquals(question.getTitle(), questionDto.getTitle());
		assertEquals(question.getContent(), questionDto.getContent());
		assertEquals(question.getUser().getAvatar(), questionDto.getAvatarUser());
		assertEquals(question.getUser().getUsername(), questionDto.getUserUsername());
	}
	
	@Test
	public void testConvertAvatar() {
		ModelMapper modelMapper = new ModelMapper();
		Converter<String, String> covertAvatarUrl = context -> "http://localhost:8080/file/"+ context.getSource();
		modelMapper.addMappings(new PropertyMap<Question, QuestionDto>() {
			@Override
			protected void configure() {
				using(covertAvatarUrl).map(source.getUser().getAvatar()).setAvatarUser(null);		
			}		
		});
		Question question = questions.get(0);
		QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
		assertEquals("http://localhost:8080/file/avatar.png", questionDto.getAvatarUser());
	}
	
	@Test
	public void testConvertCollection() {
//		ModelMapper modelMapper = new ModelMapper();
//		UserDto userDto = modelMapper.map(user, UserDto.class);
		UserDto userDto = new UserDto();
		userDto.setAvatar(user.getAvatar());
		userDto.setFullname(user.getFullname());
		userDto.setUsername(user.getUsername());
		userDto.setId(user.getId());
		List<TitleQuestion> titleQuestions = user.getQuestions()
										.stream()
										.map(q -> new TitleQuestion(q.getId(), q.getTitle()))
										.collect(Collectors.toList());
		userDto.setQuestions(titleQuestions);
		assertEquals(questions.get(0).getTitle(), userDto.getQuestions().get(0).getTitle());
	}
	
	

}
