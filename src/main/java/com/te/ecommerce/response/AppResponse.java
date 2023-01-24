package com.te.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppResponse {

	private boolean error;
	private String message;
	private Object data;
	private Integer status;

}
