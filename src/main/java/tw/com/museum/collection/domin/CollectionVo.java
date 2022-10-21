package tw.com.museum.collection.domin;
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
@Table(name = "collection")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CollectionVo extends Core {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer collectionID;
	@Lob
	@Column(columnDefinition = "TEXT")	
	private String collectionTitle;
	@Lob
	@Column(columnDefinition = "TEXT")	
	private String collectionEar;
	@Lob
	@Column(columnDefinition = "TEXT")	
	private String collectionText;
	private String collectionMaterial;
	@Column(insertable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp lastUpdateTime;
	private Boolean collectionStatus;

}
	
	
