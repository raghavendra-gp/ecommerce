package com.te.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
	
	private String recipient;
	private String msgBody;
	private String subject;
	private String attachent;

}
