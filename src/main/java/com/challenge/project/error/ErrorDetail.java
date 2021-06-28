package com.challenge.project.error;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ErrorDetail {

	private String title;
	private int status;
	private long timestamp;
	private String message;
	private Map<String, String> fieldsError;
	private List<String> errors;
	private Object data;

	private ErrorDetail(Builder builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.timestamp = builder.timestamp;
		this.message = builder.message;
		this.fieldsError = builder.fieldsError;
		this.errors = builder.errors;
		this.data = builder.data;
	}

	public ErrorDetail(String title, int status, long timestamp, String message, List<String> errors) {
		this.title = title;
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.errors = errors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getFieldsError() {
		return fieldsError;
	}

	public void setFieldsError(Map<String, String> fieldsError) {
		this.fieldsError = fieldsError;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String title;
		private int status;
		private long timestamp;
		private String message;
		private Map<String, String> fieldsError = Collections.emptyMap();
		private List<String> errors = Collections.emptyList();
		private Object data;

		private Builder() {
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder fieldsError(Map<String, String> fieldsError) {
			this.fieldsError = fieldsError;
			return this;
		}

		public Builder errors(List<String> errors) {
			this.errors = errors;
			return this;
		}

		public Builder data(Object data) {
			this.data = data;
			return this;
		}

		public ErrorDetail build() {
			return new ErrorDetail(this);
		}
	}

}
