package com.bancolombia.microcredito.technical.log;

import java.time.LocalDateTime;
import java.util.UUID;

public class LoggerModel {

	
	private String id;
	private String name;
	private String timestamp;
	private String application;
	private String service;
	private String message;
	private String stacktrace;

    public LoggerModel(String message, String application, String service, String name) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.application = application;
        this.service = service;
        this.name = name;
    }

    public LoggerModel(String application, String service, String name, Exception ex) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().toString();
        this.message = ex.getMessage();
        this.application = application;
        this.service = service;
        this.stacktrace = ex.getStackTrace().toString();
        this.name = name;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
    
    
}
