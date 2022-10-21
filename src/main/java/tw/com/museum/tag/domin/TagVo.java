package tw.com.museum.tag.domin;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tw.com.museum.core.pojo.Core;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "tag")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TagVo extends Core{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tagID;
	private String tag;
	@Column(insertable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp lastUpdateTime;
}
	