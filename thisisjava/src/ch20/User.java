package ch20;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
}
