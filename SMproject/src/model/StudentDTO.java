package model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private int sno;
	private String name;
	private Date birth;
	private String gender;
	private String phoneNumber;
	private String email;
	private int seatNumber;
}
