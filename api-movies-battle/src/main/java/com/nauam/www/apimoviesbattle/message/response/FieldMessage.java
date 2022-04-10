package com.nauam.www.apimoviesbattle.message.response;

import java.io.Serializable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;
}