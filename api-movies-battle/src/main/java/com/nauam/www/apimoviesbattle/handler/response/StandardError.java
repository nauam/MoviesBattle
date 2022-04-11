package com.nauam.www.apimoviesbattle.handler.response;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class StandardError {

	private Integer status;
	private String msg;
	private Long timeStamp;

}