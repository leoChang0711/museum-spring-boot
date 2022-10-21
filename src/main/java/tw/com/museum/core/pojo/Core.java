package tw.com.museum.core.pojo;

import javax.persistence.Transient;

import lombok.Data;

@Data
public class Core {
	@Transient
	private boolean successful;
	@Transient
	private String message;
}